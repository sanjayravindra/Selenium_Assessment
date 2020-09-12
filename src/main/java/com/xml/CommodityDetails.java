package com.xml;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class CommodityDetails {
	public static WebDriver driver;
    public static XPath xPath;
    public static Document doc;
    public static DocumentBuilder dBuilder;

    
    public static String name,weight,length,width,height;
    
    public static WebDriver createDriver(){     //Do not change the method signature
       //Create the driver using the class 'DriverSetup'. Assign it to the variable 'driver' and return it.
	   //Use URL, "http://webapps.tekstac.com/CommodityDetails/"
    	System.setProperty("webdriver.chrome.driver",
    			 "C:\\Users\\sanjay.ravindra\\eclipse-workspace\\Selenium_Assessments\\Driver\\chromedriver.exe");
    			 driver = new ChromeDriver();
    			 driver.manage().window().maximize();
    			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   driver.get("http://webapps.tekstac.com/CommodityDetails/");
	   return driver;
	}
    
    public static XPath readFile(String fileName,String id) throws ParserConfigurationException, SAXException, IOException {     //Do not change the method signature
        //Pass fileName and commodity id as parameter
        //Parse the xml file. Return the xpath reference
                File XmlFile = new File(fileName);
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                dBuilder = dbFactory.newDocumentBuilder();
                 doc = dBuilder.parse(XmlFile);
                 xPath =  XPathFactory.newInstance().newXPath();
                  return xPath;

    }
    
    public static Node getName(int id) throws XPathExpressionException  {       //Do not change the method signature
        //Pass the commodity id as parameter. Parse name and return it node.
        String expression = String.format("/Commoditydetails/Commodity[@id='"+id+"']/Name");
        Node node = (Node) xPath.compile(expression).evaluate(doc, XPathConstants.NODE);
        return node;

    }
    
    public  static Node getWeight(int id) throws XPathExpressionException  {     //Do not change the method signature
        //Pass the commodity id as parameter. Parse weight and return it node.
        String expression = String.format("/Commoditydetails/Commodity[@id='"+id+"']/Weight");
        Node node = (Node) xPath.compile(expression).evaluate(doc, XPathConstants.NODE);
        return node;
    }
    
    public  static Node getLength(int id)throws Exception {   //Do not change the method signature
        //Pass the commodity id as parameter. Parse length and return it node.
        String expression = String.format("/Commoditydetails/Commodity[@id='"+id+"']/Length");
        Node node = (Node) xPath.compile(expression).evaluate(doc, XPathConstants.NODE);
        return node;
    }
    
    public static Node getWidth(int id) throws Exception {      //Do not change the method signature
       //Pass the commodity id as parameter. Parse width and return it node.
       String expression = String.format("/Commoditydetails/Commodity[@id='"+id+"']/Width");
        Node node = (Node) xPath.compile(expression).evaluate(doc, XPathConstants.NODE);
        return node;
    }
    
    
    public static Node getHeight(int id) throws Exception {     //Do not change the method signature
        //Pass the commodity id as parameter. Parse heigth and return it node.
        String expression = String.format("/Commoditydetails/Commodity[@id='"+id+"']/Height");
        Node node = (Node) xPath.compile(expression).evaluate(doc, XPathConstants.NODE);
        return node;
    }
 
    public static void readInsertedData(){     //Do not change the method signature
        //Locate the row displayed on the page after submit.
        //Find the text of of name,weight,height,width and length and store it in respective variables declared above
    	name = driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(1)")).getText();
    	weight = driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(2)")).getText();
    	length = driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(3)")).getText();
    	width = driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(4)")).getText();
    	height = driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(5)")).getText();

    }
    
    
    
    public static String getCommodityCount(){    //Do not change the method signature
    	//Locate commodity count value after submit and return it
    	String count = driver.findElement(By.id("count")).getText();
    	return count;
    }
    
    public static String getTotalComWeight(){     //Do not change the method signature
    	//Locate total weight value after submit and return it
    	String total = driver.findElement(By.id("count")).getText();
    	return total;
    }
     
    
      public   static void  submitForm(int id) throws Exception {   //Do not change the method signature
        //Locate the form elements and send the values parsed from xml.
        //Submit the form.
        //Pass commodity id as parameter
    	  driver.findElement(By.id("name")).sendKeys(getName(id).getTextContent());
    	  driver.findElement(By.id("weight")).sendKeys(getWeight(id).getTextContent());
    	  driver.findElement(By.id("length")).sendKeys(getLength(id).getTextContent());
    	  driver.findElement(By.id("width")).sendKeys(getWidth(id).getTextContent());
    	  driver.findElement(By.id("height")).sendKeys(getHeight(id).getTextContent());
    	  driver.findElement(By.id("add")).click();
      }

    public static void main(String[] args) throws Exception 
	{
	    CommodityDetails commodity=new CommodityDetails();
	    //Implement code here
	    CommodityDetails.createDriver();
	    CommodityDetails.readFile(System.getProperty("user.dir")+"/Commodity.xml","Commodity");
	    CommodityDetails.submitForm(1);
	    CommodityDetails.readInsertedData();
	    CommodityDetails.getCommodityCount();
	    CommodityDetails.getTotalComWeight();
	} 

}
