package co.ufps.edu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import co.ufps.edu.dao.ClienteDao;
import co.ufps.edu.dao.ProductoDao;
import co.ufps.edu.dao.VendedorDao;
import co.ufps.edu.dao.VentaDao;
import co.ufps.edu.dto.Categoria;

import co.ufps.edu.dto.Venta;


@Controller
public class VentaController {
  private ProductoDao   productoDao;
  private ClienteDao    clienteDao;
  private VendedorDao   vendedorDao;
  private VentaDao ventaDao;

  public VentaController() {
    productoDao = new ProductoDao();
    clienteDao = new ClienteDao();
    vendedorDao = new VendedorDao();
    ventaDao = new VentaDao();
  }
  
  @ModelAttribute("venta")
  public Venta setUpUserForm() {
    return new Venta();
  }

  @GetMapping("ventas") // Base
  public String index(Model model) {
    model.addAttribute("ventas", ventaDao.getVentas());
    return "/Administrador/Venta/Ventas"; // Nombre del archivo jsp
  }
  
  @GetMapping(value = "/RegistrarVenta")
  public String actualizarCategoria(Model model) {
    //Categoria categoria = ventaDao.obtenerCategoriaPorId(idCategoria);
    model.addAttribute("vendedores", vendedorDao.getListaVendedores());
    model.addAttribute("productos", productoDao.getListaProductos());
    model.addAttribute("clientes", clienteDao.getListaClientes());
    model.addAttribute("precioproductos", productoDao.getListPrecioProductos());
    
    
    return "Administrador/Venta/RegistrarVenta"; // Nombre del archivo jsp
  }

  
  @PostMapping(value = "/servicios/guardarVenta" )
  public @ResponseBody ResponseEntity<String> RegistrarVenta(@RequestBody Venta venta) {

    // Consulta si tiene todos los campos llenos
    if (venta.isValidoParaRegistrar()) {
      
      String mensaje = ventaDao.registrarVenta(venta);
      
      if (mensaje.equals("Registro exitoso")) {
        return new ResponseEntity<String>("REGISTRO EXITOSO", HttpStatus.OK);
      } else {
        return new ResponseEntity<String>("REGISTRO NO EXITOSO", HttpStatus.OK);
      }
      //
    } else {
      return new ResponseEntity<String>("CAMPOS INVALIDOS", HttpStatus.OK);
    }
    
  }
  
}


