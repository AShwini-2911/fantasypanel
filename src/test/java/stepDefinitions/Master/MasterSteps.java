package stepDefinitions.Master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Pages.LoginPage;
import Pages.Master.MasterPage;
import io.cucumber.java.en.*;

public class MasterSteps extends LoginPage{

	WebDriver driver;
	
	MasterPage MasterPages = new MasterPage();
	
	public MasterSteps() {
		PageFactory.initElements(webDriver.get(), this);
	}
	
	@Given("I am logged into the application")
	public void i_am_logged_into_the_application() {
		
		
	}

	@And("I navigate to the Master Module")
	public void i_navigate_to_the_master_module() {
		
	    	MasterPages.navigateToMasterModule();
	
	}

	@And("I select the MarketingCategory Module")
	public void i_select_the_marketing_category_module() {
		  MasterPages.navigateToMarketingCategory();
	   
	}
	
	@Given("I select the Sports Module")
	public void i_select_the_sports_module() {
	      MasterPages.navigateToSportsModule();
	}

	@Given("I select the PlayerPosion Module")
	public void i_select_the_player_posion_module() {
	    MasterPages.navigateToPlayerPositionModule();
	}
	
	@Given("I select the Videos Module")
	public void i_select_the_videos_module() {
	    MasterPages.navigateToVideosModule();
	}
	
	@Given("I select the Games Module")
	public void i_select_the_games_module() {
	    MasterPages.navigateToGamesModule();
	}
	
	@Given("I select the Grade Level Module")
	public void i_select_the_grade_level_module() {
	    MasterPages.navigateToGradeLevelModule();
	}
	
}
