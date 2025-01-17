package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Pages.LoginPage;
import Utility.Util;

import io.cucumber.java.en.*;

public class LoginSteps {
	WebDriver driver;
	LoginPage login = new LoginPage();


	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
		Assert.assertEquals(Util.getURL(), "http://skyonliners.com/demo/gammingle-web/webadmin");

	}

	@When("the user enters {string} and {string}")
	public void the_user_enters_and(String string, String string2) {
		login.enterUsername(string);
		login.enterPassword(string2);
	    
	}

	@When("clicks on the login button")
	public void clicks_on_the_login_button() {
	   login.clickLoginButton();
	}

	@Then("the user should see {string}")
	public void the_user_should_see(String expectedUrl) {
		String actualUrl = Util.getURL();
        System.out.println(actualUrl);

  //      Assert.assertEquals("The URL does not match the expected value.", expectedUrl, actualUrl);
//        DriverFactory.quitDriver();
		//Assert.assertEquals(Util.getURL(), "https://ui.cogmento.com/");

	}

	@Then("clicks on Logout button")
	public void clicks_on_logout_button() {
	    login.clickLogoutButton();
	}

}
