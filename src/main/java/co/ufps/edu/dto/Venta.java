package co.ufps.edu.dto;

public class Venta {

  private int codigo;
  private int vendedor;
  private int cliente;
  private int producto;

  private int totalSinImpuesto;
  private int iva;
  private int impuestos;
  private int total;
  
  private String nombreCliente;
  private String nombreVendedor;
  
  
  public int getCodigo() {
    return codigo;
  }
  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }
  public int getVendedor() {
    return vendedor;
  }
  public void setVendedor(int vendedor) {
    this.vendedor = vendedor;
  }
  public int getCliente() {
    return cliente;
  }
  public void setCliente(int cliente) {
    this.cliente = cliente;
  }
  public int getTotalSinImpuesto() {
    return totalSinImpuesto;
  }
  public void setTotalSinImpuesto(int totalSinImpuesto) {
    this.totalSinImpuesto = totalSinImpuesto;
  }
  public int getIva() {
    return iva;
  }
  public void setIva(int iva) {
    this.iva = iva;
  }
  public int getImpuestos() {
    return impuestos;
  }
  public void setImpuestos(int impuestos) {
    this.impuestos = impuestos;
  }
  public int getTotal() {
    return total;
  }
  public void setTotal(int total) {
    this.total = total;
  }
  public boolean isValidoParaRegistrar() {
    // TODO Auto-generated method stub
    return true;
  }
  public String getNombreCliente() {
    return nombreCliente;
  }
  public void setNombreCliente(String nombreCliente) {
    this.nombreCliente = nombreCliente;
  }
  public String getNombreVendedor() {
    return nombreVendedor;
  }
  public void setNombreVendedor(String nombreVendedor) {
    this.nombreVendedor = nombreVendedor;
  }
  public int getProducto() {
    return producto;
  }
  public void setProducto(int producto) {
    this.producto = producto;
  }
  
  
}
