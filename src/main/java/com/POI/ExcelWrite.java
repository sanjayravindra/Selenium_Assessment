package com.POI;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	public static void writeExcelData(String fileName, String result) throws Exception {

		String path = System.getProperty("user.dir") + "/" + "Excel.xlsx";
		FileInputStream input = new FileInputStream(path);

		XSSFWorkbook book = new XSSFWorkbook(input);
		XSSFSheet sheet = book.getSheet("Sheet1");
		XSSFRow newRow = sheet.createRow(0);
		XSSFCell cell = newRow.createCell(0);
		cell.setCellValue(result);
		input.close();
		FileOutputStream file = new FileOutputStream(path);
		book.write(file);
		file.close();
	}
}
