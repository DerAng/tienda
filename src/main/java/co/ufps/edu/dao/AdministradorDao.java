package co.ufps.edu.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import co.ufps.edu.bd.SpringDbMgr;
import co.ufps.edu.dto.Administrador;
import co.ufps.edu.dto.Tienda;

public class AdministradorDao {

  private SpringDbMgr springDbMgr;

  public AdministradorDao() {
    springDbMgr = new SpringDbMgr();
  }

  public List<Administrador> getAdministradores() {
    List<Administrador> administradores = new ArrayList<>();

    SqlRowSet sqlRowSet = springDbMgr.executeQuery(   "select      administrador.id                   idAdmin, "
                                                    + "            administrador.nombre               nombre,"
                                                    + "            administrador.direccion            direccion,"
                                                    + "            administrador.fechaNacimiento      fn,"
                                                    + "            administrador.fechaIngreso         fi "
                                                    + "from        administrador "
                                                    + "ORDER BY    administrador.id desc");


    while (sqlRowSet.next()) {
      // Creamos la tienda
      Administrador administrador = new Administrador();

      // Llenamos el objeto de datos
      administrador.setCodigo(sqlRowSet.getInt("idAdmin"));
      administrador.setNombre(sqlRowSet.getString("nombre"));
      administrador.setDireccion(sqlRowSet.getString("direccion"));
      administrador.setFechaNacimiento(sqlRowSet.getDate("fn"));
      administrador.setFechaIngreso(sqlRowSet.getDate("fi"));      

      // Guardamos la
      administradores.add(administrador);
    }

    return administradores;
  }
  
  public Map<Integer,String> getlistaAdministradores() {
    Map<Integer,String> administradores = new HashMap<Integer,String>();

    SqlRowSet sqlRowSet = springDbMgr.executeQuery(   "select      administrador.id                   idAdmin, "
                                                    + "            administrador.nombre               nombre "
                                                    + "from        administrador "
                                                    + "ORDER BY    administrador.id desc");

    while (sqlRowSet.next()) {
      administradores.put(sqlRowSet.getInt("idAdmin"), sqlRowSet.getString("nombre"));
    }

    return administradores;
  }
  
}
