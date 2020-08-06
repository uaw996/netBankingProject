package com.netBankingTestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.netBankingPageObject.LoginPage;

import netBankingUtilities.BaseClass;

public class TC_LoginTest_001 extends BaseClass {
   WebDriver driver;
   
   
	
	
   @BeforeTest
   public void getDriver() throws IOException {
	   
	  driver = setUp();
	   
   }
   @Test(dataProvider="getDataProvide")
   public void loginTest(String uname, String passwd) {
	   driver.get(prop.getProperty("BASE_URL"));
    		   
	   LoginPage lo = new LoginPage(driver);
    	
	   lo.getUsername().sendKeys(uname);
	   
	   lo.getPassword().sendKeys(passwd);
	   
	   lo.getloginBtn().click();
	   
	   Assert.assertTrue(driver.getTitle().matches(EXPECT_TITLE), "credential is invalid");
	   
	   
   }
   
   @DataProvider
	public Object[][] getDataProvide() {

		Object[][] data = new Object[3][2];
		data[0][0] = "ajshfh";
		data[0][1] = "pass";

		data[1][0] = "djsjjd";
		data[1][1] = "jhsdjhf";

		data[2][0] = "mngr276899";
		data[2][1] = "qapydAq";

		return data;
	}

   
	   
	   
	   
   
   
   
   
	
}
