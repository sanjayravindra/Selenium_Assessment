package com.BasicSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CC1 {
static WebDriver driver;
	
	public WebDriver createDriver()
	{
	   //Create driver, store in in static variable 'driver' and return it
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sanjay.ravindra\\eclipse-workspace\\Selenium_Assessments\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://webapps.tekstac.com/CustomerShippingDetails/");
	   return driver;
	}
	
	public static void setNewFormValues(String shipmentid,String name,String departuredate,String arrivaldate)
	{
		//Find the form elements and set values by passing those values from 'main' method. 
	    //Submit form to add the details
		driver.findElement(By.id("shipmentid")).sendKeys(shipmentid);
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("departuredate")).sendKeys(departuredate);
		driver.findElement(By.id("arrivaldate")).sendKeys(arrivaldate);
		driver.findElement(By.id("add")).click();
	}
	
	public static WebElement getNewShipmentId() {
		//Find and return the 'shipmentid' web element of the row displayed after first submit
		WebElement shipmentid = driver.findElement(By.id("radio0"));
		return shipmentid;
	}
	public static WebElement getNewName() {
		//Find and return the 'name' web element of the row displayed after first submit
		WebElement name = driver.findElement(By.xpath("(//td)[14]"));
		return name;
	}
	public static WebElement getNewdepartureDate() {
		//Find and return the 'departuredate' web element of the row displayed after first submit
		WebElement departuredate = driver.findElement(By.xpath("(//td)[15]"));
		return departuredate;
	}
	public static WebElement getNewArrivalDate() {
		//Find and return the 'arrivaldate' web element of the row displayed after first submit
		WebElement arrivaldate = driver.findElement(By.xpath("(//td)[16]"));
		return arrivaldate;
	}
	
	public static void editDetails() {
		//Find the first radio button and click 
	    //Find edit button and click
		getNewShipmentId().click();
		driver.findElement(By.id("edit")).click();
		
	}
	
	
	public static String getEditShipmentId() {
		//Find and return the 'shipmentid' value in the edit box in the form after cicking edit
		 String shipmentid = getNewShipmentId().getText();
		return shipmentid;
	}
	public static String getEditName() {
		//Find and return the 'name' value in the edit box in the form after cicking edit
		String name = getNewName().getText();
		return name;
	}
	public static String EditNewDepartureDate() {
		//Find and return the 'departuredate' value in the edit box in the form after cicking edit
		String departuredate = getNewdepartureDate().getText();
		return departuredate;
	}
	public static String getEditArrivalDate() {
		//Find and return the 'arrivaldate' value in the edit box in the form after cicking edit
		String arrivaldate = getNewArrivalDate().getText();
		return arrivaldate;
	}
	
	
	public static void setUpdateFormValues(String shipmentid,String name,String departuredate,String arrivaldate)
	{
		//Set form values to update and submit (by passing those values from 'main' method).
		WebElement id = driver.findElement(By.id("shipmentid"));
		id.clear();
		id.sendKeys(shipmentid);
		WebElement nam =driver.findElement(By.id("name"));
		nam.clear();
		nam.sendKeys(name);
		WebElement dept = driver.findElement(By.id("departuredate"));
		dept.clear();
		dept.sendKeys(departuredate);
		WebElement arvl = driver.findElement(By.id("arrivaldate"));
		arvl.clear();
		arvl.sendKeys(arrivaldate);
		driver.findElement(By.id("add")).click();
	}
	
	public static void deleteDetails() {
		//Find the SECOND row of address displayed and click the radio button
		//Find delete button and click to delete SECOND row
		driver.findElement(By.id("radio1")).click();
		driver.findElement(By.id("delete")).click();
	}
	
	public static void main(String[] args) {
		CC1 ab=new CC1();
		//Add required code
		ab.createDriver();
		setNewFormValues("1", "a", "b", "c");
		setUpdateFormValues("2", "x", "y", "z");
		editDetails();
		getEditShipmentId();
		getEditName();
		EditNewDepartureDate();
		getEditArrivalDate();
		setUpdateFormValues("3", "x", "y", "z");
		deleteDetails();

	}

}
