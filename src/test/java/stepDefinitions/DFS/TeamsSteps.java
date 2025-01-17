package stepDefinitions.DFS;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Pages.DFS.TeamsPage;
import Utility.LoggerHelper;
import Utility.Util;
import io.cucumber.java.en.*;

public class TeamsSteps {
	
	private WebDriver driver;
	private TeamsPage TP;
    private static Logger log = LoggerHelper.getLogger(TeamsSteps.class);  // Log4j logger instance


    // Constructor to initialize WebDriver and VideosPage
    public TeamsSteps() {
        this.driver = Util.webDriver.get(); // Retrieve WebDriver from Util (ensure this method is accessible)
        TP = new TeamsPage(); // Initialize VideosPage with the WebDriver
    }
	
	
	@Given("User click on View Teams button")
	public void user_click_on_view_teams_button() {
		Util.startConsoleCapture();
		 log.info("User clicked on View Teams button");
	    TP.clickViewTeam();
	}

	@Then("User should able to see the Teams details")
	public void user_should_able_to_see_the_teams_details() {
	    TP.getViewTeamDetail();
	}

	@Given("User click on Update Teams button")
	public void user_click_on_update_teams_button1() {
	    TP.clickUpdateTeam();
	}

	@Then("User update title of the Teams")
	public void user_update_title_of_the_teams() {
	    TP.updateTeamTitle();
	}

	@Then("User click on update Teams button")
	public void user_click_on_update_teams_button() {
	    TP.updateTeamSubmit();
	}

	@Given("User Click on Filter Teams button")
	public void user_click_on_filter_teams_button() {
	    TP.clickFilterTeam();
	}

	@Then("User enter title in Title Teams field")
	public void user_enter_title_in_title_teams_field() {
	    TP.filterTeamName();
	}

	@Then("User should able to filtered Teams data")
	public void user_should_able_to_filtered_teams_data() {
	   TP.getFilteredTeamData();
	}


}
