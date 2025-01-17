package Pages.Marketing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;

public class CommunicationCampaignPage extends DriverManager {
	
	public CommunicationCampaignPage() {
		PageFactory.initElements(webDriver.get(), this);
	}
	
	/*All Devices
	
	Notification Template */
	
	@FindBy(id = "all_users")
	private WebElement All_Devices;
	
	@FindBy(id = "notification_check")
	private WebElement Notification_Temp;
	
	@FindBy(id = "select2-notification_listing-container")
	private WebElement NotificationTemplateDrop;
	
	@FindBy(xpath = "//li[.=\"Email2\"]")
	private WebElement vivekDropdown;
	
	@FindBy(id = "select2-page_listing-container")
	private WebElement MasterSelectDrop;
	
	@FindBy(xpath = "//li[.=\"ReferEarn\"]")
	private WebElement ReferEarnMaster;
	
	@FindBy(id = "sendData")
	private WebElement sendAllDevicesNoti;
	public void allUsers() {
		All_Devices.click();
	}
	
	public void NotificationTempCheckbox() {
		Notification_Temp.click();
	}
	
	public void NotificationTemplate() {
		NotificationTemplateDrop.click();
		vivekDropdown.click();
		
	}
	
	public void SelectMaster() {
		MasterSelectDrop.click();
		ReferEarnMaster.click();
		
	}
	public void SendNotificationAllDevices() {
		sendAllDevicesNoti.click();
	}
	
	/*All Devices
	
	Email Template */
	
	@FindBy(id = "email_check")
	private WebElement EmailTemp;
	
	@FindBy(id = "select2-email_listing-container")
	private WebElement EmailTemplateDrop;
	

	/* Login Activity
	  Android
	 */
	
	@FindBy(id = "login_activity")
	private WebElement loginActivity;
	
	@FindBy(id = "login_activity_android")
	private WebElement loginActivityAndroid;
	
	@FindBy(xpath = "//span[@class=\"ml-2 total-user-count\"]")
	private WebElement getTotalDevices;
	
	public void loginActivity() {
		loginActivity.click();
	}
	
	public void LoginActivityAndroid() {
		loginActivityAndroid.click();
	}
	public void getTotalDevices() {
		String test = getTotalDevices.getText();
		System.out.println(test);
	}
	
	//Sign Up Activity
	@FindBy(id = "signup_activity")
	private WebElement signUpActivity;
	
	@FindBy(id = "login_activity_android")
	private WebElement signUpAndroid;
	
	public void signUpActivity() {
		signUpActivity.click();
		
	}
	
	public void SignUpAndroid() {
		signUpAndroid.click();
	}

	// By Contest Participation
	
	@FindBy(id = "by_contest_participation")
	private WebElement by_contest_participation;
	
	@FindBy(id = "select2-contest_league-container")
	private WebElement LeagueDrop;
	
	@FindBy(xpath = "//li[.=\"Afghanistan tour of South Africa in United Arab Emirates (AFG vs SA)\"]")
	private WebElement selectLeague;
	

	@FindBy(id = "select2-matchId-container")
	private WebElement TeamsDrop;
	
	@FindBy(xpath = "//li[.=\"AFG vs SA ( 2024-09-18 17:30:00 )\"]")
	private WebElement SelectTeam;
	
	public void byContestParticipation() {
		by_contest_participation.click();
	}
	
	public void selectLeague() {
		LeagueDrop.click();
		selectLeague.click();
	}
	
	public void selectTeam() {
		TeamsDrop.click();
		SelectTeam.click();
	}
	
	
	
}
