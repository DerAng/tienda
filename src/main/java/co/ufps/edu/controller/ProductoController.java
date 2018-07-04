package co.ufps.edu.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import co.ufps.edu.dao.CategoriaDao;
import co.ufps.edu.dao.ProductoDao;
import co.ufps.edu.dao.ProveedorDao;
import co.ufps.edu.dto.Producto;

@Controller
public class ProductoController {

  private ProductoDao productoDao;
  private ProveedorDao proveedorDao;
  private CategoriaDao categoriaDao;

  public ProductoController() {
    productoDao = new ProductoDao();
    proveedorDao = new ProveedorDao();
    categoriaDao = new CategoriaDao();
  }

  @GetMapping("productos") // Base
  public String index(Model model) {
    model.addAttribute("proveedores", proveedorDao.getlistaProveedores());    
    model.addAttribute("categorias", categoriaDao.getListaCategorias());
    model.addAttribute("productos",productoDao.getProductos());
    return "Administrador/Producto/Productos"; // Nombre del archivo jsp
  }

  @ModelAttribute("producto")
  public Producto setUpUserForm() {     
      return new Producto();
  }
  
  @PostMapping("/guardarProducto")
  public String RegistrarProducto(@ModelAttribute("producto") Producto producto, Model model) {
      if (producto.validarDatos()) {
          String mensaje = productoDao.registrarProducto(producto);
          if(mensaje.equals("Registro exitoso")) {
              model.addAttribute("result", "producto registrado con exito");
              model.addAttribute("producto", new Producto());
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
  
  @GetMapping(value = "/eliminarProducto")
  public String eliminarCategoria(@RequestParam("codigo") long idProducto, Model model) {
    // Consulto que el Id sea mayor a 0.
    if (idProducto <= 0) {
      return index(model);
    }
    Producto producto = productoDao.obtenerProductoPorId(idProducto);
    model.addAttribute("producto", producto);
    return "Administrador/Producto/EliminarProducto"; // Nombre del archivo jsp
  }


  @PostMapping(value = "/borrarProducto")
  public String borrarCategoria(@ModelAttribute("producto") Producto producto, Model model) {
    
    productoDao.eliminarProductoPorProveedor(producto);
    String mensaje = productoDao.eliminarProducto(producto);
    if (mensaje.equals("Eliminacion exitosa")) {
      model.addAttribute("result", "Producto eliminado con éxito.");
      return index(model);
    } else {
      model.addAttribute("wrong", mensaje);
      return eliminarCategoria(producto.getCodigo(), model);
      
    }

  }
  
  
  
  @GetMapping(value = "/actualizarProducto")
  public String actualizarProducto(@RequestParam("codigo") long codigoProducto, Model model) {
    // Consulto que el Id sea mayor a 0.
    if (codigoProducto <= 0) {
      return index(model);
    }
    Producto producto = productoDao.obtenerProductoPorId(codigoProducto);
    model.addAttribute("producto", producto);
    model.addAttribute("proveedores", proveedorDao.getlistaProveedores());
    model.addAttribute("categorias", categoriaDao.getListaCategorias());
    
    return "Administrador/Producto/ActualizarProducto"; // Nombre del archivo jsp
  }

  @PostMapping(value = "/editarProducto")
  public String editarProducto(@ModelAttribute("producto") Producto producto, Model model) {

    // Consulta si tiene todos los campos llenos
    if (producto.validarDatos()) {
      String mensaje = productoDao.editarProducto(producto);
      if (mensaje.equals("Actualizacion exitosa")) {
        model.addAttribute("result", "Producto actualizado con éxito.");
        return index(model);
      } else {
        model.addAttribute("wrong", mensaje);
        return "Administrador/Producto/ActualizarProducto"; // Nombre del archivo jsp
      }
      //
    } else {
      model.addAttribute("wrong", "Debes llenar todos los campos.");
      return "Administrador/Producto/ActualizarProducto"; // Nombre del archivo jsp
    }
  }
  
  
  @GetMapping("/descargarProductos")
  private String generarInforme() {
    return "xlsView"; // Nombre del archivo jsp
  }

  
  @PostMapping(value = "servicios/registrarArchivo" )
  public @ResponseBody ResponseEntity<String> registrarArchivo(@RequestParam("archivo") MultipartFile multipartFile) {    
    //long id = contenidoDao.registrarArchivo(multipartFile);
    String mensaje = guardarProductos(multipartFile);
    return new ResponseEntity<String>(mensaje, HttpStatus.OK);
  }

  private String guardarProductos(MultipartFile multipartFile) {
    String mensaje = "";
    int i = 0;
    try {

      FileInputStream excelFile = new FileInputStream(convert(multipartFile));
   // Creating a Workbook from an Excel file (.xls or .xlsx)
      Workbook workbook = WorkbookFactory.create(excelFile);
      Sheet datatypeSheet = workbook.getSheetAt(0);
      Iterator<Row> iterator = datatypeSheet.iterator();
      List<String> titulos = new ArrayList<>();
      List<Producto> productos = new ArrayList<>();
      int j = 0;

      while (iterator.hasNext()) {

          Row currentRow = iterator.next();
          Iterator<Cell> cellIterator = currentRow.iterator();
          Producto p = new Producto();
          while (cellIterator.hasNext()) {

              Cell currentCell = cellIterator.next();

              if(i==0) {
                titulos.add(currentCell.getStringCellValue());
              }else {
                
                if(j==0) {
                  String nombre = currentCell.getStringCellValue(); 
                  p.setNombre(nombre);
                  if(nombre.equals("")) {
                    mensaje = "ERROR: El nombre en la fila "+(i+1)+" no puede ser nulo o vacio.";
                    throw new Exception();
                  }
                }else if(j==1) {
                  int categoria = new Double(currentCell.getNumericCellValue()).intValue();
                  if(existeCategoria(categoria)) {
                    p.setCategoria(categoria);
                  }else {
                    mensaje = "ERROR: La categoria en la fila "+(i+1)+" no existe.";
                    throw new Exception();                    
                  }
                }else if(j==2) {
                  int proveedor = (new Double(currentCell.getNumericCellValue())).intValue();
                  if(existeProveedor(proveedor)) {
                    p.setProveedor(proveedor);
                  }else {
                    mensaje = "ERROR: el proveedor en la fila "+(i+1)+" no existe.";
                    throw new Exception();                    
                  }

                }else if(j==3) {
                  int stock = new Double(currentCell.getNumericCellValue()+"").intValue();
                  if(stock > 0) {
                    p.setStock(stock);
                  }else {
                    mensaje = "ERROR: el stock en la fila "+(i+1)+" no puede cero o nulo.";
                    throw new Exception();                    
                  }
                }else if(j==4) {
                  int precioVenta = new Double(currentCell.getNumericCellValue()).intValue();
                  if(precioVenta > 0) {
                    p.setPrecioVenta(precioVenta);
                  }else {
                    mensaje = "ERROR: el precio de venta en la fila "+(i+1)+" no puede cero o nulo.";
                    throw new Exception();                    
                  }
                  
                }else if(j==5) {
                  int costo = new Double(currentCell.getNumericCellValue()).intValue();
                  if(costo > 0) {
                    p.setCosto(costo);
                  }else {
                    mensaje = "ERROR: el precio de costo en la fila "+(i+1)+" no puede cero o nulo.";
                    throw new Exception();                    
                  }
                }else if(j==6) {
                  int fecha = new Double(currentCell.getNumericCellValue()).intValue();
                  if(fecha > 0) {
                    p.setFechaVencimiento(new java.sql.Date(fecha));
                  }else {
                    mensaje = "ERROR: La fecha de vencimiento "+(i+1)+" no puede cero o nulo.";
                    throw new Exception();                    
                  }
                  
                }
                
                j++;
              }


          }
          if(i==0  ) {
            if(!validarEncabezado(titulos)) {
              mensaje = "ERROR: Los encabezados no son nombrados correctamente.(NOMBRE, CATEGORIA, PROVEEDOR, STOCK, PRECIOVENTA, COSTO, FECHAVENCIMIENTO)";
              throw new Exception();  
            }
          }else {
            j=0;
            productos.add(p);
          }
          i++;

          System.out.println();

      }
      guardarProductos(productos);
      mensaje = "Productos registrados con exito.";
  } catch (Exception e) {
    if(mensaje.equals("")) {
      mensaje = "ERROR en la linea "+(i+1);
    }
  }
    
    // TODO Auto-generated method stub
    return mensaje;
  }

  private void guardarProductos(List<Producto> productos) {
    for(Producto p:productos) {
      productoDao.registrarProducto(p);
    }
    
  }

  private boolean existeProveedor(int proveedor) {
    return proveedorDao.obtenerProveedorPorId(new Long(String.valueOf(proveedor))).getCodigo() != 0;
  }

  private boolean existeCategoria(int categoria) {
    // TODO Auto-generated method stub
    
    return categoriaDao.obtenerCategoriaPorId(new Long(String.valueOf(categoria))).getCodigo() != 0;
  }

  private boolean validarEncabezado(List<String> titulos) {
    if (!titulos.get(0).equalsIgnoreCase("NOMBRE")
        || !titulos.get(1).equalsIgnoreCase("CATEGORIA")
        || !titulos.get(2).equalsIgnoreCase("PROVEEDOR")
        || !titulos.get(3).equalsIgnoreCase("STOCK")
        || !titulos.get(4).equalsIgnoreCase("PRECIOVENTA")
        || !titulos.get(5).equalsIgnoreCase("COSTO")
        || !titulos.get(6).equalsIgnoreCase("FECHAVENCIMIENTO")) {
      return false;
    }
    return true;
    
  }

  public File convert(MultipartFile file)
  {    
      File convFile = new File(file.getOriginalFilename());
      try {
        convFile.createNewFile();      
        FileOutputStream fos = new FileOutputStream(convFile); 
        fos.write(file.getBytes());
        fos.close(); 
        return convFile;
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      return convFile; 

  }
}
