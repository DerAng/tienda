package co.ufps.edu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.fasterxml.jackson.databind.ext.NioPathDeserializer;
import co.ufps.edu.dao.AdministradorDao;
import co.ufps.edu.dao.TiendaDao;
import co.ufps.edu.dto.Categoria;
import co.ufps.edu.dto.Tienda;

@Controller
public class TiendaController {
	
	private TiendaDao tiendaDao;
	private AdministradorDao administradorDao;
	
	public TiendaController(){
		tiendaDao = new TiendaDao(); 
		administradorDao = new AdministradorDao();
	}
	
	@GetMapping("tiendas") // Base
	public String index(Model model) {
	    model.addAttribute("administradores",administradorDao.getlistaAdministradores());
		model.addAttribute("tiendas", tiendaDao.getTiendas());
		return "/Administrador/Tienda/Tiendas"; // Nombre del archivo jsp
	}
	
	@ModelAttribute("tienda")
	public Tienda setUpUserForm() {		
		return new Tienda();
	}
	
	@PostMapping("/guardarTienda")
	public String RegistrarTienda(@ModelAttribute("tienda") Tienda tienda, Model model) {
		if (tienda.validarDatos()) {
			String mensaje = tiendaDao.registrarTienda(tienda);
			if(mensaje.equals("Registro exitoso")) {
    			model.addAttribute("result", "Tienda registrada con exito");
    			model.addAttribute("tienda", new Tienda());
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
	
	
	 @GetMapping(value = "/eliminarTienda")
	  public String eliminarTienda(@RequestParam("codigo") long codigoTienda, Model model) {
	    // Consulto que el Id sea mayor a 0.
	    if (codigoTienda <= 0) {
	      return index(model);
	    }
	    Tienda tienda = tiendaDao.obtenerTiendaPorCodigo(codigoTienda);
	    model.addAttribute("tienda", tienda);
	    return "Administrador/Tienda/EliminarTienda"; // Nombre del archivo jsp
	  }


	  @PostMapping(value = "/borrarTienda")
	  public String borrarCategoria(@ModelAttribute("tienda") Tienda tienda, Model model) {

	    String mensaje = tiendaDao.eliminarTienda(tienda);
	    if (mensaje.equals("Eliminacion exitosa")) {
	      model.addAttribute("result", "Tienda eliminada con éxito.");
	      return index(model);
	    } else {
	      model.addAttribute("wrong", mensaje);
	      return eliminarTienda(tienda.getCodigo(), model);
	      
	    }

	  }
	

}
