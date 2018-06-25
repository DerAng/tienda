package co.ufps.edu.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;
import co.ufps.edu.dto.Producto;
import co.ufps.edu.dto.Tienda;
import co.ufps.edu.dto.Vendedor;

public class VendedorDao {
	
	SpringDbMgr springDbMgr;
	
	public VendedorDao(){
		springDbMgr = new SpringDbMgr();
	}

  public List<Vendedor> getVendedores() {
    List<Vendedor> vendedores = new ArrayList<>();
    
    SqlRowSet sqlRowSet = springDbMgr.executeQuery("select      vendedor.codigo             codigo, "
                                                 + "            vendedor.nombre             nombre, "
                                                 + "            vendedor.apellido           apellido, "
                                                 + "            vendedor.direccion          direccion, "
                                                 + "            vendedor.telefono           telefono, "
                                                 + "            vendedor.fechaNacimiento    fechaNacimiento "
                                                 
                                                 + "from        vendedor "
                                                 + "ORDER BY    vendedor.codigo desc");
    
    while(sqlRowSet.next()){
        // Creamos el Vendedor
        Vendedor vendedor = new Vendedor();
        
        // Llenamos el objeto de datos
        vendedor.setCodigo(sqlRowSet.getInt("codigo"));
        vendedor.setNombre(sqlRowSet.getString("nombre"));
        vendedor.setApellido(sqlRowSet.getString("apellido"));
        vendedor.setDireccion(sqlRowSet.getString("direccion"));
        vendedor.setTelefono(sqlRowSet.getString("telefono"));
        vendedor.setFechaNacimiento(sqlRowSet.getDate("fechaNacimiento"));

        // Guardamos la 
        vendedores.add(vendedor);
    }
    
    
    return vendedores;
  }	
  
  
  
  public String registrarVendedor(Vendedor vendedor) {
	    // Agrego los datos del registro (nombreColumna/Valor)

	    MapSqlParameterSource map = new MapSqlParameterSource();
	    map.addValue("nombre", vendedor.getNombre());
	    map.addValue("apellido", vendedor.getApellido());
	    map.addValue("direccion",vendedor.getDireccion());
	    map.addValue("telefono", vendedor.getTelefono());
	    map.addValue("fechaNacimiento", vendedor.getFechaNacimiento());
	    map.addValue("fechaIngreso", vendedor.getFechaIngreso());
	    map.addValue("idTienda",vendedor.getNombreTienda());

	    // Armar la sentencia de actualización debase de datos
	    String query =
	        "INSERT INTO vendedor(nombre,apellido,direccion,telefono,fechaNacimiento,fechaIngreso,idTienda) VALUES(:nombre,:apellido,:direccion,:telefono,:fechaNacimiento,:fechaIngreso,:idTienda)";

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
	        : "El vendedor no pudo ser registrado. Contacte al administrador";
	  }
  
  
  
  

  
  public Vendedor obtenerVendedorPorCodigo(long codigoVendedor) {
 // Lista para retornar con los datos
    Vendedor vendedor = new Vendedor();

    // Consulta para realizar en base de datos
    MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue("codigo", codigoVendedor);
    SqlRowSet sqlRowSet = springDbMgr.executeQuery("select      vendedor.codigo             codigo, "
            + "            vendedor.nombre             nombre, "
            + "            vendedor.apellido           apellido, "
            + "            vendedor.direccion          direccion, "
            + "            vendedor.telefono           telefono, "
            + "            vendedor.fechaNacimiento    fechaNacimiento, "
            + "            vendedor.fechaIngreso       fechaI, "
            + "            vendedor.idTienda           idTienda "
            
            + "from        vendedor "
            + "ORDER BY    vendedor.codigo desc");

    // Consulto si el vendedor existe
    if (sqlRowSet.next()) {
      // Almaceno los datos de la tienda
     vendedor.setCodigo(sqlRowSet.getInt("codigo"));
     vendedor.setNombre(sqlRowSet.getString("nombre"));
     vendedor.setApellido(sqlRowSet.getString("apellido"));
     vendedor.setDireccion(sqlRowSet.getString("direccion"));
     vendedor.setTelefono(sqlRowSet.getString("telefono"));
     vendedor.setFechaNacimiento(sqlRowSet.getDate("fechaNacimiento"));
     vendedor.setFechaIngreso(sqlRowSet.getDate("fechaI"));
     vendedor.setNombreTienda(sqlRowSet.getInt("idTienda"));
     
    }

    // Retorna el vendedor desde base de datos
      return vendedor;
  }


  public String eliminarVendedor(Vendedor vendedor) {

    // Agrego los datos de la eliminación (nombreColumna/Valor)
    MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue("codigo", vendedor.getCodigo());

    // Armar la sentencia de actualización debase de datos
    String query = "DELETE FROM vendedor WHERE codigo = :codigo";

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
        : "El vendedor no puede ser eliminado. Contacte al administrador.";
  }
  
  
  
  public String editarVendedor(Vendedor vendedor) {
	    // Agrego los datos del registro (nombreColumna/Valor)

	  MapSqlParameterSource map = new MapSqlParameterSource();
	    map.addValue("codigo", vendedor.getCodigo());
	    map.addValue("nombre", vendedor.getNombre());
	    map.addValue("apellido", vendedor.getApellido());
	    map.addValue("direccion",vendedor.getDireccion());
	    map.addValue("telefono", vendedor.getTelefono());
	    map.addValue("fechaNacimiento", vendedor.getFechaNacimiento());
	    map.addValue("fechaIngreso", vendedor.getFechaIngreso());
	    map.addValue("idTienda",vendedor.getNombreTienda());

	    // Armar la sentencia de actualización de base de datos
	    String query =
	        "UPDATE vendedor SET nombre = :nombre, apellido = :apellido , direccion = :direccion, telefono = :telefono, fechaNacimiento = :fechaNacimiento ,  fechaIngreso = :fechaIngreso , idTienda = :idTienda   where codigo = :codigo ";

	    // Ejecutar la sentencia
	    int result = 0;
	    try {
	      result = springDbMgr.executeDml(query, map);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    // Si hubieron filas afectadas es por que si hubo registro, en caso contrario muestra el mensaje
	    // de error.
	    return (result == 1) ? "Actualizacion exitosa"
	        : "El vendedor no pudo ser actualizado. Contacte al administrador";
	    // Si hubieron filas afectadas es por que si hubo registro, en caso contrario muestra el mensaje
	    // de error.

	  }


}
