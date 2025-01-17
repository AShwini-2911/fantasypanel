package Pages.Marketing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;

public class MarketingPage extends DriverManager {
	
	private WebDriver driver;
	 
	 public MarketingPage() {
			PageFactory.initElements(webDriver.get(), this);
		}
	 
	 @FindBy(xpath = "//span[.=\"Marketing\"]")
	 private WebElement Marketing;
	 
	 @FindBy(partialLinkText = "Notification Template")
	 private WebElement NotificationTemplate;
	 
	 @FindBy(partialLinkText = "Promo Code")
	 private WebElement PromoCode;
	 
	 @FindBy(xpath = "//a[.=\"Communication Campaign\"]")
	 private WebElement CommunicationCampaign;
	 
	 @FindBy(partialLinkText = "Email Template")
	 private WebElement emailTemplate;
	 
	 
	 public void clickMarketing() {
		  Marketing.click();
	  }
	 
	 public void clickNotificationTemplate() {
		 NotificationTemplate.click();
	 }
	 
	 public void clickPromoCode() {
		 PromoCode.click();
	 }

	 public void clickCommunicationCampaign() {
		 CommunicationCampaign.click();
	 }
	 
	 public void clickEmailTemplate() {
		 emailTemplate.click();
	 }
	 
}
