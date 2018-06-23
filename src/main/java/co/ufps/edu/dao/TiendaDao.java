package co.ufps.edu.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import co.ufps.edu.bd.SpringDbMgr;
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
}
