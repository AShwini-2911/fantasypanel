package stepDefinitions.Staff;

import static org.junit.Assert.*;

//import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertFalse;
//import static org.testng.Assert.assertNotNull;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import Base.DriverManager;
import Pages.Staff.ManageStaffPage;
import Utility.LoggerHelper;
import Utility.Util;
import io.cucumber.java.en.*;

public class ManageStaffSteps extends DriverManager {
	
	private WebDriver driver;
    ManageStaffPage manageStaff;
    private static Logger log = LoggerHelper.getLogger(ManageStaffSteps.class);
    String regex;



    // Constructor to initialize WebDriver and UserManagementPage
    public ManageStaffSteps() {
        this.driver = Util.webDriver.get(); // Retrieve WebDriver from Util
        manageStaff	= new ManageStaffPage(); // Initialize UserManagementPage
        
        
    }
    
    @When("User click on View Staff button")
    public void user_click_on_view_staff_button() throws InterruptedException {
    	Util.startConsoleCapture();
        manageStaff.clickViewStaff();
        log.info("Navigated to Manage Staff view module");

    }

    @Then("User should able to see the Staff details")
    public void user_should_able_to_see_the_staff_details() {
     String test = manageStaff.captureStaffDetails();
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
    
    @Given("User click on Update Staff button")
    public void user_click_on_update_staff_button() throws InterruptedException {
    	Util.startConsoleCapture();
        manageStaff.clickUpdateStaff();
        log.info("Navigated to Manage Staff update module");

    }

    @When("User update staff first and last name")
    public void user_update_staff_first_and_last_name() {
        manageStaff.name();
    }

    @When("User Click on submit button")
    public void user_click_on_submit_button() {
        manageStaff.updateStaffBtn();
    }

    @Then("User should able to print {string} message")
    public void user_should_able_to_print_the_message(String expectedMessage) {
    	String test = manageStaff.updateSuccessMsg();
    	System.out.println(test);
        // Capture the console output
        String consoleOutput = Util.stopConsoleCapture(); // Replace with your actual console capture method
        
        expectedMessage = expectedMessage.trim();
        consoleOutput = consoleOutput.trim();

        // Compare the captured console output with the expected message
        if (consoleOutput.equals(expectedMessage)) {
            // If they match, log success
            ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>Console Output is as expected: " + consoleOutput + "</font>");
            log.info("Success: Console Output is as expected: " + consoleOutput);
        } else {
            // If they don't match, log failure and print the expected vs actual output
            ExtentCucumberAdapter.getCurrentStep().fail("<font color='green' style='background-color:white;'>Console Output does not match the expected message.\n" +
                                                        "Expected: " + expectedMessage + "\n" +
                                                        "Actual: " + consoleOutput + "</font>");
            log.error("<font color='green' style='background-color:white;'>Error: Console Output does not match the expected message.\n" +
                      "Expected: " + expectedMessage + "\n" +
                      "Actual: " + consoleOutput + "</font>");
            // Optionally, fail the test if the message doesn't match
            Assert.fail("<font color='green' style='background-color:white;'>Console Output does not match the expected message. </font>");
        }
        Util.clearConsoleOutput();
        }

    @When("User click on Filter button")
    public void user_click_on_filter_button() {
    	Util.startConsoleCapture();
        manageStaff.filterStaff();
        
    }

    @When("User search for updated user name")
    public void user_search_for_updated_user_name() throws InterruptedException {
      
    	manageStaff.filterFirstNameStaff();
    	Thread.sleep(3000);
    	manageStaff.selectRoleByIndex(10);
    	Thread.sleep(8000);
    }

    @Then("User should able to see user name in filtered data")
    public void user_should_able_to_see_user_name_in_filtered_data() {
       
    	String test = manageStaff.captureStaffFilterDetails();
    	System.out.println(test);
    	
    	String consoleOutput3 = Util.stopConsoleCapture();
 	   if(!consoleOutput3.isEmpty()) {
 		   
            String formattedOutput = formatConsoleOutputToTable(consoleOutput3);

            ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>"+ formattedOutput + "</font>");

 		   log.info("Console Output3: " + formattedOutput);
 	   }
 	   
      Util.clearConsoleOutput();
    	
    }


    @When("User click on Cancel button")
    public void user_click_on_cancel_button() throws InterruptedException {
        manageStaff.cancelStaffBtn();
        Thread.sleep(2000);
    }

    @Then("User should able to see staff listing page {string}")
    public void user_should_able_to_see_staff_listing_page(String screenshotName) {
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
    

    @Then("User search for invalid updated user name")
    public void user_search_for_invalid_updated_user_name() throws InterruptedException {
    	Util.startConsoleCapture();

		   log.info("user search for Teste name");

       manageStaff.filterStaff();
       manageStaff.searchInvalidUserName();
       Thread.sleep(5000);
    }

    @Then("User should not get filtered data")
    public void user_should_not_get_filtered_data() {
		   log.info("No matching records");

        
    	String test2 = manageStaff.getNoData();
        System.out.println(test2);
        
        String consoleOutput2 = Util.stopConsoleCapture();
   	   if(!consoleOutput2.isEmpty()) {
   		   

              ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>"+ consoleOutput2 + "</font>");

   		   log.info("\n" +"Console Output: " + consoleOutput2);
   	   }
   	   
        Util.clearConsoleOutput();
    }

    @Given("User click on change password button")
    public void user_click_on_change_password_button() {
        manageStaff.clickChangePassword();
    }

    @When("User Enter valid new passwod {string}")
    public void user_enter_valid_new_passwod(String newPassword) {
        manageStaff.enterNewPassword(newPassword);
    }

    @When("User Enter valid Confirm password {string}")
    public void user_enter_valid_confirm_password(String confirmPassword) {
       manageStaff.enterConfirmPassword(confirmPassword);
    }

    @Then("User click on Update button")
    public void user_click_on_update_button() throws InterruptedException {
//    	String TEST = manageStaff.mismatchMessage();
//    	System.out.println(TEST);
//    	
//    	 String consoleOutput2 = Util.stopConsoleCapture();
//     	   if(!consoleOutput2.isEmpty()) {
//     		   
//
//                ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>"+ consoleOutput2 + "</font>");
//
//     		   log.info("\n" +"Console Output: " + consoleOutput2);
//     	   }
//     	   
//          Util.clearConsoleOutput();
    	
        
    }

    @Then("User should able to see updated reset password {string} message")
    public void user_should_able_to_see_updated_reset_password_message(String expectedMsg ) throws InterruptedException {
    	String test = manageStaff.resetPasswordBtn();
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
                      "Actual: " + consoleOutput + "</font>");
            // Optionally, fail the test if the message doesn't match
            Assert.fail("<font color='green' style='background-color:white;'>Console Output does not match the expected message. </font>");
        }
        Util.clearConsoleOutput();
    }

    @Then("User should able to mismatch password {string} message")
    public void user_should_able_to_mismatch_password_message(String expected) throws InterruptedException {
        
    	String test = manageStaff.mismatchMessage();
    	System.out.println(test);
        // Capture the console output
        String consoleOutput = Util.stopConsoleCapture(); // Replace with your actual console capture method
        
        expected = expected.trim();
        consoleOutput = consoleOutput.trim();

        // Compare the captured console output with the expected message
        if (consoleOutput.equals(expected)) {
            // If they match, log success
            ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>Console Output is as expected: " + consoleOutput + "</font>");
            log.info("Success: Console Output is as expected: " + consoleOutput);
        } else {
            // If they don't match, log failure and print the expected vs actual output
            ExtentCucumberAdapter.getCurrentStep().fail("<font color='green' style='background-color:white;'>Console Output does not match the expected message.\n" +
                                                        "Expected: " + expected + "\n" +
                                                        "Actual: " + consoleOutput + "</font>");
            log.error("<font color='green' style='background-color:white;'>Error: Console Output does not match the expected message.\n" +
                      "Expected: " + expected + "\n" +
                      "Actual: " + consoleOutput + "</font>");
            // Optionally, fail the test if the message doesn't match
            Assert.fail("<font color='green' style='background-color:white;'>Console Output does not match the expected message. </font>");
        }
        Util.clearConsoleOutput();
    }
    
    @Then("The Confirm Password field border color should be RED")
    public void the_confirm_password_field_border_color_should_be_red() {
		Util.startConsoleCapture();
    	try {
            // Fetch the border color using the method from the Page Object class
            String borderColor = manageStaff.getConfirmPasswordBorderColor();
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
    
    @Then("User click on back button")
    public void user_click_on_back_button() throws InterruptedException {
        Thread.sleep(3000);
        manageStaff.backButton();
    }


    @Then("User should able to see weak password {string} message")
    public void user_should_able_to_see_weak_password_message(String exp) throws InterruptedException {
    	String test = manageStaff.weakPassMessage();
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
    
    @Given("User navigates to the Add Staff User page")
    public void user_navigates_to_the_add_staff_user_page() throws InterruptedException {
        manageStaff.clickAddStaff();
        Thread.sleep(3000);
        
    }

    @When("User selects a role as {string}")
    public void user_selects_a_role_as(String string) throws InterruptedException {
       manageStaff.selectRoleByVisibleText(string);
    }

    @When("User enters {string} in the First Name field")
    public void user_enters_in_the_first_name_field(String string) {
        manageStaff.firstName(string);
    }

    @When("User enters {string} in the Last Name field")
    public void user_enters_in_the_last_name_field(String string) {
        manageStaff.lastName(string);
    }

    @When("User enters {string} in the Email ID field")
    public void user_enters_in_the_email_id_field(String string) {
        manageStaff.email(string);
    }

    @When("User enters {string} in the Phone field")
    public void user_enters_in_the_phone_field(String string) {
        manageStaff.phone(string);
    }

    @When("User enters {string} in the Password field")
    public void user_enters_in_the_password_field(String string) {
        manageStaff.password(string);
    }

    @When("User clicks on the Submit button")
    public void user_clicks_on_the_submit_button() {
       // manageStaff.submitStaff();
    }

    @Then("User should able to see {string} message")
    public void user_should_able_to_see_message(String expt) throws InterruptedException {
    	String test =  manageStaff.addStaffMsg();
       
    	System.out.println(test);
       // Capture the console output
       String consoleOutput = Util.stopConsoleCapture(); // Replace with your actual console capture method
       
       expt = expt.trim();
       consoleOutput = consoleOutput.trim();

       // Compare the captured console output with the expected message
       if (consoleOutput.equals(expt)) {
           // If they match, log success
           ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>Console Output is as expected: " + consoleOutput + "</font>");
           log.info("Success: Console Output is as expected: " + consoleOutput);
       } else {
           // If they don't match, log failure and print the expected vs actual output
           ExtentCucumberAdapter.getCurrentStep().fail("<font color='green' style='background-color:white;'>Console Output does not match the expected message.\n" +
                                                       "Expected: " + expt + "\n" +
                                                       "Actual: " + consoleOutput + "</font>");
           log.error("<font color='green' style='background-color:white;'>Error: Console Output does not match the expected message.\n" +
                     "Expected: " + expt + "\n" +
                     "Actual: " + consoleOutput + "</font>");
           // Optionally, fail the test if the message doesn't match
           Assert.fail("<font color='green' style='background-color:white;'>Console Output does not match the expected message. </font>");
       }
       Util.clearConsoleOutput();

    }
    
    @When("User clicks on the Submit button without filling any fields")
    public void user_clicks_on_the_submit_button_without_filling_any_fields() {
       
    }

    @Then("The First Name field border color should be RED")
    public void the_first_name_field_border_color_should_be_red() {
    	Util.startConsoleCapture();
    	try {
            // Fetch the border color using the method from the Page Object class
            String borderColor = manageStaff.getFirstNameBorderColor();
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

    @Then("The Email field border color should be RED")
    public void the_email_field_border_color_should_be_red() {
    	Util.startConsoleCapture();
    	try {
            // Fetch the border color using the method from the Page Object class
            String borderColor = manageStaff.getEmailColor();
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

    @Then("The Password field should mask the input")
    public void the_password_field_should_mask_the_input() {
    	 String fieldType = manageStaff.passwordFieldType();
         Assert.assertEquals(fieldType, "Password field is not masked.", "Password field is not masked.");
         log.info(fieldType);
    }

    @When("User clicks on the toggle visibility icon")
    public void user_clicks_on_the_toggle_visibility_icon() throws InterruptedException {
        manageStaff.clickPassEye();
        Thread.sleep(5000);
    }

    @Then("The Password field should display the input")
    public void the_password_field_should_display_the_input() {
    	 String fieldType = manageStaff.passwordFieldType();
         Assert.assertEquals(fieldType, "text", "Password field is not displaying input.");
         log.info(fieldType);
    }


    @When("User fills in the form with valid details")
    public void user_fills_in_the_form_with_valid_details() throws InterruptedException {
       manageStaff.selectRoleByVisibleText("data");
       manageStaff.firstName("Arjun");
       manageStaff.lastName("Soni");
       manageStaff.email("arjun@soni.com");
       manageStaff.phone("7538964120");
       manageStaff.password("Arjun@12345");
    }

    @When("User clicks on the Cancel button")
    public void user_clicks_on_the_cancel_button() {
        manageStaff.cancelStaffBtn();
    }
    
    @When("User enters an existing phone {string} in the phone number field")
    public void user_enters_an_existing_phone_in_the_phone_number_field(String string) {
        manageStaff.email("arjun@soni.com");

    }

    @When("User fills other valid details")
    public void user_fills_other_valid_details() throws InterruptedException {
    	 manageStaff.selectRoleByVisibleText("data");
         manageStaff.firstName("Arjun");
         manageStaff.lastName("Soni");
         manageStaff.phone("7538964120");
         manageStaff.password("Arjun@12345");
    }

    @Then("An error message should be displayed indicating {string}")
    public void an_error_message_should_be_displayed_indicating(String expte) throws InterruptedException {
    	String test =  manageStaff.mobileNumExistMsg();
        
    	System.out.println(test);
       // Capture the console output
       String consoleOutput = Util.stopConsoleCapture(); // Replace with your actual console capture method
       
       expte = expte.trim();
       consoleOutput = consoleOutput.trim();

       // Compare the captured console output with the expected message
       if (consoleOutput.equals(expte)) {
           // If they match, log success
           ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>Console Output is as expected: " + consoleOutput + "</font>");
           log.info("Success: Console Output is as expected: " + consoleOutput);
       } else {
           // If they don't match, log failure and print the expected vs actual output
           ExtentCucumberAdapter.getCurrentStep().fail("<font color='green' style='background-color:white;'>Console Output does not match the expected message.\n" +
                                                       "Expected: " + expte + "\n" +
                                                       "Actual: " + consoleOutput + "</font>");
           log.error("<font color='green' style='background-color:white;'>Error: Console Output does not match the expected message.\n" +
                     "Expected: " + expte + "\n" +
                     "Actual: " + consoleOutput + "</font>");
           // Optionally, fail the test if the message doesn't match
           Assert.fail("<font color='green' style='background-color:white;'>Console Output does not match the expected message. </font>");
       }
       Util.clearConsoleOutput();

    }
    
    @When("User clicks on the Back button")
    public void user_clicks_on_the_back_button() {
        manageStaff.backButton();
    }


    @When("User fills other valid details without selecting Role")
    public void user_fills_other_valid_details_without_selecting_role() {
        manageStaff.firstName("Ash");
        manageStaff.lastName("R");
        manageStaff.email("ashu@eer.com");
        manageStaff.phone("4545451212");
        manageStaff.password("Ashu@12346");
    }
    
    @Then("An error message should be displayed {string} on the Role field")
    public void an_error_message_should_be_displayed_on_the_role_field(String output) throws InterruptedException {
        
    	String test =  manageStaff.roleMsg();
        
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
    
    @When("the user enter {string} in the {string} field")
    public void the_user_enter_in_the_field(String input, String field) {
        manageStaff.enterFirstName(input);
       
    }

    @Then("the actual value displayed in the {string} field should be {string}")
    public void the_actual_value_displayed_in_the_field_should_be(String field, String expectedVal) {
    	String actualValue = manageStaff.getFirstName();
        System.out.println("Actual Value: " + actualValue); // For debugging
        System.out.println("Expected Value: " + expectedVal); // For debugging
        Assert.assertEquals(expectedVal, actualValue);
        
    }

    @Then("the expected value should match the actual value")
    public void the_expected_value_should_match_the_actual_value() {
    	
    	 String input = "Abhi@123"; // Sample input with special characters
         String sanitizedExpectedValue = "Abhi"; // Expected value after sanitization

         String actualValue = manageStaff.getFirstName();
        

         // Print sanitized expected value and actual value for verification
         System.out.println("Sanitized Input Value (Expected): " + sanitizedExpectedValue +"\n");
         System.out.println("Actual Value after input: " + actualValue);
         

         Assert.assertEquals(sanitizedExpectedValue, actualValue);
         String consoleOutput = Util.stopConsoleCapture(); // Replace with your actual console capture method

         ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>Console Output is as expected: " + consoleOutput + "</font>");
        

    }

    
    
    
    
    @When("the user checks the regex for the Password field")
    public void the_user_checks_the_regex_for_the_password_field() {
       
    }

    @Then("the regex for the Password field should be {string}")
    public void the_regex_for_the_password_field_should_be(String expectedRegex) {
//    	String actualRegex = manageStaff.getPasswordFieldRegex();
//        assertEquals("Password field regex does not match", expectedRegex, actualRegex);
    }

    


}
