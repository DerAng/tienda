package co.ufps.edu.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;
import co.ufps.edu.dto.Categoria;


public class CategoriaDao {
	private SpringDbMgr springDbMgr;
	
	
	public CategoriaDao(){
		springDbMgr = new SpringDbMgr();
	}
	
	
	public List<Categoria> getCategorias() {
		List<Categoria> categorias = new ArrayList<>();
		
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("select 		categoria.codigo			codigoCategoria, "
													 + " 	   		categoria.nombre				nom, "
													 + "			categoria.descripcion			descripcion "
													 + "from 		categoria "
													 + "ORDER BY 	categoria.codigo desc");
		
		while(sqlRowSet.next()){
			// Creamos la tienda
			Categoria categoria = new Categoria();
			
			// Llenamos el objeto de datos
			categoria.setCodigo(sqlRowSet.getInt("codigoCategoria"));
			categoria.setNombre(sqlRowSet.getString("nom"));
			categoria.setDescripcion(sqlRowSet.getString("descripcion"));
			
			
			// Guardamos la 
			categorias.add(categoria);
		}
		
		
		return categorias;
	}

	  public Map<Integer,String> getListaCategorias() {
	    Map<Integer,String> categorias = new HashMap<Integer,String>();

	    SqlRowSet sqlRowSet = springDbMgr.executeQuery(   "select      categoria.codigo               codigoCategoria, "
	                                                    + "            categoria.nombre               nombreCategoria "
	                                                    + "from        categoria "
	                                                    + "ORDER BY    categoria.codigo desc");

	    while (sqlRowSet.next()) {
	      categorias.put(sqlRowSet.getInt("codigoCategoria"), sqlRowSet.getString("nombreCategoria"));
	    }

	    return categorias;
	  }
}
