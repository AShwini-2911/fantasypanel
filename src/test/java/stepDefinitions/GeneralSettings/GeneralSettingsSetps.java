package stepDefinitions.GeneralSettings;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Pages.GeneralSettings.GeneralSettingsPage;
import Utility.LoggerHelper;
import Utility.Util;
import io.cucumber.java.en.Given;

public class GeneralSettingsSetps {

	
	private WebDriver driver;
    GeneralSettingsPage generalSet;
    private static Logger log = LoggerHelper.getLogger(GeneralSettingsSetps.class); 
    
    public GeneralSettingsSetps() {
        this.driver = Util.webDriver.get(); // Retrieve WebDriver from Util
        generalSet	= new  GeneralSettingsPage(); // Initialize UserManagementPage     
        
    }
    
	@Given("User navigate to the General Settings Module")
	public void user_navigate_to_the_general_settings_module() throws InterruptedException {
		WebElement leftSection = driver.findElement(By.xpath("//div[@class=\"ps__thumb-y\"]"));
		leftSection.click();
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(leftSection, 0, 300).perform(); // Scroll down one step in the left section

		Util.startConsoleCapture();
		
	   generalSet.clickGeneralSettings();
	   Thread.sleep(5000);
	   log.info("Gs");
		
	}

	@Given("User select the avatar Module")
	public void user_select_the_avatar_module() {

	   generalSet.clickAvatar();
	}
	
	@Given("User select the settings Module")
	public void user_select_the_settings_module() {
		log.info("settings");
	   generalSet.clickSettings();
	   
	}
	
	@Given("User select the Spin Wheel Module")
	public void user_select_the_spin_wheel_module() {
	    log.info("Spin Wheel");
	    generalSet.clickSpinWheel();
	}
	
	@Given("User select the Application SettingsModule")
	public void user_select_the_application_settings_module() {
	    generalSet.clickApplicationSettings();
	}
}
