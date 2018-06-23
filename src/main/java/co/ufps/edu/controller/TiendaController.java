package co.ufps.edu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.ufps.edu.dao.TiendaDao;
import co.ufps.edu.dto.Tienda;

@Controller
public class TiendaController {
	
	private TiendaDao tiendaDao;
	
	public TiendaController(){
		tiendaDao = new TiendaDao(); 
	}
	
	@GetMapping("tiendas") // Base
	public String index(Model model) {
		model.addAttribute("tiendas", tiendaDao.getTiendas());
		return "/Administrador/Tienda/Tiendas"; // Nombre del archivo jsp
	}
	
	@ModelAttribute("tienda")
	public Tienda setUpUserForm() {		
		return new Tienda();
	}
	/*
	@PostMapping("/guardarTienda")
	public String RegistrarEvaluador(@ModelAttribute("tienda") Tienda tienda, Model model) {
		if (tienda.validarDatos()) {
			logController.validarSesion(token, request);
			evaluadorDao.registrarEvaluador(e);
			model.addAttribute("ListaLineas", lineaDao.getLineas().values());
			model.addAttribute("result", "registroExitoso");
			model.addAttribute("evaluador", new Evaluador());
			return "Administrador/RegistrarEvaluador";
		} else {
			logController.validarSesion(token, request);
			model.addAttribute("wrong", "registro");
			model.addAttribute("ListaLineas", lineaDao.getLineas().values());
			return "Administrador/RegistrarEvaluador";
		}

	}
	*/

}
