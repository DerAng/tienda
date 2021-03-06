package co.ufps.edu.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import co.ufps.edu.bd.SpringDbMgr;
import co.ufps.edu.dto.Cliente;

import co.ufps.edu.dto.Vendedor;


public class ClienteDao {
	
	private SpringDbMgr springDbMgr;

	public ClienteDao(){
		springDbMgr = new SpringDbMgr();
	}

	public List<Cliente> getClientes() {
		List<Cliente> clientes= new ArrayList<>();
		
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("select 		cliente.codigo			 codigoCliente, "
													 + " 	   		cliente.tipoDoc 		 doc, "
													 + "			cliente.numeroDocumento  num, "
													 + " 			cliente.nombre			 nom, "
													 + "			cliente.apellido         apellido, "
													 + "			cliente.direccion	     direccion, "
													 + "			cliente.telefono	     telf, "
													 + "			cliente.correoElectronico correo "
													 + "from 		cliente "
													+ "ORDER BY 	cliente.codigo desc");
		
		while(sqlRowSet.next()){
			// Creamos Cliente
			Cliente cliente = new Cliente();
			
			// Llenamos el objeto de datos
			cliente.setCodigo(sqlRowSet.getInt("codigoCliente"));
			cliente.setTipoDoc(sqlRowSet.getString("doc"));
			cliente.setNumeroDocumento(sqlRowSet.getInt("num"));
			cliente.setNombre(sqlRowSet.getString("nom"));
			cliente.setApellido(sqlRowSet.getString("apellido"));
			cliente.setDireccion(sqlRowSet.getString("direccion"));
			cliente.setTelefono(sqlRowSet.getString("telf"));
		    cliente.setCorreoElectronico(sqlRowSet.getString("correo"));
			
			
			
			// Guardamos la 
			clientes.add(cliente);
		}
		
		
		return clientes;
	}
	
	 public String registrarCliente(Cliente cliente) {
		    // Agrego los datos del registro (nombreColumna/Valor)

		    MapSqlParameterSource map = new MapSqlParameterSource();
		    map.addValue("tipoDoc", cliente.getTipoDoc());
		    map.addValue("numeroDocumento", cliente.getNumeroDocumento());
		    map.addValue("nombre",cliente.getNombre());
		    map.addValue("apellido", cliente.getApellido());
		    map.addValue("direccion", cliente.getDireccion());
		    map.addValue("telefono", cliente.getTelefono());
		    map.addValue("correoElectronico",cliente.getCorreoElectronico());
		    

		    // Armar la sentencia de actualización debase de datos.
		    String query =
		        "INSERT INTO cliente(tipoDoc,numeroDocumento,nombre,apellido,direccion,telefono,correoElectronico) VALUES(:tipoDoc,:numeroDocumento,:nombre,:apellido,:direccion,:telefono,:correoElectronico)";

		    // Ejecutar la sentencia.
		    int result = 0;
		    try {
		      result = springDbMgr.executeDml(query, map);
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		    // Si hubieron filas afectadas es por que si hubo registro, en caso contrario muestra el mensaje.
		    // de error.
		    return (result == 1) ? "Registro exitoso"
		        : "El cliente no pudo ser registrado. Contacte al administrador";
		  }
	 
	 
	 
	 
	 public Cliente obtenerClientePorCodigo(long codigoCliente) {
		 // Lista para retornar con los datos
		    Cliente cliente = new Cliente();

		    // Consulta para realizar en base de datos
		    MapSqlParameterSource map = new MapSqlParameterSource();
		    map.addValue("codigo", codigoCliente);
		    SqlRowSet sqlRowSet = springDbMgr.executeQuery("select 		cliente.codigo			 codigoCliente, "
					 + " 	   		cliente.tipoDoc 		 doc, "
					 + "			cliente.numeroDocumento  num, "
					 + " 			cliente.nombre			 nom, "
					 + "			cliente.apellido         apellido, "
					 + "			cliente.direccion	     direccion, "
					 + "			cliente.telefono	     telf, "
					 + "			cliente.correoElectronico correo "
					 + "from 		cliente "
					+ "ORDER BY 	cliente.codigo desc");

		    // Consulto si el cliente existe
		    if (sqlRowSet.next()) {
		      // Almaceno los datos del cliente
		      cliente.setCodigo(sqlRowSet.getInt("codigoCliente"));
		      cliente.setTipoDoc(sqlRowSet.getString("doc"));
		      cliente.setNumeroDocumento(sqlRowSet.getInt("num"));
		      cliente.setNombre(sqlRowSet.getString("nom"));
		      cliente.setApellido(sqlRowSet.getString("apellido"));
		      cliente.setDireccion(sqlRowSet.getString("direccion"));
		      cliente.setTelefono(sqlRowSet.getString("telf"));
		      cliente.setCorreoElectronico(sqlRowSet.getString("correo"));
		     
		    }

		    // Retorna el cliente desde base de datos
		    return cliente;
		  }


		  public String eliminarCliente(Cliente cliente) {

		    // Agrego los datos de la eliminación (nombreColumna/Valor)
		    MapSqlParameterSource map = new MapSqlParameterSource();
		    map.addValue("codigo", cliente.getCodigo());

		    // Armar la sentencia de actualización debase de datos
		    String query = "DELETE FROM cliente WHERE codigo = :codigo";

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
		        : "El Cliente no puede ser eliminado. Contacte al administrador.";
		  }
		  
		  
		  public String editarCliente(Cliente cliente) {
			 
			    // Agrego los datos del registro (nombreColumna/Valor)

			    MapSqlParameterSource map = new MapSqlParameterSource();
			    map.addValue("codigo", cliente.getCodigo());
			    map.addValue("tipoDoc", cliente.getTipoDoc());
			    map.addValue("numeroDocumento", cliente.getNumeroDocumento());
			    map.addValue("nombre",cliente.getNombre());
			    map.addValue("apellido", cliente.getApellido());
			    map.addValue("direccion", cliente.getDireccion());
			    map.addValue("telefono", cliente.getTelefono());
			    map.addValue("correoElectronico",cliente.getCorreoElectronico());
			   

			    // Armar la sentencia de actualización debase de datos
			    String query =
			        "UPDATE cliente SET numeroDocumento = :numeroDocumento, tipoDoc = :tipoDoc, nombre = :nombre , apellido = :apellido, direccion = :direccion, telefono = :telefono, correoElectronico = :correoElectronico where codigo = :codigo ";

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
			        : "El cliente no pudo ser actualizado. Contacte al administrador";
			    // Si hubieron filas afectadas es por que si hubo registro, en caso contrario muestra el mensaje
			    // de error.

			  }


  public Map<Integer,String> getListaClientes() {
    Map<Integer,String> productos = new HashMap<Integer,String>();

    SqlRowSet sqlRowSet = springDbMgr.executeQuery(   "select      cliente.codigo                               codigo, "
                                                    + "            CONCAT(cliente.nombre,' ',cliente.apellido ) nombre "
                                                    + "from        cliente "
                                                    + "ORDER BY    cliente.codigo desc");

    while (sqlRowSet.next()) {
      productos.put(sqlRowSet.getInt("codigo"), sqlRowSet.getString("nombre"));
    }

    return productos;
  }


}
