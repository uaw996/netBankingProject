package com.netBankingTestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.netBankingPageObject.BankManagerHomePage;
import com.netBankingPageObject.LoginPage;

import lib.ReadExcel;
import netBankingUtilities.BaseClass;

public class TC_ManagerIDTest extends BaseClass {

	WebDriver driver; // to avoid failure while parallel execution will happen

	Logger log = LogManager.getLogger(TC_ManagerIDTest.class.getName());

	@BeforeTest
	public void getDriver() throws IOException {

		driver = setUp();
		log.info("Browser launch");
	}

	@Test(dataProvider = "getDataProvide")
	public void getManagerIDTest(String uname, String passwd) throws InterruptedException {
		driver.get(prop.getProperty("BASE_URL"));
		log.info("Url entered");
		LoginPage lo = new LoginPage(driver);

		lo.getUsername().sendKeys(uname);
		log.info("enter username");
		lo.getPassword().sendKeys(passwd);
		log.info("enter password");
		lo.getloginBtn().click();
		log.info("click on login button");

//		   Thread.sleep(3000);
		BankManagerHomePage Bm = new BankManagerHomePage(driver);
//		   Thread.sleep(3000);
		
		Assert.assertTrue(false);
		Assert.assertTrue(Bm.getManageraID().isDisplayed(), "ManagerID Not Shown");
		log.debug("validate manager ID ");

	}

	@DataProvider
	public Object[][] getDataProvide() throws IOException {

		ReadExcel rd = new ReadExcel(
				System.getProperty("user.dir") + "\\src\\test\\java\\netBankingTestData\\testData.xlsx");
//	   int row = rd.getRowCount(0);
		Object[][] data = new Object[1][2];

		data[0][0] = rd.getdata(0, 3, 0);
		data[0][1] = rd.getdata(0, 3, 1);

		return data;
	}

}
