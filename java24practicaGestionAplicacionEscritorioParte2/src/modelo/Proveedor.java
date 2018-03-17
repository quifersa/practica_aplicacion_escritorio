package modelo;

public class Proveedor {
	
	private String nombreEmpresa;
	private String direccion;
	private String telefono;
	private String correoElectronico;
	private String paginaWeb;
	private String nombreRepresentante;
	private String telefonoRepresentante;
	private String ambitoActividad;
	private String certificadoMinisterioIndustria;
	private String estructuraJuridica;
	private int id;
	
	public Proveedor() {

	}

	public Proveedor(String nombreEmpresa, String direccion, String telefono,
			String correoElectronico, String paginaWeb,
			String nombreRepresentante, String telefonoRepresentante,
			String ambitoActividad, String certificadoMinisterioIndustria,
			String estructuraJuridica) {
		
		this.nombreEmpresa = nombreEmpresa;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.paginaWeb = paginaWeb;
		this.nombreRepresentante = nombreRepresentante;
		this.telefonoRepresentante = telefonoRepresentante;
		this.ambitoActividad = ambitoActividad;
		this.certificadoMinisterioIndustria = certificadoMinisterioIndustria;
		this.estructuraJuridica = estructuraJuridica;
		
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getPaginaWeb() {
		return paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}

	public String getNombreRepresentante() {
		return nombreRepresentante;
	}

	public void setNombreRepresentante(String nombreRepresentante) {
		this.nombreRepresentante = nombreRepresentante;
	}

	public String getTelefonoRepresentante() {
		return telefonoRepresentante;
	}

	public void setTelefonoRepresentante(String telefonoRepresentante) {
		this.telefonoRepresentante = telefonoRepresentante;
	}
	
	public String getAmbitoActividad() {
		return ambitoActividad;
	}

	public void setAmbitoActividad(String ambitoActividad) {
		this.ambitoActividad = ambitoActividad;
	}
	

	public String getCertificadoMinisterioIndustria() {
		return certificadoMinisterioIndustria;
	}

	public void setCertificadoMinisterioIndustria(
			String certificadoMinisterioIndustria) {
		this.certificadoMinisterioIndustria = certificadoMinisterioIndustria;
	}


	public String getEstructuraJuridica() {
		return estructuraJuridica;
	}

	public void setEstructuraJuridica(String estructuraJuridica) {
		this.estructuraJuridica = estructuraJuridica;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Proveedor [nombre empresa=" + nombreEmpresa + ", dirección="
				+ direccion + ", teléfono=" + telefono + ", correo electrónico="
				+ correoElectronico + ", \n página web=" + paginaWeb
				+ ", nombre representante=" + nombreRepresentante
				+ ", teléfono representante=" + telefonoRepresentante
				+ ", ámbito actividad=" + ambitoActividad
				+ ", certificado Ministerio Industria="
				+ certificadoMinisterioIndustria + ", \n estructura jurídica="
				+ estructuraJuridica + "]";
	}

}
