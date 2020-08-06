package com.netBankingPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
WebDriver driver;
	
	
	By UserID = By.name("uid");
	By Password = By.name("password");
	By loginbtn = By.name("btnLogin");
	
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		
	}
		
	public WebElement getUsername() {
		
	return	driver.findElement(UserID);
	}
	public WebElement getPassword() {
		return driver.findElement(Password);
	}
	public WebElement getloginBtn() {
		
		return driver.findElement(loginbtn);
	}
	

	
	

}
