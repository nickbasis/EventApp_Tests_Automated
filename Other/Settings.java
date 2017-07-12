package Other;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Settings {

	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		//This Launches firefox browser
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("webdriver.log.file", "c:\\temp\\firefox.log");
		
		//System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"false");
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium3.4\\geckodriver.exe");
		driver = new FirefoxDriver(profile);
		//driver = new FirefoxDriver(); //Reference variable driver, pointing to the object
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); //Implicit wait applies prwto an exw kai ta 2 energa se ena script*/
		
		/*
		//This Launches Chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium3.4\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		//Start Chrome Full Screen
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		*/
		
//		Customized xpath Using Attributes .//tagName[@attribute=‘value’] 		
		
		//GO to the app
		
		driver.get("https://staging.cmdapp.com/cms");
		
		//Enter login details
				driver.findElement(By.id("ctl00_mainContent_LoginCtrl_UserName")).clear(); //Vres to pedio gia username kai katharise to
				driver.findElement(By.id("ctl00_mainContent_LoginCtrl_UserName")).sendKeys("****"); //Grapse 'admin'
				driver.findElement(By.id("ctl00_mainContent_LoginCtrl_Password")).clear(); //Vres to pedio gia password kai katharise to
				driver.findElement(By.id("ctl00_mainContent_LoginCtrl_Password")).sendKeys("******");
				
//				driver.findElement(By.id("ctl00_mainContent_LoginCtrl_UserName")).clear(); //Vres to pedio gia username kai katharise to
//				driver.findElement(By.id("ctl00_mainContent_LoginCtrl_UserName")).sendKeys("*****"); //Grapse 'admin'
//				driver.findElement(By.id("ctl00_mainContent_LoginCtrl_Password")).clear(); //Vres to pedio gia password kai katharise to
//				driver.findElement(By.id("ctl00_mainContent_LoginCtrl_Password")).sendKeys("*****");
				
				//Click on 'Sign In' button
				
				driver.findElement(By.name("ctl00$mainContent$LoginCtrl$Login")).click();
						
				
	}
	
	
	@AfterMethod
	public void tearDown()
    {
        driver.close();
    }
}
