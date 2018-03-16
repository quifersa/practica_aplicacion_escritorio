package daos;

import modelo.Proveedor;

public interface ProveedoresDAO {

	void registrarProveedor(Proveedor p);
	void borrarProveedor(int id);
	Proveedor[] obtenerProveedores();
	
}
