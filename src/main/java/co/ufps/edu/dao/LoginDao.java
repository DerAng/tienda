package co.ufps.edu.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;

public class LoginDao {

	
	SpringDbMgr springDbMgr = new SpringDbMgr();

	public String authenticate(String correoElectronico, String contrase�a) {
		if (esAdmin(correoElectronico, contrase�a)) {
			return "admin";
		} 
		return "";
	}

	private boolean esAdmin(String correoElectronico, String contrase�a) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("correo", correoElectronico);
		mapSqlParameterSource.addValue("contrase�a", contrase�a);
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("SELECT correoElectronico " + "	FROM usuario "
				+ "	WHERE correoElectronico = :correo " + " AND contrase�a = :contrase�a", mapSqlParameterSource);
		return (sqlRowSet.next());
	}

	

	
}
