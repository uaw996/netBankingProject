package netBankingUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;

public class BaseClass {
public 	WebDriver driver;
public	Properties prop;
public static  String EXPECT_TITLE = "Guru99 Bank Manager HomePage";
public static  String EXPECT_ERROR = "User or Password is not valid";






	Logger log = LogManager.getLogger(BaseClass.class.getName());
	public WebDriver setUp() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\netBankingUtilities\\config.properties");
		prop.load(fis);
		
		String browserName =prop.getProperty("browser");
		System.out.println(browserName);
		
			
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe" );
			driver = new ChromeDriver();
			
		}
			
		if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//drivers//geckodriver.exe" );
			driver = new FirefoxDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
    return driver;
	}
	public void getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
//		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// you can also write above statement 
		String dateName = new SimpleDateFormat("hh mm ss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source =  ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\screenShots\\"+testCaseName+""+dateName+".png";
		 
		 FileHandler.copy(source,new File(destinationFile));

//		return destinationFile;
	
} 

	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
		log.info("Browser closed successfully");
	}
	
			
				
			}
			
			
		
		
		
				
	
	
	


