package com.project.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public static Object[][] ReadFromExcelToObjArr(String filepath,String filename,String sheetname) throws IOException{
		File file = new File(filepath + "/" + filename);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetname);
		int rowCount=sheet.getLastRowNum(); //2 data rows and 1 header row - returns 2 as rowcount - it only considers data rows
		Object[][] data = new Object[rowCount][1];
		Hashtable<String,String>rec = null;
		Row keysrow = sheet.getRow(0); //Keys Row
		for(int r=1;r<rowCount+1;r++){
			rec = new Hashtable<String,String>(); //hashtable created for every record 
			Row datarow = sheet.getRow(r);
			for(int c=0;c<datarow.getLastCellNum();c++){
				String key = keysrow.getCell(c).getStringCellValue();
				String val = datarow.getCell(c).getStringCellValue();
				rec.put(key, val);
			}
			data[r-1][0] =rec; 
		}
		return data;
	}

	
	public static void ReadFromExcel(String filepath,String filename,String sheetname) throws IOException{
		//First point to the physical location of file using File Object
		File file = new File(filepath + "/" + filename);
		//I have to first open file in Read Mode
		FileInputStream inputStream = new FileInputStream(file);
		//Creating an instance Workbook - Excel Workbook object
		//we use XSSFWorkbook for reading from xlsx
		//we use HSSFWorkbook for reading from xls
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetname);
		//This returns number of non empty rows
		int rowCount=sheet.getLastRowNum(); //2 data rows and 1 header row - returns 2 as rowcount - it only considers data rows
		//nested for loop //thus in the row for loop the condition is check on rowCount+1 
		for(int r=0;r<rowCount+1;r++){
			Row row = sheet.getRow(r);
			for(int c=0;c<row.getLastCellNum();c++){
				Cell cell = row.getCell(c);
				System.out.print(cell.getStringCellValue().toString() + "\t");
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) throws IOException{
		String ProjectPath = System.getProperty("user.dir");
		String filepath = ProjectPath + "/src/com/project/testdata";
		String filename = "CalorieTestData.xlsx";
		String sheetname ="CalorieTestSet";
		ExcelReader.ReadFromExcel(filepath, filename, sheetname);
	}
}
