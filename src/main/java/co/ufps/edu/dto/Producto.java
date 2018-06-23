package co.ufps.edu.dto;

import java.sql.Date;
import org.springframework.util.StringUtils;

public class Producto {

  private int proveedor;
  private int codigo;
  private String nombre;
  private int categoria;
  private int stock;
  private int precioVenta;
  private int costo;
  private Date fechaVencimiento;

  private String nombreProveedor;
  private String nombreCategoria;



  public Producto() {

  }

  public String getNombreProveedor() {
    return nombreProveedor;
  }

  public void setNombreProveedor(String nombreProveedor) {
    this.nombreProveedor = nombreProveedor;
  }

  public String getNombreCategoria() {
    return nombreCategoria;
  }

  public void setNombreCategoria(String nombreCategoria) {
    this.nombreCategoria = nombreCategoria;
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

  public boolean validarDatos(){
    return (!StringUtils.isEmpty(this.nombre) 
          && !StringUtils.isEmpty(this.fechaVencimiento.toString())
          && this.proveedor > 0 
          && this.categoria > 0
          && this.stock > 0
          && this.precioVenta > 0
          && this.costo > 0);
  }



}
