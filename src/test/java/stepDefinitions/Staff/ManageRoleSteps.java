package stepDefinitions.Staff;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import Base.DriverManager;
import Pages.Staff.ManageRolePage;
import Utility.LoggerHelper;
import Utility.Util;
import io.cucumber.java.en.*;

public class ManageRoleSteps extends DriverManager {
	
	private WebDriver driver;
    ManageRolePage rolePage;
    private static Logger log = LoggerHelper.getLogger(ManageRoleSteps.class);




    // Constructor to initialize WebDriver and UserManagementPage
    public ManageRoleSteps() {
        this.driver = Util.webDriver.get(); // Retrieve WebDriver from Util
        rolePage= new ManageRolePage(); // Initialize UserManagementPage
        
        
    }
	
	@Given("User navigates to the Add Role page")
	public void user_navigates_to_the_add_role_page() {
	    rolePage.addRole();
	}

	@When("User add Role name in Staff")
	public void user_add_role_name_in_staff() {
	    rolePage.roleName();
	}

	@When("User add Role description in Staff")
	public void user_add_role_description_in_staff() throws InterruptedException {
	   rolePage.roleDescription();
	   Thread.sleep(2000);
	}

	@Then("User Select the Role permission toggles")
	public void user_select_the_role_permission_toggles() throws InterruptedException {
		Thread.sleep(2000);
	    rolePage.rolePermission();
	}

	@Then("User click on Add Role submit button")
	public void user_click_on_add_role_submit_button() {
	    
	}

	@Then("User should able to see Role added message {string}")
	public void user_should_able_to_see_role_added_message(String expectedMessage) throws InterruptedException {
		rolePage.addRoleSubmit();
		Thread.sleep(2000);
		String test = rolePage.addRoleSuccessMsg();
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

	@Then("User should able to see duplicate Role added message {string}")
	public void user_should_able_to_see_duplicate_role_added_message(String expectedMessage) throws InterruptedException {
		rolePage.addRoleSubmit();
		Thread.sleep(2000);
		String test = rolePage.duplicateStaffRoleErrorMsg();
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
	

	@When("User clicks on the Submit button without filling role name and description")
	public void user_clicks_on_the_submit_button_without_filling_role_name_and_description() {
	   
	}

	@Then("Add Role error message should display {string}")
	public void add_role_error_message_should_display(String expectedMessage) throws InterruptedException {
		rolePage.addRoleSubmit();
		Thread.sleep(2000);
		String test = rolePage.addRoleErrorMsg();
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
	
	@When("User clicks on the Submit button without selecting permission toogle")
	public void user_clicks_on_the_submit_button_without_selecting_permission_toogle() {
	    
	}

	@Then("Add Role permission error message should display {string}")
	public void add_role_permission_error_message_should_display(String expectedMessage) throws InterruptedException {
		rolePage.addRoleSubmit();
		Thread.sleep(2000);
		String test = rolePage.addRolePermissionErrorMsg();
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
	
	@Given("User navigates to the Update Role page")
	public void user_navigates_to_the_update_role_page() {
	    rolePage.updateRole();
	}

	@When("User update the role name")
	public void user_update_the_role_name() {
	    rolePage.updateRoleName();
	}

	@When("User click on Add Role update button")
	public void user_click_on_add_role_update_button() {
	    
	}

	@Then("Update Role message should display {string}")
	public void update_role_message_should_display(String expectedMessage) throws InterruptedException {
		rolePage.addRoleSubmit();
		Thread.sleep(2000);
		String test = rolePage.updateRoleMsg();
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

	@Given("User navigates to the Filter role")
	public void user_navigates_to_the_filter_role() {
	    rolePage.filterRole();
	}

	@When("User Selects Admin Role")
	public void user_selects_admin_role() throws InterruptedException {
	    rolePage.filterRole();
	    Thread.sleep(5000);
	}

	@Then("User should get filtered Admin role data")
	public void user_should_get_filtered_admin_role_data() {
		String test = rolePage.filterstaffRoleData();
    	System.out.println(test);
    	
    	String consoleOutput3 = Util.stopConsoleCapture();
 	   if(!consoleOutput3.isEmpty()) {
 		   
            String formattedOutput = formatConsoleOutputToTable(consoleOutput3);

            ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>"+ formattedOutput + "</font>");

 		   log.info("Console Output3: " + formattedOutput);
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
}
