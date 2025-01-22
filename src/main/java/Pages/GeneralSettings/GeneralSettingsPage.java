package Pages.GeneralSettings;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;

public class GeneralSettingsPage  extends DriverManager{
	
	
	public GeneralSettingsPage() {

		PageFactory.initElements(webDriver.get(), this);
    }
	
	@FindBy(xpath = "//span[.=\"General Settings\"]")
	private WebElement GeneralSettings;
	
	@FindBy(partialLinkText = "Avatar")
	private WebElement avatar;
	
	@FindBy(xpath = "//i[@class=\"fa fa-cog\"]")
	private WebElement Settings;
	
	public void clickGeneralSettings() {
		GeneralSettings.click();
	}
	
	public void clickAvatar() {
		avatar.click();
	}


	public void clickSettings() {
		Settings.click();
	}
}
