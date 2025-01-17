package Utility;

import java.io.ByteArrayOutputStream;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import Base.DriverManager;
import Pages.LoginPage;
import Pages.Master.GamesPage;
import Pages.Master.VideosPage;

import java.io.FileInputStream;
import java.io.InputStream;


public class Util extends DriverManager {

	
        private WebDriver driver;

	    private static FileReader reader;
	    private static Properties p;
	    private static String screenshotDir;

	    private static final ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
	    private static final PrintStream originalOut = new PrintStream(consoleOutput);
	    private WebDriverWait wait;
	    private static Properties videosProperties;
	    private static Properties gamesProperties;



	    
	    public Util(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // You can set any timeout
	    }

	    // Wait for an element to be visible
	    public void waitForElementVisible(WebElement element) {
	        wait.until(ExpectedConditions.visibilityOf(element));
	    }
	    static {
	        // Load screenshot directory from extent.properties
	        Properties properties = new Properties();
	        try {
	            properties.load(Util.class.getClassLoader().getResourceAsStream("extent.properties"));
	            screenshotDir = properties.getProperty("screenshot.dir", "screenshots/");  // Default to 'screenshots/' if not set
	        } catch (IOException e) {
	            e.printStackTrace();
	            screenshotDir = "screenshots/"; // Default if loading fails
	        }
	        
	        // Load `videos.properties` file
	        videosProperties = new Properties();
	        try (InputStream input = new FileInputStream("D:\\automation\\practice\\src\\test\\resources\\property\\AddVideos.properties")) {
	            videosProperties.load(input);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	    

	        
	        
	    }

	 // Method to get values from `videos.properties`
	    public static String getVideoProperty(String key) {
	        return videosProperties.getProperty(key);
	    }

	    
	    public static void fillVideoForm(VideosPage videoFormPage) {
	        videoFormPage.enterTitle(getVideoProperty("video.Title"));
	        videoFormPage.enterDescription(getVideoProperty("video.Description"));
	        videoFormPage.enterURL(getVideoProperty("video.URL"));
	        videoFormPage.updateTitle(getVideoProperty("Video.TitleUpdate"));
	        videoFormPage.titleFilter(getVideoProperty("video.TitleFilter"));

	    }
	    
	

	    // Method to capture a screenshot as a byte array
	    public static byte[] takeScreenShot() {
	        return ((TakesScreenshot) webDriver.get()).getScreenshotAs(OutputType.BYTES);
	    }

	    // Method to save a screenshot file and attach it to Extent Report
	    public static void addScreenshotToReport(String screenshotName) {
	    	 try {
	    	        byte[] screenshotBytes = takeScreenShot();
	    	        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	    	        String fileName = screenshotName + "_" + timestamp + ".png";
	    	        String screenshotFullPath = screenshotDir + fileName;

	    	        // Save the screenshot file
	    	        File screenshotFile = new File(screenshotFullPath);
	    	        screenshotFile.getParentFile().mkdirs(); // Create directory if necessary
	    	        
	    	        try (FileOutputStream fos = new FileOutputStream(screenshotFile)) {
	    	            fos.write(screenshotBytes);
	    	        }

	    	        // Retrieve relative path and attach to Extent Report
	    	        String relativeFilePath = "../" + screenshotDir + fileName;
	    	        ExtentCucumberAdapter.getCurrentStep().info(screenshotName,
	    	                MediaEntityBuilder.createScreenCaptureFromPath(relativeFilePath).build());

	    	    } catch (IOException e) {
	    	        e.printStackTrace();
	    	    }	    }

	    // Method to read properties from a specified properties file
	    public static String properties(String fileName, String value) {
	        String propValue = null;
	        try {
	            reader = new FileReader("AppConfig" + "//" + fileName + ".properties");
	            p = new Properties();
	            p.load(reader);
	            propValue = p.getProperty(value);
	        } catch (FileNotFoundException e) {
	            throw new RuntimeException("File not found: " + fileName);
	        } catch (IOException e) {
	            e.printStackTrace();
	            throw new RuntimeException("IO exception occurred");
	        }
	        return propValue;
	    }

	    // Method to send text to a WebElement
	    public static void sendText(WebElement element, String value) {
	        element.click();
	        element.sendKeys(value);
	    }

	    // Method to click a WebElement
	    public static void click(WebElement element) {
	        element.click();
	    }

	    // Method to get the current URL
	    public static String getURL() {
	        return webDriver.get().getCurrentUrl();
	    }

	    // Method to perform login using credentials from properties file
	    public static void performLogin() {
	        // Retrieve username and password from the properties file
	        String username = properties("config", "username");
	        String password = properties("config", "password");

	        // Initialize the LoginPage elements
	        LoginPage loginPage = PageFactory.initElements(webDriver.get(), LoginPage.class);

	        // Use the login page to enter credentials and log in
	        loginPage.enterUsername(username);
	        loginPage.enterPassword(password);
	        loginPage.clickLoginButton();
	    }
	    
	    
	    /**
	     * Method to start capturing console output.
	     */
	    public static void startConsoleCapture() {
	        System.setOut(originalOut);  // Redirect System.out to capture output
	        //System.out.println("Start Console capture");
	    }

	    /**
	     * Method to stop capturing console output.
	     */
	    public static String stopConsoleCapture() {
	    	
	    	  String consoleOutput1 = consoleOutput.toString();
	          return consoleOutput1;
	        //System.setOut(originalOut);  // Restore original System.out
	    }

	  

	    /**
	     * Clears captured console output for fresh capture in the next test.
	     */
	    public static void clearConsoleOutput() {
	        consoleOutput.reset();  // Clear the ByteArrayOutputStream
	    }

	   
	    }

	