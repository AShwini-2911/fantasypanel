package Pages.GeneralSettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import Base.DriverManager;

public class SettingsPage extends DriverManager {
	
	private WebDriver driver;

	 public SettingsPage() {
			PageFactory.initElements(webDriver.get(), this);
		}
	@FindBy(id = "system_email")
	private WebElement system_email;
	
	@FindBy(id = "system_contact_no")
	private WebElement system_contact_no;
	
	public void enterSystemEmail(String Email) {
		system_email.clear();
		system_email.sendKeys(Email);
		
	}
	
	public void enterSystemContactNo(String num) {
		system_contact_no.clear();
		system_contact_no.sendKeys(num);
		
	}
	
	
	
	@FindBy(xpath = "//span[.=\"Social Media Links\"]")
	private WebElement socialMedia;
	
	@FindBy(id = "facebook")
	private WebElement Facebook;
	
	@FindBy(id = "twitter")
	private WebElement Twitter;
	
	@FindBy(id = "youtube")
	private WebElement Youtube;
	
	public void socialMedia() {
		socialMedia.click();
	}
	
	public void enterfacebookLink(String facebook) {
		Facebook.clear();
		Facebook.sendKeys(facebook);
	}
	
	public void entertwitterLink(String twitter) {
		Twitter.clear();
		Twitter.sendKeys(twitter);
	}
	
	public void enteryoutubeLink(String youtube) {
		Youtube.clear();
		Youtube.sendKeys(youtube);
	}
	
	
	@FindBy(xpath = "//span[.=\"Deposit and withdraw\"]")
	private WebElement depositeAndWithdraw;
	
	@FindBy(name = "minimum_deposit_amount")
	private WebElement minimum_deposit_amount;
	
	@FindBy(name = "maximum_deposit_amount")
	private WebElement maximum_deposit_amount;
	
	@FindBy(name = "minimum_withdrawal_amount")
	private WebElement minimum_withdrawal_amount;
	
	@FindBy(name = "maximum_withdrawal_amount")
	private WebElement maximum_withdrawal_amount;
	
	public void depositeAndWithdraw() {
		depositeAndWithdraw.click();
	}
	
	public void minimum_deposit_amount(String minde) {
		minimum_deposit_amount.clear();
		minimum_deposit_amount.sendKeys(minde);
	}
	
	public void maximum_deposit_amount(String maxDe) {
		maximum_deposit_amount.clear();
		maximum_deposit_amount.sendKeys(maxDe);
	}
	
	public void minimum_withdrawal_amount(String minWith) {
		minimum_withdrawal_amount.clear();
		minimum_withdrawal_amount.sendKeys(minWith);
	}
	
	public void maximum_withdrawal_amount(String maxWith) {
		maximum_withdrawal_amount.clear();
		maximum_withdrawal_amount.sendKeys(maxWith);
	}
	
	
	
	@FindBy(xpath = "//span[.=\"App Link\"]")
	private WebElement App_Link;
	
	@FindBy(id = "android_url")
	private WebElement android_url;
	
	@FindBy(id = "ios_url")
	private WebElement ios_url;
	
	public void App_Link() {
		App_Link.click();
	}
	public void android_url(String aurl) {
		android_url.clear();
		android_url.sendKeys(aurl);
	}
	
	public void ios_url(String iurl) {
		ios_url.clear();
		ios_url.sendKeys(iurl);
	}
	
	@FindBy(xpath = "//span[.=\"App Version\"]")
	private WebElement App_Version;
	
	@FindBy(id = "android_version")
	private WebElement android_version;
	
	@FindBy(id = "ios_version")
	private WebElement ios_version;
	
	public void App_Version() {
		App_Version.click();
	}
	
	public void   android_version(String aver) {
		android_version.clear();
		 android_version.sendKeys(aver);
		
	}
	
	public void ios_version(String iver) {
		ios_version.clear();
		ios_version.sendKeys(iver);
	}
	
	@FindBy(xpath = "(//button[.=\"Save Changes\"])[1]")
	private WebElement saveChanges1;

	@FindBy(xpath = "(//button[.=\"Save Changes\"])[2]")
	private WebElement saveChanges2;
	
	@FindBy(xpath = "(//button[.=\"Save Changes\"])[3]")
	private WebElement saveChanges3;

	@FindBy(xpath = "(//button[.=\"Save Changes\"])[4]")
	private WebElement saveChanges4;
	
	@FindBy(xpath = "(//button[.=\"Save Changes\"])[5]")
	private WebElement saveChanges5;


	@FindBy(xpath = "//p[.=\"Data Saved Successfully\"]")
	private WebElement DataSuccessMsg;
	
	public void saveChanges1() {
		saveChanges1.click();
	}
	
	public void saveChanges2() {
		saveChanges2.click();
	}
	
	public void saveChanges3() {
		saveChanges3.click();
	}
	
	public void saveChanges4() {
		saveChanges4.click();
	}
	
	public void saveChanges5() {
		saveChanges5.click();
	}
	public String dataSuccessMsg() {
		return DataSuccessMsg.getText();
	}
}
