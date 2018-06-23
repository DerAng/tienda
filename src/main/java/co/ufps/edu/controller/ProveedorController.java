package co.ufps.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProveedorController {
	

	@GetMapping("proveedores") // Base
	public String index() {
		return "/Administrador/Proveedor/Proveedores"; // Nombre del archivo jsp
	}
	
	
	
	

}
