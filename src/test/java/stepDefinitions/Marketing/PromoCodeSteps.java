package stepDefinitions.Marketing;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;
import Pages.Marketing.PromoCodePage;
import io.cucumber.java.en.*;

public class PromoCodeSteps extends DriverManager {
	
	WebDriver driver;
	
	PromoCodePage Promo= new PromoCodePage();
	
	public PromoCodeSteps() {
		PageFactory.initElements(webDriver.get(), this);
		
	}
	
	//Add Promo Code
	@Given("User click on Add Promo code button")
	public void user_click_on_add_promo_code_button() {
	    Promo.addPromoCode();
	}

	@Then("User fill all the Promo code details")
	public void user_fill_all_the_promo_code_details() throws AWTException {
	  Promo.Type();
	  Promo.promoCode();
	  Promo.amount();
	  Promo.promo_code_start_date();
	  Promo.promo_code_end_date();
	  Promo.capping_of_user();
	  Promo.imageupload();
	  Robot robot = new Robot();
	  robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	  Promo.description();
	}

	@Then("User click on Promo code Submit")
	public void user_click_on_promo_code_submit() {
	    Promo.addPromosubmit();
	}

	//update Promo Code
	@Given("User click on Update Promo code button")
	public void user_click_on_update_promo_code_button1() {
	   Promo.updatePromoCode();
	}

	@Then("User update title of the Promo code")
	public void user_update_title_of_the_promo_code() {
	    Promo.updateData();
	}

	@Then("User click on update Promo code button")
	public void user_click_on_update_promo_code_button() {
	    Promo.updatePromoBtn();
	}

	//View Promo Code
	@Given("User click on View Promo code button")
	public void user_click_on_view_promo_code_button() {
	    Promo.viewPromoCode();
	}

	@Then("User should able to see the Promo code details")
	public void user_should_able_to_see_the_promo_code_details() {
	    Promo.getViewPromoCode();
	}

	@Given("User Click on Filter Promo code button")
	public void user_click_on_filter_promo_code_button() {
	    Promo.filterPromoCode();
	}

	@Then("User enter title in Title Promo code field")
	public void user_enter_title_in_title_promo_code_field() {
	   Promo.filterPromoCodeSearch();
	}
}
