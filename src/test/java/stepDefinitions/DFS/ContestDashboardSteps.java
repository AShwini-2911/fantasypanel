package stepDefinitions.DFS;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import Pages.DFS.ContestDashboardPage;

import Utility.LoggerHelper;
import Utility.Util;
import io.cucumber.java.en.*;

public class ContestDashboardSteps {
	
	private WebDriver driver;
	private ContestDashboardPage CDP;
    private static Logger log = LoggerHelper.getLogger(ContestDashboardSteps.class);  // Log4j logger instance


    // Constructor to initialize WebDriver and VideosPage
    public ContestDashboardSteps() {
        this.driver = Util.webDriver.get(); // Retrieve WebDriver from Util (ensure this method is accessible)
        CDP = new ContestDashboardPage(); // Initialize VideosPage with the WebDriver
    }
	
	@Given("User Click on Filter Contest Dashboard button")
	public void user_click_on_filter_contest_dashboard_button() {
    	Util.startConsoleCapture();

	   CDP.filterContestDashboard();
	}

	@Then("User enter title in Title Contest Dashboard field")
	public void user_enter_title_in_title_contest_dashboard_field() {
	   CDP.filterLeague();
	}

	@Then("User should able to filtered Contest Dashboard data")
	public void user_should_able_to_filtered_contest_dashboard_data() {
	   CDP.getFilteredcontestDash();
	}

	@Given("User clicks on UnPin contest which has id {int}")
	public void user_clicks_on_pin_contest_which_has_id(Integer contestId) throws InterruptedException {
	    
System.out.println("User clicked on Pin contest with ID: " + contestId);
        
        // Click on the corresponding pin/unpin button and get the message
        String message = CDP.clickPinButton(contestId);
        
        // Log the message in console
        System.out.println("Contest message displayed: " + message);
	}

	@Then("User gets a unpinned contest message")
	public void user_gets_a_unpinned_contest_message() throws InterruptedException {
		String message = CDP.clickPinButton(1);  // ID 1 should unpin
        Assert.assertEquals(message, "Unpinned Successfully!", "Message is not as expected!");
        
        // Log the validation in console
        System.out.println("Unpinned contest message displayed: " + message);
        
        String consoleOutput = Util.stopConsoleCapture(); // Replace with your actual console capture method

        ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>Console Output: " + consoleOutput + "</font>");
        Util.clearConsoleOutput();
	}

	@When("User clicks on Pin contest which has id {int}")
	public void user_clicks_on_pin_contest_which_has_zero_id(Integer contestId) throws InterruptedException {
	   
		Util.startConsoleCapture();
		 // Click on the corresponding pin/unpin button and get the message
        String message = CDP.clickPinButton(contestId);
        
        // Log the message in console
        System.out.println("Contest message displayed: " + message);
	}

	@Then("User gets a pinned contest message")
	public void user_gets_a_pinned_contest_message() throws InterruptedException {
		String message = CDP.clickPinButton(0);  // ID 0 should unpin
        Assert.assertEquals(message, "Pinned Successfully!", "Message is not as expected!");
        
        // Log the validation in console
        System.out.println("Pinned contest message displayed: " + message);
        
        String consoleOutput = Util.stopConsoleCapture(); // Replace with your actual console capture method

        ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>Console Output: " + consoleOutput + "</font>");
        Util.clearConsoleOutput();
	    
	}

}
