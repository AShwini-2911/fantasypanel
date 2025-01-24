package Pages.Leaderboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;

public class DepositorsLeaderboardPage extends DriverManager{
	
	public DepositorsLeaderboardPage() {
		PageFactory.initElements(webDriver.get(), this);
	}
	
	@FindBy(xpath = "//i[@class=\"fa fa-filter\"]")
	private WebElement filterDepositorsLeaderboard;
	
	public void clickFilterDepositorsLeaderboard() {
		filterDepositorsLeaderboard.click();
	}
	
	@FindBy(id = "search_username")
	private WebElement filterDepositorsName;
	
	public void filterDepositorsName() {
		filterDepositorsName.sendKeys("SDT");
	}
	
	@FindBy(id = "search_phone")
	private WebElement filterDepositorsMobileNo;
	
	public void filterDepositorsMobileNo() {
		filterDepositorsMobileNo.sendKeys("7977586379");
	}
	
	@FindBy(tagName = "table")
	private WebElement filteredNameData;
	
	public String filteredNameData() {
		return filteredNameData.getText();
	}
	
	@FindBy(id = "date_range_picker")
	private WebElement dateRangeFilter;
	
	public void clickDateRangeFilter() {
		dateRangeFilter.click();
	}
	
	@FindBy(xpath = "(//td[.=\"24\"])[1]")
	private WebElement selectdate;
	
	public void selectDate() {
		selectdate.click();
	}
	
	@FindBy(xpath = "//button[.=\"Apply\"]")
	public WebElement dateApplybtn;
	
	public void dateApplybtn() {
		dateApplybtn.click();
	}
	@FindBy(xpath = "//a[.=\"SDT\"]")
	private WebElement clickNameDepositor; 
	public void clickNameDepositor() {
		clickNameDepositor.click();
	}
	@FindBy(xpath = "(//div[@class=\"table-responsive\"])[1]/table")
	private WebElement accountVerificationData;
	
	public String accountVerificationData() {
		return accountVerificationData.getText();
	}
	
	@FindBy(xpath = "(//div[@class=\"table-responsive\"])[2]/table")
	private WebElement basicDetailsData;
	
	public String basicDetailsData() {
		return basicDetailsData.getText();
	}
	
	@FindBy(xpath = "(//div[@class=\"table-responsive\"])[3]/table")
	private WebElement kycData;
	
	public String kycData() {
		return kycData.getText();
	}
	

}
