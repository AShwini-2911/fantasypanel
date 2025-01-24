package stepDefinitions.Leaderboard;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Base.DriverManager;
import Pages.Leaderboard.LeaderboardPage;
import Utility.LoggerHelper;
import Utility.Util;
import io.cucumber.java.en.Given;

public class LeaderboardSteps extends DriverManager {
	
	private WebDriver driver;
	LeaderboardPage leaderboard;
	
	
    private static Logger log = LoggerHelper.getLogger(LeaderboardSteps.class); 
    
    public LeaderboardSteps() {
        this.driver = Util.webDriver.get(); // Retrieve WebDriver from Util
       leaderboard = new LeaderboardPage(); // Initialize UserManagementPage     
        
    }
	
    @Given("User navigate to the Leaderboard Module")
    public void user_navigate_to_the_leaderboard_module() {
        leaderboard.navigateToLeaderboard();
    }

    @Given("User navigate to the Depositors Leaderboard Module")
    public void user_navigate_to_the_depositors_leaderboard_module() {
       leaderboard.navigateToDepositorsLeaderboar();
    }
    

}
