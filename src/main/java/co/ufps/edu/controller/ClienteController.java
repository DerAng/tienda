package co.ufps.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {
	
	@GetMapping("clientes") // Base
	public String index() {
		return "/Administrador/Cliente/Clientes"; // Nombre del archivo jsp
	}

}
