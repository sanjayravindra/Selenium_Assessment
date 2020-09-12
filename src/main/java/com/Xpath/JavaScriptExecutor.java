package com.Xpath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor 
{

	public WebDriver driver;
	public String Url = "http://webapps.tekstac.com/Cargo_Shipping_Cost/";

	
	public WebDriver createDriver()  //DO NOT Change the method Signature
	{
	    /* Replace this comment by the code statement to create and return the driver */
	    /* Naviaget to the Url  */
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sanjay.ravindra\\eclipse-workspace\\Selenium_Assessments\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Url);
	    return driver;
	    
	}
 
  public String submitForm(String weight,String mode) 
  {
      /*Using the driver, Locate the element using javascript executor ONLY. */
      /* Set the form values and submit */
      /* Return the displayed message */
       /*Close the driver*/
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("document.getElementById('weight').value="+weight+";");
	  executor.executeScript("document.getElementById('"+mode+"').click();");
	  executor.executeScript("document.getElementById('calculate').click();");
	 String text = executor.executeScript("return document.getElementById('result').innerHTML").toString();
	 System.out.println(text);
       return text;
  }
  public static void main(String[] args) {
	  JavaScriptExecutor at=new JavaScriptExecutor();
	 //Add required code
	  at.createDriver();
	  at.submitForm("10", "road");
  }
}
