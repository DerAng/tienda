package co.ufps.edu.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import co.ufps.edu.dao.ProveedorDao;
import co.ufps.edu.dto.Categoria;
import co.ufps.edu.dto.Proveedor;
import co.ufps.edu.dto.Tienda;


@Controller
public class ProveedorController {

  private ProveedorDao proveedorDao;

  public ProveedorController() {
    proveedorDao = new ProveedorDao();
  }

  @GetMapping("proveedores") // Base
  public String index(Model model) {
    model.addAttribute("proveedores", proveedorDao.getProveedores());
    model.addAttribute("formas", getFormas());
    return "/Administrador/Proveedor/Proveedores"; // Nombre del archivo jsp
  }

  private Map<String, String> getFormas() {
    Map<String, String> formas = new HashMap<>();
    formas.put("Efectivo", "Efectivo");
    formas.put("Cheque", "Cheque");
    formas.put("Credito", "Credito");
    return formas;
  }



  @ModelAttribute("proveedor")
  public Proveedor setUpUserForm() {
    return new Proveedor();
  }



  @PostMapping("/guardarProveedor")
  public String RegistrarEvaluador(@ModelAttribute("proveedor") Proveedor proveedor, Model model) {
    if (proveedor.validarDatos()) {
      String mensaje = proveedorDao.registrarProveedor(proveedor);
      if (mensaje.equals("Registro exitoso")) {
        model.addAttribute("result", "Proveedor registrado con exito");
        model.addAttribute("proveedor", new Proveedor());
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

  @GetMapping(value = "/eliminarProveedor")
  public String eliminarProveedor(@RequestParam("id") long idProveedor, Model model) {
    // Consulto que el Id sea mayor a 0.
    if (idProveedor <= 0) {
      return index(model);
    }
    Proveedor proveedor = proveedorDao.obtenerProveedorPorId(idProveedor);
    model.addAttribute("proveedor", proveedor);
    return "Administrador/Proveedor/EliminarProveedor"; // Nombre del archivo jsp
  }


  @PostMapping(value = "/borrarProveedor")
  public String borrarProveedor(@ModelAttribute("proveedor") Proveedor proveedor, Model model) {

    String mensaje = proveedorDao.eliminarProveedor(proveedor);
    if (mensaje.equals("Eliminacion exitosa")) {
      model.addAttribute("result", "Proveedor eliminada con éxito.");
      return index(model);
    } else {
      model.addAttribute("wrong", mensaje);
      return eliminarProveedor(proveedor.getCodigo(), model);
    }
  }
  
  
  
  @GetMapping(value = "/actualizarProveedor")
  public String actualizarProveedor(@RequestParam("codigo") long codigoProveedor, Model model) {
    // Consulto que el Id sea mayor a 0.
    if (codigoProveedor <= 0) {
      return index(model);
    }
   Proveedor proveedor = proveedorDao.obtenerProveedorPorId(codigoProveedor);
    model.addAttribute("proveedor", proveedor);
    model.addAttribute("formas", getFormas());
    return "Administrador/Proveedor/ActualizarProveedor"; // Nombre del archivo jsp
  }

  @PostMapping(value = "/editarProveedor")
  public String editarTienda(@ModelAttribute("proveedor") Proveedor proveedor, Model model) {

    // Consulta si tiene todos los campos llenos
    if (proveedor.validarDatos()) {
      String mensaje = proveedorDao.editarProveedor(proveedor);
      if (mensaje.equals("Actualizacion exitosa")) {
        model.addAttribute("result", "Proveedor actualizado con éxito.");
        return index(model);
      } else {
        model.addAttribute("wrong", mensaje);
        model.addAttribute("formas", getFormas());
        return "Administrador/Proveedor/ActualizarProveedor"; // Nombre del archivo jsp
      }
      //
    } else {
      model.addAttribute("wrong", "Debes llenar todos los campos.");
      return "Administrador/Proveedor/ActualizarProveedor"; // Nombre del archivo jsp
    }
  }

}
