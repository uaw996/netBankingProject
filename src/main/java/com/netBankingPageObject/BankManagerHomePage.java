package com.netBankingPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class BankManagerHomePage {
WebDriver driver;
	
	By managerID = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td");
	



       public  BankManagerHomePage(WebDriver driver) {
	
	this.driver = driver;
	
	
}
	
	
       @Test
       public WebElement getManageraID() {
    	   
    	 return  driver.findElement(managerID);
       }
       
       
	
	
	
	
}
