package co.ufps.edu.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
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
	
	
	public String registrarProveedor(Proveedor proveedor) {
	    // Agrego los datos del registro (nombreColumna/Valor)

	    MapSqlParameterSource map = new MapSqlParameterSource();
	    map.addValue("nit_Empresa", proveedor.getNit_Empresa());
	    map.addValue("nomEmpresa", proveedor.getNomEmpresa());
	    map.addValue("nombreContacto", proveedor.getNombreContacto());
	    map.addValue("telefono", proveedor.getTelefono());
	    map.addValue("correoElectronico", proveedor.getCorreoElectronico());
	    map.addValue("formaPago", proveedor.getFormaPago());

	    // Armar la sentencia de actualización debase de datos
	    String query =
	        "INSERT INTO proveedor(nit_Empresa,nomEmpresa,nombreContacto,telefono,correoElectronico,formaPago) VALUES(:nit_Empresa,:nomEmpresa,:nombreContacto,:telefono,:correoElectronico,:formaPago)";

	    // Ejecutar la sentencia
	    int result = 0;
	    try {
	      result = springDbMgr.executeDml(query, map);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    // Si hubieron filas afectadas es por que si hubo registro, en caso contrario muestra el mensaje
	    // de error.
	    return (result == 1) ? "Registro exitoso"
	        : "El proveedor no pudo ser registrado. Contacte al administrador";
	  }

}
