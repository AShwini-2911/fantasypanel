package Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Utility.Util;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	public static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	
	 public static WebDriver getDriver() {
	        return webDriver.get();
	    }
	
	@BeforeMethod
	public static void CreateDriver() {
		 try {
	            WebDriverManager.chromedriver().setup();

	            // Configure Chrome options
	            ChromeOptions options = new ChromeOptions();
	            
//	            if (Boolean.parseBoolean(Util.properties("config", "Headless"))) {
//	                options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
//	            }

	            // Create a new WebDriver instance
	            WebDriver driver = new ChromeDriver(options);

	            // Load application URL and configure driver
	            driver.get(Util.properties("config", "Applink"));
	            driver.manage().window().maximize();
	            driver.manage().timeouts().implicitlyWait(Integer.parseInt(Util.properties("config", "ImplicitWait")), TimeUnit.SECONDS);

	            // Set WebDriver to ThreadLocal
	            webDriver.set(driver);
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException("Failed to initialize WebDriver: " + e.getMessage());
	        }
	}

	@AfterMethod
	public synchronized void afterSuite() {
		webDriver.get().close();
		webDriver.get().quit();
		
	}

	
}
