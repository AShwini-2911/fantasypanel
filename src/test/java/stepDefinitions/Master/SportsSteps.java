package stepDefinitions.Master;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import Base.DriverManager;
import Pages.Master.GamesPage;
import Pages.Master.SportsPage;
import Utility.GamesUtil;
import Utility.LoggerHelper;
import Utility.Util;
import io.cucumber.java.en.*;

public class SportsSteps extends DriverManager{
	 private WebDriver driver;

	private SportsPage SP ;
    private static Logger log = LoggerHelper.getLogger(GamesSteps.class);  // Log4j logger instance

    public SportsSteps() {
        this.driver = Util.webDriver.get(); // Retrieve WebDriver from Util (ensure this method is accessible)
        SP = new SportsPage(); // Initialize VideosPage with the WebDriver
    }

	
	@When("I click on a Sports titled {string}")
	public void i_click_on_a_sports_titled(String string) {
		
	SP.Click_View_Sports();
	   
	}
	
	@Then("I should see the details of the sports")
	public void i_should_see_the_details_of_the_sports() {
	   
	   String test =  SP.Get_details_Sports();
	     System.out.println(test);
	     
	     String consoleOutput1 = Util.stopConsoleCapture();
		   if(!consoleOutput1.isEmpty()) {
			   
	           String formattedOutput = formatConsoleOutputToTable(consoleOutput1);

	           ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>"+ formattedOutput + "</font>");

			   log.info("Console Output: " + formattedOutput);
		   }
		   
	     Util.clearConsoleOutput();

	}
	
	

	 @Given("User click on Update Sports button")
	    public void user_click_on_update_sports_button1() {
	       SP.click_update_sports();
			 log.info("User clicked on update Sports button");

	    }

	    @Then("User update title of the sports")
	    public void user_update_title_of_the_sports() {
	    	SP.update_commission_rate();
	    }

	    @Then("User click on update Sports button")
	    public void user_click_on_update_sports_button() {
	      SP.click_sports_submit();

	    }

	    @Given("User Click on Filter Sports button")
	    public void user_click_on_filter_sports_button() {
	        SP.sportsFilter();
			 log.info("User clicked on Filter Sports button");

	    }

	    @Then("User enter title in Title Sports field")
	    public void user_enter_title_in_title_sports_field() {
	    	SP.sportsFilterName();
	    
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


	    @Then("User should able to filtered Sports data")
	    public void user_should_able_to_filtered_sports_data() {
	    	
	    	
	    	String test = SP.getSportsFilteredData();
	    	System.out.println(test);
	    	
	    	String consoleOutput3 = Util.stopConsoleCapture();
	 	   if(!consoleOutput3.isEmpty()) {
	 		   
	            String formattedOutput = formatConsoleOutputToTable(consoleOutput3);

	            ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>"+ formattedOutput + "</font>");

	 		   log.info("Console Output3: " + formattedOutput);
	 	   }
	 	   
	      Util.clearConsoleOutput();

	    }
	    
	    @Given("User click on publish sport button")
	    public void user_click_on_publish_sport_button() {
	    	SP.clickPublish();
	    }

	

}
