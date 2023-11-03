package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.sl.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.VerticalAlign;

public class ExcelDataConfig {
	
	public XSSFWorkbook wb;
	
	public XSSFSheet sheet1,sheet2,sheet3,sheet4,sheet5,sheet6,sheet7,sheet8,sheet9,sheet10;
	
	public ExcelDataConfig(String excelPath)
	{
		ZipSecureFile.setMinInflateRatio(0);
		
		try {
			File src = new File(System.getProperty("user.dir")+excelPath);
			
			FileInputStream fis = new FileInputStream(src);
			
			wb = new XSSFWorkbook(fis);
			
			
		} 
		
		catch (Exception e) {

			System.out.println(e.getMessage());

		}
		
	}
	
	public String getData(String SheetName, int row, int column)
	{
		sheet1 = wb.getSheet(SheetName);
		
		String data = sheet1.getRow(row).getCell(column).getStringCellValue();
		
				
		return data;

	}
	
	public Double getNumericDataAsDouble(int sheetNumber, int row, int column)
	{

		sheet1 = wb.getSheetAt(sheetNumber);
		
		Double data = (Double) sheet1.getRow(row).getCell(column).getNumericCellValue();
		
				
		return data;

	}
	
	public Integer getNumericDataAsInteger(int sheetNumber, int row, int column)
	{

		sheet1 = wb.getSheetAt(sheetNumber);
		
		Integer data =  (int) sheet1.getRow(row).getCell(column).getNumericCellValue();
		
				
		return data;

	}
//	public String setData(int sheetNumber, int row, int column)
//	{
//
//		sheet1 = wb.getSheetAt(sheetNumber);
//		
//		String data = sheet1.getRow(row).getCell(column).getStringCellValue(); 
//		
//				
//		return data;
//
//	}
	
	public void setreportData(String sheetName, int row, int column, String ReportValue) throws Exception
	{

			
			sheet1 = wb.getSheet(sheetName);
			
			CellStyle style=wb.createCellStyle();
			Font font=wb.createFont();
			font.setFontHeightInPoints((short)9);
//			font.setFontName("Calibri");
//			font.setColor(IndexedColors.WHITE.getIndex());
			
			Cell cell=	sheet1.getRow(row).createCell(column);
			
		
				style.setBorderBottom(BorderStyle.THIN);
				style.setBorderLeft(BorderStyle.THIN);
				style.setBorderTop(BorderStyle.THIN);
				style.setBorderRight(BorderStyle.THIN);
				style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
				style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
				style.setTopBorderColor(IndexedColors.BLACK.getIndex());
				style.setRightBorderColor(IndexedColors.BLACK.getIndex());
				style.setAlignment(HorizontalAlignment.CENTER);
				style.setFont(font);
				cell.setCellStyle(style);
				cell.setCellValue(ReportValue); 
			
//			sheet1.getRow(row).createCell(column).setCellValue(ReportValue);
			
			
		
		
	
				
	}
	
	public void setreport_PassedData(String sheetName, int row, int column, String ReportValue) throws Exception
	{
		

		CellStyle style=wb.createCellStyle();
		Font font=wb.createFont();
		font.setFontHeightInPoints((short)9);
//		font.setFontName("Calibri");
		font.setColor(IndexedColors.WHITE.getIndex());
		
		Cell cell=	sheet1.getRow(row).createCell(column);
		
	
			style.setBorderBottom(BorderStyle.THIN);
			style.setBorderLeft(BorderStyle.THIN);
			style.setBorderTop(BorderStyle.THIN);
			style.setBorderRight(BorderStyle.THIN);
			style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
			style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
			style.setTopBorderColor(IndexedColors.BLACK.getIndex());
			style.setRightBorderColor(IndexedColors.BLACK.getIndex());
			style.setAlignment(HorizontalAlignment.CENTER);
//			style.setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			style.setFont(font);
			cell.setCellStyle(style);
			cell.setCellValue(ReportValue);
		
		
	
				
	}
	
	public void setreport_FailedData(String sheetName, int row, int column, String ReportValue) throws Exception
	{		
		CellStyle style=wb.createCellStyle();
		Cell cell=	sheet1.getRow(row).createCell(column);	
		Font font=wb.createFont();
		font.setFontHeightInPoints((short)9);
		
		style.setBorderBottom(BorderStyle.THIN);
		style.setBorderLeft(BorderStyle.THIN);
		style.setBorderTop(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setAlignment(HorizontalAlignment.CENTER);
//		style.setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);

	double ReportValues=Double.parseDouble(ReportValue);
		
		if(ReportValues>0)
		{
			style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			style.setFont(font);
			cell.setCellStyle(style);
			cell.setCellValue(ReportValue);	
		}
		else
		{
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			style.setFont(font);
			cell.setCellStyle(style);
			cell.setCellValue(ReportValue);		
		}
	}
	
	
	public void setreport_FailedData_Int(String sheetName, int row, int column, String ReportValue) throws Exception
	{		
		CellStyle style=wb.createCellStyle();
		Cell cell=	sheet1.getRow(row).createCell(column);	
		Font font=wb.createFont();
		font.setFontHeightInPoints((short)9);
		
		style.setBorderBottom(BorderStyle.THIN);
		style.setBorderLeft(BorderStyle.THIN);
		style.setBorderTop(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setAlignment(HorizontalAlignment.CENTER);
//		style.setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);

	int ReportValues=Integer.parseInt(ReportValue);
		
		if(ReportValues>0)
		{
			style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			style.setFont(font);
			cell.setCellStyle(style);
			cell.setCellValue(ReportValue);	
		}
		else
		{
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			style.setFont(font);
			cell.setCellStyle(style);
			cell.setCellValue(ReportValue);		
		}
	}
	


	public void toWrite(String excelpath) throws Exception
	{
		FileOutputStream fos=new FileOutputStream(System.getProperty("user.dir")+excelpath);
		wb.write(fos);
	}


}
