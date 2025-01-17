package stepDefinitions.Marketing;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;
import Pages.Marketing.NotificationTemplatePage;
import io.cucumber.java.en.*;
import io.reactivex.rxjava3.core.Notification;


public class NotificationTemplateSteps extends DriverManager {
	
		WebDriver driver;
		
		NotificationTemplatePage NotificationTemp = new NotificationTemplatePage();
		
		public NotificationTemplateSteps() {
			PageFactory.initElements(webDriver.get(), this);
		}
		
		@Given("User click on Add Notification Template button")
		public void user_click_on_add_notification_template_button() throws InterruptedException {
		   NotificationTemp.AddNotificationTemp();
		   Thread.sleep(5000);
		}

		@Then("User fill all the Notification Template details")
		public void user_fill_all_the_notification_template_details() throws InterruptedException, AWTException {
			Thread.sleep(5000);
			
		   NotificationTemp.PrintDropDown();
		   NotificationTemp.TemplateName();
		   NotificationTemp.headerContent();
		   Thread.sleep(3000);
		   NotificationTemp.bodyContent();
		   Thread.sleep(5000);
		   Robot robot = new Robot();

	        // Simulate PAGE_DOWN key press
	        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	        NotificationTemp.image();
		}

		@Then("User click on Notification Template Submit")
		public void user_click_on_notification_template_submit() {
		   NotificationTemp.submitAddNotification();
		}
		
		@Given("User click on View Notification Template button")
		public void user_click_on_view_notification_template_button() {
		   NotificationTemp.viewNotificationTemp();
		   
		}

		@Then("User should able to see the Notification Template details")
		public void user_should_able_to_see_the_notification_template_details() {
			NotificationTemp.viewDetailsNotificationTemp();
		}

		@Given("User click on Update Notification Template button")
		public void user_click_on_update_notification_template_button1() {
		    NotificationTemp.updateNotificationTemp();
		}

		@Then("User update title of the Notification Template")
		public void user_update_title_of_the_notification_template() {
		    NotificationTemp.updateTemplateName();
		}

		@Then("User click on update Notification Template button")
		public void user_click_on_update_notification_template_button() throws AWTException {
			 Robot robot = new Robot();
	        robot.keyPress(KeyEvent.VK_PAGE_DOWN);

		   NotificationTemp.updateNotificationTempBtn();
		}
		
		@Given("User Click on Filter Notification Template button")
		public void user_click_on_filter_notification_template_button() {
		   NotificationTemp.filterNotificationTemp();
		}

		@Then("User enter title in Title Notification Template field")
		public void user_enter_title_in_title_notification_template_field() {
		   NotificationTemp.filterTemplateName();
		}

	



}
