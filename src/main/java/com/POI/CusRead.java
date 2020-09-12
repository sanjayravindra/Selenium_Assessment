package com.POI;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CusRead {

	// Use this declaration to store values parsed from excel
	public static String[] customerData = new String[5];

	public static String[] readExcelData(String fileName) throws IOException { // Do not change the method signature

		// Implement code to read data from excel file. Store the values in
		// 'customerData' array. Return the array. */
		String path = System.getProperty("user.dir") + "/" + fileName;
		FileInputStream input = new FileInputStream(path);
		XSSFWorkbook book = new XSSFWorkbook(input);
		XSSFSheet sheet = book.getSheet("Sheet1");
		XSSFRow row = sheet.getRow(0);
		for (int i = 0; i < customerData.length; i++) {
			XSSFCell cell = row.getCell(i);
			DataFormatter format = new DataFormatter();
			customerData[i] = format.formatCellValue(cell);	
		}

		// String[][] data = new String[rowCount + 1][cellCount];
		// for (int i = 0; i <= rowCount; i++) {
		// XSSFRow row = sheet.getRow(i);
		// for (int j = 0; j < cellCount; j++) {
		// XSSFCell cell = row.getCell(j);
		// if (cell != null) {
		// switch (cell.getCellType()) {
		// case XSSFCell.CELL_TYPE_NUMERIC:
		// data[i][j] = "" + cell.getNumericCellValue();
		// break;
		// case XSSFCell.CELL_TYPE_STRING:
		// data[i][j] = "" + cell.getStringCellValue();
		// break;
		// default:
		// break;
		// }
		// }
		// customerData[j] = data[i][j];
		// }
		// }
		return customerData;
	}

	public static void main(String[] args) throws IOException {
		String[] cus = CusRead.readExcelData("Excel.xlsx");
		for (String string : cus) {
			System.out.println(string);
		}
	}
}
