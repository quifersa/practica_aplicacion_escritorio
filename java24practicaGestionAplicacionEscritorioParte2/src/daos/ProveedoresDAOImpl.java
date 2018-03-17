package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Proveedor;


public class ProveedoresDAOImpl implements ProveedoresDAO{

	private Connection miConexion = null;
	
	public ProveedoresDAOImpl() {
		
		// Preparo driver y conexión
		try {
			Class.forName("com.mysql.jdbc.Driver");
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
					+ "practica_escritorio", "root", "jeveris");
			
		} catch (ClassNotFoundException e) { // Este catch es por si falla Class.forName
			e.printStackTrace();
			System.out.println("No encuentro el driver (librería de mysql)");
			
		} catch (SQLException e) {// Este catch es por si falla el Driver.Manager.getConnection
			System.out.println("Error de conexión o la sql está mal");
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void registrarProveedor(Proveedor p) {
		
		PreparedStatement ps;
		
		try {
			ps = miConexion.prepareStatement(ConstantesSQL.sqlInsercionProveedor);
			
			ps.setString(1, p.getNombreEmpresa());
			ps.setString(2, p.getDireccion());
			ps.setString(3, p.getTelefono());
			ps.setString(4, p.getCorreoElectronico());
			ps.setString(5, p.getPaginaWeb());
			ps.setString(6, p.getNombreRepresentante());
			ps.setString(7, p.getTelefonoRepresentante());
			ps.setString(8, p.getAmbitoActividad());
			ps.setString(9, p.getCertificadoMinisterioIndustria());
			ps.setString(10, p.getEstructuraJuridica());

			
			ps.execute();
			ps.close();
			
			System.out.println("El proveedor se ha registrado correctamente");
		} catch (SQLException e) {
			System.out.println("Fallo en la sql");
			e.printStackTrace();
		}
		
	}

	@Override
	public void borrarProveedor(int id) {
	    try {
		   PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.sqlBorradoProveedor);
		   ps.setInt(1, id);
		   ps.execute();
		   ps.close();
		} catch (SQLException e) {
		   System.out.println("La sql de borrado está mal");
	       System.out.println(e.getMessage());// Para sacar un poco más de información del error
		   e.printStackTrace();
		}
	}

	@Override
	public Proveedor[] obtenerProveedores() {

		Proveedor[] proveedores = null;

		PreparedStatement ps;

		try {
			ps = miConexion.prepareStatement(ConstantesSQL.sqlSeleccionProveedores);

			// Para sql tipo select debo usar el método executeQuery
			ResultSet resultado = ps.executeQuery();
			List<Proveedor> listProveedores = new ArrayList<Proveedor>();

			/* next pasa al siguiente resultado de la base de datos que aún no
			  hemos procesado, si no hay ningún resultado más devuelve false */
			while (resultado.next()) {
				Proveedor p = new Proveedor();

				// Nombre de la columna de la tabla en el get String
				p.setNombreEmpresa(resultado.getString("nombre_empresa"));
				p.setDireccion(resultado.getString("direccion"));
				p.setTelefono(resultado.getString("telefono"));
				p.setCorreoElectronico(resultado.getString("correo_electronico"));
				p.setPaginaWeb(resultado.getString("pagina_web"));
				p.setNombreRepresentante(resultado.getString("nombre_representante"));
				p.setTelefonoRepresentante(resultado.getString("telefono_representante"));
				p.setAmbitoActividad(resultado.getString("ambito_actividad"));
				p.setCertificadoMinisterioIndustria(resultado.getString("certificado_ministerio"
																		+ "_industria"));
				p.setEstructuraJuridica(resultado.getString("estructura_juridica"));
				p.setId(resultado.getInt("id"));

				listProveedores.add(p);
				
				//Transformar de list a array
				proveedores = listProveedores.toArray(new Proveedor[listProveedores.size()]);
				
				
			    /* public static void main(String[] args) {
				
						ClientesDAOImpl dao = new ClientesDAOImpl();
						Cliente[] clientes = dao.obtenerClientes();
				
					for (Cliente cliente : clientes) {
						System.out.println(cliente.toString());
						}
				   } */
				
			
			}

		} catch (SQLException e) {
			System.out.println("Fallo en la SQL de selección clientes");
			e.printStackTrace();
		}

		return proveedores;
		
	}
	
	
	
}
