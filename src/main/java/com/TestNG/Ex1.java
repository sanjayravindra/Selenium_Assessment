package com.TestNG;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Ex1 {
	public static WebDriver driver; 
	String name;
	String password;
	
	
	
//	public void createDriver() {         //DO NOT change the method signature
//		//Implement code to create Driver from DriverSetup and assign it to 'static' driver variable
//		DriverSetup.getWebDriver();
//    }
	@Test(groups = {"init"})
	public void initializeName() {         //DO NOT change the method signature
		name="Tom";
		System.out.println("name");
	}
	@Test(groups = {"init"})
	public void initializePassword() {    //DO NOT change the method signature      
		password="Tom";
		System.out.println("pass");
	}
	@Test(dependsOnGroups = { "init.* "})
	public void signin() {               //DO NOT change the method signature
		System.out.println("signin");
	}
	
	public void closeBrowser() {         //DO NOT change the method signature
		driver.close();
	}
	
	public static void main(String[] args){          //DO NOT change the method signature
	    Ex1 page=new Ex1();
	    //Implement the required code
	}

}
