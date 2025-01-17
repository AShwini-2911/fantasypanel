package stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Pages.DashboardPage;
import Pages.Master.VideosPage;
import Utility.LoggerHelper;
import Utility.Util;
import io.cucumber.java.en.When;

public class DashboardSteps {
	private WebDriver driver;
    DashboardPage dashboard;
    private static Logger log = LoggerHelper.getLogger(DashboardSteps.class);  // Log4j logger instance


    // Constructor to initialize WebDriver and VideosPage
    public DashboardSteps() {
        this.driver = Util.webDriver.get(); // Retrieve WebDriver from Util (ensure this method is accessible)
        dashboard = new DashboardPage(); // Initialize VideosPage with the WebDriver
    }

	@When("the user gets the registered user count")
	public void the_user_gets_the_registered_user_count() {
		// Util.startConsoleCapture();

	    System.out.println("User get registered user count");
	    Object test = dashboard.registeredUser();
	    System.out.println(test);
	    
	    String consoleOutput0 = Util.stopConsoleCapture();
		   if(!consoleOutput0.isEmpty()) {
			   log.info("Console Output: " +consoleOutput0);
		   }
		   
	       Util.clearConsoleOutput();
	    
	   
	   
	}

	@When("the user gets the active users count")
	public void the_user_gets_the_active_users_count() {
		 Util.startConsoleCapture();

	    System.out.println("User get Active user count");
	   Object active = dashboard.ActiveUser();
	   System.out.println(active);
	   
	   String consoleOutput1 = Util.stopConsoleCapture();
	   if(!consoleOutput1.isEmpty()) {
		   log.info("Console Output: " +consoleOutput1);
	   }
	   
       Util.clearConsoleOutput();
	    
	}

	@When("the user gets the passive users count")
	public void the_user_gets_the_passive_users_count() {
		 Util.startConsoleCapture();

	    System.out.println("User get Passive user count");
	   Object passive = dashboard.passiveUser();
	   System.out.println(passive);
	   
	   String consoleOutput = Util.stopConsoleCapture();
	   if(!consoleOutput.isEmpty()) {
		   log.info("Console Output: " +consoleOutput);
	   }
	   
       Util.clearConsoleOutput();
	    
	}

	@When("the user gets the amount deposited users count")
	public void the_user_gets_the_amount_deposited_users_count() {
		 Util.startConsoleCapture();

	    System.out.println("User get amount deposited user count");
	   Object amount = dashboard.amountDeposited();
	   System.out.println(amount);
	   
	   String consoleOutput2 = Util.stopConsoleCapture();
	   if(!consoleOutput2.isEmpty()) {
		   log.info("Console Output: " +consoleOutput2);
	   }
	   
       Util.clearConsoleOutput();
	   
	}
}
