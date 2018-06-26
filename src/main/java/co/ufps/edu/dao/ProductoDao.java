package co.ufps.edu.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import co.ufps.edu.bd.SpringDbMgr;
import co.ufps.edu.dto.Categoria;
import co.ufps.edu.dto.Producto;
import co.ufps.edu.dto.Proveedor;
import co.ufps.edu.dto.Tienda;

public class ProductoDao {
  
  private SpringDbMgr springDbMgr;
  
  public ProductoDao(){
      springDbMgr = new SpringDbMgr();
  }

  public List<Producto> getProductos() {
      List<Producto> productos = new ArrayList<>();
      
      SqlRowSet sqlRowSet = springDbMgr.executeQuery("select      producto.codigo             codigoProducto, "
                                                   + "            producto.nombre             nombre,"
                                                   + "            producto.stock              stock,"
                                                   + "            producto.precioVenta        precio,"
                                                   + "            producto.costo              costo,"
                                                   + "            producto.fechaVencimiento   fechaVencimiento,"
                                                   + "            proveedor.nomEmpresa     nombreProveedor,"
                                                   + "            proveedor.codigo            codigoProveedor, "
                                                 
                                                   + "            categoria.codigo            codigoCategoria,"
                                                   + "            categoria.nombre            categoriaNombre "
                                                   
                                                   + "from        producto "
                                                   + "inner join  productoproveedor ON productoproveedor.idProducto = producto.codigo "
                                                   + "inner join  proveedor         ON proveedor.codigo = productoproveedor.idProveedor "
                                                   + "inner join  categoria         ON categoria.codigo = producto.categoria "
                                                   + "ORDER BY    producto.codigo desc");
      
      while(sqlRowSet.next()){
          // Creamos la tienda
          Producto producto = new Producto();
          
          // Llenamos el objeto de datos
          
          producto.setCodigo(sqlRowSet.getInt("codigoProducto"));
          producto.setNombre(sqlRowSet.getString("nombre"));
          producto.setStock(sqlRowSet.getInt("stock"));
          producto.setPrecioVenta(sqlRowSet.getInt("precio"));
          producto.setCosto(sqlRowSet.getInt("costo"));
          producto.setFechaVencimiento(sqlRowSet.getDate("fechaVencimiento"));
          producto.setNombreProveedor(sqlRowSet.getString("nombreProveedor"));
          producto.setNombreCategoria(sqlRowSet.getString("categoriaNombre"));
          
          // Guardamos la 
          productos.add(producto);
      }
      
      
      return productos;
  }
  
  public Map<Integer,String> getListaProductos() {
    Map<Integer,String> productos = new HashMap<>();

    SqlRowSet sqlRowSet = springDbMgr.executeQuery(   "select      producto.codigo               codigo, "
                                                    + "            producto.nombre               nombre,"
                                                    + "            producto.precioVenta          precio "
                                                    + "from        producto "
                                                    + "ORDER BY    producto.codigo desc");

    while (sqlRowSet.next()) {
      productos.put(sqlRowSet.getInt("codigo"), sqlRowSet.getString("nombre"));
    }

    return productos;
  }
  
  
  public String registrarProducto(Producto producto) {
    // Agrego los datos del registro (nombreColumna/Valor)

    MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue("nombre", producto.getNombre());
    map.addValue("categoria", producto.getCategoria());
    map.addValue("stock", producto.getStock());
    map.addValue("precioVenta", producto.getPrecioVenta());
    map.addValue("costo", producto.getCosto());
    map.addValue("fechaVencimiento", producto.getFechaVencimiento());

    // Armar la sentencia de actualización debase de datos
    String query =
        "INSERT INTO producto(nombre,categoria,stock,precioVenta,costo,fechaVencimiento) VALUES(:nombre,:categoria,:stock,:precioVenta,:costo,:fechaVencimiento)";

    // Ejecutar la sentencia
    ResultDB result = new ResultDB();
    try {
      result = springDbMgr.executeDmlWithKey(query, map);
    } catch (Exception e) {
      e.printStackTrace();
    }
    long cod = result.getKey();
    if(cod>0) {
      insertarProductoProveedor(cod, producto.getProveedor());
    }
    // Si hubieron filas afectadas es por que si hubo registro, en caso contrario muestra el mensaje
    // de error.
    return (cod > 0) ? "Registro exitoso"
        : "El producto no pudo ser registrado. Contacte al administrador";
  }

  private void insertarProductoProveedor(long cod, int proveedor) {
 // Agrego los datos del registro (nombreColumna/Valor)

    MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue("idProducto", cod);
    map.addValue("idProveedor", proveedor);

    // Armar la sentencia de actualización debase de datos
    String query =
        "INSERT INTO productoproveedor(idProducto,idProveedor) VALUES(:idProducto,:idProveedor)";

    // Ejecutar la sentencia
    int result = 0;
    try {
      result = springDbMgr.executeDml(query, map);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
  
  public Producto obtenerProductoPorId(long idProducto) {
 // Lista para retornar con los datos
    Producto producto = new Producto();

    // Consulta para realizar en base de datos
    MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue("codigo", idProducto);
    SqlRowSet sqlRowSet = springDbMgr.executeQuery("select      producto.codigo             codigoProducto, "
            + "            producto.nombre             nombre,"
            + "            producto.stock              stock,"
            + "            producto.precioVenta        precio,"
            + "            producto.costo              costo,"
            + "            producto.fechaVencimiento   fechaVencimiento,"
            + "            proveedor.nomEmpresa     nombreProveedor,"
            + "            proveedor.codigo            codigoProveedor, "
          
            + "            categoria.codigo            codigoCategoria,"
            + "            categoria.nombre            categoriaNombre "
            
            + "from        producto "
            + "inner join  productoproveedor ON productoproveedor.idProducto = producto.codigo "
            + "inner join  proveedor         ON proveedor.codigo = productoproveedor.idProveedor "
            + "inner join  categoria         ON categoria.codigo = producto.categoria "
            + "where producto.codigo = :codigo "
            + "ORDER BY    producto.codigo desc", map);

    // Consulto si la categoria existe
    if (sqlRowSet.next()) {
      // Almaceno los datos de la categoria
      producto.setCodigo(sqlRowSet.getInt("codigo"));
      producto.setProveedor(sqlRowSet.getInt("codigoProveedor"));
      producto.setNombre(sqlRowSet.getString("nombre"));
      producto.setCategoria(sqlRowSet.getInt("codigoCategoria"));
      producto.setStock(sqlRowSet.getInt("stock"));
      producto.setPrecioVenta(sqlRowSet.getInt("precio"));
      producto.setCosto(sqlRowSet.getInt("costo"));
      producto.setFechaVencimiento(sqlRowSet.getDate("fechaVencimiento"));
      
    }

    // Retorna la categoria desde base de datos
    return producto;
  }
  
  
  public String eliminarProducto(Producto producto) {
    // Agrego los datos de la eliminación (nombreColumna/Valor)
    MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue("codigo", producto.getCodigo());

    // Armar la sentencia de actualización debase de datos
    String query = "DELETE FROM producto WHERE codigo = :codigo";

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
        : "La categoria no puede ser eliminada. Contacte al administrador.";
  }
  
  public void eliminarProductoPorProveedor(Producto producto) {
    // Agrego los datos de la eliminación (nombreColumna/Valor)
    MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue("idProducto", producto.getCodigo());

    // Armar la sentencia de actualización debase de datos
    String query = "DELETE FROM productoproveedor WHERE idProducto = :idProducto";

    // Ejecutar la sentencia
    int result = 0;
    try {
      result = springDbMgr.executeDml(query, map);
    } catch (Exception e) {
      new Exception();
    }

  }
  
  
  public String editarProducto(Producto producto) {
	    // Agrego los datos del registro (nombreColumna/Valor)

	    MapSqlParameterSource map = new MapSqlParameterSource();
	    map.addValue("codigo", producto.getCodigo());
	    map.addValue("nombre", producto.getNombre());
	    map.addValue("categoria", producto.getCategoria());
	    map.addValue("stock", producto.getStock());
	    map.addValue("precioVenta", producto.getPrecioVenta());
	    map.addValue("costo", producto.getCosto());
	    map.addValue("fechaVencimiento", producto.getFechaVencimiento());
	
	    

	    // Armar la sentencia de actualización debase de datos
	    String query =
	        "UPDATE producto SET nombre = :nombre, categoria = :categoria , stock = :stock, precioVenta = :precioVenta, costo = :costo, fechaVencimiento = :fechaVencimiento where codigo = :codigo ";

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
	        : "El producto no pudo ser actualizado. Contacte al administrador";
	    // Si hubieron filas afectadas es por que si hubo registro, en caso contrario muestra el mensaje
	    // de error.

	  }

  public Object getListPrecioProductos() {
    Map<Integer,Integer> productos = new HashMap<>();

    SqlRowSet sqlRowSet = springDbMgr.executeQuery(   "select      producto.codigo               codigo, "
                                                    + "            producto.nombre               nombre,"
                                                    + "            producto.precioVenta          precio "
                                                    + "from        producto "
                                                    + "ORDER BY    producto.codigo desc");

    
    while (sqlRowSet.next()) {
      
      productos.put(sqlRowSet.getInt("codigo"), sqlRowSet.getInt("precio"));
    }

    return productos;
  }

  public static void main(String[] args) {
    ProductoDao p = new ProductoDao();
    System.out.println(p.getListPrecioProductos());
  }
  
}
