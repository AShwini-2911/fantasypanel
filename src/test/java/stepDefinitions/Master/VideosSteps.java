 package stepDefinitions.Master;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import Base.DriverManager;
import Pages.Master.VideosPage;
import Utility.LoggerHelper;
import Utility.Util;
import io.cucumber.java.en.*;

public class VideosSteps extends DriverManager{

	 private WebDriver driver;
	    VideosPage VP;
	    private static Logger log = LoggerHelper.getLogger(VideosSteps.class);  // Log4j logger instance


	    // Constructor to initialize WebDriver and VideosPage
	    public VideosSteps() {
	        this.driver = Util.webDriver.get(); // Retrieve WebDriver from Util (ensure this method is accessible)
	        VP = new VideosPage(); // Initialize VideosPage with the WebDriver
	    }

	@Given("User click on Add Videos button")
	public void user_click_on_add_videos_button() throws InterruptedException {
		 Util.startConsoleCapture();
		 log.info("User clicked on Add Videos button");

		   
	
	        
	        // Log output using log4j
       

		Thread.sleep(4000);
	    VP.clickAddVideo();
	    
	    
	}

	@Then("User fill all the details")
	public void user_fill_all_the_details() {
		 VP.enterTitle(Util.getVideoProperty("video.Title"));
	        VP.enterDescription(Util.getVideoProperty("video.Description"));
	        VP.enterURL(Util.getVideoProperty("video.URL"));
	}

	@Then("User click on Submit")
	public void user_click_on_submit() {
//	   VP.videoSubmit();
//	   String pageSource = driver.getPageSource(); // Get the page source
//
//	   if (pageSource.contains("Data Added Successfully")) {
//           System.out.println("Data Added Successfully");
//       } 
//           else {
//           System.out.println("Video already exist!");
//       }
	   
//	   String consoleOutput2 = Util.stopConsoleCapture();
//	   if(!consoleOutput2.isEmpty()) {
//		   log.info("Console Output: " +consoleOutput2);
//	   }
//	   
//       Util.clearConsoleOutput();
	   
	}
	
	@Given("User click on Update Videos button")
	public void user_click_on_update_videos_button() {
	    VP.clickUpdateVideo();
	}

	@Then("User update title of the Video")
	public void user_update_title_of_the_video() {
		 VP.updateTitle(Util.getVideoProperty("Video.TitleUpdate"));

	}

	@Then("User click on update button")
	public void user_click_on_update_button() {
	   VP.VideoUpdateBtn();
	}

	@Given("User click on View videos button")
	public void user_click_on_view_videos_button() {
	   VP.clickViewVideo();
	}

	@Then("User should able to see the details")
	public void user_should_able_to_see_the_details() {
	    VP.getVideoDetails();
	}

	@Given("User Click on Filter button")
	public void user_click_on_filter_button() {
	    VP.clickVideoFilter();
	}

	@Then("User enter title in Title field")
	public void user_enter_title_in_title_field() {
	    VP.titleFilter(Util.getVideoProperty("video.TitleFilter"));
	}

	@Then("User should able to filtered data")
	public void user_should_able_to_filtered_data() {
	   VP.filteredData();
	}


	@Then("a success message {string} should be displayed")
	public void a_success_message_should_be_displayed(String exp) {
		VP.videoSubmit();
		String test = VP.videoSuccessMsg();
    	System.out.println(test);
        // Capture the console output
        String consoleOutput = Util.stopConsoleCapture(); // Replace with your actual console capture method
        
        exp = exp.trim();
        consoleOutput = consoleOutput.trim();

        // Compare the captured console output with the expected message
        if (consoleOutput.equals(exp)) {
            // If they match, log success
            ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>Console Output is as expected: " + consoleOutput + "</font>");
            log.info("Success: Console Output is as expected: " + consoleOutput);
        } else {
            // If they don't match, log failure and print the expected vs actual output
            ExtentCucumberAdapter.getCurrentStep().fail("<font color='green' style='background-color:white;'>Console Output does not match the expected message.\n" +
                                                        "Expected: " + exp + "\n" +
                                                        "Actual: " + consoleOutput + "</font>");
            log.error("<font color='green' style='background-color:white;'>Error: Console Output does not match the expected message.\n" +
                      "Expected: " + exp + "\n" +
                      "Actual: " + consoleOutput + "</font>");
            // Optionally, fail the test if the message doesn't match
            Assert.fail("<font color='green' style='background-color:white;'>Console Output does not match the expected message. </font>");
        }
        Util.clearConsoleOutput();

	}

	@Then("Video title border color should be RED indicating that field is mandatory")
	public void video_title_border_color_should_be_red_indicating_that_field_is_mandatory() {
		VP.videoSubmit();
		Util.startConsoleCapture();
    	try {
            // Fetch the border color using the method from the Page Object class
            String borderColor = VP.VideoTitleBorderColor();
            System.out.println("Border Color: " + borderColor);


            // Start capturing console output (assuming Util.startConsoleCapture() exists)
            String cOutput = Util.stopConsoleCapture();

            log.info("Success: Console Output is as expected: " + cOutput);

            // Verify the border color matches the expected value for red
            if (borderColor.equals("rgb(245, 82, 82)")) { // CSS border colors are in RGB format
                System.out.println("Test Passed:Confirm password border color changed to red.");
                ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>Console Output is as expected: " + cOutput + "</font>");
            } else {
                System.out.println("Test Failed:Confirm password border color did not change as expected.");
                ExtentCucumberAdapter.getCurrentStep().info("<font color='red' style='background-color:white;'>Border color mismatch. Actual: " + borderColor + "</font>");
            }
        } catch (Exception e) {
            e.printStackTrace();
          //  ExtentCucumberAdapter.getCurrentStep().error("<font color='red'>An exception occurred: " + e.getMessage() + "</font>");
        } finally {
            // Clear the captured console output (if applicable)
            Util.clearConsoleOutput();
        }


	}
	
	@When("User clicks on the VideoSubmit button without filling any fields")
	public void user_clicks_on_the_video_submit_button_without_filling_any_fields() {
	   VP.videoSubmit();
	}

	@Then("User clicks on Add videos Cancel button")
	public void user_clicks_on_add_videos_cancel_button() {
	    VP.clickCancelVideo();
	}

	@Then("User should able to see video listing page {string}")
	public void user_should_able_to_see_video_listing_page(String screenshotName) {
		Util.startConsoleCapture();

    	try {
            // Call the utility method to save the screenshot and attach it to the report
            Util.addScreenshotToReport(screenshotName);
            System.out.println("Screenshot captured and attached to the report: " + screenshotName);
        } catch (Exception e) {
            e.printStackTrace();
            ExtentCucumberAdapter.getCurrentStep().fail("Failed to capture screenshot: " + screenshotName);
        }
    	
    	 String consoleOutput2 = Util.stopConsoleCapture();
     	   if(!consoleOutput2.isEmpty()) {
     		   

                ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>"+ consoleOutput2 + "</font>");

     		   log.info("\n" +"Console Output: " + consoleOutput2);
     	   }
     	   
          Util.clearConsoleOutput();
    	

	}
	
	@Then("User clicks on Add videos Back button")
	public void user_clicks_on_add_videos_back_button() {
	   VP.clickBackBtnVideo();
	}
	
	@Then("User enters title and Description")
	public void user_enters_title_and_description() {
		VP.enterTitle(Util.getVideoProperty("video.Title"));
        VP.enterDescription(Util.getVideoProperty("video.Description"));
	}

	@When("the user enters {string} in the {string} field")
	public void the_user_enters_in_the_field(String string, String string2) {
        VP.enterURL(Util.getVideoProperty("video.SQLURL"));

	}

	@Then("an error video URL message {string} should be displayed")
	public void an_error_video_url_message_should_be_displayed(String expectedMsg) {
		String test = VP.videoURLInvalidMsg();
    	System.out.println(test);
        // Capture the console output
        String consoleOutput = Util.stopConsoleCapture(); // Replace with your actual console capture method
        
        expectedMsg = expectedMsg.trim();
        consoleOutput = consoleOutput.trim();

        // Compare the captured console output with the expected message
        if (consoleOutput.equals(expectedMsg)) {
            // If they match, log success
            ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>Console Output is as expected: " + consoleOutput + "</font>");
            log.info("Success: Console Output is as expected: " + consoleOutput);
        } else {
            // If they don't match, log failure and print the expected vs actual output
            ExtentCucumberAdapter.getCurrentStep().fail("<font color='green' style='background-color:white;'>Console Output does not match the expected message.\n" +
                                                        "Expected: " + expectedMsg + "\n" +
                                                        "Actual: " + consoleOutput + "</font>");
            log.error("<font color='green' style='background-color:white;'>Error: Console Output does not match the expected message.\n" +
                      "Expected: " + expectedMsg + "\n" +
                      "Actual: " + consoleOutput + "\n" +  "</font>");
            // Optionally, fail the test if the message doesn't match
            Assert.fail("<font color='green' style='background-color:white;'>Console Output does not match the expected message. </font>");
        }
        Util.clearConsoleOutput();

	}
	
	@When("User enter {string} in title")
	public void user_enter_in_title(String string) {
		VP.enterTitle(Util.getVideoProperty("video.Title"));

	}

	@When("User enter URL and Description")
	public void user_enter_url_and_description() {
		VP.enterDescription(Util.getVideoProperty("video.Description"));
        VP.enterURL(Util.getVideoProperty("video.URL"));
	}

	@Then("An video already exist error message should be displayed indicating {string}")
	public void an_video_already_exist_error_message_should_be_displayed_indicating(String output) {
		
		VP.videoSubmit();
String test =  VP.videoTitleExistsMsg();
        
    	System.out.println(test);
       // Capture the console output
       String consoleOutput = Util.stopConsoleCapture(); // Replace with your actual console capture method
       
       output = output.trim();
       consoleOutput = consoleOutput.trim();

       // Compare the captured console output with the expected message
       if (consoleOutput.equals(output)) {
           // If they match, log success
           ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>Console Output is as expected: " + consoleOutput + "</font>");
           log.info("Success: Console Output is as expected: " + consoleOutput);
       } else {
           // If they don't match, log failure and print the expected vs actual output
           ExtentCucumberAdapter.getCurrentStep().fail("<font color='green' style='background-color:white;'>Console Output does not match the expected message.\n" +
                                                       "Expected: " + output + "\n" +
                                                       "Actual: " + consoleOutput + "</font>");
           log.error("<font color='green' style='background-color:white;'>Error: Console Output does not match the expected message.\n" +
                     "Expected: " + output + "\n" +
                     "Actual: " + consoleOutput + "</font>");
           // Optionally, fail the test if the message doesn't match
           Assert.fail("<font color='green' style='background-color:white;'>Console Output does not match the expected message. </font>");
       }
       Util.clearConsoleOutput();


	}

	

	


}
