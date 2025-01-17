package stepDefinitions.DFS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;
import Pages.DFS.DFSPage;
import io.cucumber.java.en.Given;

public class DFSSteps extends DriverManager {
	WebDriver driver;
	
	DFSPage DFSPages = new DFSPage();
	
	public DFSSteps() {
		PageFactory.initElements(webDriver.get(), this);
	}
	
	@Given("I navigate to the DFS Module")
	public void i_navigate_to_the_dfs_module() {
	  DFSPages.clickDFS();
	}

	
	@Given("I select the Teams Module")
	public void i_select_the_teams_module() {
	  DFSPages.clickTeams();
	}

	@Given("I select the Players Module")
	public void i_select_the_players_module() {
	    DFSPages.clickPlayers();
	}
	
	@Given("I select the Contest Module")
	public void i_select_the_contest_module() {
	    DFSPages.clickContest();
	}
	
	@Given("I select the Contest Group Module")
	public void i_select_the_contest_group_module() {
	   DFSPages.clickContestGroup();
	}
	
	@Given("I select the Contest Dashboard Module")
	public void i_select_the_contest_dashboard_module() {
	   DFSPages.clickContestDashboard();
	}
	
	@Given("I select the League Module")
	public void i_select_the_league_module() {
	   DFSPages.clickLeague();
	}
	
}
