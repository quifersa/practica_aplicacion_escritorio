package modelo;

public class Cliente {

	private String nombre;
	private String domicilio;
	private String poblacion;
	private String codigoPostal;
	private String telefono;
	private int id;
	
	public Cliente() {
	}
	
	public Cliente(String nombre, String domicilio, String poblacion,
			String codigoPostal, String telefono) {
		super();
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.poblacion = poblacion;
		this.codigoPostal = codigoPostal;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", domicilio=" + domicilio
				+ ", población=" + poblacion + ", código postal=" + codigoPostal
				+ ", teléfono=" + telefono + "]";
	}
	
	
	
	
	
}
