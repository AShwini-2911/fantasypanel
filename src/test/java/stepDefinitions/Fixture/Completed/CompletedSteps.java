package stepDefinitions.Fixture.Completed;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import Base.DriverManager;
import Pages.Fixture.Completed.CompletedPage;
import Utility.LoggerHelper;
import Utility.Util;
import io.cucumber.java.en.*;

public class CompletedSteps extends DriverManager {
	
	private WebDriver driver;
    CompletedPage completed;
    private static Logger log = LoggerHelper.getLogger(CompletedSteps.class);




    // Constructor to initialize WebDriver and UserManagementPage
    public CompletedSteps() {
        this.driver = Util.webDriver.get(); // Retrieve WebDriver from Util
        completed = new CompletedPage(); // Initialize UserManagementPage
    }
    
    @Given("User Click on Filter Completed match button")
    public void user_click_on_filter_completed_match_button() {
        completed.filtercompleted();
    }

    @When("User Select League of Completed match")
    public void user_select_league_of_completed_match() {
        completed.filter_contest_league();
    }

    @When("User Select League match")
    public void user_select_league_match() throws InterruptedException {
        completed.filter_matchId();
        Thread.sleep(5000);
    }

    @Then("User should able to get filtered completed match data")
    public void user_should_able_to_get_filtered_completed_match_data() {
       
        String test = completed.filterCompletedMatchData();
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
    
    @Given("user click on Statistics Completed match button")
    public void user_click_on_statistics_completed_match_button() throws InterruptedException {
        completed.Statistics();
    }

    @When("user click on Filter Statistics button")
    public void user_click_on_filter_statistics_button() {
    	 completed.statisticsFilterBtn();
    }

    @When("user select innings of Statistics")
    public void user_select_innings_of_statistics() throws InterruptedException {
       
        completed.StatisticsFilter();
        Thread.sleep(5000);
    }

    @Then("user should able to get filtered Statistics data")
    public void user_should_able_to_get_filtered_statistics_data() {
    	 String test = completed.StatisticsFilteredData();
     	System.out.println(test);
     	
     	String consoleOutput3 = Util.stopConsoleCapture();
  	   if(!consoleOutput3.isEmpty()) {
  		   
             String formattedOutput = formatConsoleOutputToTable(consoleOutput3);

             ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>"+ formattedOutput + "</font>");

  		   log.info("Console Output3: " + formattedOutput);
  	   }
  	   
       Util.clearConsoleOutput();
    }


}
