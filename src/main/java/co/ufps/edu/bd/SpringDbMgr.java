package co.ufps.edu.bd;

import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.dao.ResultDB;


/**
 * Class with basic operations to interact with Database System.
 * 
 * <p>
 * This class contains specific implementation using Spring-JDBC Project. For
 * more information check Spring Framework Reference Documentation.
 * 
 * @see <a href=
 *      "https://docs.spring.io/spring/docs/current/spring-framework-reference/html/spring-data-tier.html">
 *      https://docs.spring.io/spring/docs/current/spring-framework-reference/html/spring-data-tier.html
 *      </a>
 */
public class SpringDbMgr {

	private DataSource dataSource;

	public SpringDbMgr() {
		initDataSource();
	}

	private void initDataSource() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Properties p = new Properties();
		p.setProperty("user", "root");
		p.setProperty("password", "");
		p.setProperty("driverClassName", "com.mysql.jdbc.Driver");

		dataSource = new DriverManagerDataSource("jdbc:mysql://localhost:3306/tienda?useUnicode=true&amp;characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&serverTimezone=UTC", p);
		//jdbc:mysql://localhost:3306/dbname
	}

	/**
	 * This method implements SELECT query execution logic without parameters in
	 * Database System using Spring-JDBC.
	 * 
	 * @param query
	 *            Text that represents query to be executed.
	 * @return Set of rows returned by the query.
	 * @throws AppException
	 *             If there is any problem in the execution.
	 */
	public SqlRowSet executeQuery(String query) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		SqlRowSet sqlRowSet = namedParameterJdbcTemplate.queryForRowSet(query, mapSqlParameterSource);
		return sqlRowSet;
	}

	/**
	 * This method implements SELECT query execution logic in Database System
	 * using Spring-JDBC.
	 * 
	 * @param query
	 *            Text that represents query to be executed.
	 * @param parameterMap
	 *            Object containing all parameters required to bind SQL
	 *            variables.
	 * @return Set of rows returned by the query.
	 * @throws AppException
	 *             If there is any problem in the execution.
	 */
	public SqlRowSet executeQuery(String query, MapSqlParameterSource parameterMap) {

		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		SqlRowSet sqlRowSet = namedParameterJdbcTemplate.queryForRowSet(query, parameterMap);

		return sqlRowSet;
	}

	/**
	 * This method implements INSERT/UPDATE/DELETE query execution logic without
	 * parameters in Database System using Spring-JDBC.
	 * 
	 * @param query
	 *            Text that represents query to be executed.
	 * @return the number of rows affected.
	 * @throws AppException
	 *             If there is any problem in the execution.
	 */
	public int executeDml(String query) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		int affectedRows = namedParameterJdbcTemplate.update(query, mapSqlParameterSource);

		return affectedRows;
	}

	/**
	 * This method implements INSERT/UPDATE/DELETE query execution logic in
	 * Database System using Spring-JDBC.
	 * 
	 * @param query
	 *            Text that represents DML to be executed.
	 * @param parameterMap
	 *            Object containing all parameters required to bind SQL
	 *            variables.
	 * @return the number of rows affected.
	 * @throws AppException
	 *             If there is any problem in the execution.
	 */
	public int executeDml(String query, MapSqlParameterSource parameterMap) {

		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int affectedRows = namedParameterJdbcTemplate.update(query, parameterMap,keyHolder);

		return affectedRows;
	}
	
	public ResultDB executeDmlWithKey(String query, MapSqlParameterSource parameterMap) {

		ResultDB resultDB = new ResultDB();
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int affectedRows = namedParameterJdbcTemplate.update(query, parameterMap,keyHolder);
		Long generatedId = keyHolder.getKey().longValue();
		resultDB.setResult(affectedRows);
		resultDB.setKey(generatedId);
		return resultDB;
	}

	/**
	 * This method set a dataSource.
	 * 
	 * @param dataSource
	 *            for set
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public static void main(String[] args) {
		SpringDbMgr s = new SpringDbMgr();
		SqlRowSet r = s.executeQuery("select * from tienda");
		r.next();
		System.out.println(r.getString("nombre"));
		
		/*MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("codigo", 1550967);
		map.addValue("nombre", "juan");
		map.addValue("apellido", "perez");
		map.addValue("correo", "juan.perez@gmail.com");
		map.addValue("telefono", 555);
		map.addValue("semestre", 7);
		map.addValue("contrasena", 1234);
		
		
		
		String query = "insert into estudiante(codigo,nombre,apellido,correo,telefono,semestre,contrasena) "
							  + "values(:codigo,:nombre,:apellido,:correo,:telefono,:semestre,:contrasena)";
				
		int result = s.executeDml(query, map);*/
	}
}
