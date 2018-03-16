package paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import daos.ClientesDAOImpl;
import modelo.Cliente;

public class PanelRegistroCliente extends JPanel implements ActionListener{

	JTextField campoNombre = new JTextField(15);
	JTextField campoDomicilio = new JTextField(15);
	JTextField campoPoblacion = new JTextField(15);
	JTextField campoCodigoPostal = new JTextField(15);
	JTextField campoTelefono = new JTextField(15);
	
	public PanelRegistroCliente() {
		
		/* Así asigno un gestor de diseño que me permite colocar las cosas en forma de
		   filas y celdas */
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		// Primera fila:
		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.gridwidth = 2; // Para centrar el título, le dices que ocupe el doble
		this.add(new JLabel("INTRODUCE LOS DATOS DEL CLIENTE"), gbc);
		
		// Vuelvo a decir que cada componente solo ocupe un elemento:
		gbc.gridwidth = 1;
		// Segunda fila:
		   // Primer elemento:
		gbc.gridy = 1;
		gbc.gridx = 0;
		this.add(new JLabel("Nombre: "), gbc);
		   // Segundo elemento:
		gbc.gridy = 1;
		gbc.gridx = 1;
		this.add(campoNombre, gbc);
		// Tercera fila:
		gbc.gridy = 2;
		gbc.gridx = 0;
		this.add(new JLabel("Domicilio: "), gbc);
		gbc.gridy = 2;
		gbc.gridx = 1;
		this.add(campoDomicilio,gbc);
		// Cuarta fila:
		gbc.gridy = 3;
		gbc.gridx = 0;
		this.add(new JLabel("Población: "), gbc);
		gbc.gridy = 3;
		gbc.gridx = 1;
		this.add(campoPoblacion,gbc);
		gbc.gridy = 4;
		gbc.gridx = 0;
		// Quinta fila:
		this.add(new JLabel("Código Postal: "), gbc);
		gbc.gridy = 4;
		gbc.gridx = 1;
		this.add(campoCodigoPostal,gbc);
		// Sexta fila:
		gbc.gridy = 5;
		gbc.gridx = 0;
		this.add(new JLabel("Teléfono: "), gbc);
		gbc.gridy = 5;
		gbc.gridx = 1;
		this.add(campoTelefono,gbc);
		// Séptima fila:
		JButton botonRegistroCliente = new JButton("REGISTRAR");
		botonRegistroCliente.addActionListener(this);
		gbc.gridy = 6;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		this.add(botonRegistroCliente, gbc);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("actionPerformed del PanelRegistroCliente");
		String nombre = campoNombre.getText();
		String domicilio = campoDomicilio.getText();
		String poblacion = campoPoblacion.getText();
		String codigoPostal = campoCodigoPostal.getText();
		String telefono = campoTelefono.getText();
		// Ahora habría que validar estos datos (que lo haremos más tarde)
		
		//... TODO
		
	 /* Tanto la nomenclatura de arriba de los puntos suspensivos, como el TODO indican que 
	 queda algo por hacer en ese punto, con TODO se crea además una marca azul a la derecha */
		
		// Una vez validados todos los datos, registramos en base de datos:
		Cliente clienteARegistrar = new Cliente(nombre, domicilio, poblacion, 
												codigoPostal, telefono);
		
		System.out.println("Voy a registrar: " + clienteARegistrar.toString());
		
	   // Invoco a lo necesario de la capa de datos para registrar al cliente en base de datos	
		ClientesDAOImpl clientesDAO = new ClientesDAOImpl();
		clientesDAO.registrarCliente(clienteARegistrar);
		
		JOptionPane.showMessageDialog(null, "Información registrada correctamente");
		
		
	}
	
}
