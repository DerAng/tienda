package co.ufps.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import co.ufps.edu.dao.CategoriaDao;

import co.ufps.edu.dto.Categoria;
import co.ufps.edu.dto.Vendedor;


@Controller
public class CategoriaController {
	private CategoriaDao categoriaDao;
	
	public CategoriaController(){
		categoriaDao= new CategoriaDao(); 
	}
	
	@GetMapping("categorias") // Base
	public String index(Model model) {
		model.addAttribute("categorias", categoriaDao.getCategorias());
		return "/Administrador/Categoria/Categorias"; // Nombre del archivo jsp
	}
	

	
	@ModelAttribute("categoria")
	public Categoria setUpUserForm() {		
		return new Categoria();
	}
	
	@PostMapping("/guardarCategoria")
	public String RegistrarCategoria(@ModelAttribute("categoria") Categoria categoria, Model model) {
		if (categoria.validarDatos()) {
			String mensaje = categoriaDao.registrarCategoria(categoria);
			if(mensaje.equals("Registro exitoso")) {
  			model.addAttribute("result", "Categoria registrada con exito");
  			model.addAttribute("categoria", new Categoria());
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


