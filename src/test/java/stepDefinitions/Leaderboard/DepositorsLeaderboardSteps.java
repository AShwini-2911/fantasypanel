package stepDefinitions.Leaderboard;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import Base.DriverManager;
import Pages.Leaderboard.DepositorsLeaderboardPage;
import Utility.LoggerHelper;
import Utility.Util;
import io.cucumber.java.en.*;

public class DepositorsLeaderboardSteps extends DriverManager {

	private WebDriver driver;
	DepositorsLeaderboardPage depositorsPage;
	
	
    private static Logger log = LoggerHelper.getLogger(DepositorsLeaderboardSteps.class); 
    
    public DepositorsLeaderboardSteps() {
        this.driver = Util.webDriver.get(); // Retrieve WebDriver from Util
      depositorsPage = new DepositorsLeaderboardPage(); // Initialize UserManagementPage     
        
    }
    
   

    @Given("User click on Filter Depositors Leaderboard")
    public void user_click_on_filter_depositors_leaderboard() {
        depositorsPage.clickFilterDepositorsLeaderboard();
    }

    @When("User Enter filter name in Depositors Leaderboard")
    public void user_enter_filter_name_in_depositors_leaderboard() {
       depositorsPage.filterDepositorsName();
    }

    @When("User Enter filter Mobile no in Depositors Leaderboard")
    public void user_enter_filter_mobile_no_in_depositors_leaderboard() throws InterruptedException {
        depositorsPage.filterDepositorsMobileNo();
        Thread.sleep(5000);

    }

    @Then("filtered data should display in Depositors Leaderboard")
    public void filtered_data_should_display_in_depositors_leaderboard() {
    	String test = depositorsPage.filteredNameData();
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

    @Then("User Enter date range in Depositors Leaderboard")
    public void user_enter_date_range_in_depositors_leaderboard() throws InterruptedException {
        depositorsPage.clickDateRangeFilter();
        Thread.sleep(2000);
        depositorsPage.selectDate();
        Thread.sleep(2000);

        depositorsPage.dateApplybtn();
        Thread.sleep(5000);
    }

    @Then("print the filtered data according to the date range in depositors leaderboard")
    public void print_the_filtered_data_according_to_the_date_range_in_depositors_leaderboard() {
    	String test = depositorsPage.filteredNameData();
    	 System.out.println(test);
         
         String consoleOutput1 = Util.stopConsoleCapture();
    	   if(!consoleOutput1.isEmpty()) {
    		   
               String formattedOutput = formatConsoleOutputToTable(consoleOutput1);

               ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>"+ formattedOutput + "</font>");

    		   log.info("Console Output: " + formattedOutput);
    	   }
    	   
         Util.clearConsoleOutput();
         
    }
    
    @Given("User click on user name in depositors leaderboard")
    public void user_click_on_user_name_in_depositors_leaderboard() {
        depositorsPage.clickNameDepositor();
    }

    @When("User is on Personal page of user name")
    public void user_is_on_personal_page_of_user_name() {
        
    }

    @When("User print Account Verification data in depositors leaderboard")
    public void user_print_account_verification_data_in_depositors_leaderboard() {
    	 String test = depositorsPage.accountVerificationData();
        
   	 System.out.println(test);
        
        String consoleOutput1 = Util.stopConsoleCapture();
   	   if(!consoleOutput1.isEmpty()) {
   		   
              String formattedOutput = formatConsoleOutputToTable(consoleOutput1);

              ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>"+ formattedOutput + "</font>");

   		   log.info("Console Output: " + formattedOutput);
   	   }
   	   
        Util.clearConsoleOutput();
    }

    @When("User print Basic Details data in depositors leaderboard")
    public void user_print_basic_details_data_in_depositors_leaderboard() {
    	String test = depositorsPage.basicDetailsData();
       
   	 System.out.println(test);
        
        String consoleOutput1 = Util.stopConsoleCapture();
   	   if(!consoleOutput1.isEmpty()) {
   		   
              String formattedOutput = formatConsoleOutputToTable(consoleOutput1);

              ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>"+ formattedOutput + "</font>");

   		   log.info("Console Output: " + formattedOutput);
   	   }
   	   
        Util.clearConsoleOutput();
    }

    @Then("User print KYC data in depositors leaderboard")
    public void user_print_kyc_data_in_depositors_leaderboard() {
    	 String test =  depositorsPage.kycData();
       
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
