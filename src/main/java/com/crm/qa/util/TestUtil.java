package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {

	public  static long PAGE_LOAD_TIMEOUT=20;
	public  static long IMPLICIT_WAIT = 10;
	
	//git  ccc dddd
public static String Testdata_Sheet_Path = "D:\\ASB BEBO\\POM\\src\\main\\java\\com\\crm\\testdata\\contact.xlsx";	

static Workbook book;
static Sheet sheet;

public static Object[][] getTestData (String sheetname){
	
	FileInputStream file = null;
	
	try{
	file = new FileInputStream(Testdata_Sheet_Path);
	}
	catch (FileNotFoundException e){
		e.printStackTrace();
	}
	
	try {
		book = WorkbookFactory.create(file);
	}
	catch (InvalidFormatException e){
		e.printStackTrace();
	}
	catch (IOException e){
		e.printStackTrace();
	}
	sheet = book.getSheet(sheetname);
	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	

	for(int i=0; i<sheet.getLastRowNum();i++){
		for (int k =0; k<sheet.getRow(0).getLastCellNum();k++)
		{
			data[i][k] = sheet.getRow(i+1).getCell(k).toString();
		}
	 }
	return data;
}
}
