package co.ufps.edu.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;
import co.ufps.edu.dto.Producto;
import co.ufps.edu.dto.Vendedor;

public class VendedorDao {
	
	SpringDbMgr springDbMgr;
	
	public VendedorDao(){
		springDbMgr = new SpringDbMgr();
	}

	public boolean registrarVendedor(Vendedor v) {

		// Agrego los datos del registro (nombreColumna/Valor)

		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("codigo",v.getCodigo());
		map.addValue("nombre", v.getNombre());
		map.addValue("apellido", v.getApellido());
		map.addValue("direccion", v.getDireccion());
		map.addValue("telefono", v.getTelefono());
		map.addValue("fechaNacimiento", v.getFechaNacimiento());
		map.addValue("fechaIngreso", v.getFechaIngreso());
		map.addValue("nombreTienda", v.getNombreTienda());

		String query = "insert into vendedor(codigo,nombre,apellido,direccion,telefono,fechaNacimiento,fechaIngreso,nombreTienda) "
				+ "values(:codigo,:nombre,:apellido,:direccion,:telefono,:fechaNacimiento,:fechaIngreso)";

		int result = springDbMgr.executeDml(query, map);

		return (result == 1);
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
        // Creamos la tienda
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

}
