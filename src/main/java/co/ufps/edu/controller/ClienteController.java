package co.ufps.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import co.ufps.edu.dao.ClienteDao;

import co.ufps.edu.dto.Cliente;
import co.ufps.edu.dto.Vendedor;


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
	
	 @PostMapping("/guardarCliente")
		public String RegistrarCliente(@ModelAttribute("cliente") Cliente cliente, Model model) {
			if (cliente.validarDatos()) {
				String mensaje = clienteDao.registrarCliente(cliente);
				if(mensaje.equals("Registro exitoso")) {
	  			model.addAttribute("result", "Cliente registrado con exito");
	  			model.addAttribute("cliente", new Cliente());
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
