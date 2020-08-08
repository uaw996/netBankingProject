package netBankingUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class BaseClass {
public 	WebDriver driver;
public	Properties prop;
public static  String EXPECT_TITLE = "Guru99 Bank Manager HomePage";
public static  String EXPECT_ERROR = "User or Password is not valid";

public static String uname ="mngr276899";

public  static String passwd= "qapydAq";


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
	@AfterClass
	public void tearDown() {
		
		driver.close();
		log.info("Browser closed successfully");
	}
	
			
				
			}
			
			
		
		
		
				
	
	
	


