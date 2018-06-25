package co.ufps.edu.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.ufps.edu.dao.ClienteDao;

import co.ufps.edu.dto.Cliente;
import co.ufps.edu.dto.Tienda;
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
		
		model.addAttribute("tipodocumentos", getTipoDeDocumentos());
		return "/Administrador/Cliente/Clientes"; // Nombre del archivo jsp
	}
	

	private Map<String, String> getTipoDeDocumentos() {
	    Map<String, String> formas = new HashMap<>();
	    formas.put("Cedula de ciudadania", "Cedula de ciudadania");
	    formas.put("Cedula de extranjeria", "Cedula de extranjeria");
	    formas.put("Tajerta de identidad", "Tajerta de identidad");
	    return formas;
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
	 
	 @GetMapping(value = "/eliminarCliente")
	  public String eliminarCliente(@RequestParam("codigo") long codigoCliente, Model model) {
	    // Consulto que el Id sea mayor a 0.
	    if (codigoCliente <= 0) {
	      return index(model);
	    }
	    Cliente cliente = clienteDao.obtenerClientePorCodigo(codigoCliente);
	    model.addAttribute("cliente", cliente);
	    return "Administrador/Cliente/EliminarCliente"; // Nombre del archivo jsp
	  }

	  @PostMapping(value = "/borrarCliente")
	  public String borrarCliente(@ModelAttribute("cliente") Cliente cliente, Model model) {

	    String mensaje = clienteDao.eliminarCliente(cliente);
	    if (mensaje.equals("Eliminacion exitosa")) {
	      model.addAttribute("result", "Cliente eliminado con éxito.");
	      return index(model);
	    } else {
	      model.addAttribute("wrong", mensaje);
	      return eliminarCliente(cliente.getCodigo(), model);	      
	    }
	  }
	  
	  
	  @GetMapping(value = "/actualizarCliente")
	  public String actualizarCliente(@RequestParam("codigo") long codigoCliente, Model model) {
	    // Consulto que el Id sea mayor a 0.
	    if (codigoCliente <= 0) {
	      return index(model);
	    }
	    Cliente cliente = clienteDao.obtenerClientePorCodigo(codigoCliente);
	    model.addAttribute("cliente",cliente);
	    model.addAttribute("tipodocumentos", getTipoDeDocumentos());
	    return "Administrador/Cliente/ActualizarCliente"; // Nombre del archivo jsp
	  }

	  @PostMapping(value = "/editarCliente")
	  public String editarCliente(@ModelAttribute("cliente") Cliente cliente, Model model) {

	    // Consulta si tiene todos los campos llenos
	    if (cliente.validarDatos()) {
	      String mensaje = clienteDao.editarCliente(cliente);
	      if (mensaje.equals("Actualizacion exitosa")) {
	        model.addAttribute("result", "Cliente actualizado con éxito.");
	        return index(model);
	      } else {
	        model.addAttribute("wrong", mensaje);
	        return "Administrador/Cliente/ActualizarCliente"; // Nombre del archivo jsp
	      }
	      //
	    } else {
	      model.addAttribute("wrong", "Debes llenar todos los campos.");
	      return "Administrador/Cliente/ActualizarCliente"; // Nombre del archivo jsp
	    }
	  }
}
