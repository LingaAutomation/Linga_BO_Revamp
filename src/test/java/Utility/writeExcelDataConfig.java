package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writeExcelDataConfig 
{

XSSFWorkbook wb;
	
	XSSFSheet sheet1,sheet2,sheet3,sheet4,sheet5,sheet6,sheet7,sheet8,sheet9,sheet10;
	
	public writeExcelDataConfig(String excelPath)
	{
		try {
			File src = new File(excelPath);
			
			FileInputStream fis = new FileInputStream(src);
			
			wb = new XSSFWorkbook(fis);
			
			
		} 
		
		catch (Exception e) {

			System.out.println(e.getMessage());

		}
		
		
		try {
			
			FileOutputStream fos=new FileOutputStream(excelPath);
			wb.write(fos);
			
		} 
		
		catch (Exception e) {

			System.out.println(e.getMessage());

		}
	}
	
	
	public void setNumericData(String ExcelPath, String sheetName, int row, int column, String ReportValue) throws Exception
	{


		try {
			
		
			
			sheet1 = wb.getSheet(sheetName);
			
			sheet1.getRow(row).createCell(column).setCellValue(ReportValue);
		
		} 
		
		catch (Exception e) {

			e.printStackTrace();
			System.out.println(e.getMessage());

		}
		
	
				
	}
}
