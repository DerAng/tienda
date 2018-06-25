package co.ufps.edu.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.ufps.edu.dao.TiendaDao;
import co.ufps.edu.dao.VendedorDao;
import co.ufps.edu.dto.Tienda;
import co.ufps.edu.dto.Vendedor;

@Controller
public class VendedorController {

  private VendedorDao vendedorDao;
  private TiendaDao tiendaDao;
  
  public VendedorController(){
	  vendedorDao = new VendedorDao();
	  tiendaDao = new TiendaDao();
  }


  @GetMapping("/vendedores")
  public String index(Model model) {
    model.addAttribute("vendedores",vendedorDao.getVendedores());
    model.addAttribute("tiendas", tiendaDao.getListaTiendas());
    return "/Administrador/Vendedor/Vendedores";
  }


  @ModelAttribute("vendedor")
  public Vendedor setUpUserForm() {
    return new Vendedor();
  }

  @GetMapping("/index") // Base
  public String main() {
    return "index"; // Nombre del archivo jsp
  }
  
  @PostMapping("/guardarVendedor")
	public String RegistrarVendedor(@ModelAttribute("vendedor") Vendedor vendedor, Model model) {
		if (vendedor.validarDatos()) {
			String mensaje = vendedorDao.registrarVendedor(vendedor);
			if(mensaje.equals("Registro exitoso")) {
  			model.addAttribute("result", "Vendedor registrado con exito");
  			model.addAttribute("vendedor", new Vendedor());
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
  
  
  @GetMapping(value = "/eliminarVendedor")
  public String eliminarVendedor(@RequestParam("codigo") long codigoVendedor, Model model) {
    // Consulto que el Id sea mayor a 0.
    if (codigoVendedor <= 0) {
      return index(model);
    }
    Vendedor vendedor= vendedorDao.obtenerVendedorPorCodigo(codigoVendedor);
    model.addAttribute("vendedor", vendedor);
    return "Administrador/Vendedor/EliminarVendedor"; // Nombre del archivo jsp
  }


  @PostMapping(value = "/borrarVendedor")
  public String borrarVendedor(@ModelAttribute("vendedor") Vendedor vendedor, Model model) {

    String mensaje = vendedorDao.eliminarVendedor(vendedor);
    if (mensaje.equals("Eliminacion exitosa")) {
      model.addAttribute("result", "Vendedor eliminado con éxito.");
      return index(model);
    } else {
      model.addAttribute("wrong", mensaje);
      return eliminarVendedor(vendedor.getCodigo(), model);
      
    }

  }
  
  
  @GetMapping(value = "/actualizarVendedor")
  public String actualizarVendedor(@RequestParam("codigo") long codigoVendedor, Model model) {
    // Consulto que el Id sea mayor a 0.
    if (codigoVendedor<= 0) {
      return index(model);
    }
    Vendedor vendedor = vendedorDao.obtenerVendedorPorCodigo(codigoVendedor);
    model.addAttribute("vendedor", vendedor);
    model.addAttribute("tiendas", tiendaDao.getListaTiendas());
    return "Administrador/Vendedor/ActualizarVendedor"; // Nombre del archivo jsp
  }

  @PostMapping(value = "/editarVendedor")
  public String editarVendedor(@ModelAttribute("vendedor") Vendedor vendedor, Model model) {

    // Consulta si tiene todos los campos llenos
    if (vendedor.validarDatos()) {
      String mensaje = vendedorDao.editarVendedor(vendedor);
      if (mensaje.equals("Actualizacion exitosa")) {
        model.addAttribute("result", "Vendedor actualizado con éxito.");
        return index(model);
      } else {
        model.addAttribute("wrong", mensaje);
        return "Administrador/Vendedor/ActualizarVendedor"; // Nombre del archivo jsp
      }
      //
    } else {
      model.addAttribute("wrong", "Debes llenar todos los campos.");
      return "Administrador/Vendedor/ActualizarVendedor"; // Nombre del archivo jsp
    }
  }

}
