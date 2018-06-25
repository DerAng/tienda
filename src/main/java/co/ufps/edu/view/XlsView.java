package co.ufps.edu.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

public class XlsView extends AbstractXlsView {

	
    @Override
    protected void buildExcelDocument( Map<String, Object> model, Workbook workbook,  HttpServletRequest request, HttpServletResponse response) throws Exception 
    {

    	// Nombre del excel.
        response.setHeader("Content-Disposition", "attachment; filename=\"Reporte.xls\"");
        
        
        // Se crea la hoja para principal de totales.
        Sheet sheet = workbook.createSheet("Totales de contenidos");
        
        //Encabezado de la hoja
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("NOMBRE");
        header.createCell(2).setCellValue("TOTAL");
        
        //Se carga la información en la hoja
        Row Row = sheet.createRow(1);
        //Row.createCell(0).setCellValue(1);
        //Row.createCell(1).setCellValue("Categoria");
       // Row.createCell(2).setCellValue(categoriaDao.getCantidadCategorias());
        }
}
