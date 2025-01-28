package stepDefinitions.Leaderboard;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import Base.DriverManager;
import Pages.Leaderboard.globalLeaderboardPage;
import Utility.LoggerHelper;
import Utility.Util;
import io.cucumber.java.en.*;

public class GlobalLeaderboardSteps extends DriverManager {
	
	private WebDriver driver;
	globalLeaderboardPage globalLeaderboard;
	
	
    private static Logger log = LoggerHelper.getLogger(GlobalLeaderboardSteps.class); 
    
    public GlobalLeaderboardSteps() {
        this.driver = Util.webDriver.get(); // Retrieve WebDriver from Util
      globalLeaderboard = new globalLeaderboardPage(); // Initialize UserManagementPage     
        
    }
    
   
    @Given("user click on add payout leaderboard")
    public void user_click_on_add_payout_leaderboard() {
        globalLeaderboard.addPayoutLeaderboard();
    }

    @When("user user select leaderboard type of payout leaderboard")
    public void user_user_select_leaderboard_type_of_payout_leaderboard() {
        globalLeaderboard.leaderboardType();
    }

    @When("user select start date of payout leaderderboard")
    public void user_select_start_date_of_payout_leaderderboard() {
        globalLeaderboard.payout_leaderboard_start_date();
    }

    @When("user select end date of payout leaderboard")
    public void user_select_end_date_of_payout_leaderboard() {
        globalLeaderboard.payout_leaderboard_end_date();
    }

    @When("user enter max rank in payout data")
    public void user_enter_max_rank_in_payout_data() {
        globalLeaderboard.PayoutDataMaxRank();
    }

    @When("user enter distribution amount in payout data")
    public void user_enter_distribution_amount_in_payout_data() {
        globalLeaderboard.payoutDatadistribution_amount();
    }

    @When("user click on total amount in payout data")
    public void user_click_on_total_amount_in_payout_data() {
        globalLeaderboard.payoutDataTotal();
    }

    @When("user click on add button in payout data")
    public void user_click_on_add_button_in_payout_data() {
        globalLeaderboard.addPayoutData();
    }

    @When("user click on delete button in payout data")
    public void user_click_on_delete_button_in_payout_data() {
        globalLeaderboard.deletePayoutData();
    }

    @When("user click on submit button of add payout leaderboard")
    public void user_click_on_submit_button_of_add_payout_leaderboard() {
        
    }

    @Then("user should able to see payout leaderboard success message {string}")
    public void user_should_able_to_see_payout_leaderboard_success_message(String exp) throws InterruptedException {
    	globalLeaderboard.addPayoutSubmit();
//    	Thread.sleep(3000);
//        
//		String test = globalLeaderboard.addPayoutSuccessMsg();
//    	System.out.println(test);
//        // Capture the console output
//        String consoleOutput = Util.stopConsoleCapture(); // Replace with your actual console capture method
//        
//        exp = exp.trim();
//        consoleOutput = consoleOutput.trim();
//
//        // Compare the captured console output with the expected message
//        if (consoleOutput.equals(exp)) {
//            // If they match, log success
//            ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>Console Output is as expected: " + consoleOutput + "</font>");
//            log.info("Success: Console Output is as expected: " + consoleOutput);
//        } else {
//            // If they don't match, log failure and print the expected vs actual output
//            ExtentCucumberAdapter.getCurrentStep().fail("<font color='green' style='background-color:white;'>Console Output does not match the expected message.\n" +
//                                                        "Expected: " + exp + "\n" +
//                                                        "Actual: " + consoleOutput + "</font>");
//            log.error("<font color='green' style='background-color:white;'>Error: Console Output does not match the expected message.\n" +
//                      "Expected: " + exp + "\n" +
//                      "Actual: " + consoleOutput + "</font>");
//            // Optionally, fail the test if the message doesn't match
//            Assert.fail("<font color='green' style='background-color:white;'>Console Output does not match the expected message. </font>");
//        }
//        Util.clearConsoleOutput();
	}
    
    @Then("user should able to see payout leaderboard duplicate message {string}")
    public void user_should_able_to_see_payout_leaderboard_duplicate_message(String exp) throws InterruptedException {
    	globalLeaderboard.addPayoutSubmit();
//    	Thread.sleep(3000);
//        
//		String test = globalLeaderboard.addPayoutduplicateMsg();
//    	System.out.println(test);
//        // Capture the console output
//        String consoleOutput = Util.stopConsoleCapture(); // Replace with your actual console capture method
//        
//        exp = exp.trim();
//        consoleOutput = consoleOutput.trim();
//
//        // Compare the captured console output with the expected message
//        if (consoleOutput.equals(exp)) {
//            // If they match, log success
//            ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>Console Output is as expected: " + consoleOutput + "</font>");
//            log.info("Success: Console Output is as expected: " + consoleOutput);
//        } else {
//            // If they don't match, log failure and print the expected vs actual output
//            ExtentCucumberAdapter.getCurrentStep().fail("<font color='green' style='background-color:white;'>Console Output does not match the expected message.\n" +
//                                                        "Expected: " + exp + "\n" +
//                                                        "Actual: " + consoleOutput + "</font>");
//            log.error("<font color='green' style='background-color:white;'>Error: Console Output does not match the expected message.\n" +
//                      "Expected: " + exp + "\n" +
//                      "Actual: " + consoleOutput + "</font>");
//            // Optionally, fail the test if the message doesn't match
//            Assert.fail("<font color='green' style='background-color:white;'>Console Output does not match the expected message. </font>");
//        }
//        Util.clearConsoleOutput();
    }
    
    @Given("user click on view payout leaderboard")
    public void user_click_on_view_payout_leaderboard() {
        globalLeaderboard.globalLeaderboardView();
    }

    @Then("user should able to see details of view leaderboard")
    public void user_should_able_to_see_details_of_view_leaderboard() {
       
        String test = globalLeaderboard.viewedDescriptionDetails();
        System.out.println(test);
        
        String consoleOutput1 = Util.stopConsoleCapture();
   	   if(!consoleOutput1.isEmpty()) {
   		   
              String formattedOutput = formatConsoleOutputToTable(consoleOutput1);

              ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>"+ formattedOutput + "</font>");

   		   log.info("Console Output: " + formattedOutput);
   	   }
   	   
        Util.clearConsoleOutput();
        
    }
    
    @When("user click on Winners")
    public void user_click_on_winners() {
        globalLeaderboard.viewWinner();
    }

    @Then("user should able to see winners details")
    public void user_should_able_to_see_winners_details() {
        
        String test = globalLeaderboard.viewedWinnersDetails();
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
    
    @Given("user click on update global leaderboard")
    public void user_click_on_update_global_leaderboard() {
        globalLeaderboard.updatePayout();
    }

    @When("user update the rank of global leaderboard")
    public void user_update_the_rank_of_global_leaderboard() {
        globalLeaderboard.updateRank();
    }

    @When("user click on update global leaderboard button")
    public void user_click_on_update_global_leaderboard_button() {
       
    }

    @Then("user should able to see update global leaderboard message {string}")
    public void user_should_able_to_see_update_global_leaderboard_message(String exp) throws InterruptedException {
        
    	 globalLeaderboard.updatePayoutBtn();
        Thread.sleep(5000);
//      
//		String test = globalLeaderboard.updateSuccessMsg();
//  	System.out.println(test);
//      // Capture the console output
//      String consoleOutput = Util.stopConsoleCapture(); // Replace with your actual console capture method
//      
//      exp = exp.trim();
//      consoleOutput = consoleOutput.trim();
//
//      // Compare the captured console output with the expected message
//      if (consoleOutput.equals(exp)) {
//          // If they match, log success
//          ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>Console Output is as expected: " + consoleOutput + "</font>");
//          log.info("Success: Console Output is as expected: " + consoleOutput);
//      } else {
//          // If they don't match, log failure and print the expected vs actual output
//          ExtentCucumberAdapter.getCurrentStep().fail("<font color='green' style='background-color:white;'>Console Output does not match the expected message.\n" +
//                                                      "Expected: " + exp + "\n" +
//                                                      "Actual: " + consoleOutput + "</font>");
//          log.error("<font color='green' style='background-color:white;'>Error: Console Output does not match the expected message.\n" +
//                    "Expected: " + exp + "\n" +
//                    "Actual: " + consoleOutput + "</font>");
//          // Optionally, fail the test if the message doesn't match
//          Assert.fail("<font color='green' style='background-color:white;'>Console Output does not match the expected message. </font>");
//      }
//      Util.clearConsoleOutput();
   }
    
    @Given("user click on filter global leaderboard")
    public void user_click_on_filter_global_leaderboard() {
              globalLeaderboard.filterGlobalLeaderboard();
    }

    @When("user select filter leaderboard type")
    public void user_select_filter_leaderboard_type() throws InterruptedException {
        globalLeaderboard.filter_search_leaderboard_type();
        
        Thread.sleep(5000);

    }

    @Then("user should able to filtered data of global leaderboard")
    public void user_should_able_to_filtered_data_of_global_leaderboard() {
    	String test = globalLeaderboard.viewedDescriptionDetails();
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

	


