package co.ufps.edu.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import co.ufps.edu.dao.VendedorDao;
import co.ufps.edu.dto.Vendedor;

@Controller
public class VendedorController {

  private VendedorDao vendedorDao = new VendedorDao();


  @GetMapping("/vendedores")
  public String registration(Model model) {
    model.addAttribute("vendedores",vendedorDao.getVendedores());
    return "/Administrador/Vendedor/Vendedores";
  }


  @ModelAttribute("vendedor")
  public Vendedor setUpUserForm() {
    return new Vendedor();
  }

  @GetMapping("/index") // Base
  public String main() {
    return "index"; // Nombre del archivo jsp
  }


  /*
   * @PostMapping(value = "/guardarVendedor") public String
   * registrarEstudiante(@ModelAttribute("estudiante") Vendedor vendedor,
   * 
   * @RequestParam("contrasena2") String contrasena2, Model model) { if (esCodigoValido()) { } if
   * (!estudiante.getContrasena().equals(contrasena2)) { model.addAttribute("wrong",
   * "Las contraseñas deben ser iguales."); model.addAttribute("wrongh", "Error en el formulario.");
   * 
   * } else { try { boolean result = vendedorDao.registrarVendedor(vendedor); if (result) {
   * model.addAttribute("result", "eee"); model.addAttribute("estudiante", new Vendedor()); } else {
   * 
   * model.addAttribute("wrong", "El Vendedor ya ha sido registrado anteriormente.");
   * model.addAttribute("wrongh",
   * "El Vendedor ya se encuentra en el sistema. Para validar la contraseña contacte al administrador."
   * ); } } catch (Exception e) { e.printStackTrace(); model.addAttribute("wrongh",
   * "El sistema no se encuentra disponible en este momento por motivos de mantenimiento.");
   * model.addAttribute("wrong", "Error en el sistema. Contacte al administrador."); } }
   * 
   * return "index"; }
   */


  private boolean esCodigoValido() {
    return true;
  }



}
