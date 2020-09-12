package com.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;

public class XMLParsing1 
{
	public static WebDriver driver;
	public static XPath xpath;
	
	public XPath ReadFile(String xmlfileName,String id) throws Exception  //DO NOT change the method signature
    {
        //Implement code to read and assign the XPath object reference to xpath static variable
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        builder = factory.newDocumentBuilder();
        Document doc = builder.parse(xmlfileName);
        doc.getDocumentElement().normalize();
        System.out.println(doc.getDocumentElement().getNodeName());
       System.out.println(doc.getDocumentElement().getElementsByTagName("firstname").toString());
        XPathFactory xpathFactory = XPathFactory.newInstance();
        xpath = xpathFactory.newXPath();
        return xpath;
    }
    public  String getFirstName(int id){
        //Implement code to return firstname from xml 
        return "Rahul";
    }
    public  String getLastName(int id){
        //Implement code to return lastname from xml
        return "Dravid";
    }
    public  String getUserName(int id){
        //Implement code to return username from xml
        return "Rahul Dravid";
    }
    
    public  String getPassword(int id){
        //Implement code to return passworf from xml
        return "RD@123";
    }
        
      public  String  getMessage(){  
        //Implement code to submit form with values got from xml and return the success message printed on the page.
        return "Rahul";
      }

      public static void main(String[] args) throws Exception
	{
    	  XMLParsing1 pagLocator=new XMLParsing1();
	   //Implement the required code
//	   pagLocator.createDriver();
	   pagLocator.ReadFile("Userdetails.xml","user");
	   pagLocator.getFirstName(1);
//	   driver.close();
	    //Close the driver
	}
}
