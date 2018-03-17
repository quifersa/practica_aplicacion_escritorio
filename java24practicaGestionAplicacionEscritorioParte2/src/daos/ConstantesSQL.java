package daos;

public class ConstantesSQL {
	
	final static String sqlInsercionCliente = "insert into tabla_clientes (nombre,domicilio,"
									+ "poblacion,codigo_postal,telefono) values (?,?,?,?,?)";
	
	final static String sqlInsercionProveedor = "insert into tabla_proveedores (nombre_empresa,"
			+ "direccion,telefono,correo_electronico,pagina_web,nombre_representante,"
			+ "telefono_representante,ambito_actividad,certificado_ministerio_industria,"
			+ "estructura_juridica) values (?,?,?,?,?,?,?,?,?,?)";
	
	final static String sqlSeleccionClientes = "select * from tabla_clientes";
	
	final static String sqlSeleccionProveedores = "select * from tabla_proveedores";
	
	final static String sqlBorradoCliente = "delete from tabla_clientes where id=?";
	
	final static String sqlBorradoProveedor = "delete from tabla_proveedores where id=?";
	
}
