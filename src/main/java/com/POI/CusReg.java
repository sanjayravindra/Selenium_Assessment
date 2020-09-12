package com.POI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CusReg {
	
	static String[] fields1 = new String[] { "Tester", "32" , "XYZ", "2323245235", "test1@gmail.com"};
	static String[] fields2 = new String[] { "Tester1", "33" , "ABC", "4323245125", "test2@gmail.com"};
	static String[] fields3 = new String[] { "Tester2", "34" , "KLM", "1323245235", "test3@gmail.com"};
	
	public static void writeExcel() throws Exception
	{
		String path = System.getProperty("user.dir") + "/" + "Excel.xlsx";
		FileInputStream input = new FileInputStream(path);

		XSSFWorkbook book = new XSSFWorkbook(input);
		XSSFSheet sheet = book.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum();
		int cellCount = sheet.getRow(0).getLastCellNum();

		XSSFRow newRow = sheet.createRow(rowCount + 1);
		for (int i = 0; i < cellCount; i++) {
			XSSFCell cell = newRow.createCell(i);
			cell.setCellValue(fields1[i]);
		}
		XSSFRow newRow1 = sheet.createRow(rowCount + 2);
		for (int i = 0; i < cellCount; i++) {
			XSSFCell cell = newRow1.createCell(i);
			cell.setCellValue(fields2[i]);
		}
		XSSFRow newRow2 = sheet.createRow(rowCount + 3);
		for (int i = 0; i < cellCount; i++) {
			XSSFCell cell = newRow2.createCell(i);
			cell.setCellValue(fields3[i]);
		}
		input.close();
		FileOutputStream file = new FileOutputStream(path);
		book.write(file);
		file.close();
	    
	    
	    
	}

	public static String getExcelPath(String sheetName) throws Exception {
		// Implement code to locate the excel file. Return the filepath
		// File input=new File(sheetName);
		// String path = input.getAbsolutePath();

		File fileObj = new File(sheetName);
		String dirPath = fileObj.getAbsolutePath();
		return dirPath;
	}

	public static Object[][] readExcelData(String sheetName) throws Exception {
		// DO NOT change the method signature
		// Implement code to read data from excel sheet in a 2-D array. Return the array
		String path = System.getProperty("user.dir") + "/" + "Excel.xlsx";
		FileInputStream input = new FileInputStream(path);
		XSSFWorkbook book = new XSSFWorkbook(input);
		XSSFSheet sheet = book.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum();
		
		int cellCount = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rowCount+1][cellCount];
		for (int i = 0; i <=rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < cellCount; j++) {
				XSSFCell cell = row.getCell(j);
				if (cell != null) {
					switch (cell.getCellType()) {
					case XSSFCell.CELL_TYPE_NUMERIC:
						data[i][j] = "" + cell.getNumericCellValue();
						break;
					case XSSFCell.CELL_TYPE_STRING:
						data[i][j] = "" + cell.getStringCellValue();
						break;
					default:
						break;
					}
				}
				System.out.println(data[i][j]);
			}
		}
		return data;
	}
	


	public static void main(String[] args) throws Exception {

//		CusReg.readExcelData("");
//		 CusReg.readExcelData();
		CusReg.writeExcel();

	}
}

//String path = System.getProperty("user.dir") + "/" + "CustReg.xlsx" ;
//FileInputStream input = new FileInputStream(path);
//XSSFWorkbook book = new XSSFWorkbook(input);
//XSSFSheet sheet = book.getSheetAt(0);
//int rowCount = sheet.getLastRowNum();
//int cellCount = sheet.getRow(0).getLastCellNum();
//Object[][] data = new Object[rowCount+1][cellCount];
//for (int i = 0; i <= rowCount; i++) {
//	XSSFRow row = sheet.getRow(i);
//	for (int j = 0; j < cellCount; j++) {
//		XSSFCell cell = row.getCell(j);
//		if (cell != null) {
//			switch (cell.getCellType()) {
//			case XSSFCell.CELL_TYPE_NUMERIC:
//				data[i][j] = "" + cell.getNumericCellValue();
//				break;
//			case XSSFCell.CELL_TYPE_STRING:
//				data[i][j] = "" + cell.getStringCellValue();
//				break;
//			default:
//				break;
//			}
//		}
//	}
//}
//return data;


	//File input=new File("CustReg.xlsx");
	//String path = input.getAbsolutePath();
	//return path;

//String path = System.getProperty("user.dir") + "/" + "CustReg.xlsx";
//FileInputStream input = new FileInputStream(path);
//
//XSSFWorkbook book = new XSSFWorkbook(input);
//XSSFSheet sheet = book.getSheetAt(0);
//int rowCount = sheet.getLastRowNum();
//int cellCount = sheet.getRow(0).getLastCellNum();
//
//XSSFRow newRow = sheet.createRow(rowCount + 1);
//for (int i = 0; i < cellCount; i++) {
//	XSSFCell cell = newRow.createCell(i);
//	cell.setCellValue(fields1[i]);
//}
//XSSFRow newRow1 = sheet.createRow(rowCount + 2);
//for (int i = 0; i < cellCount; i++) {
//	XSSFCell cell = newRow1.createCell(i);
//	cell.setCellValue(fields2[i]);
//}
//XSSFRow newRow2 = sheet.createRow(rowCount + 3);
//for (int i = 0; i < cellCount; i++) {
//	XSSFCell cell = newRow2.createCell(i);
//	cell.setCellValue(fields3[i]);
//}
//input.close();
//FileOutputStream file = new FileOutputStream(path);
//book.write(file);
//file.close();


//String path = System.getProperty("user.dir") + "/" + fileName;
//FileInputStream input = new FileInputStream(path);
//XSSFWorkbook book = new XSSFWorkbook(input);
//XSSFSheet sheet = book.getSheet("customervalid");
//	XSSFRow row = sheet.getRow(0);
//	for (int i = 0; i < customerData.length; i++) {
//	XSSFCell cell = row.getCell(i);
//	DataFormatter format = new DataFormatter();
//	customerData[i] = format.formatCellValue(cell);	
//}
//return customerData;


//String path = System.getProperty("user.dir") + "/" + fileName;
//FileInputStream input = new FileInputStream(path);
//XSSFWorkbook book = new XSSFWorkbook(input);
//XSSFSheet sheet = book.getSheetAt(0);
//XSSFRow newRow = sheet.createRow(0);
//XSSFCell cell = newRow.createCell(0);
//cell.setCellValue(result);
//input.close();
//FileOutputStream file = new FileOutputStream(path);
//book.write(file);
//file.close();