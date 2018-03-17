package tableModels;

import javax.swing.table.AbstractTableModel;

import modelo.Proveedor;

public class TableModelProveedores extends AbstractTableModel{

	private String[] columnas = {"Nombre empresa","Dirección","Teléfono","Correo electrónico",
								"Página web","Nombre representante", "Teléfono representante", 
								"Ámbito actividad", "Certificado Ministerio Industria", 
								"Estructura jurídica"};
	private String[][] datos = null;
	
	public TableModelProveedores(Proveedor[] proveedores) {
		
		/* datos va a ser tantos arrays de strings como clientes tenga que listar.
		   Cada uno de esos arrays deberá tener tantos elementos como queramos mostrar 
		   por cada columna */
		datos = new String[proveedores.length][columnas.length];
		
		for (int i = 0; i < proveedores.length; i++) {
			Proveedor p = proveedores[i];
			
			datos[i][0] = p.getNombreEmpresa();
			datos[i][1] = p.getDireccion();
			datos[i][2] = p.getTelefono();
			datos[i][3] = p.getCorreoElectronico();
			datos[i][4] = p.getPaginaWeb();
			datos[i][5] = p.getNombreRepresentante();
			datos[i][6] = p.getTelefonoRepresentante();
			datos[i][7] = p.getAmbitoActividad();
			datos[i][8] = p.getCertificadoMinisterioIndustria();
			datos[i][9] = p.getEstructuraJuridica();
			
		}// fin for
		
	}// fin TableModelClientes

	@Override
	public String getColumnName(int numCol) {
	      return columnas[numCol];
	}
	
	@Override
	public int getColumnCount() {
		return columnas.length;
	}

	@Override
	public int getRowCount() {
		return datos.length;
	}

	@Override
	public Object getValueAt(int indiceFila, int indiceColumna) {
		return datos[indiceFila][indiceColumna];
	}
	
}
