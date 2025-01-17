package stepDefinitions.Master;



import Pages.Master.PlayerPositionPage;
import io.cucumber.java.en.*;

public class PlayerPositionSteps {
	
	
	PlayerPositionPage Player = new PlayerPositionPage();

	@Given("I click view btn of all rounder button")
	public void i_click_view_btn_of_all_rounder_button() {
	  Player.View_AllRounder();
	}

	@Then("I should see the details of all rounder")
	public void i_should_see_the_details_of_all_rounder() {
	    Player.Get_Details_ofAllRounder();
	}

	@Given("I click on update of all rounder")
	public void i_click_on_update_of_all_rounder()  {
		Player.Update_AllRounder();

	}

	@When("user update sport name")
	public void user_update_sport_name() {
	    Player.Update_AllRounder_Sport();
	}

	@When("user click on submit of sport update")
	public void user_click_on_submit_of_sport_update() {
	   Player.All();
	}

	@Given("user click on Filter button")
	public void user_click_on_filter_button() {
	   Player.Filter_PlayerPosition();
	}

	@When("user enter the title {string}")
	public void user_enter_the_title(String string) {
	    Player.Filter_Name(string);
	}


}
