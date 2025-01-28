package Pages.Leaderboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;

public class LeaderboardPage extends DriverManager {
	public LeaderboardPage() {

		PageFactory.initElements(webDriver.get(), this);
    }
	
	
	@FindBy(xpath = "//span[.=\"Leaderboard\"]")
	private WebElement leaderboard;
	
	public void navigateToLeaderboard() {
		leaderboard.click();
	}
	
	@FindBy(xpath = "//a[.=\"Depositors Leaderboard\"]")
	private WebElement depositorsLeaderboard;
	
	public void navigateToDepositorsLeaderboar() {
		depositorsLeaderboard.click();
	}
	
	@FindBy(xpath = "//a[.=\"Global Leaderboard\"]")
	private WebElement globalLeaderboard;

	public void navigateToGlobalLeaderboard() {
		globalLeaderboard.click();
	}

}
