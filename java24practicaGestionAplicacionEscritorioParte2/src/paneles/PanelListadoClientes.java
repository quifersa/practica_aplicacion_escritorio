package paneles;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import tableModels.TableModelClientes;
import modelo.Cliente;
import daos.ClientesDAO;
import daos.ClientesDAOImpl;

public class PanelListadoClientes extends JPanel{
	
	private ClientesDAO daoClientes = new ClientesDAOImpl();
	private Cliente[] clientes;
	
	
	public PanelListadoClientes() {
		this.add(new JLabel("Soy el panel del listado de clientes"));
	}
	
	public void refrescarClientes(){
		this.clientes = daoClientes.obtenerClientes();
		
		JTable tabla = new JTable(new TableModelClientes(clientes));
		tabla.setPreferredScrollableViewportSize(new Dimension(500, 50));
        tabla.setFillsViewportHeight(true);
        
      // Creamos una "barra" en el lateral para desplazarnos hacia abajo       
        JScrollPane scrollPane = new JScrollPane(tabla);

        
		// Para quitar todo lo que tuviera antes el panel
		this.removeAll();
		// Add the scroll pane to this panel.
        this.add(scrollPane);
		
	}
	
	
}
