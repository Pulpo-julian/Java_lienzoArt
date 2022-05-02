package modelo;

public class Usuario {
	
	private String docid;
	private String nombres;
	private String apellidos;
	private String correo;

	
	public Usuario() {
		
		
		
	}

	public Usuario(String docid, String nombres, String apellidos, String correo) {
		
		super();
		this.docid = docid;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		
	}
	
	//GET SET
	public String getCedula() {
		return docid;
	}

	public void setCedula(String cedula) {
		this.docid = cedula;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return correo;
	}

	public void setEmail(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Usuario [docid=" + docid + 
				", nombres=" + nombres + 
				", apellidos=" + apellidos + 
				", correo=" + correo
				+ "]";
	}
	
	//over
	
	

}
