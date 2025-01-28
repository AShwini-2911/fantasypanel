package Pages.Leaderboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.DriverManager;

public class globalLeaderboardPage extends DriverManager{
	
	public globalLeaderboardPage() {
		PageFactory.initElements(webDriver.get(), this);

	}
	
	//add Payout Leaderboard
	
	@FindBy(xpath = "//i[@class=\"fa fa-plus\"]")
	private WebElement addPayoutLeaderboard;
	
	public void addPayoutLeaderboard() {
		addPayoutLeaderboard.click();
	}
	
	@FindBy(id = "payout_leaderboard_type")
	private WebElement leaderboardType;
	
	public void leaderboardType() {
		Select s = new Select(leaderboardType);
		s.selectByVisibleText("Deposit Leaderboard");
	}
	
	@FindBy(id = "payout_leaderboard_start_date")
	private WebElement payout_leaderboard_start_date;
	
	@FindBy(xpath = "(//span[@aria-label=\"January 31, 2025\"])[1]")
	private WebElement dateSelect;
	
	@FindBy(xpath = "(//span[@aria-label=\"January 31, 2025\"])[2]")
	private WebElement endDateSelect;
	
	
	
	public void payout_leaderboard_start_date() {
		payout_leaderboard_start_date.click();
		dateSelect.click();
		
		
	}

	@FindBy(id = "payout_leaderboard_end_date")
	private WebElement payout_leaderboard_end_date;
	
	public void payout_leaderboard_end_date() {
		payout_leaderboard_end_date.click();
		endDateSelect.click();
	}
	
	@FindBy(id = "rank_max")
	private WebElement PayoutDataMaxRank;
	
	public void PayoutDataMaxRank() {
		PayoutDataMaxRank.sendKeys("44");
		
	}
	
	@FindBy(id = "distribution_amount")
	private WebElement payoutDatadistribution_amount;
	
	public void payoutDatadistribution_amount() {
		payoutDatadistribution_amount.sendKeys("444");
	}
	
	@FindBy(id = "total")
	private WebElement payoutDataTotal;
	
	public void payoutDataTotal() {
		payoutDataTotal.click();
	}
	
	@FindBy(xpath = "//i[@class=\"fa fa-plus fa-lg\"]")
	private WebElement addPayoutData;
	
	public void addPayoutData() {
		addPayoutData.click();
	}
	@FindBy(xpath = "//i[@class=\"fa fa-trash\"]")
	private WebElement deletePayoutData;
	
	public void deletePayoutData() {
		deletePayoutData.click();
	}
	
	@FindBy(xpath = "//button[.=\"Submit\"]")
	private WebElement addPayoutSubmit;
	
	public void addPayoutSubmit() {
		addPayoutSubmit.click();
	}
	
	
	@FindBy(xpath = "//p[@class =\"alert-message\"]")
	private WebElement addPayoutSuccessMsg;
	
	public String addPayoutSuccessMsg() {
		return addPayoutSuccessMsg.getText();
	}
	
	@FindBy(xpath = "//p[@class =\"alert-message\"]")
	private WebElement addPayoutduplicateMsg;
	
	public String addPayoutduplicateMsg() {
		return addPayoutSuccessMsg.getText();
	}
	
	//view 
	@FindBy(xpath = "(//i[@class=\"fa fa-eye\"])[7]")
	private WebElement globalLeaderboardView;
	
	public void globalLeaderboardView() {
		globalLeaderboardView.click();
	}
	
	@FindBy(tagName = "table")
	private WebElement viewedDescriptionDetails;
	
	public String viewedDescriptionDetails() {
		return viewedDescriptionDetails.getText();
	}
	
	@FindBy(xpath = "//a[.=\"Winners\"]")
	private WebElement viewWinners;
	
	public void viewWinner() {
		viewWinners.click();
	}
	
	@FindBy(tagName = "table")
	private WebElement viewedWinnersDetails;
	
	public String viewedWinnersDetails() {
		return viewedWinnersDetails.getText();
	}

	//update
	@FindBy(xpath = "(//i[@class=\"fa fa-edit\"])[1]")
	private WebElement updatePayout;
	
	public void updatePayout() {
		updatePayout.click();
	}
	
	@FindBy(xpath = "//input[@id=\"rank_max\"]")
	private WebElement updateRank;
	
	public void updateRank() {
		updateRank.sendKeys("50");
	}
	
	@FindBy(xpath = "//button[.=\"Submit\"]")
	private WebElement updatePayoutbtn;
	
	public void updatePayoutBtn() {
		updatePayoutbtn.click();
	}
	
	@FindBy(xpath = "//p[.=\"Data Updated Successfully\"]")
	private WebElement updateSuccessMsg;
	
	public String updateSuccessMsg() {
		return updateSuccessMsg.getText();
	}
	
	//filter
	@FindBy(xpath = "//i[@class=\"fa fa-filter\"]")
	private WebElement filterGlobalLeaderboard;
	
	public void filterGlobalLeaderboard() {
		filterGlobalLeaderboard.click();
	}
	
	@FindBy(id = "search_leaderboard_type")
	private WebElement filter_search_leaderboard_type;
	
	public void filter_search_leaderboard_type() {
		Select s = new Select(filter_search_leaderboard_type);
		s.selectByVisibleText("Fantasy Leaderboard");
	}
	
	
	
}
