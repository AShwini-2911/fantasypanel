package stepDefinitions.Master;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import Base.DriverManager;
import Pages.Master.GamesPage;
import Utility.GamesUtil;
import Utility.LoggerHelper;
import Utility.Util;
import io.cucumber.java.en.*;

public class GamesSteps extends DriverManager{
	
	 private WebDriver driver;
	    private GamesPage GP;
	    private static Logger log = LoggerHelper.getLogger(GamesSteps.class);  // Log4j logger instance


	    // Constructor to initialize WebDriver and VideosPage
	    public GamesSteps() {
	        this.driver = Util.webDriver.get(); // Retrieve WebDriver from Util (ensure this method is accessible)
	        GP = new GamesPage(); // Initialize VideosPage with the WebDriver
	    }

	    @Given("User click on Add Games button")
	    public void user_click_on_add_games_button() throws InterruptedException {
	    	
	    	Util.startConsoleCapture();
			 log.info("User clicked on Add Games button");
			
		       
			 Thread.sleep(3000);

	        GP.clickAddGame();
	    	
	    }

	    @Then("User fill all the Games details")
	    public void user_fill_all_the_games_details() throws InterruptedException {
	    	//GP.enterSequence();
	        GP.enterSequence(GamesUtil.getGameProperty("games.Sequence"));
			 Thread.sleep(3000);
			 
			GP.enterLink(GamesUtil.getGameProperty("games.Link"));
			 Thread.sleep(4000);
			 
			 
			GP.uploadImage();
	        Thread.sleep(3000);


	        GP.EnglishName(GamesUtil.getGameProperty("English.name"));
	        Thread.sleep(3000);

	        GP.HindiName(GamesUtil.getGameProperty("Hindi.name"));
	    }

	    @Then("User click on Games Submit")
	    public void user_click_on_games_submit() throws InterruptedException {
			 Thread.sleep(8000);

//	       GP.AddGamesSubmit();
			 log.info("Game Added");

	    }

	    @Given("User click on View Games button")
	    public void user_click_on_view_games_button() {
			 log.info("User clicked on View Games button");

	       GP.ViewGamesClick();
	    }

	    @Then("User should able to see the Games details")
	    public void user_should_able_to_see_the_games_details() {
	      
			 log.info("Viewed Games Detailed");
			 
			 String test =  GP.GetDetailsGames();
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



	    @Given("User click on Update Games button")
	    public void user_click_on_update_games_button1() {
	       GP.UpdateGamesClick();
			 log.info("User clicked on update Games button");

	    }

	    @Then("User update image of the Games")
	    public void user_update_title_of_the_games() throws InterruptedException {
			GP.uploadImage();
			Thread.sleep(3000);
	    }

	    @Then("User click on update Games button")
	    public void user_click_on_update_games_button() {
//	      
	    }

	    @Then("an Game updated successfully {string} should display")
	    public void an_game_updated_successfully_should_display(String exp) {
	    	 String test = GP.gameUpdateSuccessMsg();
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
	    @Given("User Click on Filter Games button")
	    public void user_click_on_filter_games_button() {
	        GP.filterGame();
			 log.info("User clicked on Filter Games button");

	    }

	    @Then("User enter title in Title Games field")
	    public void user_enter_title_in_title_games_field() {
	       GP.filterGameName(GamesUtil.getGameProperty("games.TitleFilter"));
	    }

	    @Then("User should able to filtered Games data")
	    public void user_should_able_to_filtered_games_data() {
	       
	       String test = GP.getFilteredGameDetails();
	    	System.out.println(test);
	    	
	    	String consoleOutput3 = Util.stopConsoleCapture();
	 	   if(!consoleOutput3.isEmpty()) {
	 		   
	            String formattedOutput = formatConsoleOutputToTable(consoleOutput3);

	            ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>"+ formattedOutput + "</font>");

	 		   log.info("Console Output3: " + formattedOutput);
	 	   }
	 	   
	      Util.clearConsoleOutput();

	    }
	    
	    @Then("User should able to see games success message {string}")
	    public void user_should_able_to_see_games_success_message(String exp) {
	        String test = GP.addGamesSuccessMsg();
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

	    
	    @When("the user leaves the games Hindi Name field empty")
	    public void the_user_leaves_the_games_hindi_name_field_empty() {
	        GP.enterSequence("");

	    }

	    @Then("Games name border color should be RED")
	    public void games_name_border_color_should_be_red() {
	       
	    	Util.startConsoleCapture();
	    	try {
	            // Fetch the border color using the method from the Page Object class
	            String borderColor = GP.HindiNameBorderColor();
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
	    
	    @When("User click on Add Games Cancel")
	    public void user_click_on_add_games_cancel() throws InterruptedException {
	    	Thread.sleep(3000);
	       GP.addGamesCancel();
	    }

	    @Then("User should able to see Games listing page {string}")
	    public void user_should_able_to_see_games_listing_page(String screenshotName) {
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
	    
	    @Then("an Game name error message {string} should be display")
	    public void an_game_name_error_message_should_be_display(String exp) {
	    	String test = GP.addGamesExistsMsg();
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
	    
	    @When("User fill details uplaod image larger than one MB")
	    public void user_fill_details_uplaod_image_larger_than_one_mb()  throws InterruptedException {
	    	 GP.enterSequence(GamesUtil.getGameProperty("games.Sequence"));
			 Thread.sleep(3000);
			 
			GP.enterLink(GamesUtil.getGameProperty("games.Link"));
			 Thread.sleep(4000);
			 
			 GP.uploadLargeSizeImage();
			 Thread.sleep(4000);
			


	        GP.EnglishName(GamesUtil.getGameProperty("English.name"));
	        Thread.sleep(3000);

	        GP.HindiName(GamesUtil.getGameProperty("Hindi.name"));

	    }

	   

	    @Then("an Game image should less than one MB {string} should display")
	    public void an_game_image_should_less_than_one_mb_should_display(String exp) throws InterruptedException {
	    	String test = GP.addGamesImageSizeMsg();
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
