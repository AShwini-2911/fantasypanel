package stepDefinitions.Master;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import Base.DriverManager;
import Pages.Master.MarketingCategoryPage;
import Utility.LoggerHelper;
import Utility.Util;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import stepDefinitions.Staff.ManageStaffSteps;

public class MarketingCategorySteps extends DriverManager {
	
	MarketingCategoryPage MCP= new MarketingCategoryPage();
    private static Logger log = LoggerHelper.getLogger(ManageStaffSteps.class);


	WebDriver driver;
	public MarketingCategorySteps() {
		PageFactory.initElements(webDriver.get(), this);
	}
	
	@Given("I click on Add MarketingCategory button")
	public void i_click_on_add_marketing_category_button() throws InterruptedException {
		Thread.sleep(3000);;
	    MCP.Add_Marketing_Category();
	}

	@Then("fill all the details")
	public void fill_all_the_details() throws InterruptedException {
		Thread.sleep(5000);;

	  MCP.Category_Name();
	}
	
	@Then("click on Submit button")
	public void click_on_submit() {
	    MCP.Category_Submit();
	    
	}

	@When("I click on a MarketingCategory titled {string}")
	public void i_click_on_a_marketing_category_titled(String string) {
	    MCP.View_Marketing_Category();
	}

	@Then("I should see the details of the category")
	public void i_should_see_the_details_of_the_category() {
		
		 String test = MCP.Get_Detials_ofViewCategory();
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


	@Given("I am on the MarketingCategory Details page for {string}")
	public void i_am_on_the_marketing_category_details_page_for(String string) {
		MCP.Update_MArketing_Category();
	}

	@When("I update the MarketingCategory name to {string}")
	public void i_update_the_marketing_category_name_to(String string) {
	    MCP.Update_Name_Marketing();
	}

	@When("I click the save button")
	public void i_click_the_save_button() {
	   MCP.Update_Btn();
	}

//	@When("I toggle the active status")
//	public void i_toggle_the_active_status() {
//	   
//	}
//
//	@Then("the MarketingCategory status should be updated")
//	public void the_marketing_category_status_should_be_updated() {
//	   
//	}

	@Given("I click on Filter")
	public void i_click_on_filter() {
	   MCP.click_Filter();
	}

	@Then("Enter name as {string}")
	public void enter_name_as(String string) throws InterruptedException {
	   MCP.Filter_Name();
	   Util.addScreenshotToReport("Filtered details page");
	}

	@Then("Click on Clear search")
	public void click_on_clear_search() {
	   MCP.Marketing_Clear_Search();
	}
	
	@When("the user leaves the Name field empty")
	public void ther_user_leaves_the_name_field_empty()	{
		
		MCP.blank_CN();
	}

	@Then("Marketing Category name border color should be RED")
	public void marketing_category_name_border_color_should_be_red() {
		Util.startConsoleCapture();
    	try {
            // Fetch the border color using the method from the Page Object class
            String borderColor = MCP.MarketingNameBorderColor();
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
	
	@And("User clicks on Marketing Category Cancel button")
	public void user_clicks_on_thecancel_button() {
		MCP.cancelMarketingCategory();
	}
	
	@Then("User should able to see category listing page {string}")
	public void user_should_able_to_see_category_listing_page(String screenshotName) {
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
	
	@And("User clicks on Marketing Category Back button")
	public void user_clicks_on_marketing_category_back_button() {
		MCP.backMarketingCategory();
	}
	
	@When("the user enters already an existing Marketing category")
	public void the_user_enter_already_an_existing_marketing_category() {
		MCP.Category_Name();
	}
	@Then("User should able to see marketing category success message {string}")
	public void success_Category_message(String exp) throws InterruptedException {
		String test = MCP.MarketingSuccessMessage();
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
	@Then("an category error message {string} should be display")
	public void an_category_error_message_should_be_display(String exp) {
		String test = MCP.marketingCategoryExistMsg();
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
	
	@Then("an category update message {string} should be display")
	public void update_category_message(String exp) throws InterruptedException {
		
		String test = MCP.MarketingUpdateMessage();
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
	
	
	

}
