package co.ufps.edu.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;
import co.ufps.edu.dto.Proveedor;
import co.ufps.edu.dto.Tienda;

public class ProveedorDao {
	private SpringDbMgr springDbMgr;
	
	
	public ProveedorDao(){
		springDbMgr = new SpringDbMgr();
	}
	
	public List<Proveedor> getProveedores() {
		List<Proveedor> proveedores = new ArrayList<>();
		
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("select 		proveedor.codigo					codigoProveedor, "
				                                     + "            proveedor.nit_Empresa               nitProveedor, "
													 + " 	   		proveedor.nomEmpresa				nomEmpresaProveedor, "
													 + "			proveedor.nombreContacto	        nombreContactoProveedor, "
													 + " 			proveedor.telefono			        telefonoProveedor, "
													 + "			proveedor.correoElectronico         correoProveedor "
													 
												     + "from 		proveedor "
													
													 + "ORDER BY 	proveedor.codigo desc ");
		
		while(sqlRowSet.next()){
			// Creamos el proveedor
			Proveedor proveedor = new Proveedor();
			
			// Llenamos el objeto de datos
			proveedor.setCodigo(sqlRowSet.getInt("codigoProveedor"));
			proveedor.setNit_Empresa(sqlRowSet.getInt("nitProveedor"));
			proveedor.setNomEmpresa(sqlRowSet.getString("nomEmpresaProveedor"));
			proveedor.setNombreContacto(sqlRowSet.getString("nombreContactoProveedor"));
			proveedor.setTelefono(sqlRowSet.getString("telefonoProveedor"));
			proveedor.setCorreoElectronico(sqlRowSet.getString("correoProveedor"));
			
			
			// Guardamos la 
			proveedores.add(proveedor);
		}
		
		
		return proveedores;
	}

}
