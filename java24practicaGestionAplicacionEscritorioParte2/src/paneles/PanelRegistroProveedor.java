package paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import daos.ProveedoresDAOImpl;
import modelo.Proveedor;

public class PanelRegistroProveedor extends JPanel implements ActionListener{

	JTextField campoNombreEmpresa = new JTextField(20);
	JTextField campoDireccion = new JTextField(20);
	JTextField campoTelefono = new JTextField(20);
	JTextField campoCorreoElectronico = new JTextField(20);
	JTextField campoPaginaWeb = new JTextField(20);
	JTextField campoNombreRepresentante = new JTextField(20);
	JTextField campoTelefonoRepresentante = new JTextField(20);
	JRadioButton botonNacional = new JRadioButton("Nacional",true);
	JRadioButton botonInternacional = new JRadioButton("Internacional",false);
	String ambitoActividad;
	JCheckBox botonCertificado = new JCheckBox("Certificado");
	String certificadoMinisterioIndustria;
	String[] opcionesLista = {
			null,
			"Empresa conjunta",
			"Sociedad Limitada",
			"Sociedad Anónima"
	};
	JComboBox listaEstructura = new JComboBox(opcionesLista);
	String estructuraJuridica = null;

	
	public PanelRegistroProveedor() {
		
		/* Así asigno un gestor de diseño que me permite colocar las cosas en forma de
		   filas y celdas */
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.gridwidth = 2; // Para centrar el título, le dices que ocupe el doble
		this.add(new JLabel("INTRODUCE LOS DATOS DEL PROVEEDOR"), gbc);
		
		gbc.gridwidth = 1;
		
		gbc.gridy = 1;
		gbc.gridx = 0;
		this.add(new JLabel("Nombre empresa: "), gbc);
		
		gbc.gridy = 1;
		gbc.gridx = 1;
		this.add(campoNombreEmpresa, gbc);
		
		gbc.gridy = 2;
		gbc.gridx = 0;
		this.add(new JLabel("Dirección: "), gbc);
		
		gbc.gridy = 2;
		gbc.gridx = 1;
		this.add(campoDireccion, gbc);
		
		gbc.gridy = 3;
		gbc.gridx = 0;
		this.add(new JLabel("Teléfono: "), gbc);
		
		gbc.gridy = 3;
		gbc.gridx = 1;
		this.add(campoTelefono, gbc);
		
		gbc.gridy = 4;
		gbc.gridx = 0;
		this.add(new JLabel("Correo electrónico: "), gbc);
		
		gbc.gridy = 4;
		gbc.gridx = 1;
		this.add(campoCorreoElectronico, gbc);
		
		gbc.gridy = 5;
		gbc.gridx = 0;
		this.add(new JLabel("Página web: "), gbc);
		
		gbc.gridy = 5;
		gbc.gridx = 1;
		this.add(campoPaginaWeb, gbc);
		
		gbc.gridy = 6;
		gbc.gridx = 0;
		this.add(new JLabel("Nombre representante: "), gbc);
		
		gbc.gridy = 6;
		gbc.gridx = 1;
		this.add(campoNombreRepresentante, gbc);
		
		gbc.gridy = 7;
		gbc.gridx = 0;
		this.add(new JLabel("Teléfono representante: "), gbc);
		
		gbc.gridy = 7;
		gbc.gridx = 1;
		this.add(campoTelefonoRepresentante, gbc);
		
	 /*	botonNacional.setActionCommand("Nacional"); //Asigno identificador 'Nacional' al botón
		botonInternacional.setActionCommand("Internacional");
	    botonNacional.setMnemonic('n');  // Con esto asigno la letra b como atajo al botón
	    botonInternacional.setMnemonic('i'); */
		
				
		ButtonGroup grupoBotones = new ButtonGroup();
		grupoBotones.add(botonNacional);
		grupoBotones.add(botonInternacional);
		
		gbc.gridy = 8;
		gbc.gridx = 0;
		this.add(new JLabel("Ámbito actividades: "), gbc);
		
		gbc.gridy = 8;
		gbc.gridx = 1;
		this.add(botonNacional, gbc);
		
		gbc.gridy = 8;
		gbc.gridx = 2;
		this.add(botonInternacional, gbc);
		
		gbc.gridy = 9;
		gbc.gridx = 0;
		this.add(new JLabel("Certificado Ministerio de Industria: "), gbc);
		
		gbc.gridy = 9;
		gbc.gridx = 1;
		this.add(botonCertificado, gbc);
		
		listaEstructura.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e1) {
				estructuraJuridica = (String) listaEstructura.getSelectedItem();
			}
		});
		
		gbc.gridy = 10;
		gbc.gridx = 0;
		this.add(new JLabel("Estructura jurídica: "), gbc);
		
		gbc.gridy = 10;
		gbc.gridx = 1;
		this.add(listaEstructura, gbc);
		
		JButton botonRegistrarProveedor = new JButton("REGISTRAR");
		botonRegistrarProveedor.addActionListener(this);
		
		gbc.gridwidth = 2;
		gbc.gridy = 11;
		gbc.gridx = 0;
		this.add(botonRegistrarProveedor, gbc);
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {

		System.out.println("actionPerformed del PanelRegistroProveedor");
		
		String nombreEmpresa = campoNombreEmpresa.getText();
		String direccion = campoDireccion.getText();
		String telefono = campoTelefono.getText();
		String correoElectronico = campoCorreoElectronico.getText();
		String paginaWeb = campoPaginaWeb.getText();
		String nombreRepresentante = campoNombreRepresentante.getText();
		String telefonoRepresentante = campoTelefonoRepresentante.getText();		
		
		if (botonNacional.isSelected()){
			ambitoActividad = "Nacional";
		} else if (botonInternacional.isSelected()){
			ambitoActividad = "Internacional";
		}
		
		if (botonCertificado.isSelected()){
			certificadoMinisterioIndustria = "Sí";
		} else {
			certificadoMinisterioIndustria = null;
		}
		
		if (estructuraJuridica == null){
			JOptionPane.showMessageDialog(null, "Por favor, seleccione una estructura"
										+ " jurídica");
			return;
		}
	
		
		Proveedor proveedorARegistrar = new Proveedor(nombreEmpresa, direccion, telefono, 
			correoElectronico, paginaWeb, nombreRepresentante, telefonoRepresentante,
			ambitoActividad, certificadoMinisterioIndustria, estructuraJuridica);

		System.out.println("Voy a registrar: " + proveedorARegistrar.toString());
		
		ProveedoresDAOImpl proveedoresDAO = new ProveedoresDAOImpl();
		proveedoresDAO.registrarProveedor(proveedorARegistrar);
		
		JOptionPane.showMessageDialog(null, "Información registrada correctamente");
		
		// Limpiamos los campos del formulario al registrar
		campoNombreEmpresa.setText(null);
		campoDireccion.setText(null);
		campoTelefono.setText(null);
		campoCorreoElectronico.setText(null);
		campoPaginaWeb.setText(null);
		campoNombreRepresentante.setText(null);
		campoTelefonoRepresentante.setText(null);
		botonNacional.setSelected(true);
		botonInternacional.setSelected(false);
		botonCertificado.setSelected(false);
		listaEstructura.setSelectedIndex(0);
		
		}
	
}

