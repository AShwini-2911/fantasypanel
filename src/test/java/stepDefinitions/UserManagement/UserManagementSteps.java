//package stepDefinitions.UserManagement;
//
//import org.apache.log4j.Logger;
//import org.openqa.selenium.WebDriver;
//
//import Pages.UserManagement.UserManagementPage;
//import Utility.LoggerHelper;
//import Utility.Util;
//import io.cucumber.java.en.*;
//
//public class UserManagementSteps {
//
//    private WebDriver driver;
//    UserManagementPage userMgmt;
//    private static Logger log = LoggerHelper.getLogger(UserManagementSteps.class);
//
//    // Constructor to initialize WebDriver and UserManagementPage
//    public UserManagementSteps() {
//        this.driver = Util.webDriver.get(); // Retrieve WebDriver from Util
//        userMgmt = new UserManagementPage(); // Initialize UserManagementPage
//    }
//
//    @Given("I navigate to the User Management Module")
//    public void i_navigate_to_the_user_management_module() {
//        Util.startConsoleCapture();
//        userMgmt.clickUserMgmt();
//        log.info("Navigated to User Management Module");
//    }
//
//    @Given("User clicks on the Filter button")
//    public void user_clicks_on_the_filter_button() {
//        userMgmt.clickFilterUserManagement();
//        log.info("Clicked on the Filter button in User Management");
//    }
//
//    @Then("User enters {string} in the name filter")
//    public void user_enters_in_the_name_filter(String name) {
//        userMgmt.enterFilterName(name);
//        log.info("Entered name in the filter: " + name);
//    }
//
//    @Then("User should see filtered data displayed in the table")
//    public void user_should_see_filtered_data_displayed_in_the_table() throws InterruptedException {
//    	Thread.sleep(3000);
//        String tableData = userMgmt.getTableDataAsString();
//        System.out.println("\nFiltered Table Data:\n" + tableData);
//    	Thread.sleep(3000);
//
//        log.info("Filtered table data retrieved:\n" + tableData);
//
//    	Thread.sleep(3000);
//
//        // Stop console capture and log the output
//        String consoleOutput = Util.stopConsoleCapture();
//        if (!consoleOutput.isEmpty()) {
//        	Thread.sleep(3000);
//
//            log.info("Console Output:\n" + consoleOutput);
//        }
//        Util.clearConsoleOutput();
//    }
//}


package stepDefinitions.UserManagement;

import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import Pages.UserManagement.UserManagementPage;
import Utility.LoggerHelper;
import Utility.Util;
import io.cucumber.java.en.*;

public class UserManagementSteps {

    private WebDriver driver;
    UserManagementPage userMgmt;
    private static Logger log = LoggerHelper.getLogger(UserManagementSteps.class);

    // Constructor to initialize WebDriver and UserManagementPage
    public UserManagementSteps() {
        this.driver = Util.webDriver.get(); // Retrieve WebDriver from Util
        userMgmt = new UserManagementPage(); // Initialize UserManagementPage
    }

    @Given("I navigate to the User Management Module")
    public void i_navigate_to_the_user_management_module() {
        Util.startConsoleCapture();
        userMgmt.clickUserMgmt();
        log.info("Navigated to User Management Module");
    }

    @Given("User clicks on the Filter button")
    public void user_clicks_on_the_filter_button() {
        userMgmt.clickFilterUserManagement();
        log.info("Clicked on the Filter button in User Management");
    }

    @Then("User enters {string} in the name filter")
    public void user_enters_in_the_name_filter(String name) throws InterruptedException {
        userMgmt.enterFilterName(name);
        log.info("Entered name in the filter: " + name);
        
    }

    @Then("User should see filtered data displayed in the table")
    public void user_should_see_filtered_data_displayed_in_the_table() throws InterruptedException {
//        String tableData = userMgmt.getTableDataAsString();
//        System.out.println("\nFiltered Table Data:\n" + tableData);
//        log.info("Filtered table data retrieved:\n" + tableData);
    	
        waitForTableToUpdate();

    	 String actualData = userMgmt.getFilteredTableDataAsString();
         log.info("Actual Table Data:\n" + actualData);

         // Now, perform comparison logic to check if the expected data matches
         String expectedData = "Test";  // Replace this with dynamic expected value or parameter

         // Compare actual data with expected data
         boolean isDataCorrect = compareTableDataWithExpected(actualData, expectedData);

         if (isDataCorrect) {
             log.info("Data matches successfully with the expected value.");
         } else {
             log.error("Data does not match the expected value.");
         }

         // Assert or further logic (optional)
         assert isDataCorrect : "Actual data does not match expected data!";


        // Stop console capture and log the output
        String consoleOutput1 = Util.stopConsoleCapture();
        if (!consoleOutput1.isEmpty()) {
            ExtentCucumberAdapter.getCurrentStep().info("Console Output: " + consoleOutput1);

            log.info("Console Output:\n" + consoleOutput1);
        }
        Util.clearConsoleOutput();
    }

    @Then("User data comparison with {string}")
    public void user_data_comparison_with(String expectedData) throws InterruptedException {
        Thread.sleep(3000);

     // Wait for the table to load and get the actual data
//        String actualData = userMgmt.getTableDataAsString();
//        log.info("Actual Table Data:\n" + actualData);
//
//        // Now, perform comparison logic to check if the expected data matches
//        String expectedData1 = "Test";  // Replace this with dynamic expected value or parameter
//
//        // Compare actual data with expected data
//        boolean isDataCorrect = compareTableDataWithExpected(actualData, expectedData1);
//
//        if (isDataCorrect) {
//            log.info("Data matches successfully with the expected value.");
//        } else {
//            log.error("Data does not match the expected value.");
//        }
//
//        // Assert or further logic (optional)
//        assert isDataCorrect : "Actual data does not match expected data!";
      
    }
    
    private void waitForTableToUpdate() {
        try {
            // Wait for a specific element in the table to become visible (e.g., the first row or a column)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(driver -> userMgmt.getRows().size() > 0);//            wait.until(driver -> userMgmt.getRows().size() > 0);  // Wait for at least one row in the table
        } catch (Exception e) {
            log.error("Error waiting for table to update after applying filter: " + e.getMessage());
        }
    }

    
    private boolean compareTableDataWithExpected(String actualData, String expectedData) {
        // Split the actual data by line to get each row
        String[] rows = actualData.split("\n");

        // Loop through each row to compare the data
        boolean isMatch = true;
        for (String row : rows) {
            if (row.contains(expectedData)) {
                log.info("Found matching data in the table: " + row);
            } else {
                log.error("No match found for expected data in row: " + row);
                isMatch = false;
            }
        }
        return isMatch;
        
        
    }
}
