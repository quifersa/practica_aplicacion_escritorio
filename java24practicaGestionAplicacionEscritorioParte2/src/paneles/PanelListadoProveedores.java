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

import com.sun.org.apache.xml.internal.serialize.LineSeparator;

import tableModels.TableModelProveedores;
import modelo.Proveedor;
import daos.ProveedoresDAO;
import daos.ProveedoresDAOImpl;

public class PanelListadoProveedores extends JPanel implements ActionListener{
	
	private ProveedoresDAO daoProveedores = new ProveedoresDAOImpl();
	private Proveedor[] proveedores;
	JTable tabla;
	JButton botonBorrar = new JButton("BORRAR");
	
	
	public PanelListadoProveedores() {
		this.add(new JLabel("Soy el panel del listado de proveedores"));
	}
	
	
	public void refrescarProveedores(){
		this.proveedores = daoProveedores.obtenerProveedores();
		
		tabla = new JTable(new TableModelProveedores(proveedores));
		
		// Con este comando hacemos que la tabla no se autorreajuste y aparezca la barra lateral
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		tabla.setPreferredScrollableViewportSize(new Dimension(700, 400));
        tabla.setFillsViewportHeight(true); // Adapta el contenido al tamaño
        
        // Para solo poder seleccionar una fila
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // Creamos una "barra" en el lateral para desplazarnos hacia abajo       
        JScrollPane scrollPane = new JScrollPane(tabla);
       
		// Para quitar todo lo que tuviera antes el panel
		this.removeAll();

		// Add the scroll pane to this panel.
        this.add(scrollPane);
        
        // Añadimos el botón
		this.add(botonBorrar);
        
        // Voy a atender al botón BORRAR desde la instancia de esta clase
        botonBorrar.addActionListener(this);
		
	}
        
    	@Override
    	public void actionPerformed(ActionEvent e){
    		// Por si tanto no se selecciona una fila como si pulso el botón repetidas veces
    		if(tabla.getSelectedRow()==-1){
    			return; /* Aunque la función no devuelva nada, puedes llamar a return directamente
    						para decir que finaliza la función */
    		}
    		
    		int confirmacion = JOptionPane.showConfirmDialog(null, "¿Realmente quiere borrar: " + 
    								proveedores[tabla.getSelectedRow()].toString() + "?", 
    								"CONFIRMACIÓN DE BORRADO",JOptionPane.YES_NO_CANCEL_OPTION, 
    								JOptionPane.QUESTION_MESSAGE);
    		
    		if (confirmacion == 0) {
    		
    			daoProveedores.borrarProveedor(proveedores[tabla.getSelectedRow()].getId());
    			refrescarProveedores();
    			SwingUtilities.updateComponentTreeUI(this);
    			
    		} else {
    			refrescarProveedores();
    			SwingUtilities.updateComponentTreeUI(this);
    			return;
    		} 
    	}
}
