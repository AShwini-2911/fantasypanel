package stepDefinitions.DFS;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Pages.DFS.ContestPage;
import Utility.LoggerHelper;
import Utility.Util;
import io.cucumber.java.en.*;

public class ContestSteps {
	
	private WebDriver driver;
	private ContestPage ContestP;
    private static Logger log = LoggerHelper.getLogger(ContestSteps.class);  // Log4j logger instance


    // Constructor to initialize WebDriver and VideosPage
    public ContestSteps() {
        this.driver = Util.webDriver.get(); // Retrieve WebDriver from Util (ensure this method is accessible)
        ContestP = new ContestPage(); // Initialize VideosPage with the WebDriver
    }

	@Given("User click on Add Contest button")
	public void user_click_on_add_contest_button() throws InterruptedException {
		Thread.sleep(3000);
	   ContestP.clickAddContest();
	}

	@Then("User fill all the Contest details")
	public void user_fill_all_the_contest_details() throws InterruptedException {
		Thread.sleep(3000);

	  ContestP.selectContestGrp();
		Thread.sleep(3000);

	  ContestP.entryFee();
		Thread.sleep(3000);

	  ContestP.actualPrizePool();
		Thread.sleep(3000);

	  ContestP.participantMin();
		Thread.sleep(3000);

	  ContestP.participantMax();
		Thread.sleep(3000);

	 ContestP.contestType();
		Thread.sleep(3000);

		ContestP.rankMax();
		Thread.sleep(3000);

		ContestP.distributionAmount();
		Thread.sleep(3000);

		ContestP.total();
		Thread.sleep(3000); 

	}
	
	@Then("User click on Contest Submit")
	public void user_click_on_contest_submit() {
	    ContestP.addContestSubmit();
	}

	@Given("User click on View Contests button")
	public void user_click_on_view_contests_button() {
	   ContestP.viewContest();
	}

	@Then("User should able to see the Contests details")
	public void user_should_able_to_see_the_contests_details() {
	    ContestP.getViewedContestDetails();
	}
	
	@Given("User click on Update Contests button")
	public void user_click_on_update_contests_button1() {
	    ContestP.updateContest();
	}

	@Then("User update title of the Contests")
	public void user_update_title_of_the_contests() {
	    ContestP.updateEntryFee();
	}

	@Then("User click on update Contests button")
	public void user_click_on_update_contests_button() {
	    ContestP.updateContestBtn();
	}

	@Given("User Click on Filter Contests button")
	public void user_click_on_filter_contests_button() {
	   ContestP.filterContest();
	}

	@Then("User enter title in Title Contests field")
	public void user_enter_title_in_title_contests_field() {
	   ContestP.filterContestTemplateName();
	}

	@Then("User should able to filtered Contests data")
	public void user_should_able_to_filtered_contests_data() {
	    ContestP.filterContestData();
	}


	
}
