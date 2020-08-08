package com.netBankingTestCases;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.netBankingPageObject.LoginPage;

import lib.ReadExcel;
import netBankingUtilities.BaseClass;

public class TC_LoginTest_001 extends BaseClass {
   WebDriver driver;
   
    Logger log = LogManager.getLogger(TC_LoginTest_001.class.getName());
	
	
   @BeforeTest
   public void getDriver() throws IOException {
	   
	  driver = setUp();
	   log.info("Browser launch");
   }
   @Test(dataProvider="getDataProvide")
   public void loginTest(String uname, String passwd) {
	   driver.get(prop.getProperty("BASE_URL"));
	   log.info("Url entered");	   
	   LoginPage lo = new LoginPage(driver);
	   
	   lo.getUsername().sendKeys(uname);
	   log.info("enter username");
	   lo.getPassword().sendKeys(passwd);
	   log.info("enter password");
	   lo.getloginBtn().click();
	   log.info("click on login button");
	   
	   try{ 
		    
	       	Alert alt = driver.switchTo().alert();
			String actualBoxtitle = alt.getText(); // get content of the Alter Message
			alt.accept();
			if (actualBoxtitle.contains(EXPECT_ERROR)) { // Compare Error Text with Expected Error Value
			    System.out.println("Test case: Passed"); 
			} else {
			    System.out.println("Test case: Failed");
			}
		}    
	    catch (NoAlertPresentException Ex){ 
	         String	actualTitle = driver.getTitle();
			// On Successful login compare Actual Page Title with Expected Title
			if (actualTitle.contains(EXPECT_TITLE)) {
			    System.out.println("Test case: Passed");
			} else {
			    System.out.println("Test case: Failed");
			}
			  
	    }
	   
	   
	   
	   
	   
	    
   }
   
   @Test
   public void titleTest() {
	   
	   Assert.assertTrue(driver.getTitle().matches(EXPECT_TITLE), "credential is invalid");
	   log.info("Validate Title");
	   
   }
   
   
   
   
   
   
   @DataProvider
	public Object[][] getDataProvide() throws IOException {

	   ReadExcel rd = new ReadExcel(System.getProperty("user.dir")+"\\src\\test\\java\\netBankingTestData\\testData.xlsx");
	   int row = rd.getRowCount(0);
		Object[][] data = new Object[row][2];
	for(int i=0; i<row;i++) {
		
		data[i][0] = rd.getdata(0, i, 0);
		data[i][1] = rd.getdata(0, i, 1);
		
		
	}
		
		

		return data;
	}

   
	   
	   
	   
   
   
   
   
	
}
