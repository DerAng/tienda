package co.ufps.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import co.ufps.edu.dao.CategoriaDao;
import co.ufps.edu.dao.ProductoDao;
import co.ufps.edu.dao.ProveedorDao;
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

}
