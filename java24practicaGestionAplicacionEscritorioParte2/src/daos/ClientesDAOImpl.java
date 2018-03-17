package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;

public class ClientesDAOImpl implements ClientesDAO {

	private Connection miConexion = null;

	public ClientesDAOImpl() {
		// Preparo driver y conexi�n
		try {
			Class.forName("com.mysql.jdbc.Driver");
			miConexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/practica_escritorio","root", "jeveris");

		} catch (ClassNotFoundException e) { // Este catch es por si falla Class.forName
			e.printStackTrace();
			System.out.println("No encuentro el driver (librer�a de mysql)");

		} catch (SQLException e) {// Este catch es por si falla el Driver.Manager.getConnection
			System.out.println("Error de conexi�n o la sql est� mal");
			e.printStackTrace();
		}

	}

	@Override
	public void registrarCliente(Cliente c) {

		PreparedStatement ps;

		try {
			ps = miConexion.prepareStatement(ConstantesSQL.sqlInsercionCliente);

			ps.setString(1, c.getNombre());
			ps.setString(2, c.getDomicilio());
			ps.setString(3, c.getPoblacion());
			ps.setString(4, c.getCodigoPostal());
			ps.setString(5, c.getTelefono());

			ps.execute();
			ps.close();

			System.out.println("El cliente se ha registrado correctamente");
		} catch (SQLException e) {
			System.out.println("Fallo en la sql");
			e.printStackTrace();
		}

	}

	@Override
	public void borrarCliente(int id) {
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.sqlBorradoCliente);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("La sql de borrado est� mal");
			System.out.println(e.getMessage());// Para sacar un poco m�s de informaci�n del error
			e.printStackTrace();
		}
	}

	@Override
	public Cliente[] obtenerClientes() {

		Cliente[] clientes = null;

		PreparedStatement ps;

		try {
			ps = miConexion.prepareStatement(ConstantesSQL.sqlSeleccionClientes);

			// Para sql tipo select debo usar el m�todo executeQuery
			ResultSet resultado = ps.executeQuery();
			List<Cliente> listClientes = new ArrayList<Cliente>();

			/* next pasa al siguiente resultado de la base de datos que a�n no
			  hemos procesado, si no hay ning�n resultado m�s devuelve false */
			while (resultado.next()) {
				Cliente c = new Cliente();

				// Nombre de la columna de la tabla en el get String
				c.setNombre(resultado.getString("nombre"));
				c.setDomicilio(resultado.getString("domicilio"));
				c.setPoblacion(resultado.getString("poblacion"));
				c.setCodigoPostal(resultado.getString("codigo_postal"));
				c.setTelefono(resultado.getString("telefono"));
				c.setId(resultado.getInt("id"));

				listClientes.add(c);
				
				//Transformar de list a array
				clientes = listClientes.toArray(new Cliente[listClientes.size()]);
				
				
			    /* public static void main(String[] args) {
				
						ClientesDAOImpl dao = new ClientesDAOImpl();
						Cliente[] clientes = dao.obtenerClientes();
				
					for (Cliente cliente : clientes) {
						System.out.println(cliente.toString());
						}
				   } */
				
			
			}

		} catch (SQLException e) {
			System.out.println("Fallo en la SQL de selecci�n clientes");
			e.printStackTrace();
		}

		return clientes;

	}

}
