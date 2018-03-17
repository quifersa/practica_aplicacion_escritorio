package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import paneles.PanelListadoClientes;
import paneles.PanelListadoProveedores;
import paneles.PanelRegistroCliente;
import paneles.PanelRegistroProveedor;

public class VentanaPrincipal extends JFrame implements ActionListener{

	private PanelRegistroCliente panelRegistroCliente = new PanelRegistroCliente();	
	private PanelListadoClientes panelListadoClientes = new PanelListadoClientes();
	private PanelRegistroProveedor panelRegistroProveedor = new PanelRegistroProveedor();
	private PanelListadoProveedores panelListadoProveedores = new PanelListadoProveedores();
	
	
 // JMenuBar contiene diferentes JMenu y éstos tienen a su vez diferentes JMenuItem
	
	// Barra de menú:
	private JMenuBar barraDeMenu = new JMenuBar();
	private JMenu menuClientes = new JMenu("Clientes");
	private JMenu menuAyuda = new JMenu("Ayuda");
	private JMenu menuProveedores = new JMenu("Proveedores");
	
	public VentanaPrincipal() {
		
		// Preparación de la barra de menú:
		JMenuItem clientesInsertar = new JMenuItem("Insertar cliente");
		JMenuItem clientesListar = new JMenuItem("Listar clientes");
		JMenuItem proveedoresInsertar = new JMenuItem("Insertar proveedor");
		JMenuItem proveedoresListar = new JMenuItem("Listar proveedores");
		menuClientes.add(clientesInsertar);
		menuClientes.add(clientesListar);
		menuProveedores.add(proveedoresInsertar);
		menuProveedores.add(proveedoresListar);
		barraDeMenu.add(menuClientes);
		barraDeMenu.add(menuProveedores);
		barraDeMenu.add(menuAyuda);
		this.setJMenuBar(barraDeMenu);
		
		
		// Voy a decir a las opciones de menú quién las va a atender cuando se pinche en ellas
		clientesInsertar.addActionListener(this);
		clientesListar.addActionListener(this);
		proveedoresInsertar.addActionListener(this);
		proveedoresListar.addActionListener(this);
		
		
		// Preparación de la ventana principal:
		this.setSize(800, 600);
		this.setLocation(50, 50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	// Vamos a decir que cuando arranque esta ventana, se muestre el panel de registro cliente:
		
		this.setContentPane(panelRegistroCliente); /* Se pone cuando la ventana solo tiene 
													  un panel */
		
	    /* this.add(panelRegistroCliente); // Se podría hacer así también, pero como solo vamos
		   								   // a agregar ese panel, mejor de la forma anterior
		   									  */
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	   System.out.println("Atiendo a: " + e.getActionCommand());
	   if(e.getActionCommand().equals("Insertar cliente")){ //equals() es para comparar strings
		setContentPane(panelRegistroCliente);
	   } else if (e.getActionCommand().equals("Listar clientes")) {
		   setContentPane(panelListadoClientes);
		   panelListadoClientes.refrescarClientes();
	   } else if (e.getActionCommand().equals("Insertar proveedor")) {
		   setContentPane(panelRegistroProveedor);
	   } else if (e.getActionCommand().equals("Listar proveedores")) {
		   setContentPane(panelListadoProveedores);
		   panelListadoProveedores.refrescarProveedores();
	   }
	   // Esto es para refrescar cuando paso de un panel a otro
	   SwingUtilities.updateComponentTreeUI(this);
	}
	

}
