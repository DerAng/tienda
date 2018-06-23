package co.ufps.edu.dto;

import java.util.Date;

public class Producto {
	
	private int proveedor;
	private int codigo;
	private String nombre;
	private int categoria;
	private int stock;
	private int precioVenta;
	private  int costo;
	private Date fechaVencimiento;
	
	
	public Producto(){
		
	}


	public Producto(int proveedor, int codigo, String nombre, int categoria, int stock, int precioVenta, int costo,
			Date fechaVencimiento) {
		super();
		this.proveedor = proveedor;
		this.codigo = codigo;
		this.nombre = nombre;
		this.categoria = categoria;
		this.stock = stock;
		this.precioVenta = precioVenta;
		this.costo = costo;
		this.fechaVencimiento = fechaVencimiento;
	}


	public int getProveedor() {
		return proveedor;
	}


	public void setProveedor(int proveedor) {
		this.proveedor = proveedor;
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


	public int getCategoria() {
		return categoria;
	}


	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public int getPrecioVenta() {
		return precioVenta;
	}


	public void setPrecioVenta(int precioVenta) {
		this.precioVenta = precioVenta;
	}


	public int getCosto() {
		return costo;
	}


	public void setCosto(int costo) {
		this.costo = costo;
	}


	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}


	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	
	
	
	

}
