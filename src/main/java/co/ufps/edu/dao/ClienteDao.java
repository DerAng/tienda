package co.ufps.edu.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;
import co.ufps.edu.dto.Cliente;


public class ClienteDao {
	
	private SpringDbMgr springDbMgr;
	

	
	public ClienteDao(){
		springDbMgr = new SpringDbMgr();
	}

	public List<Cliente> getClientes() {
		List<Cliente> clientes= new ArrayList<>();
		
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("select 		cliente.codigo			 codigoCliente, "
													 + " 	   		cliente.tipoDoc 		 doc, "
													 + "			cliente.numeroDocumento  num, "
													 + " 			cliente.nombre			 nom, "
													 + "			cliente.apellido         apellido, "
													 + "			cliente.direccion	     direccion "
													 + "from 		cliente "
													+ "ORDER BY 	cliente.codigo desc");
		
		while(sqlRowSet.next()){
			// Creamos la tienda
			Cliente cliente = new Cliente();
			
			// Llenamos el objeto de datos
			cliente.setCodigo(sqlRowSet.getInt("codigoCliente"));
			cliente.setTipoDoc(sqlRowSet.getString("doc"));
			cliente.setNumeroDocumento(sqlRowSet.getInt("num"));
			cliente.setNombre(sqlRowSet.getString("nom"));
			cliente.setApellido(sqlRowSet.getString("apellido"));
			cliente.setDireccion(sqlRowSet.getString("direccion"));
			
			
			// Guardamos la 
			clientes.add(cliente);
		}
		
		
		return clientes;
	}

}
