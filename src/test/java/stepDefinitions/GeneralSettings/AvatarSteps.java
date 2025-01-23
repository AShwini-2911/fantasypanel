package stepDefinitions.GeneralSettings;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import Pages.GeneralSettings.AvatarPage;
import Utility.LoggerHelper;
import Utility.Util;
import io.cucumber.java.en.*;

public class AvatarSteps {

	private WebDriver driver;
	AvatarPage avatar;
	
	String newWindowUrl;
    private static Logger log = LoggerHelper.getLogger(AvatarSteps.class); 
    
    public AvatarSteps() {
        this.driver = Util.webDriver.get(); // Retrieve WebDriver from Util
        avatar = new  AvatarPage(); // Initialize UserManagementPage     
        
    }
	
	

	@Given("User is on the Add Avatar form page")
	public void user_is_on_the_add_avatar_form_page() {
	    Util.startConsoleCapture();
	    
	    avatar.clickAddAvatar();
	    
	    
	}

	@When("User uploads a valid image file with dimensions 1200x700 pixels")
	public void user_uploads_a_valid_image_file_with_dimensions_1200x700_pixels() {
	   
		avatar.imageUpload();
	}

	@When("User clicks the Add avatar Submit button")
	public void user_clicks_the_add_avatar_submit_button() {
	  // avatar.clickAvatarSubmit();
	}

	@Then("User should see a success message {string}")
	public void user_should_see_a_success_message(String exp) {
		avatar.clickAvatarSubmit();
	    log.info("Add avatar");
	    String test = avatar.addAvatarSuccessMsg();
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

	@When("User uploads an image file with dimensions less than 1200x700 pixels")
	public void user_uploads_an_image_file_with_dimensions_less_than_1200x700_pixels() {
	    avatar.image1Upload();
	}

	@Then("User should see an error message {string}")
	public void user_should_see_an_error_message(String exp) throws InterruptedException {
	   
		avatar.clickAvatarSubmit();
		Thread.sleep(12000);
	    String test = avatar.addAvatarImageSizeErrorMsg();
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

	@When("User clicks the Add avatar Submit  button without uploading any file")
	public void user_clicks_the_add_avatar_submit_button_without_uploading_any_file() {
		avatar.clickAvatarSubmit();
	}

	@Then("add avatar image field border color should be RED")
	public void add_avatar_image_field_border_color_should_be_red() throws InterruptedException {
		avatar.clickAvatarSubmit();
	    
	    Util.startConsoleCapture();
    	try {
            // Fetch the border color using the method from the Page Object class
            String borderColor = avatar.imageBorderColor();
            System.out.println("Border Color: " + borderColor);


            // Start capturing console output (assuming Util.startConsoleCapture() exists)
            String Output = Util.stopConsoleCapture();

            log.info("Success: Console Output is as expected: " + Output);

            // Verify the border color matches the expected value for red
            if (borderColor.equals("rgb(245, 82, 82)")) { // CSS border colors are in RGB format
                System.out.println("Test Passed:Confirm password border color changed to red.");
                ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>Console Output is as expected: " + Output + "</font>");
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

	@When("User clicks the Add avatar Cancel  button")
	public void user_clicks_the_add_avatar_cancel_button() {
	    avatar.clickAvatarCancel();
	}

	@Then("User should be avatar listing page")
	public void user_should_be_avatar_listing_page() {
	    
	    
	    String test = avatar.captureavatarDetails();
	     System.out.println(test);
	     
	     String consoleOutput1 = Util.stopConsoleCapture();
		   if(!consoleOutput1.isEmpty()) {
			   
	           String formattedOutput = formatConsoleOutputToTable(consoleOutput1);

	           ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>"+ formattedOutput + "</font>");

			   log.info("Console Output: " + formattedOutput);
		   }
		   
	     Util.clearConsoleOutput();
	     
	}
	
	/**
     * Formats the captured console output into an HTML table format.
     * 
     * @param consoleOutput The raw console output to format.
     * @return A formatted string representing the console output as a table.
     */
    private String formatConsoleOutputToTable(String consoleOutput) {
    	StringBuilder tableBuilder = new StringBuilder();
        tableBuilder.append("<table border='1' cellpadding='5' cellspacing='0' style='border-collapse: collapse;'>");
        
        // Add table headers
        tableBuilder.append("<tr><th style='background-color:#4CAF50; color:white;'>Console Output</th></tr>");
        
        // Split the console output into lines and add each line as a row in the table
        String[] lines = consoleOutput.split("\n");
        for (int i = 0; i < lines.length; i++) {
            // Define color logic for each row
            String rowColor = (i % 2 == 0) ? "#f2f2f2" : "#ffffff"; // Alternating row colors
            String cellColor = "#000000"; // Default cell color (black text)
            
            // Example: If the line contains specific text, change the color
            if (lines[i].contains("Error")) {
                rowColor = "#FFCDD2"; // Light red for errors
                cellColor = "#d32f2f"; // Dark red text color
            } else if (lines[i].contains("Success")) {
                rowColor = "#C8E6C9"; // Light green for success
                cellColor = "#388E3C"; // Dark green text color
            }

            // Add row with colored background and text
            tableBuilder.append("<tr style='background-color:").append(rowColor).append(";'>")
                        .append("<td style='color:").append(cellColor).append(";'>")
                        .append(lines[i]).append("</td></tr>");
        }

        // Close the table
        tableBuilder.append("</table>");
        
        return tableBuilder.toString();

    }


    @When("User click on View Avatar button")
    public void user_click_on_view_avatar_button() {
        avatar.viewAvatar();
    }

    @Then("User should able to see the avatar details")
    public void user_should_able_to_see_the_avatar_details() {
        
    	String test = avatar.getViewAvatarDetails();
        System.out.println(test);
        
        String consoleOutput1 = Util.stopConsoleCapture();
   	   if(!consoleOutput1.isEmpty()) {
   		   
              String formattedOutput = formatConsoleOutputToTable(consoleOutput1);

              ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>"+ formattedOutput + "</font>");

   		   log.info("Console Output: " + formattedOutput);
   	   }
   	   
        Util.clearConsoleOutput();
        
    }
    
    @Given("User is on the Edit Avatar form page")
    public void user_is_on_the_edit_avatar_form_page() {
        avatar.updateAvatar();
    }

    @When("clicks on the avatar update button")
    public void clicks_on_the_avatar_update_button() {
    	
    }
    

    @Then("avatar update success message {string} should be displayed")
    public void avatar_update_success_message_should_be_displayed(String exp) throws InterruptedException {
        
    	avatar.upadateAvatarBtn();
		Thread.sleep(2000);
	    String test = avatar.updateAvatarSuccessMsg();
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

    
    @Given("clicks on the Preview button")
    public void clicks_on_the_preview_button() {
    	Util.startConsoleCapture();
        avatar.clickPreviewImageBtn();
    }

    @Then("the image preview should open in a new browser tab")
    public void the_image_preview_should_open_in_a_new_browser_tab() throws InterruptedException {
         
      String originalWindow = driver.getWindowHandle();

      // Switch to the new window
      Set<String> windowHandles = driver.getWindowHandles();
      for (String window : windowHandles) {
          if (!window.equals(originalWindow)) {
              driver.switchTo().window(window);
              break;
          }
      }

      // Get the URL of the new window
      newWindowUrl = driver.getCurrentUrl();
      System.out.println("URL of the new window: " + newWindowUrl);

         // Verify the preview image is displayed
         
    }
    
    @Then("the preview image URL should be correct")
    public void the_preview_image_url_should_be_correct() {

        String originalWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        String newWindowUrl = "";

        for (String window : windowHandles) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                newWindowUrl = driver.getCurrentUrl(); // Store the dynamic URL
                break;
            }
        }

        // Switch back to original window
        driver.switchTo().window(originalWindow);

        // Compare the dynamic value with the expected value
        String expectedUrl = "https://gammingle-admin-file-s3.s3.amazonaws.com/avatar/c066328d-b86e-466e-b5cc-908d89cc832c.jpeg\r\n";
        if (newWindowUrl.equals(expectedUrl)) {
            System.out.println("URL matches the expected URL!");
        } else {
            System.out.println("URL does not match. Expected: " + expectedUrl + ", Found: " + newWindowUrl);
        }
    }


  

    @Then("the user should return to the Edit Avatar page")
    public void the_user_should_return_to_the_edit_avatar_page() {
    	 driver.switchTo().window(driver.getWindowHandles().iterator().next());

         
         // Verify that the user is back on the Edit Avatar page (e.g., by checking the page title)
         assertTrue(driver.getTitle().contains("Admin"));
    }


    @Given("user clicks on the Filter Avatar button")
    public void user_clicks_on_the_filter_avatar_button() {
        avatar.filterAvatar();
    }

    @When("user clicks on the filter dropdown button and select Inactive status")
    public void user_clicks_on_the_filter_dropdown_button_and_select_inactive_status() throws InterruptedException {
        avatar.selectDropdownOption();
        Thread.sleep(3000);
    }

    @Then("user clicks on the View Avatar button")
    public void user_clicks_on_the_view_avatar_button() throws InterruptedException {
       avatar.viewAvatar();
       Thread.sleep(3000);
    }

    @Then("the status from the viewed data is verified as Inactive")
    public void the_status_from_the_viewed_data_is_verified_as_inactive() {
    	String expectedOptionText2 = "In-Active";
    	String expectedOptionText = expectedOptionText2.trim();
    	String actualOptionText = avatar.inactiveStatus();
        if (actualOptionText.equals(expectedOptionText)) {
           System.out.println("In-Active Status");
           log.info("In-Active Status");
        } else {
            System.out.println("test fail");
            log.info("Active Status");
        }
    }


    



}
