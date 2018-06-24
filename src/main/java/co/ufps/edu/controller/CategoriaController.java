package co.ufps.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import co.ufps.edu.dao.CategoriaDao;
import co.ufps.edu.dto.Categoria;
import co.ufps.edu.dto.Vendedor;


@Controller
public class CategoriaController {
  private CategoriaDao categoriaDao;

  public CategoriaController() {
    categoriaDao = new CategoriaDao();
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
      if (mensaje.equals("Registro exitoso")) {
        model.addAttribute("result", "Categoria registrada con exito");
        model.addAttribute("categoria", new Categoria());
        return index(model);
      } else {
        model.addAttribute("wrong", mensaje);
        return index(model);
      }
    } else {
      model.addAttribute("wrong", "Campos invalidos.");
      return index(model);
    }

  }

  @GetMapping(value = "/eliminarCategoria")
  public String eliminarCategoria(@RequestParam("id") long idCategoria, Model model) {
    // Consulto que el Id sea mayor a 0.
    if (idCategoria <= 0) {
      return index(model);
    }
    Categoria categoria = categoriaDao.obtenerCategoriaPorId(idCategoria);
    model.addAttribute("categoria", categoria);
    return "Administrador/Categoria/EliminarCategoria"; // Nombre del archivo jsp
  }


  @PostMapping(value = "/borrarCategoria")
  public String borrarCategoria(@ModelAttribute("categoria") Categoria categoria, Model model) {

    String mensaje = categoriaDao.eliminarCategoria(categoria);
    if (mensaje.equals("Eliminacion exitosa")) {
      model.addAttribute("result", "Categoria eliminada con éxito.");
      return index(model);
    } else {
      model.addAttribute("wrong", mensaje);
      return eliminarCategoria(categoria.getCodigo(), model);
      
    }
  }
  
  @GetMapping(value = "/actualizarCategoria")
  public String actualizarCategoria(@RequestParam("id") long idCategoria, Model model) {
    // Consulto que el Id sea mayor a 0.
    if (idCategoria <= 0) {
      return index(model);
    }
    Categoria categoria = categoriaDao.obtenerCategoriaPorId(idCategoria);
    model.addAttribute("categoria", categoria);
    return "Administrador/Categoria/ActualizarCategoria"; // Nombre del archivo jsp
  }

  @PostMapping(value = "/editarCategoria")
  public String editarCategoria(@ModelAttribute("categoria") Categoria categoria, Model model) {

    // Consulta si tiene todos los campos llenos
    if (categoria.validarDatos()) {
      String mensaje = categoriaDao.editarCategoria(categoria);
      if (mensaje.equals("Actualizacion exitosa")) {
        model.addAttribute("result", "Categoria actualizada con éxito.");
        return index(model);
      } else {
        model.addAttribute("wrong", mensaje);
        return "Administrador/Categoria/ActualizarCategoria";
      }
      //
    } else {
      model.addAttribute("wrong", "Debes llenar todos los campos.");
      return "Administrador/Categoria/ActualizarCategoria";
    }
  }
  
  
}


