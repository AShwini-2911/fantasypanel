package stepDefinitions.Marketing;



import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;
import Pages.Marketing.EmailTemplatePage;
import io.cucumber.java.en.*;


public class EmailTemplateSteps extends DriverManager {
	
	WebDriver driver;	
	EmailTemplatePage email = new EmailTemplatePage();
	public EmailTemplateSteps() {
		PageFactory.initElements(webDriver.get(), this);
		
	}
	
	@Given("User click on Add Email Template button")
	public void user_click_on_add_email_template_button() {
	    email.addEmailTemplate();
	}

	@Then("User fill all the Email Template details")
	public void user_fill_all_the_email_template_details() throws AWTException, InterruptedException {
	    email.fillFormAddEmailTemplate();
	    email.enterBodyContent();
	}

	@Then("User click on Email Template Submit")
	public void user_click_on_email_template_submit() throws InterruptedException {
	    email.addEmailTemplatebtn();
	}

	

}
