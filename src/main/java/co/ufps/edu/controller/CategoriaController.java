package co.ufps.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoriaController {
	
	@GetMapping("categorias") // Base
	public String index() {
		return "/Administrador/Categoria/Categorias"; // Nombre del archivo jsp
	}


}


