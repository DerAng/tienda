package co.ufps.edu.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;

public class LoginDao {

	
	SpringDbMgr springDbMgr = new SpringDbMgr();

	public String authenticate(String correoElectronico, String contraseña) {
		if (esAdmin(correoElectronico, contraseña)) {
			return "admin";
		} 
		return "";
	}

	private boolean esAdmin(String correoElectronico, String contraseña) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("correo", correoElectronico);
		mapSqlParameterSource.addValue("contraseña", contraseña);
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("SELECT correoElectronico " + "	FROM usuario "
				+ "	WHERE correoElectronico = :correo " + " AND contraseña = :contraseña", mapSqlParameterSource);
		return (sqlRowSet.next());
	}

	

	
}
