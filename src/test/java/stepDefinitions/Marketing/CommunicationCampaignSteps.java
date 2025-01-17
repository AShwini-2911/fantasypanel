package stepDefinitions.Marketing;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;
import Pages.Marketing.CommunicationCampaignPage;
import io.cucumber.java.en.*;

public class CommunicationCampaignSteps extends DriverManager {
	
	WebDriver driver;
	
	

	CommunicationCampaignPage commCamp = new CommunicationCampaignPage(); 
	public CommunicationCampaignSteps() {
         PageFactory.initElements(webDriver.get(), this);
	}
	
	

	@Given("user click on All device")
	public void user_click_on_all_device() throws AWTException, InterruptedException {
	   commCamp.allUsers();
	   Thread.sleep(5000);
	   Robot robot = new Robot();

	    
	    robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	   
	}
	
	

	@When("user select Noification template")
	public void user_select_noification_template() throws AWTException, InterruptedException {
		Robot robot = new Robot();

	    
	    robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(5000);
		commCamp.NotificationTempCheckbox();
		commCamp.NotificationTemplate();
		commCamp.SelectMaster();
		Thread.sleep(3000);
	}

	@When("user click on Send All Devices for Notification Template")
	public void user_click_on_send_all_devices_for_notification_template() throws InterruptedException {
	    commCamp.SendNotificationAllDevices();
	    Thread.sleep(3000);

	}
	
	@Given("user click on Login Activity")
	public void user_click_on_login_activity() {
	    commCamp.loginActivity();
	}

	@When("user selct android Device")
	public void user_selct_android_device() throws InterruptedException {
	   commCamp.LoginActivityAndroid();
	   Thread.sleep(3000);
	}

	@When("user get the total num of devices")
	public void user_get_the_total_num_of_devices() {
	    commCamp.getTotalDevices();
	}


	@Given("user click on Sign Up activity")
	public void user_click_on_sign_up_activity() {
	  commCamp.signUpActivity();
	}

	@Then("user click on android")
	public void user_click_on_android() {
	    commCamp.SignUpAndroid();
	}


	//By Contest Participation
	@Given("user click on By Contest Participation")
	public void user_click_on_by_contest_participation() {
		commCamp.byContestParticipation();
	   
	}

	@When("user select League")
	public void user_select_league() {
	   commCamp.selectLeague();
	}

	@When("user select Teams")
	public void user_select_teams() throws InterruptedException {
	   commCamp.selectTeam();
	   Thread.sleep(3000);
	}

	

}
