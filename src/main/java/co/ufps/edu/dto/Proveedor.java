package co.ufps.edu.dto;

import org.springframework.util.StringUtils;

public class Proveedor {
	
	private int codigo;
	private int nit_Empresa;
	private String nomEmpresa;
	private String nombreContacto;
	private String telefono;
	private String correoElectronico;
	private String formaPago;


	public int getNit_Empresa() {
		return nit_Empresa;
	}


	public void setNit_Empresa(int nit_Empresa) {
		this.nit_Empresa = nit_Empresa;
	}


	public String getNomEmpresa() {
		return nomEmpresa;
	}


	public void setNomEmpresa(String nomEmpresa) {
		this.nomEmpresa = nomEmpresa;
	}


	public String getNombreContacto() {
		return nombreContacto;
	}


	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
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

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getFormaPago() {
		return formaPago;
	}


	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}	
	
	public boolean validarDatos(){
		return (!StringUtils.isEmpty(this.nomEmpresa) 
		      && !StringUtils.isEmpty(this.nombreContacto) 
		      && !StringUtils.isEmpty(this.telefono)
		      && !StringUtils.isEmpty(this.correoElectronico)
		      && !StringUtils.isEmpty(this.formaPago)		     
		      && this.nit_Empresa > 0) ;		     
	}

}
