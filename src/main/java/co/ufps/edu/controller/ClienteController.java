package co.ufps.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import co.ufps.edu.dao.ClienteDao;

import co.ufps.edu.dto.Cliente;


@Controller
public class ClienteController {
	
	private ClienteDao clienteDao;
	
	 public ClienteController() {
		 clienteDao = new  ClienteDao(); 
	}
	
	@GetMapping("clientes") // Base
	public String index(Model model) {
		model.addAttribute("clientes", clienteDao.getClientes());
		return "/Administrador/Cliente/Clientes"; // Nombre del archivo jsp
	}
	

	@ModelAttribute("cliente")
	public Cliente setUpUserForm() {		
		return new Cliente();
	}

}
