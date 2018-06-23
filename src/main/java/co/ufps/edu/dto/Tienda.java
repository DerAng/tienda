package co.ufps.edu.dto;

import org.springframework.util.StringUtils;

public class Tienda {
	
	private int codigo;
	private int nit;
	private String nombre;
	private int administrador;
	private String direccion;
	private String nombreRepresentante;
	private String nombreAdministrador;
	
	public Tienda(){
		
	}

	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public int getNit() {
		return nit;
	}


	public void setNit(int nit) {
		this.nit = nit;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getAdministrador() {
		return administrador;
	}


	public void setAdministrador(int administrador) {
		this.administrador = administrador;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getNombreRepresentante() {
		return nombreRepresentante;
	}


	public void setNombreRepresentante(String nombreRepresentante) {
		this.nombreRepresentante = nombreRepresentante;
	}
	
	public boolean validarDatos(){
		return (!StringUtils.isEmpty(this.nombre) 
		      && !StringUtils.isEmpty(this.direccion) 
		      && !StringUtils.isEmpty(this.nombreRepresentante)
		      && this.nit > 0 
		      && this.administrador > 0);
	}

	public String getNombreAdministrador() {
		return nombreAdministrador;
	}

	public void setNombreAdministrador(String nombreAdministrador) {
		this.nombreAdministrador = nombreAdministrador;
	}
}


