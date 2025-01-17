package stepDefinitions.ContentManagement;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Pages.ContentManagement.ContentManagementPage;
import Utility.LoggerHelper;
import Utility.Util;
import io.cucumber.java.en.Given;

public class ContentManagementSteps {
	private WebDriver driver;
    ContentManagementPage contentMgmt;
    private static Logger log = LoggerHelper.getLogger(ContentManagementSteps.class);  // Log4j logger instance


    // Constructor to initialize WebDriver and VideosPage
    public ContentManagementSteps() {
        this.driver = Util.webDriver.get(); // Retrieve WebDriver from Util (ensure this method is accessible)
        contentMgmt = new ContentManagementPage(); // Initialize VideosPage with the WebDriver
    }

	@Given("I navigate to the Content Management Module")
	public void i_navigate_to_the_content_management_module() {
	 
		contentMgmt.clickContentManagement();
	}

	@Given("I select the Promo Banner Module")
	public void i_select_the_promo_banner_module() {
		contentMgmt.clickPromoBanner();
	   
	}
	
	@Given("I select the App Banner Module")
	public void i_select_the_app_banner_module() {
	    contentMgmt.clickAppBanner();
	}
	
	@Given("I select the CMS Page Module")
	public void i_select_the_cms_page_module() {
	    contentMgmt.clickCMSPage();
	}

}
