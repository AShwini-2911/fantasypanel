package Pages.ContentManagement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;

public class ContentManagementPage extends DriverManager {
	
	public ContentManagementPage() {
		PageFactory.initElements(webDriver.get(), this);
	}

	@FindBy(xpath = "//span[.=\"Content Management\"]")
	private WebElement ContentManagement;
	
	public void clickContentManagement() {
		
		ContentManagement.click();
	}
	
	@FindBy(partialLinkText = "Promo Banner")
	private WebElement PromoBanner;
	
	@FindBy(partialLinkText = "CMS Page")
	private WebElement CMSPage;
	
	public void clickPromoBanner() {
		PromoBanner.click();
	}
	
	@FindBy(partialLinkText = "App Banner")
	private WebElement AppBanner;
	
	public void clickAppBanner() {
		AppBanner.click();
	}
	
	public void clickCMSPage() {
		CMSPage.click();
	}
	
}
