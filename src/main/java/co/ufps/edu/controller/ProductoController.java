package co.ufps.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductoController {

	
	@GetMapping("productos") // Base
	public String index() {
		return "/Administrador/Producto/Productos"; // Nombre del archivo jsp
	}
	
}
