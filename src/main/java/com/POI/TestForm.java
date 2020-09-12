package com.POI;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestForm {

	static WebDriver driver;
	public static String result;
	public static String msg;

	public void testSeleniumTestForm(String weight, String transportMode) throws Exception {
		// 'weight' and 'transportMode' parameter are used to send the values to the
		// form
		// find the elements in the form and set values as per description. Submit the
		// form.
		// Find the element of the message displayed after submit. Store it in 'msg'
		// variable.
		// Store the 'pass' or 'fail' in the 'result' variable
		driver.findElement(By.id("weight")).sendKeys(weight);
		driver.findElement(By.id(transportMode)).click();
		driver.findElement(By.id("calculate")).click();
		try {
			msg = driver.findElement(By.id("result")).getText();
			System.out.println(msg);
			result = "pass";
		} catch (Exception e) {
			result = "fail";
		}
		ExcelWrite.writeExcelData("cargo.xlsx", result);
	}
@Test(priority = 0)
	public void closeBrowser() {
		// close the browser
		driver.close();
	}

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sanjay.ravindra\\eclipse-workspace\\Selenium_Assessments\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://webapps.tekstac.com/Cargo_Shipping_Cost/");
		TestForm st = new TestForm();
		// Add code here
		st.testSeleniumTestForm("200", "air");
	}
}
