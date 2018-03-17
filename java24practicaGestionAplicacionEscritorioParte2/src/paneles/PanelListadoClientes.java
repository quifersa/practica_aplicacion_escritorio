package paneles;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import tableModels.TableModelClientes;
import modelo.Cliente;
import daos.ClientesDAO;
import daos.ClientesDAOImpl;

public class PanelListadoClientes extends JPanel implements ActionListener{
	
	private ClientesDAO daoClientes = new ClientesDAOImpl();
	private Cliente[] clientes;
	JTable tabla;
	JButton botonBorrar = new JButton("BORRAR");
	
	
	public PanelListadoClientes() {
		this.add(new JLabel("Soy el panel del listado de clientes"));
	}
	
	public void refrescarClientes(){
		this.clientes = daoClientes.obtenerClientes();
		
		tabla = new JTable(new TableModelClientes(clientes));
		tabla.setPreferredScrollableViewportSize(new Dimension(700, 400));
        tabla.setFillsViewportHeight(true); // Adapta el contenido al tamaño
        
        // Para solo poder seleccionar una fila
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // Creamos una "barra" en el lateral para desplazarnos hacia abajo       
        JScrollPane scrollPane = new JScrollPane(tabla);
       
		// Para quitar todo lo que tuviera antes el panel
		this.removeAll();
		this.add(botonBorrar);
		// Add the scroll pane to this panel.
        this.add(scrollPane);
        
        // Voy a atender al botón BORRAR desde la instancia de esta clase
        botonBorrar.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Por si tanto no se selecciona una fila como si pulso el botón repetidas veces
		if(tabla.getSelectedRow()==-1){
			return; /* Aunque la función no devuelva nada, puedes llamar a return directamente
						para decir que finaliza la función */
		}
		
		int confirmacion = JOptionPane.showConfirmDialog(null, "¿Realmente quiere borrar: " + 
								clientes[tabla.getSelectedRow()].toString() + "?", 
								"CONFIRMACIÓN DE BORRADO",JOptionPane.YES_NO_CANCEL_OPTION, 
								JOptionPane.QUESTION_MESSAGE);
		
		if (confirmacion == 0) {
		
			daoClientes.borrarCliente(clientes[tabla.getSelectedRow()].getId());
			refrescarClientes();
			SwingUtilities.updateComponentTreeUI(this);
			
		} else if (confirmacion == 1 || confirmacion == 2 || confirmacion == 3) {
			refrescarClientes();
			SwingUtilities.updateComponentTreeUI(this);
			return;
		} 
	}
	
	
}
