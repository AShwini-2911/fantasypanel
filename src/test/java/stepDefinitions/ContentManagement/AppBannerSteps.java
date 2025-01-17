package stepDefinitions.ContentManagement;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Pages.ContentManagement.AppBannerPage;
import Utility.LoggerHelper;
import Utility.Util;
import io.cucumber.java.en.*;

public class AppBannerSteps {
	
	private WebDriver driver;
    AppBannerPage app;
    private static Logger log = LoggerHelper.getLogger(AppBannerSteps.class);  // Log4j logger instance


    // Constructor to initialize WebDriver and VideosPage
    public AppBannerSteps() {
        this.driver = Util.webDriver.get(); // Retrieve WebDriver from Util (ensure this method is accessible)
        app = new AppBannerPage(); // Initialize VideosPage with the WebDriver
    }
	
	
	@Given("User click on Add App Banner button")
	public void user_click_on_add_app_banner_button() {
		 Util.startConsoleCapture();

		 app.addAppBanner();
	}

	@Then("User fill all the App Banner details")
	public void user_fill_all_the_app_banner_details() {
	   app.addTitleAppBanner();
	   app.addLinkAppBanner();
	   app.ImageAppBanner();
	   
	}

	@Then("User click on App Banner Submit")
	public void user_click_on_app_banner_submit() {
	  app.addAppBannerSubmit();
	}

	@Given("User click on View App Banner button")
	public void user_click_on_view_app_banner_button() throws InterruptedException {
	   
	   System.out.println("view");
	    String test = app.viewAppBannerDetails();
	   System.out.println(test);
	   
	   String consoleOutput1 = Util.stopConsoleCapture();
	   if(!consoleOutput1.isEmpty()) {
		   log.info("Console Output: " +consoleOutput1);
	   }
	   
      Util.clearConsoleOutput();
	}

	@Then("User should able to see the App Banner details")
	public void user_should_able_to_see_the_app_banner_details() throws InterruptedException {
	   app.viewAppBannerDetails();
	}

	@Given("User click on Update App Banner button")
	public void user_click_on_update_app_banner_button() {
	    app.updateAppBanner();
	}

	@Then("User update title of the App Banner")
	public void user_update_title_of_the_app_banner() {
	   app.updateTitleAppBanner();
	}

	@Then("User click on update App Banner button")
	public void user_click_on_update_app_banner_button1() {
	    app.updateBtnAppBanner();
	}

	@Given("User Click on Filter App Banner button")
	public void user_click_on_filter_app_banner_button() {
	   app.filterAppBanner();
	}

	@Then("User enter title in Title App Banner field")
	public void user_enter_title_in_title_app_banner_field() {
	    app.filterTitleAppBanner();
	}

	@Then("User should able to filtered App Banner data")
	public void user_should_able_to_filtered_app_banner_data() throws InterruptedException {
	    
	    Util.startConsoleCapture();
        System.out.println("Filter");
	   String print = app.filterAppBannerDetails();
	   System.out.println(print);
	   
	   String consoleOutput2 = Util.stopConsoleCapture();
	   if(!consoleOutput2.isEmpty()) {
		   log.info("\n Console Output: " +consoleOutput2);
	   }
	   
       Util.clearConsoleOutput();
	}


}
