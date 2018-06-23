package co.ufps.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import co.ufps.edu.dao.CategoriaDao;

import co.ufps.edu.dto.Categoria;


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


}


