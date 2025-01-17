package stepDefinitions.Marketing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;
import Pages.Marketing.MarketingPage;
import io.cucumber.java.en.Given;

public class MarketingSteps extends DriverManager{

    WebDriver driver;
	
	MarketingPage Marketing=  new MarketingPage();
	
	public MarketingSteps() {
		PageFactory.initElements(webDriver.get(), this);
	}
	
	@Given("I navigate to the Marketing Module")
	public void i_navigate_to_the_marketing_module() {
		
	    Marketing.clickMarketing();
	}

	@Given("I select the Notification Template Module")
	public void i_select_the_notification_template_module() {
	    Marketing.clickNotificationTemplate();
	}
	
	@Given("I select the Promo code Module")
	public void i_select_the_promo_code_module() {
	   Marketing.clickPromoCode();
	}
	
	@Given("I select the Communication campaign Module")
	public void i_select_the_communication_campaign_module() {
	    Marketing.clickCommunicationCampaign();
	}
	
	@Given("I select the Email Template Module")
	public void i_select_the_email_template_module() {
	   Marketing.clickEmailTemplate();
	}
}
