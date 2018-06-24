package co.ufps.edu.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import co.ufps.edu.bd.SpringDbMgr;
import co.ufps.edu.dto.Categoria;
import co.ufps.edu.dto.Tienda;

public class TiendaDao {

  private SpringDbMgr springDbMgr;

  public TiendaDao() {
    springDbMgr = new SpringDbMgr();
  }

  public List<Tienda> getTiendas() {
    List<Tienda> tiendas = new ArrayList<>();

    SqlRowSet sqlRowSet = springDbMgr.executeQuery(   "select      tienda.id                   idTienda, "
                                                    + "            tienda.nit                  nit,"
                                                    + "            tienda.nombre               nombre,"
                                                    + "            tienda.direccion            direccion,"
                                                    + "            tienda.nombreRepresentante  nr,"
                                                    + "            administrador.nombre        nombreAdmin,"
                                                    + "            administrador.id            idAdmin "
                                                    + "from        tienda "
                                                    + "inner join  administrador ON administrador.id = tienda.administrador "
                                                    + "ORDER BY    tienda.id desc");


    while (sqlRowSet.next()) {
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

  public String registrarTienda(Tienda tienda) {
    // Agrego los datos del registro (nombreColumna/Valor)

    MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue("nit", tienda.getNit());
    map.addValue("nombre", tienda.getNombre());
    map.addValue("administrador", tienda.getAdministrador());
    map.addValue("direccion", tienda.getDireccion());
    map.addValue("nombreRepresentante", tienda.getNombreRepresentante());

    // Armar la sentencia de actualización debase de datos
    String query =
        "INSERT INTO tienda(nit,nombre,administrador,direccion,nombreRepresentante) VALUES(:nit,:nombre,:administrador,:direccion,:nombreRepresentante)";

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
        : "La tienda no pudo ser registrada. Contacte al administrador";
  }
  
  
  
  
 
  public Tienda obtenerTiendaPorCodigo(long codigoTienda) {
 // Lista para retornar con los datos
    Tienda tienda = new Tienda();

    // Consulta para realizar en base de datos
    MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue("id", codigoTienda);
    SqlRowSet sqlRowSet = springDbMgr.executeQuery(" SELECT * FROM tienda WHERE id = :id", map);

    // Consulto si la tienda existe
    if (sqlRowSet.next()) {
      // Almaceno los datos de la tienda
      tienda.setCodigo(sqlRowSet.getInt("id"));
      tienda.setNombre(sqlRowSet.getString("nombre"));
     
    }

    // Retorna la tienda desde base de datos
    return tienda;
  }


  public String eliminarTienda(Tienda tienda) {

    // Agrego los datos de la eliminación (nombreColumna/Valor)
    MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue("id", tienda.getCodigo());

    // Armar la sentencia de actualización debase de datos
    String query = "DELETE FROM tienda WHERE id = :id";

    // Ejecutar la sentencia
    int result = 0;
    try {
      result = springDbMgr.executeDml(query, map);
    } catch (Exception e) {
      new Exception();
    }
    // Si hubieron filas afectadas es por que si hubo registro, en caso contrario muestra el mensaje
    // de error.
    return (result == 1) ? "Eliminacion exitosa"
        : "La Tienda no puede ser eliminada. Contacte al administrador.";
  }

  public Map<Integer,String> getListaTiendas() {
    Map<Integer,String> tiendas = new HashMap<Integer,String>();

    SqlRowSet sqlRowSet = springDbMgr.executeQuery(   "select      tienda.id                   idTienda, "
                                                    + "            tienda.nombre               nombre "
                                                    + "from        tienda "
                                                    + "ORDER BY    tienda.id desc");

    while (sqlRowSet.next()) {
    	tiendas.put(sqlRowSet.getInt("idTienda"), sqlRowSet.getString("nombre"));
    }

    return tiendas;
  }
}
