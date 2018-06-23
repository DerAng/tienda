package co.ufps.edu.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import co.ufps.edu.bd.SpringDbMgr;
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
                                                   + "inner join  productoproveedor ON productoproveedor.idProducto = producto.proveedor "
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
  
}
