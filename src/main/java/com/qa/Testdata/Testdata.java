package com.qa.Testdata;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

import com.kits.sit.Base_Setup.Base_Setup;

public class Testdata extends Base_Setup {
	
	
	public static HSSFSheet ExcelWSheet;
	public static HSSFWorkbook ExcelWBook;
	public static HSSFCell Cell;
	public static HSSFSheet sheet;
	//public static String SheetName;
	public static HSSFRow row;
	public static String Path = "C:\\work\\TestData.xls";
	public static String SheetName ="login";
	
	
public static void setExcelFile(String Path,String SheetName) throws IOException {
		
		FileInputStream ExcelFile = new FileInputStream(Path);
		ExcelWBook = new HSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		
		
	}
	public static String getCelldata(int RowNum,int ColNum) {
		
		DataFormatter formatter = new DataFormatter();
		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
		String CellData = formatter.formatCellValue(Cell);
		return CellData;
	}
	

}
