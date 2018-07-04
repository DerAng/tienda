package co.ufps.edu.view;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;
import co.ufps.edu.dao.ProductoDao;
import co.ufps.edu.dto.Producto;

public class XlsView extends AbstractXlsView {

  private ProductoDao productoDao;

  public XlsView() {
    super();
    productoDao = new ProductoDao();
  }

  @Override
  protected void buildExcelDocument(Map<String, Object> model, Workbook workbook,
      HttpServletRequest request, HttpServletResponse response) throws Exception {

    // Nombre del excel.
    response.setHeader("Content-Disposition", "attachment; filename=\"PRODUCTOS.xls\"");

    // Se crea la hoja para principal de totales.
    Sheet sheet = workbook.createSheet("PRODUCTOS");

    
    // Encabezado de la hoja
    Row header = sheet.createRow(0);
    
    header.createCell(0).setCellValue("ID");  
    header.getCell(0).setAsActiveCell();
    
    CellStyle style;
    Font headerFont = workbook.createFont();
    headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
    headerFont.setFontHeightInPoints((short) 12);
    style = createBorderedStyle(workbook);
    style.setAlignment(CellStyle.ALIGN_CENTER);
    style.setFont(headerFont);
 
    header.getCell(0).setCellStyle(style);
    header.getCell(0).setCellComment(getComment("Identificador del producto en el sistema",sheet,workbook,header ));
    
    
    header.createCell(1).setCellValue("NOMBRE");
    header.getCell(1).setCellStyle(style);
    header.getCell(1).setCellComment(getComment("Nombre del producto",sheet,workbook,header ));
    
    header.createCell(2).setCellValue("CATEGORIA");
    header.getCell(2).setCellStyle(style);
    header.getCell(2).setCellComment(getComment("Codigo de la categoria del producto",sheet,workbook,header ));
    
    header.createCell(3).setCellValue("PROVEEDOR");
    header.getCell(3).setCellStyle(style);
    header.getCell(3).setCellComment(getComment("Codigo del proveedor del producto",sheet,workbook,header ));
    
    header.createCell(4).setCellValue("STOCK");
    header.getCell(4).setCellStyle(style);
    header.getCell(4).setCellComment(getComment("Cantidad de productos",sheet,workbook,header ));
    
    header.createCell(5).setCellValue("PRECIOVENTA");
    header.getCell(5).setCellStyle(style);
    header.getCell(5).setCellComment(getComment("Precio de cuanto cuesta el producto para la venta",sheet,workbook,header ));
    
    header.createCell(6).setCellValue("COSTO");
    header.getCell(6).setCellStyle(style);
    header.getCell(6).setCellComment(getComment("Costo del producto al momento de comprarlo",sheet,workbook,header ));
    
    header.createCell(7).setCellValue("FECHAVENCIMIENTO");
    header.getCell(7).setCellStyle(style);
    header.getCell(7).setCellComment(getComment("Fecha en la que se vende el producto",sheet,workbook,header ));
    
    sheet.setColumnWidth(0, 6000);
    sheet.setColumnWidth(1, 6000);
    sheet.setColumnWidth(2, 6000);
    sheet.setColumnWidth(3, 6000);
    sheet.setColumnWidth(4, 6000);
    sheet.setColumnWidth(5, 6000);
    sheet.setColumnWidth(6, 6000);
    sheet.setColumnWidth(7, 6000);
    
    // Obtenemos los datos de la base de datos
    List<Producto> productos = productoDao.getProductos();

    // Insertamos cada fila en el excel
    int i = 1;
    for (Producto producto : productos) {
      // Se carga la información en la hoja
      Row Row = sheet.createRow(i++);
      Row.createCell(0).setCellValue(producto.getCodigo());
      Row.createCell(1).setCellValue(producto.getNombre());
      Row.createCell(2).setCellValue(producto.getCategoria());
      Row.createCell(3).setCellValue(producto.getProveedor());
      Row.createCell(4).setCellValue(producto.getStock());
      Row.createCell(5).setCellValue(producto.getPrecioVenta());
      Row.createCell(6).setCellValue(producto.getCosto());
      
      CellStyle cellStyle = workbook.createCellStyle();
      
      CreationHelper createHelper = workbook.getCreationHelper();
      cellStyle.setDataFormat(
          createHelper.createDataFormat().getFormat("d/m/yy"));
      Cell cell = Row.createCell(7);
      cell.setCellValue(new Date(producto.getFechaVencimiento().getTime()));
      cell.setCellStyle(cellStyle);
      
    }
  }
  
  private Comment getComment(String texto, Sheet sheet, Workbook workbook, Row header) {
    Drawing drawing = sheet.createDrawingPatriarch();
    CreationHelper factory = workbook.getCreationHelper();
    
    // When the comment box is visible, have it show in a 1x3 space
    ClientAnchor anchor = factory.createClientAnchor();
    anchor.setCol1(header.getCell(0).getColumnIndex());
    anchor.setCol2(header.getCell(0).getColumnIndex()+1);
    anchor.setRow1(header.getRowNum());
    anchor.setRow2(header.getRowNum()+3);

    Comment comment = drawing.createCellComment(anchor);
    RichTextString str = factory.createRichTextString(texto);
    comment.setString(str);
    comment.setAuthor("SGV");
    return comment;
  }

  private static CellStyle createBorderedStyle(Workbook wb) {
    CellStyle style = wb.createCellStyle();
    style.setBorderRight(CellStyle.BORDER_THIN);
    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
    style.setBorderBottom(CellStyle.BORDER_THIN);
    style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
    style.setBorderLeft(CellStyle.BORDER_THIN);
    style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
    style.setBorderTop(CellStyle.BORDER_THIN);
    style.setTopBorderColor(IndexedColors.BLACK.getIndex());
    return style;
}
}
