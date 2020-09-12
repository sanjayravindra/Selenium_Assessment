package com.POI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AddressBook {
	public static String filePath = null;
	public static Object[][] data;
	  
    public static String getExcelPath(String firstSheetName)  
    {
        //get the file path of the excel sheet, store it in the variable 'filePath' and return it
        File input=new File("AddressBook.xlsx");
	    filePath = input.getAbsolutePath();
	    return filePath;
    }
     
    public static Object[][] readExcelData(String firstSheetName) throws Exception 
    {
        
	    //read the data from excel sheet and store it in 2-D array. Return the array
	    String path = System.getProperty("user.dir") + "/Excel.xlsx";
        FileInputStream input = new FileInputStream(path);
        XSSFWorkbook book = new XSSFWorkbook(input);
        XSSFSheet sheet = book.getSheet("Sheet1");
	   int rowCount = sheet.getLastRowNum();
        int cellCount = sheet.getRow(0).getLastCellNum();
        data = new Object[rowCount+1][cellCount];
        for (int i = 0; i <= rowCount; i++) {
	    XSSFRow row = sheet.getRow(i);
	    for (int j = 0; j < cellCount; j++) {
		XSSFCell cell = row.getCell(j);
	    DataFormatter format = new DataFormatter();
	    data[i][j] = format.formatCellValue(cell);	
        }
        }
    return data;
    }

    public static void writeExcelData(String firstSheetName, String[][] result) throws Exception 
    {
	  
	 	  //Write the data from 'result' in the new sheet 'customervalid1'
//    	String path = System.getProperty("user.dir") + "/Excel.xlsx";
//    	FileInputStream input = new FileInputStream(path);
//    	XSSFWorkbook book = new XSSFWorkbook(input);
//    	XSSFSheet sheet = book.getSheetAt(1);
//    	Row[] row = new Row[result.length];
//        Cell[][] cell = new Cell[row.length][];
//        for(int i = 0; i < row.length; i ++)
//        {
//            row[i] = sheet.createRow(i);
//            cell[i] = new Cell[result[i].length];
//            for(int j = 0; j < cell[i].length; j ++)
//            {
//                cell[i][j] = row[i].createCell(j);
//                cell[i][j].setCellValue(result[i][j]);
//            }
//        }
//    	input.close();
//    	FileOutputStream file = new FileOutputStream(path);
//    	book.write(file);
//    	file.close();
    	
    	
    	
    	
    	String[][] obj = result;

    	XSSFSheet xssfResultSheet = null;
//    	String filepath = getExcelPath(firstSheetName);
//
//    	FileInputStream inputStream = new FileInputStream(new File(filepath));
    	String path = System.getProperty("user.dir") + "/Excel.xlsx";
    	FileInputStream input = new FileInputStream(path);
    	XSSFWorkbook workbook = null;
    	workbook = new XSSFWorkbook(input);
    	xssfResultSheet = workbook.createSheet(firstSheetName);

    	for (int i = 0; i < obj.length; i++) {



    	XSSFRow rw = xssfResultSheet.createRow(i);
    	for (int j = 0; j < 2; j++) {
    	XSSFCell cell = rw.createCell(j);
    	// if(cell.getCellType().equals(1)) {
    	cell.setCellValue((String) obj[i][j]);
    	// }
    	}


    	}

    	input.close();

    	FileOutputStream outputStream = new FileOutputStream(filePath);

    	workbook.write(outputStream);

    	outputStream.close();
    }

}
