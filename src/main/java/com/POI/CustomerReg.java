package com.POI;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomerReg {
	static WebDriver driver;


	public static void testSeleniumTestForm() throws IOException
	{
//		 String[] cus = CusRead.readExcelData("Excel.xlsx");
		driver.findElement(By.name("cname")).sendKeys(CusRead.customerData[0]);
		driver.findElement(By.name("age")).sendKeys(CusRead.customerData[1]);
		driver.findElement(By.name("address")).sendKeys(CusRead.customerData[2]);
		driver.findElement(By.name("phonenumber")).sendKeys(CusRead.customerData[3]);
		driver.findElement(By.name("email")).sendKeys(CusRead.customerData[4]);
		driver.findElement(By.id("submit")).click();
	}
	
	public static void main(String[] args) throws Exception {

		
		 System.setProperty("webdriver.chrome.driver",
		 "C:\\Users\\sanjay.ravindra\\eclipse-workspace\\Selenium_Assessments\\Driver\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("http://webapps.tekstac.com/CustomerRegistration/");
		CustomerReg.testSeleniumTestForm();
		System.out.println();
	}

}
