package co.ufps.edu.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;
import co.ufps.edu.dto.Tienda;

public class TiendaDao {
	
	private SpringDbMgr springDbMgr;
	
	public TiendaDao(){
		springDbMgr = new SpringDbMgr();
	}

	public List<Tienda> getTiendas() {
		List<Tienda> tiendas = new ArrayList<>();
		
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("select 		tienda.id 					idTienda, "
													 + " 	   		tienda.nit 					nit,"
													 + "			tienda.nombre				nombre,"
													 + " 			tienda.direccion 			direccion,"
													 + "			tienda.nombreRepresentante  nr,"
													 + "			administrador.nombre		nombreAdmin,"
													 + "			administrador.id			idAdmin "
													 + "from 		tienda "
													 + "inner join 	administrador ON administrador.id = tienda.administrador "
													 + "ORDER BY 	tienda.id desc");
		
		while(sqlRowSet.next()){
			// Creamos la tienda
			Tienda tienda = new Tienda();
			
			// Llenamos el objeto de datos
			tienda.setCodigo(sqlRowSet.getInt("idTienda"));
			tienda.setNit(sqlRowSet.getInt("nit"));
			tienda.setDireccion(sqlRowSet.getString("direccion"));
			tienda.setNombre(sqlRowSet.getString("nombre"));
			tienda.setNombreRepresentante(sqlRowSet.getString("nr"));
			tienda.setNombreAdministrador(sqlRowSet.getString("nombreAdmin"));
			tienda.setAdministrador(sqlRowSet.getInt("idAdmin"));
			
			// Guardamos la 
			tiendas.add(tienda);
		}
		
		
		return tiendas;
	}
}
