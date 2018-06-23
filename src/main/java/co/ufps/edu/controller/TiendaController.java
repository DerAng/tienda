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
	public String RegistrarEvaluador(@ModelAttribute("tienda") Tienda tienda, Model model) {
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
	

}
