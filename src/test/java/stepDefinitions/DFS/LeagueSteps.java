package stepDefinitions.DFS;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Pages.DFS.LeaguePage;
import Utility.LoggerHelper;
import Utility.Util;
import io.cucumber.java.en.*;

public class LeagueSteps {
	private WebDriver driver;
	private LeaguePage LeagueP;
    private static Logger log = LoggerHelper.getLogger(LeagueSteps.class);  // Log4j logger instance


    // Constructor to initialize WebDriver and VideosPage
    public LeagueSteps() {
        this.driver = Util.webDriver.get(); // Retrieve WebDriver from Util (ensure this method is accessible)
        LeagueP = new LeaguePage(); // Initialize VideosPage with the WebDriver
    }
    
    @Given("User click on View League button")
    public void user_click_on_view_league_button() {
        LeagueP.viewLeague();
    }

    @Then("User should able to see the League details")
    public void user_should_able_to_see_the_league_details() {
        LeagueP.getViewLeagueDetails();
    }

    @Given("User click on Update League button")
    public void user_click_on_update_league_button1() {
      
    	LeagueP.updateLeague();
    }

    @Then("User update title of the League")
    public void user_update_title_of_the_league() {
        LeagueP.updateLeagueTitle();
    }

    @Then("User click on update League button")
    public void user_click_on_update_league_button() {
        LeagueP.updateLeagueBtn();
    }

    @Given("User Click on Filter League button")
    public void user_click_on_filter_league_button() {
        LeagueP.leagueFilter();
    }

    @Then("User enter title in Title League field")
    public void user_enter_title_in_title_league_field() {
        LeagueP.leagueFilterName();
    }

    @Then("User should able to filtered League data")
    public void user_should_able_to_filtered_league_data() {
        LeagueP.leagueFilterBtn();
    }

    
    

}
