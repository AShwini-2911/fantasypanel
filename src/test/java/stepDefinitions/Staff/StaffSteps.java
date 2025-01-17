package stepDefinitions.Staff;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Pages.Staff.StaffPage;
import Utility.LoggerHelper;
import Utility.Util;
import io.cucumber.java.en.Given;

public class StaffSteps {
	
	private WebDriver driver;
    StaffPage staff;
    private static Logger log = LoggerHelper.getLogger(StaffSteps.class);

    // Constructor to initialize WebDriver and UserManagementPage
    public StaffSteps() {
        this.driver = Util.webDriver.get(); // Retrieve WebDriver from Util
        staff	= new StaffPage(); // Initialize UserManagementPage
    }
	
	@Given("I navigate to the Staff Module")
	public void i_navigate_to_the_staff_module() {
        Util.startConsoleCapture();

	   staff.navigateToStaff();
	   
	   
	}

	@Given("I select the Manage Staff Module")
	public void i_select_the_manage_staff_module() {
	  
		staff.navigateToManageStaff();
	}

}
