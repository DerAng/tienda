package co.ufps.edu.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;

public class LoginDao {

	
	SpringDbMgr springDbMgr = new SpringDbMgr();

	public String authenticate(String correoElectronico, String contraseņa) {
		if (esAdmin(correoElectronico, contraseņa)) {
			return "admin";
		} 
		return "";
	}

	private boolean esAdmin(String correoElectronico, String contraseņa) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("correo", correoElectronico);
		mapSqlParameterSource.addValue("contraseņa", contraseņa);
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("SELECT correoElectronico " + "	FROM usuario "
				+ "	WHERE correoElectronico = :correo " + " AND contraseņa = :contraseņa", mapSqlParameterSource);
		return (sqlRowSet.next());
	}

	

	
}
