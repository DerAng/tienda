package co.ufps.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import co.ufps.edu.dao.CategoriaDao;
import co.ufps.edu.dao.ProductoDao;
import co.ufps.edu.dao.ProveedorDao;
import co.ufps.edu.dto.Categoria;
import co.ufps.edu.dto.Producto;
import co.ufps.edu.dto.Tienda;

@Controller
public class ProductoController {

  private ProductoDao productoDao;
  private ProveedorDao proveedorDao;
  private CategoriaDao categoriaDao;

  public ProductoController() {
    productoDao = new ProductoDao();
    proveedorDao = new ProveedorDao();
    categoriaDao = new CategoriaDao();
  }

  @GetMapping("productos") // Base
  public String index(Model model) {
    model.addAttribute("proveedores", proveedorDao.getlistaProveedores());    
    model.addAttribute("categorias", categoriaDao.getListaCategorias());
    model.addAttribute("productos",productoDao.getProductos());
    return "Administrador/Producto/Productos"; // Nombre del archivo jsp
  }

  @ModelAttribute("producto")
  public Producto setUpUserForm() {     
      return new Producto();
  }
  
  @PostMapping("/guardarProducto")
  public String RegistrarProducto(@ModelAttribute("producto") Producto producto, Model model) {
      if (producto.validarDatos()) {
          String mensaje = productoDao.registrarProducto(producto);
          if(mensaje.equals("Registro exitoso")) {
              model.addAttribute("result", "producto registrado con exito");
              model.addAttribute("producto", new Producto());
              return index(model);
          }else {
             model.addAttribute("wrong", mensaje);
             return index(model);
          }
      } else {            
          model.addAttribute("wrong", "Campos invalidos.");
          return index(model);
      }
  }
  
  @GetMapping(value = "/eliminarProducto")
  public String eliminarCategoria(@RequestParam("codigo") long idProducto, Model model) {
    // Consulto que el Id sea mayor a 0.
    if (idProducto <= 0) {
      return index(model);
    }
    Producto producto = productoDao.obtenerProductoPorId(idProducto);
    model.addAttribute("producto", producto);
    return "Administrador/Producto/EliminarProducto"; // Nombre del archivo jsp
  }


  @PostMapping(value = "/borrarProducto")
  public String borrarCategoria(@ModelAttribute("producto") Producto producto, Model model) {
    
    productoDao.eliminarProductoPorProveedor(producto);
    String mensaje = productoDao.eliminarProducto(producto);
    if (mensaje.equals("Eliminacion exitosa")) {
      model.addAttribute("result", "Producto eliminado con éxito.");
      return index(model);
    } else {
      model.addAttribute("wrong", mensaje);
      return eliminarCategoria(producto.getCodigo(), model);
      
    }

  }
  
  
  
  @GetMapping(value = "/actualizarProducto")
  public String actualizarProducto(@RequestParam("codigo") long codigoProducto, Model model) {
    // Consulto que el Id sea mayor a 0.
    if (codigoProducto <= 0) {
      return index(model);
    }
    Producto producto = productoDao.obtenerProductoPorId(codigoProducto);
    model.addAttribute("producto", producto);
    model.addAttribute("proveedores", proveedorDao.getlistaProveedores());
    model.addAttribute("categorias", categoriaDao.getListaCategorias());
    
    return "Administrador/Producto/ActualizarProducto"; // Nombre del archivo jsp
  }

  @PostMapping(value = "/editarProducto")
  public String editarProducto(@ModelAttribute("producto") Producto producto, Model model) {

    // Consulta si tiene todos los campos llenos
    if (producto.validarDatos()) {
      String mensaje = productoDao.editarProducto(producto);
      if (mensaje.equals("Actualizacion exitosa")) {
        model.addAttribute("result", "Producto actualizado con éxito.");
        return index(model);
      } else {
        model.addAttribute("wrong", mensaje);
        return "Administrador/Producto/ActualizarProducto"; // Nombre del archivo jsp
      }
      //
    } else {
      model.addAttribute("wrong", "Debes llenar todos los campos.");
      return "Administrador/Producto/ActualizarProducto"; // Nombre del archivo jsp
    }
  }
  
  
  @GetMapping("/descargarProductos")
  private String generarInforme() {
    return "xlsView"; // Nombre del archivo jsp
  }

}
