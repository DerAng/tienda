package co.ufps.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import co.ufps.edu.dao.ProveedorDao;

import co.ufps.edu.dto.Proveedor;
import co.ufps.edu.dto.Tienda;


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

	
	
	@PostMapping("/guardarProveedor")
	public String RegistrarEvaluador(@ModelAttribute("proveedor") Proveedor proveedor, Model model) {
		if (proveedor.validarDatos()) {
			String mensaje = proveedorDao.registrarProveedor(proveedor);
			if(mensaje.equals("Registro exitoso")) {
    			model.addAttribute("result", "Proveedor registrado con exito");
    			model.addAttribute("proveedor", new Proveedor());
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
