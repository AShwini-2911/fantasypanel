package Pages.GeneralSettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;

public class ApplicationSettingsPage extends DriverManager{

	private WebDriver driver;

	 public ApplicationSettingsPage() {
			PageFactory.initElements(webDriver.get(), this);
		}
	 
	 //Feeds
	 @FindBy(id = "text1")
	 private WebElement FeedText;
	 
	 @FindBy(xpath = "(//button[.=\"Submit\"])[1]")
	 private WebElement FeedSubmit;
	 
	 @FindBy(xpath = "//p[.=\"Data Saved Successfully\"]")
	 private WebElement submitApplicationSettingMsg;
	 
	 public void FeedText() {
		 FeedText.clear();
		 FeedText.sendKeys("Text1");
		 
	 }
	 
	 public void FeedSubmitbtn() {
		 FeedSubmit.click();
	 }
	 
	 public String submitApplicationSettingMsg() {
		 return submitApplicationSettingMsg.getText();
	 }
	
	 
	 //Runs
	 @FindBy(partialLinkText = "Runs")
	 private WebElement runsClick;
	 
	 @FindBy(name = "activate_spin_on")
	 private WebElement activate_spin_on;
	 
	 @FindBy(xpath = "(//button[.=\"Submit\"])[2]")
	 private WebElement RunsSubmit;
	 
	 public void runsClick() {
		 runsClick.click();
	 }
	 
	 public void activate_spin_on() {
		 activate_spin_on.clear();
		 activate_spin_on.sendKeys("1500");
	 }
	 
	 public void RunsSubmitbtn() {
		 RunsSubmit.click();
	 }
	 
	 
	 //PlayMore Multiplier
	 @FindBy(partialLinkText = "PlayMore Multiplier")
	 private WebElement PlayMoreMultiplier;
	 
	 @FindBy(id = "direct_deposit_multiplier")
	 private WebElement direct_deposit_multiplier;
	 
	 @FindBy(xpath = "(//button[.=\"Submit\"])[3]")
	 private WebElement PlayMoreMultiplierSubmit;
	 
	 public void PlayMoreMultiplier() {
		 PlayMoreMultiplier.click();
	 }
	 
	 public void direct_deposit_multiplier() {
		 direct_deposit_multiplier.clear();
		 direct_deposit_multiplier.sendKeys("1");
	 }
	 
	 public void PlayMoreMultiplierSubmitbtn() {
		 PlayMoreMultiplierSubmit.click();
	 }
	 
	 
	 //Referrals
	 @FindBy(partialLinkText = "Referrals")
	 private WebElement Referrals;
	 
	 @FindBy(id = "referred_from_amount")
	 private WebElement referred_from_amount;
	 
	 @FindBy(xpath = "//i[@class=\"fa fa-plus fa-lg\"]")
	 private WebElement referralsAdd;
	 
	 @FindBy(xpath = "(//input[@id=\"refer_friend\"])[5]")
	 private WebElement referralCount;
	 
	 @FindBy(xpath = "(//input[@id=\"get_amount\"])[5]")
	 private WebElement bonusAmount;
	 
	 @FindBy(xpath = "(//i[@class=\"fa fa-trash\"])[1]")
	 private WebElement deleteReferrals;
	 
	 @FindBy(xpath = "//button[@onclick=\"submitForm('referralsForm','post')\"]")
	 private WebElement ReferralsSubmit;
	 
	 @FindBy(xpath = "//p[@class=\"alert-message\"]")
	 private WebElement referralErrorMsg;
	 
	 public void Referrals() {
		 Referrals.click();
	 }
	 
	 public void referred_from_amount() {
		 referred_from_amount.clear();
		 referred_from_amount.sendKeys("4");
	 }
	 
	 public void referralsAdd() {
		 referralsAdd.click();
	 }
	 
	 public void referralCount() {
		
		 referralCount.sendKeys("100");
	 }
	 
	 public void clickbonusAmount() {
			
		 bonusAmount.sendKeys("");
	 }
	 
	 public void deleteReferrals() {
		 deleteReferrals.click();
	 }
	 
	 public void bonusAmount() {
		 bonusAmount.sendKeys("101");
	 }
	 
	 public void ReferralsSubmitbtn() {
		 ReferralsSubmit.click();
	 }
	 
	 public String referralErrorMsg() {
		 return referralErrorMsg.getText();
	 }
	 //SignUp
	 @FindBy(partialLinkText = "SignUp")
	 private WebElement SignUp;
	 
	 @FindBy(id = "signup_bonus")
	 private WebElement signup_bonus;
	 
	 @FindBy(xpath = "(//button[.=\"Submit\"])[4]")
	 private WebElement SignUpSubmit;
	 
	 public void SignUp() {
		 SignUp.click();
	 }
	 
	 public void signup_bonus() {
		 signup_bonus.clear();
		 signup_bonus.sendKeys("3");
	 }
	 
	 public void SignUpSubmitbtn() {
		 SignUpSubmit.click();
	 }
	 
}
