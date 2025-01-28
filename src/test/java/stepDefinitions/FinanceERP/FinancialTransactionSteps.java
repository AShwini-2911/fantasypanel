package stepDefinitions.FinanceERP;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import Base.DriverManager;
import Pages.FinanceERP.FinancialTransactionPage;
import Utility.LoggerHelper;
import Utility.Util;
import io.cucumber.java.en.*;


public class FinancialTransactionSteps extends DriverManager {
	
	private WebDriver driver;
	FinancialTransactionPage financialTransaction;
	
	
    private static Logger log = LoggerHelper.getLogger(FinancialTransactionSteps.class); 
    
    public FinancialTransactionSteps() {
        this.driver = Util.webDriver.get(); // Retrieve WebDriver from Util
      financialTransaction = new FinancialTransactionPage(); // Initialize UserManagementPage     
        
    }
	

	@Given("User click on Add Financial Transaction button")
	public void user_click_on_add_financial_transaction_button() {
	    financialTransaction.addFinancialTransaction();
	}

	@When("User select finacial category in financial transaction")
	public void user_select_finacial_category_in_financial_transaction() {
	    financialTransaction.selectFinancialCategory();
	}

	@When("User enter amount in financial transaction")
	public void user_enter_amount_in_financial_transaction() {
	    financialTransaction.transaction_amount();
	}

	@When("User enter date in financial transaction")
	public void user_enter_date_in_financial_transaction() {
	    financialTransaction.transaction_date();
	}

	@When("User enter description in financial transaction")
	public void user_enter_description_in_financial_transaction() {
	    financialTransaction.transactionDescription();
	}

	@When("User click on submit button of financial transaction")
	public void user_click_on_submit_button_of_financial_transaction() {
//	    financialTransaction.financialTransactionSubmit();
	}

	@Then("user should able to see succes message of financial transaction {string}")
	public void user_should_able_to_see_succes_message_of_financial_transaction(String exp) throws InterruptedException {
		financialTransaction.financialTransactionSubmit();
	    Thread.sleep(5000);
//		String test = financialTransaction.financialTransactionSuccessMsg();
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
	
	@Given("User click on view Financial transaction details")
	public void user_click_on_view_financial_transaction_details() {
	    financialTransaction.viewFinancialTransaction();
	}

	@Then("user should able to see viewed Finacial transaction details")
	public void user_should_able_to_see_viewed_finacial_transaction_details() {
	    
		String test = financialTransaction.getviewedFTransactionDetail();
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
    
    @Given("User click on filter financial transaction")
    public void user_click_on_filter_financial_transaction() {
        financialTransaction.filterFinancialTransaction();
    }

    @When("User select financial category type filter")
    public void user_select_financial_category_type_filter() throws InterruptedException {
        financialTransaction.filterFCategoryType();
        Thread.sleep(5000);
    }

    @Then("User should able to see filtered data according to the category type Insurance")
    public void user_should_able_to_see_filtered_data_according_to_the_category_type_insurance() {
    	String test = financialTransaction.filterFinacialTransactiondata();
	     
	     String consoleOutput1 = Util.stopConsoleCapture();
		   if(!consoleOutput1.isEmpty()) {
			   
	           String formattedOutput = formatConsoleOutputToTable(consoleOutput1);

	           ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>"+ formattedOutput + "</font>");

			   log.info("Console Output: " + formattedOutput);
		   }
		   
	     Util.clearConsoleOutput();
    }

}
