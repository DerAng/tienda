package co.ufps.edu.dao;

import java.util.ArrayList;
import java.util.List;

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
													 + "			cliente.direccion	     direccion "
													 + "from 		cliente "
													+ "ORDER BY 	cliente.codigo desc");
		
		while(sqlRowSet.next()){
			// Creamos la tienda
			Cliente cliente = new Cliente();
			
			// Llenamos el objeto de datos
			cliente.setCodigo(sqlRowSet.getInt("codigoCliente"));
			cliente.setTipoDoc(sqlRowSet.getString("doc"));
			cliente.setNumeroDocumento(sqlRowSet.getInt("num"));
			cliente.setNombre(sqlRowSet.getString("nom"));
			cliente.setApellido(sqlRowSet.getString("apellido"));
			cliente.setDireccion(sqlRowSet.getString("direccion"));
			
			
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

}
