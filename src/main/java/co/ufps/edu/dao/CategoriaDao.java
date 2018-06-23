package co.ufps.edu.dao;

import java.util.ArrayList;
import java.util.List;

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
}
