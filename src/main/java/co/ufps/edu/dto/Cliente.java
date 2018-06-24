package co.ufps.edu.dto;

import org.springframework.util.StringUtils;

public class Cliente {
	
	private int codigo;
	private String tipoDoc;
	private int numeroDocumento;
	private String nombre;
	private String apellido;
	private String direccion;
	private String telefono;
	private String correoElectronico;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public int getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(int numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
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
	
	public boolean validarDatos(){
		return (!StringUtils.isEmpty(this.nombre) 
		      && !StringUtils.isEmpty(this.apellido)
		      && !StringUtils.isEmpty(this.direccion)
		      && !StringUtils.isEmpty(this.telefono)
		      && !StringUtils.isEmpty(this.correoElectronico)
		      && !StringUtils.isEmpty(this.tipoDoc)
		      && this.numeroDocumento > 0 
		      );
		
		     
	}
	
	
}
