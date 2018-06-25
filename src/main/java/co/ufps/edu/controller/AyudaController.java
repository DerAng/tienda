package co.ufps.edu.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AyudaController {
	
	public AyudaController() {
	
	}
	
	 @GetMapping("ayuda")
	  public String index() {
	  return "/Administrador/Ayuda/MesaAyuda"; // Nombre del archivo jsp
	  }

}
