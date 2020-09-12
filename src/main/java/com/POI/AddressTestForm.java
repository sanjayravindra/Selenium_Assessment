package com.POI;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AddressTestForm {
	public static WebDriver driver;
    public static String[][] result=new String[6][2]; 
       
   public void createDriver() {
       //Create driver and store in in static variable 'driver'
	   System.setProperty("webdriver.chrome.driver",
				 "C:\\Users\\sanjay.ravindra\\eclipse-workspace\\Selenium_Assessments\\Driver\\chromedriver.exe");
				 driver = new ChromeDriver();
				 driver.manage().window().maximize();
				 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				 driver.get("https://webapps.tekstac.com/AddressBook/");
     
   }

   public void testSeleniumTestForm() throws Exception {
       //Parse the first row from excel sheet. Send the data to form and submit. 
   	//Retrieve the respective element value displayed on page after submit. Store it in respective static variable
   	//Assert each element value.
   	//Store the element value, "Test Passed" or "Test Failed"  to variable 'result'
   	//Example, nickname value in result[0][0]
   	//         "Test Passed" or "Test Failed" in result[0][1]     	
   	//Write the data in 'result' new sheet 'customervalid1' on each row 
	   AddressBook.readExcelData("");
	   driver.findElement(By.id("nickname")).sendKeys(AddressBook.data[0][0].toString());
	   driver.findElement(By.id("contact")).sendKeys(AddressBook.data[0][1].toString());
	   driver.findElement(By.id("company")).sendKeys(AddressBook.data[0][2].toString());
	   driver.findElement(By.id("city")).sendKeys(AddressBook.data[0][3].toString());
	   driver.findElement(By.id("country")).sendKeys(AddressBook.data[0][4].toString());
	   driver.findElement(By.id("type")).sendKeys(AddressBook.data[0][5].toString());
	   driver.findElement(By.id("add")).click();    
	   
	   String name = driver.findElement(By.xpath("//*[@id=\"result\"]/table/tbody/tr[2]/td[1]")).getText();
	   Assert.assertEquals(AddressBook.data[0][0].toString(), name);
	   result[0][0] = name;
	   result[0][1] = "Test Passed";
//	   AddressBook.writeExcelData(" ", result);
	   String con = driver.findElement(By.xpath("//*[@id=\"result\"]/table/tbody/tr[2]/td[2]")).getText();
	   Assert.assertEquals(AddressBook.data[0][1].toString(), con);
	   result[1][0] = name;
	   result[1][1] = "Test Failed";
//	   AddressBook.writeExcelData(" ", result);
	   String comp = driver.findElement(By.xpath("//*[@id=\"result\"]/table/tbody/tr[2]/td[3]")).getText();
	   Assert.assertEquals(AddressBook.data[0][2].toString(), comp);
	   result[2][0] = name;
	   result[2][1] = "Test Passed";
//	   AddressBook.writeExcelData(" ", result);
	   String city = driver.findElement(By.xpath("//*[@id=\"result\"]/table/tbody/tr[2]/td[4]")).getText();
	   Assert.assertEquals(AddressBook.data[0][3].toString(), city);
	   result[3][0] = name;
	   result[3][1] = "Test Passed";
	   AddressBook.writeExcelData("Sheet", result);
   }
   
  
  public static void main(String[] args) throws Exception 
	{ 				
	  AddressTestForm st=new AddressTestForm();
		//Add code here
	  st.createDriver();
	  st.testSeleniumTestForm();

	}
}
