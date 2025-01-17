package stepDefinitions.DFS;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Pages.DFS.PlayersPage;
import Utility.LoggerHelper;
import Utility.Util;
import io.cucumber.java.en.*;

public class PlayersSteps {
	
	private WebDriver driver;
	private PlayersPage Player;
    private static Logger log = LoggerHelper.getLogger(PlayersSteps.class);  // Log4j logger instance


    // Constructor to initialize WebDriver and VideosPage
    public PlayersSteps() {
        this.driver = Util.webDriver.get(); // Retrieve WebDriver from Util (ensure this method is accessible)
        Player = new PlayersPage(); // Initialize VideosPage with the WebDriver
    }
	@Given("User click on View Players button")
	public void user_click_on_view_players_button() {
		Util.startConsoleCapture();
		 log.info("User clicked on view Players button");
	   Player.clickViewPlayer();
	}

	@Then("User should able to see the Players details")
	public void user_should_able_to_see_the_players_details() {
		Player.getPlayerDetails();
	}

	@Given("User click on Update Players button")
	public void user_click_on_update_players_button1() {
		Player.updatePlayer();
	}

	@Then("User update name of the Players")
	public void user_update_name_of_the_players() {
		Player.updatePlayerName();
	}

	@Then("User click on update Players button")
	public void user_click_on_update_players_button() {
		Player.updatePlayerSubmit();
	}

	@Given("User Click on Filter Players button")
	public void user_click_on_filter_players_button() {
		Player.filterPlayer();
	}

	@Then("User enter title in Title Players field")
	public void user_enter_title_in_title_players_field() {
		Player.filterPlayerName();
	}

	@Then("User should able to filtered Players data")
	public void user_should_able_to_filtered_players_data() {
		Player.filteredPlayerData();
	}


}
