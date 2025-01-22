package stepDefinitions.FAQ;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import Base.DriverManager;
import Pages.FAQ.FAQPage;
import Utility.LoggerHelper;
import Utility.Util;
import io.cucumber.java.en.*;

public class FAQSteps extends DriverManager {
	
	private WebDriver driver;
    FAQPage faq;
    private static Logger log = LoggerHelper.getLogger(FAQSteps.class); 
    
    public FAQSteps() {
        this.driver = Util.webDriver.get(); // Retrieve WebDriver from Util
        faq = new FAQPage(); // Initialize UserManagementPage             
    }

    @Given("User navigate to the FAQ Module")
    public void user_navigate_to_the_faq_module() {
    	Util.startConsoleCapture();
    	WebElement leftSection = driver.findElement(By.xpath("//div[@class=\"ps__thumb-y\"]"));
		leftSection.click();
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(leftSection, 0, 300).perform(); // Scroll down one step in the left section

        faq.clickFAQ();
    }

    @Given("User is on the Add FAQ")
    public void user_is_on_the_add_faq() {
       faq.clickAddFAQ();
    }

    @When("User select the sequence of FAQ")
    public void user_select_the_sequence_of_faq() {
       faq.enterSequence();
    }

    @When("User clicks English lang FAQ")
    public void user_clicks_english_lang_faq() {
        faq.clickEnglish();
        log.info("english");
    }

    @Then("User fill the Question and answer in FAQ in English")
    public void user_fill_the_question_and_answer_in_faq_in_english() {
       faq.enterQandAEng();
    }

    @Then("User fill the Question and answer in FAQ in Hindi")
    public void user_fill_the_question_and_answer_in_faq_in_hindi() {
       faq.enterQandAHi();
    }


    @Then("User clicks Hindi lang FAQ")
    public void user_clicks_hindi_lang_faq() {
        faq.clickHindi();
      
    }
    
    @Then("User click on Submit FAQ button")
    public void user_click_on_submit_faq_button() {
    	 
    }

    @Then("User should see a success message {string} in FAQ")
    public void user_should_see_a_success_message_in_faq(String exp) {
    	 faq.submitFAQ();
	    
	    String test = faq.getFAQSuccessMsg();
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
    
    @Then("User should see a Error message {string} in FAQ")
    public void user_should_see_a_error_message_in_faq(String exp) {
    	 faq.submitFAQ();
 	    
 	    String test = faq.getFAQDuplicateDataMsg();
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

    
    @When("User clicks the Add FAQ Submit button without filling data")
    public void user_clicks_the_add_faq_submit_button_without_filling_data() {
    	faq.submitFAQ();
    }

    @Then("add FAQ sequence field border color should be RED")
    public void add_faq_sequence_field_border_color_should_be_red() {
    	Util.startConsoleCapture();
    	faq.submitFAQ();
	    
	    Util.startConsoleCapture();
    	try {
            // Fetch the border color using the method from the Page Object class
            String borderColor = faq.SequenceFAQColor();
            System.out.println("Border Color: " + borderColor);


            // Start capturing console output (assuming Util.startConsoleCapture() exists)
            String Output = Util.stopConsoleCapture();

            log.info("Success: Console Output is as expected: " + Output);

            // Verify the border color matches the expected value for red
            if (borderColor.equals("rgb(245, 82, 82)")) { // CSS border colors are in RGB format
                System.out.println("Test Passed:Sequence border color changed to red.");
                ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>Console Output is as expected: " + Output + "</font>");
            } else {
                System.out.println("Test Failed:Sequence border color did not change as expected.");
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
    
    @When("User clicks the Add FAQ Cancel  button")
    public void user_clicks_the_add_faq_cancel_button() {
       
    }


   
    @Then("User should be FAQ listing page")
    public void user_should_be_faq_listing_page() throws InterruptedException {
    	 faq.cancelFAQ();
    	 Thread.sleep(5000);
    	 String test = faq.getFAQListing();
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

    
    @When("User click on View FAQ button")
    public void user_click_on_view_faq_button() throws InterruptedException {
        Util.startConsoleCapture();
        faq.clickViewFAQ();
        Thread.sleep(5000);
    }

    @Then("User should able to see the FAQ details")
    public void user_should_able_to_see_the_faq_details() {
    	String test = faq.getFAQListing();
        System.out.println(test);
        
        String consoleOutput1 = Util.stopConsoleCapture();
   	   if(!consoleOutput1.isEmpty()) {
   		   
              String formattedOutput = formatConsoleOutputToTable(consoleOutput1);

              ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>"+ formattedOutput + "</font>");

   		   log.info("Console Output: " + formattedOutput);
   	   }
   	   
        Util.clearConsoleOutput();
    }

    @Given("User is on the Edit FAQ form page")
    public void user_is_on_the_edit_faq_form_page() {
        Util.startConsoleCapture();
        faq.updateFAQ();
    }

    @When("User update FAQ sequence")
    public void user_update_faq_sequence() {
        faq.updatesequence();
    }

    @When("clicks on the FAQ update button")
    public void clicks_on_the_faq_update_button() {
        
    }

    @Then("FAQ update success message {string} should be displayed")
    public void faq_update_success_message_should_be_displayed(String exp) {
    	 faq.submitFAQ();
  	    
  	    String test = faq.updateFAQSuccessMsg();
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



    @Given("User click on FAQ Filter button")
    public void user_click_on_faq_filter_button() {
        Util.startConsoleCapture();
        faq.clickFilterFAQ();
    }

    @When("User enter Question on Filter Question FAQ")
    public void user_enter_question_on_filter_question_faq() {
       faq.filterFAQQues();
    }

    @When("User select FAQ Filter Status In-active")
    public void user_select_faq_filter_status_in_active() throws InterruptedException {
        faq.selectInactiveDropdownOption();
        Thread.sleep(3000);
    }

    @Then("User should able to see filtered listing of FAQ")
    public void user_should_able_to_see_filtered_listing_of_faq() {
    	String test = faq.getFAQListing();
        System.out.println(test);
        
        String consoleOutput1 = Util.stopConsoleCapture();
   	   if(!consoleOutput1.isEmpty()) {
   		   
              String formattedOutput = formatConsoleOutputToTable(consoleOutput1);

              ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>"+ formattedOutput + "</font>");

   		   log.info("Console Output: " + formattedOutput);
   	   }
   	   
        Util.clearConsoleOutput();
    }


}
