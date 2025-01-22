package stepDefinitions.GeneralSettings;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import Base.DriverManager;
import Pages.GeneralSettings.SettingsPage;

import Utility.LoggerHelper;
import Utility.SettingsUtil;
import Utility.Util;
import io.cucumber.java.en.*;


public class SettingsSteps extends DriverManager {
	
	 private WebDriver driver;
	    private SettingsPage settingspage;
	    private static Logger log = LoggerHelper.getLogger(SettingsSteps.class);  // Log4j logger instance


	    // Constructor to initialize WebDriver and VideosPage
	    public SettingsSteps() {
	        this.driver = Util.webDriver.get(); // Retrieve WebDriver from Util (ensure this method is accessible)
	       settingspage = new SettingsPage();// Initialize VideosPage with the WebDriver
	    }

	
	
	

	@Given("user is on General info page")
	public void user_is_on_general_info_page() {
	   
	}

	@When("user updates the system email and contact number")
	public void user_updates_the_system_email_and_contact_number() {
		
	    settingspage.enterSystemEmail(SettingsUtil.getSettingsProperty("SystemE-mail"));
	    settingspage.enterSystemContactNo(SettingsUtil.getSettingsProperty("SystemContactNo"));
	}

	@When("user saves the changes")
	public void user_saves_the_changes() {
	    
	}

	
	@Then("user should see General info success message {string}")
	public void user_should_see_general_info_success_message(String exp) {
		settingspage.saveChanges1();
		String test = settingspage.dataSuccessMsg();
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

	@Then("user should see social media success message {string}")
	public void user_should_see_social_media_success_message(String exp) {
		settingspage.saveChanges2();
		String test = settingspage.dataSuccessMsg();
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

	@Then("user should see deposite and withdraw amount success message {string}")
	public void user_should_see_deposite_and_withdraw_amount_success_message(String exp) {
		settingspage.saveChanges3();
		String test = settingspage.dataSuccessMsg();
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

	@Then("user should see app link success message {string}")
	public void user_should_see_app_link_success_message(String exp) {
		settingspage.saveChanges4();
		String test = settingspage.dataSuccessMsg();
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

	@Then("user should see app version success message {string}")
	public void user_should_see_app_version_success_message(String exp) {
		settingspage.saveChanges5();
		String test = settingspage.dataSuccessMsg();
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
        Util.clearConsoleOutput();	}


	@Given("user is on Social media links page")
	public void user_is_on_social_media_links_page() {
	   settingspage.socialMedia();
	}

	@When("user updates the facebook , twitter and youtube links")
	public void user_updates_the_facebook_twitter_and_youtube_links() {
		  settingspage.enterfacebookLink(SettingsUtil.getSettingsProperty("Facebook"));
		  settingspage.entertwitterLink(SettingsUtil.getSettingsProperty("Twitter"));
		  settingspage.enteryoutubeLink(SettingsUtil.getSettingsProperty("YouTube"));


	}

	@Given("user is on deposite and withdraw page")
	public void user_is_on_deposite_and_withdraw_page() {
	   settingspage.depositeAndWithdraw();
	}

	@When("user updates the deposite and withdraw amount")
	public void user_updates_the_deposite_and_withdraw_amount() {
		  settingspage.minimum_deposit_amount(SettingsUtil.getSettingsProperty("MinimumDepositAmount"));
		  settingspage.maximum_deposit_amount(SettingsUtil.getSettingsProperty("MaximumDepositAmount"));
		  settingspage.minimum_withdrawal_amount(SettingsUtil.getSettingsProperty("MinimumWithdrawalAmount"));
		  settingspage.maximum_withdrawal_amount(SettingsUtil.getSettingsProperty("MaximumWithdrawalAmount"));



	}

	@Given("user is on App links page")
	public void user_is_on_app_links_page() {
	   settingspage.App_Link();
	}

	@When("user updates the android and iOS links")
	public void user_updates_the_android_and_i_os_links() {
		 settingspage.android_url(SettingsUtil.getSettingsProperty("Android"));
		 settingspage.ios_url(SettingsUtil.getSettingsProperty("IOS"));


	}

	@Given("user is on app version page")
	public void user_is_on_app_version_page() {
	    settingspage.App_Version();
	}

	@When("user updates the android and iOS versions")
	public void user_updates_the_android_and_i_os_versions() {
		 settingspage.android_version(SettingsUtil.getSettingsProperty("AndroidVer"));
		 settingspage.ios_version(SettingsUtil.getSettingsProperty("IOSVer"));

	}

}
