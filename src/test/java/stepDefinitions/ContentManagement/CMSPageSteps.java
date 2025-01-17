package stepDefinitions.ContentManagement;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import Pages.ContentManagement.CMSPage;
import Utility.LoggerHelper;
import Utility.Util;
import io.cucumber.java.en.*;

public class CMSPageSteps {
	
	private WebDriver driver;
	CMSPage cms;
    private static Logger log = LoggerHelper.getLogger(CMSPageSteps.class);  // Log4j logger instance


    // Constructor to initialize WebDriver and VideosPage
    public CMSPageSteps() {
        this.driver = Util.webDriver.get(); // Retrieve WebDriver from Util (ensure this method is accessible)
        cms = new CMSPage(); // Initialize VideosPage with the WebDriver
    }

	@Given("User click on View CMS Page button")
	public void user_click_on_view_cms_page_button(){
		 Util.startConsoleCapture();

		 cms.clickViewCMSPage();
	  
	}

	@When("User should able to see the CMS Page details")
	public void user_should_able_to_see_the_cms_page_details() throws InterruptedException {
		 String test = cms.getCMSDetails();
		 System.out.println(test);
		   
		   String consoleOutput1 = Util.stopConsoleCapture();
		   if(!consoleOutput1.isEmpty()) {
			   log.info("Console Output: " +consoleOutput1);
		   }
		   
	      Util.clearConsoleOutput();
	   
	}

	@And("User should able to see the CMS Page English details")
	public void user_should_able_to_see_the_cms_page_english_details() throws InterruptedException {
	  
		 cms.clickCMSEnglish();
		 String output = cms.getCMSEnglish();
		 System.out.println(output);
		   
		   String consoleOutput2 = Util.stopConsoleCapture();
		   if(!consoleOutput2.isEmpty()) {
			   log.info("Console Output: " +consoleOutput2);
		   }
		   
	      Util.clearConsoleOutput();
	}

	@Then("User should able to see the CMS Page Hindi details")
	public void user_should_able_to_see_the_cms_page_hindi_details() {
		
		 cms.clickCMSHindi();

		 String output1 = cms.getCMSHindi();
		 System.out.println(output1);
		   
		   String consoleOutput3 = Util.stopConsoleCapture();
		   if(!consoleOutput3.isEmpty()) {
			   log.info("Console Output: " +consoleOutput3);
		   }
		   
	      Util.clearConsoleOutput();
	}

}
