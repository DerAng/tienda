package co.ufps.edu.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import co.ufps.edu.bd.SpringDbMgr;
import co.ufps.edu.dto.Categoria;
import co.ufps.edu.dto.Venta;


public class VentaDao {
  private SpringDbMgr springDbMgr;


  public VentaDao() {
    springDbMgr = new SpringDbMgr();
  }


  public List<Venta> getVentas() {
    List<Venta> ventas = new ArrayList<>();

    SqlRowSet sqlRowSet =
        springDbMgr.executeQuery("select 		  venta.id			             idVenta, "
            + " 	   		                      venta.cliente				     cliente, "
            + "			                          venta.vendedor			     vendedor, "
            + "                                   venta.total                    total, "
            + "                                   venta.iva                      iva, "
            + "                                   venta.impuestoConsumo          impuestoConsumo,"
            + "                                   cliente.nombre                 nomCliente,"
            + "                                   vendedor.nombre                nomVendedor   " 
            + "                   from 		      venta "
            + "                     inner join    cliente on venta.cliente = cliente.codigo "
            + "                     inner join    vendedor on venta.vendedor = vendedor.codigo "
            + "                   ORDER BY 	      venta.id desc");

    while (sqlRowSet.next()) {
      // Creamos la tienda
      Venta venta = new Venta();

      // Llenamos el objeto de datos
      venta.setCodigo(sqlRowSet.getInt("idVenta"));
      venta.setCliente(sqlRowSet.getInt("cliente"));
      venta.setImpuestos(sqlRowSet.getInt("impuestoConsumo"));
      venta.setIva(sqlRowSet.getInt("iva"));
      venta.setTotal(sqlRowSet.getInt("total"));
      venta.setVendedor(sqlRowSet.getInt("vendedor"));
      venta.setNombreCliente(sqlRowSet.getString("nomCliente"));
      venta.setNombreVendedor(sqlRowSet.getString("nomVendedor"));


      // Guardamos la
      ventas.add(venta);
    }


    return ventas;
  }




  public String registrarVenta(Venta venta) {
    // Agrego los datos del registro (nombreColumna/Valor)

    MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue("cliente", venta.getCliente());
    map.addValue("vendedor", venta.getVendedor());
    map.addValue("impuestos", venta.getImpuestos());
    map.addValue("iva", venta.getIva());
    map.addValue("total", venta.getTotal());


    // Armar la sentencia de actualización de base de datos
    String query = "INSERT INTO venta(cliente,vendedor,impuestoConsumo,iva,total) VALUES(:cliente,:vendedor,:impuestos,:iva,:total)";

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
        : "La categoria no pudo ser registrada. Contacte al administrador";
  }

  public Map<Integer, String> getListaCategorias() {
    Map<Integer, String> categorias = new HashMap<Integer, String>();

    SqlRowSet sqlRowSet =
        springDbMgr.executeQuery("select      categoria.codigo               codigoCategoria, "
            + "            categoria.nombre               nombreCategoria "
            + "from        categoria " + "ORDER BY    categoria.codigo desc");

    while (sqlRowSet.next()) {
      categorias.put(sqlRowSet.getInt("codigoCategoria"), sqlRowSet.getString("nombreCategoria"));
    }

    return categorias;

  }



}
