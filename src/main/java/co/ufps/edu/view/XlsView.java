package co.ufps.edu.view;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    CellStyle style;
    Font headerFont = workbook.createFont();
    headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
    headerFont.setFontHeightInPoints((short) 12);
    style = createBorderedStyle(workbook);
    style.setAlignment(CellStyle.ALIGN_CENTER);
    style.setFont(headerFont);
 
    
    // Encabezado de la hoja
    Row header = sheet.createRow(0);
    header.createCell(0).setCellValue("ID");
    header.getCell(0).setAsActiveCell();
    header.getCell(0).setCellStyle(style);
    Drawing drawing = sheet.createDrawingPatriarch();
    CreationHelper factory = workbook.getCreationHelper();
    
    // When the comment box is visible, have it show in a 1x3 space
    ClientAnchor anchor = factory.createClientAnchor();
    anchor.setCol1(header.getCell(0).getColumnIndex());
    anchor.setCol2(header.getCell(0).getColumnIndex()+1);
    anchor.setRow1(header.getRowNum());
    anchor.setRow2(header.getRowNum()+3);

    Comment comment = drawing.createCellComment(anchor);
    RichTextString str = factory.createRichTextString("Identificador de la tabla de productos");
    comment.setString(str);
    comment.setAuthor("Apache POI");

    header.getCell(0).setCellComment(comment);
    
    header.createCell(1).setCellValue("NOMBRE");
    header.createCell(2).setCellValue("CATEGORIA");
    header.createCell(3).setCellValue("PROVEEDOR");
    header.createCell(4).setCellValue("STOCK");
    header.createCell(5).setCellValue("PRECIOVENTA");
    header.createCell(6).setCellValue("COSTO");
    header.createCell(7).setCellValue("FECHAVENCIMIENTO");

    
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
      Row.createCell(7).setCellValue(producto.getFechaVencimiento());
    }
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
