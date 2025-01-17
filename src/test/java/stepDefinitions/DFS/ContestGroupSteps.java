package stepDefinitions.DFS;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Pages.DFS.ContestGroupPage;
import Utility.LoggerHelper;
import Utility.Util;
import io.cucumber.java.en.*;

public class ContestGroupSteps {

	private WebDriver driver;
	private ContestGroupPage CGP;
    private static Logger log = LoggerHelper.getLogger(ContestGroupSteps.class);  // Log4j logger instance


    // Constructor to initialize WebDriver and VideosPage
    public ContestGroupSteps() {
        this.driver = Util.webDriver.get(); // Retrieve WebDriver from Util (ensure this method is accessible)
        CGP = new ContestGroupPage(); // Initialize VideosPage with the WebDriver
    }
    
    @Given("User click on Add Contest Group button")
    public void user_click_on_add_contest_group_button() {
        CGP.clickAddContestGroup();
    }

    @Then("User fill all the Contest Group details")
    public void user_fill_all_the_contest_group_details() {
       CGP.formDetails();
    }

    @Then("User click on Contest Group Submit")
    public void user_click_on_contest_group_submit() {
       CGP.addContestGroupSubmit();
    }
    
    @Given("User click on View Contest Group button")
    public void user_click_on_view_contest_group_button() {
        CGP.viewContestGroup();
    }

    @Then("User should able to see the Contest Group details")
    public void user_should_able_to_see_the_contest_group_details() {
       CGP.getContestGroupDetails();
    }

    @Given("User click on Update Contest Group button")
    public void user_click_on_update_contest_group_button1() {
        CGP.updateContestGroup();
    }

    @Then("User update title of the Contest Group")
    public void user_update_title_of_the_contest_group() {
        CGP.updateContestSequence();
    }

    @Then("User click on update Contest Group button")
    public void user_click_on_update_contest_group_button() {
        CGP.submitContestGroup();
    }

    @Given("User Click on Filter Contest Group button")
    public void user_click_on_filter_contest_group_button() {
        CGP.filterContestGroup();
    }

    @Then("User enter title in Title Contest Group field")
    public void user_enter_title_in_title_contest_group_field() {
        CGP.filterContestGroupName();
    }

    @Then("User should able to filtered Contest Group data")
    public void user_should_able_to_filtered_contest_group_data() {
        CGP.getFilteredContestGrpData();
    }


}
