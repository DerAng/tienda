package co.ufps.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import co.ufps.edu.dao.ProveedorDao;

import co.ufps.edu.dto.Proveedor;


@Controller
public class ProveedorController {
	
	private ProveedorDao proveedorDao;
	
	public ProveedorController(){
		proveedorDao = new ProveedorDao(); 
	}
	
	
	
	@GetMapping("proveedores") // Base
	public String index(Model model) {
		model.addAttribute("proveedores", proveedorDao.getProveedores());
		return "/Administrador/Proveedor/Proveedores"; // Nombre del archivo jsp
	}
	
	@ModelAttribute("proveedor")
	public Proveedor setUpUserForm() {		
		return new Proveedor();
	}  

	
	

	
	

}
