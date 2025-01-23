package stepDefinitions.GeneralSettings;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import Base.DriverManager;
import Pages.GeneralSettings.ApplicationSettingsPage;
import Pages.GeneralSettings.AvatarPage;
import Utility.LoggerHelper;
import Utility.Util;
import io.cucumber.java.en.*;

public class ApplicationSettingsSteps extends DriverManager {
	
	private WebDriver driver;
	ApplicationSettingsPage appPage;
	
	
    private static Logger log = LoggerHelper.getLogger(ApplicationSettingsSteps.class); 
    
    public ApplicationSettingsSteps() {
        this.driver = Util.webDriver.get(); // Retrieve WebDriver from Util
        appPage = new ApplicationSettingsPage(); // Initialize UserManagementPage     
        
    }
	
	
	@When("User updated text1 in feeds")
	public void user_updated_text1_in_feeds() {
	    appPage.FeedText();
	}

	@When("User click on Feeds Submit button")
	public void user_click_on_feeds_submit_button() {
	  
	}

	@Then("User should able to see Feeds update message {string}")
	public void user_should_able_to_see_feeds_update_message(String exp) {
		 appPage.FeedSubmitbtn();
		String test = appPage.submitApplicationSettingMsg();
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
	
	@When("User updated Active spin in runs")
	public void user_updated_active_spin_in_runs() {
	    appPage.runsClick();
	    appPage.activate_spin_on();
	}

	@When("User click on Runs Submit button")
	public void user_click_on_runs_submit_button() {
	    
	}

	@Then("User should able to see Runs update message {string}")
	public void user_should_able_to_see_runs_update_message(String exp) {
		 appPage.RunsSubmitbtn();
			String test = appPage.submitApplicationSettingMsg();
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

	@When("User updated Direct Deposit Multiplier in Play More Multiplier")
	public void user_updated_direct_deposit_multiplier_in_play_more_multiplier() {
	    appPage.PlayMoreMultiplier();
	    appPage.direct_deposit_multiplier();
	}

	@When("User click on Play More Multiplier Submit button")
	public void user_click_on_play_more_multiplier_submit_button() {
	    
	}

	@Then("User should able to see Play More Multiplier update message {string}")
	public void user_should_able_to_see_play_more_multiplier_update_message(String exp) {
		appPage.PlayMoreMultiplierSubmitbtn();
		String test = appPage.submitApplicationSettingMsg();
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

	
	@When("User updated Referred By in Referrals")
	public void user_updated_referred_by_in_referrals() {
	    appPage.Referrals();
	    appPage.referred_from_amount();
	}

	@When("User click on add Refer and Earn Additional Bonus button")
	public void user_click_on_add_refer_and_earn_additional_bonus_button() {
	   appPage.referralsAdd();
	}

	@Then("User Entered Referral Count and Bonus Amount")
	public void user_entered_referral_count_and_bonus_amount() {
	    appPage.referralCount();
	    appPage.bonusAmount();
	}

	@Then("User Entered Referral Count")
	public void user_entered_referral_count() {
		appPage.referralCount();
		appPage.clickbonusAmount();
	}
	@Then("User click on Delete Refer and Earn Additional Bonus button")
	public void user_click_on_delete_refer_and_earn_additional_bonus_button() {
	    appPage.deleteReferrals();
	    
	}

	@Then("User click on Referrals Submit button")
	public void user_click_on_referrals_submit_button() {
	   
	}

	@Then("User should able to see Referrals update message {string}")
	public void user_should_able_to_see_referrals_update_message(String exp) {
		Actions a = new Actions(driver);
		//scroll down a page
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		appPage.ReferralsSubmitbtn();
		String test = appPage.submitApplicationSettingMsg();
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

	@Then("User should able to see unique Referrals update message {string}")
	public void user_should_able_to_see_unique_referrals_update_message(String exp) {
		
		String test = appPage.referralErrorMsg();
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

	@When("User updated SignUp Bonus in SignUp")
	public void user_updated_sign_up_bonus_in_sign_up() {
	    appPage.SignUp();
	    appPage.signup_bonus();
	}

	@When("User click on SignUp Submit button")
	public void user_click_on_sign_up_submit_button() {
	    
	}

	@Then("User should able to see SignUp update message {string}")
	public void user_should_able_to_see_sign_up_update_message(String exp) {
		appPage.SignUpSubmitbtn();
		String test = appPage.submitApplicationSettingMsg();
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
