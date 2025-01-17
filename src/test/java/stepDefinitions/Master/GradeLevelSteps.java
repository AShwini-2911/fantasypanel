package stepDefinitions.Master;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import Pages.Master.GamesPage;
import Pages.Master.GradeLevelPage;
import Utility.LoggerHelper;
import Utility.Util;
import io.cucumber.java.en.*;

public class GradeLevelSteps extends Base.DriverManager{
	
	 private WebDriver driver;
	    private GradeLevelPage GradeLevel;
	    private static Logger log = LoggerHelper.getLogger(GamesSteps.class);  // Log4j logger instance


	    // Constructor to initialize WebDriver and VideosPage
	    public GradeLevelSteps() {
	        this.driver = Util.webDriver.get(); // Retrieve WebDriver from Util (ensure this method is accessible)
	        GradeLevel = new GradeLevelPage(); // Initialize VideosPage with the WebDriver
	    }
	    
	    @Given("User click on View Grade Level button")
	    public void user_click_on_view_grade_level_button() {
	        GradeLevel.clickViewGradeLevel();
	    }

	    @Then("User should able to see the Grade Level details")
	    public void user_should_able_to_see_the_grade_level_details() {
	    	 String test =  GradeLevel.getGradeLevelDetails();
	       
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



	    @Given("User click on Update Grade Level button")
	    public void user_click_on_update_grade_level_button1() {
	       GradeLevel.updateGradeLevel();
	    }

	    @Then("User update title of the Grade Level")
	    public void user_update_title_of_the_grade_level() {
	       GradeLevel.accumulatedDeposite();
	    }

	    @Then("User click on update Grade Level button")
	    public void user_click_on_update_grade_level_button() {
	        GradeLevel.updateGradeLevelBtn();
	    }

	    @Then("an Grade Level updated successfully {string} should display")
	    public void an_grade_level_updated_successfully_should_display(String exp) {
	    	 String test = GradeLevel.Get_update_gradeLevel();
	        
	       
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
