package stepDefinitions.ContentManagement;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;


import Pages.ContentManagement.PromoBannerPage;
import Utility.LoggerHelper;
import Utility.Util;
import io.cucumber.java.en.*;

public class PromoBannerSteps  {
	
	private WebDriver driver;
    PromoBannerPage promo;
    private static Logger log = LoggerHelper.getLogger(PromoBannerSteps.class);  // Log4j logger instance


    // Constructor to initialize WebDriver and VideosPage
    public PromoBannerSteps() {
        this.driver = Util.webDriver.get(); // Retrieve WebDriver from Util (ensure this method is accessible)
        promo = new PromoBannerPage(); // Initialize VideosPage with the WebDriver
    }
	
	
	
	

	@Given("User click on View Promo Banner button")
	public void user_click_on_view_promo_banner_button() {
		 Util.startConsoleCapture();

		 promo.viewPromoBanner();

	}

	@Then("User should able to see the Promo Banner details")
	public void user_should_able_to_see_the_promo_banner_details() throws InterruptedException {

		System.out.println("view");
		    String test = promo.viewPromoBannerDetails();
		   System.out.println(test);
		   
		   String consoleOutput1 = Util.stopConsoleCapture();
		   if(!consoleOutput1.isEmpty()) {
			   log.info("Console Output: " +consoleOutput1);
		   }
		   
	       Util.clearConsoleOutput();
	}

	@Given("User Click on Filter Promo Banner button")
	public void user_click_on_filter_promo_banner_button() {
	   
		promo.filterPromoBanner();
	}

	@Then("User enter title in Title Promo Banner field")
	public void user_enter_title_in_title_promo_banner_field() {
	  promo.filterTitlePromoBanner();
	}

	@Then("User should able to filtered Promo Banner data")
	public void user_should_able_to_filtered_promo_banner_data() throws InterruptedException {
		 Util.startConsoleCapture();
        System.out.println("Filter");
	   String print = promo.filterPromoBannerDetails();
	   System.out.println(print);
	   
	   String consoleOutput2 = Util.stopConsoleCapture();
	   if(!consoleOutput2.isEmpty()) {
		   log.info("\n Console Output: " +consoleOutput2);
	   }
	   
       Util.clearConsoleOutput();
	}

	@Given("User click on Update Promo Banner button")
	public void user_click_on_update_promo_banner_button1() {
	    promo.updatePromoBanner();
	}

	@Then("User update title of the Promo Banner")
	public void user_update_title_of_the_promo_banner() {
	    promo.updateTitlePromoBanner();
	}

	@Then("User click on update Promo Banner button")
	public void user_click_on_update_promo_banner_button() {
	   promo.updateBtnPromoBanner();
	}
	
	@Given("User click on Add Promo Banner button")
	public void user_click_on_add_promo_banner_button() {
	    promo.addPromoBanner();
	}

	@Then("User fill all the Promo Banner details")
	public void user_fill_all_the_promo_banner_details() {
	   promo.addTitlePromoBanner();
	   promo.addLinkPromoBanner();
	   promo.ImagePromoBanner();
	}

	@Then("User click on Promo Banner Submit")
	public void user_click_on_promo_banner_submit() {
		   promo.addPromoBannerSubmit();

	}



}
