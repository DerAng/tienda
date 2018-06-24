package co.ufps.edu.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import java.util.Map;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;
import co.ufps.edu.dto.Categoria;
import co.ufps.edu.dto.Vendedor;


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

	
	
	
	public String registrarCategoria(Categoria categoria) {
	    // Agrego los datos del registro (nombreColumna/Valor)

	    MapSqlParameterSource map = new MapSqlParameterSource();
	    map.addValue("nombre", categoria.getNombre());
	    map.addValue("descripcion", categoria.getDescripcion());
	    

	    // Armar la sentencia de actualización de base de datos
	    String query =
	        "INSERT INTO categoria(nombre,descripcion) VALUES(:nombre,:descripcion)";

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
	        : "La categoria no pudo ser registrada. Contacte al administrador";

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
