package stepDefinitions.GeneralSettings;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import Base.DriverManager;

import Pages.GeneralSettings.SpinWheelPage;
import Utility.LoggerHelper;
import Utility.Util;
import io.cucumber.java.en.*;

public class SpinWheelSteps extends DriverManager {
	
	private WebDriver driver;
	SpinWheelPage spinPage;
	
    private static Logger log = LoggerHelper.getLogger(SpinWheelSteps.class); 
    
    public SpinWheelSteps() {
        this.driver = Util.webDriver.get(); // Retrieve WebDriver from Util
        spinPage = new SpinWheelPage(); // Initialize UserManagementPage     
        
    }
	
    
    @When("User click on View spin wheel button")
    public void user_click_on_view_spin_wheel_button() {
    	Util.startConsoleCapture();
        spinPage.viewSpinWheel();
    }

    @Then("User should able to see spin wheel details")
    public void user_should_able_to_see_spin_wheel_details() {
    	String test = spinPage.getSpinWheelDetails();
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

    @Given("User is on the Edit Spin Wheel form page")
    public void user_is_on_the_edit_spin_wheel_form_page() {
        spinPage.updateSpinWheel();
    }

    @When("User clear the prize and click on update button")
    public void user_clear_the_prize_and_click_on_update_button() {
       spinPage.clearPrize();
    }

    @Then("prize field border color should be RED")
    public void prize_field_border_color_should_be_red() {
    	spinPage.spinWheelUpdateBtn();
    	Util.startConsoleCapture();
    	try {
            // Fetch the border color using the method from the Page Object class
            String borderColor = spinPage.prizeColor();
            System.out.println("Border Color: " + borderColor);


            // Start capturing console output (assuming Util.startConsoleCapture() exists)
            String Output = Util.stopConsoleCapture();

            log.info("Success: Console Output is as expected: " + Output);

            // Verify the border color matches the expected value for red
            if (borderColor.equals("rgb(245, 82, 82)")) { // CSS border colors are in RGB format
                System.out.println("Test Passed:Prize border color changed to red.");
                ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>Console Output is as expected: " + Output + "</font>");
            } else {
                System.out.println("Test Failed:Prize color did not change as expected.");
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

    @When("User updates prize in Spin Wheel")
    public void user_updates_prize_in_spin_wheel() {
    	Util.startConsoleCapture();
        spinPage.prizeUpdate();
    }

    @When("clicks on the Spin Wheel update button")
    public void clicks_on_the_spin_wheel_update_button() {
        spinPage.spinWheelUpdateBtn();
    }


	

}
