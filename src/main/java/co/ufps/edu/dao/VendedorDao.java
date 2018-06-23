package co.ufps.edu.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;
import co.ufps.edu.dto.Vendedor;

public class VendedorDao {
	
	SpringDbMgr springDbMgr;
	
	public VendedorDao(){
		springDbMgr = new SpringDbMgr();
	}

	public boolean registrarVendedor(Vendedor v) {

		// Agrego los datos del registro (nombreColumna/Valor)

		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("codigo",v.getCodigo());
		map.addValue("nombre", v.getNombre());
		map.addValue("apellido", v.getApellido());
		map.addValue("direccion", v.getDireccion());
		map.addValue("telefono", v.getTelefono());
		map.addValue("fechaNacimiento", v.getFechaNacimiento());
		map.addValue("fechaIngreso", v.getFechaIngreso());
		map.addValue("nombreTienda", v.getNombreTienda());

		String query = "insert into vendedor(codigo,nombre,apellido,direccion,telefono,fechaNacimiento,fechaIngreso,nombreTienda) "
				+ "values(:codigo,:nombre,:apellido,:direccion,:telefono,:fechaNacimiento,:fechaIngreso)";

		int result = springDbMgr.executeDml(query, map);

		return (result == 1);
	}
	
	
/*
	private boolean esCodigoRepetido(int codigo, SpringDbMgr springDbMgr) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("code", Integer.parseInt(codigo));
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("select codigo from estudiante where codigo = :code",
				mapSqlParameterSource);
		return (sqlRowSet.next());
	}
	
	*/

	
	
	

}
