package co.ufps.edu.dto;


import java.sql.Date;

import org.springframework.util.StringUtils;

public class Vendedor {
	
	private int codigo;
	private String nombre;
	private String apellido;
	private String direccion;
	private String telefono;
	private Date fechaNacimiento;
	private Date fechaIngreso;
	private int nombreTienda;
	
	public Vendedor(){
		
	}
	
	public Vendedor(int codigo, String nombre, String apellido, String direccion, String telefono, Date fechaNacimiento,
			Date fechaIngreso, int nombreTienda) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIngreso = fechaIngreso;
		this.nombreTienda = nombreTienda;
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
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	public int getNombreTienda() {
		return nombreTienda;
	}
	public void setNombreTienda(int nombreTienda) {
		this.nombreTienda = nombreTienda;
	}
	
	public boolean validarDatos(){
		return (!StringUtils.isEmpty(this.nombre) 
		      && !StringUtils.isEmpty(this.apellido) 
		      && !StringUtils.isEmpty(this.direccion)
		      && !StringUtils.isEmpty(this.telefono)
		      && !StringUtils.isEmpty(this.fechaNacimiento.toString())
		      && !StringUtils.isEmpty(this.fechaIngreso.toString())
		      && this.nombreTienda > 0);
	}
	
	

}
