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
	public void user_navigate_to_the_general_settings_module() {
		WebElement leftSection = driver.findElement(By.xpath("//div[@class=\"ps__thumb-y\"]"));
		leftSection.click();
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(leftSection, 0, 300).perform(); // Scroll down one step in the left section

	   generalSet.clickGeneralSettings();
		
	}

	@Given("User select the avatar Module")
	public void user_select_the_avatar_module() {

	   generalSet.clickAvatar();
	}
	
}
