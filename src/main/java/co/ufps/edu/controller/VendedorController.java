package co.ufps.edu.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import co.ufps.edu.dao.VendedorDao;
import co.ufps.edu.dto.Tienda;
import co.ufps.edu.dto.Vendedor;

@Controller
public class VendedorController {

  private VendedorDao vendedorDao = new VendedorDao();


  @GetMapping("/vendedores")
  public String index(Model model) {
    model.addAttribute("vendedores",vendedorDao.getVendedores());
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


  


}
