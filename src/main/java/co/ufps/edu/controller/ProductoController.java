package co.ufps.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import co.ufps.edu.dao.ProductoDao;

@Controller
public class ProductoController {

  private ProductoDao productoDao;

  public ProductoController() {
    productoDao = new ProductoDao();
  }

  @GetMapping("productos") // Base
  public String index(Model model) {
    model.addAttribute("productos", productoDao.getProductos());
    return "/Administrador/Producto/Productos"; // Nombre del archivo jsp
  }


}
