package co.ufps.edu.dto;

import org.springframework.util.StringUtils;

public class Categoria {
	
	private int codigo;
	private String nombre;
	private String descripcion;
	
	public Categoria(){
		
	}
	
	public Categoria(int codigo, String nombre, String descripcion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	

	public boolean validarDatos(){
		return (!StringUtils.isEmpty(this.nombre) 
		      && !StringUtils.isEmpty(this.descripcion)); 
		     
	}
	
	

}
