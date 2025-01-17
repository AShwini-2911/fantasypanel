package Pages;






import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.DriverManager;

public class LoginPage extends DriverManager {

	 private WebDriver driver;
	 
	 
	 public LoginPage() {
			PageFactory.initElements(webDriver.get(), this);
		}
	 @FindBy(name = "email")
	 private WebElement usernameField;
	 
	 @FindBy(id = "password")
	 private WebElement passwordField;
	 
	 @FindBy(xpath = "//button[.=\"Login\"]")
	 private WebElement loginButton;

	 @FindBy(xpath = "//i[@class=\"fa fa-power-off fa-lg\"]")
	 private WebElement logoutButton;

	//method	 
	 public void enterUsername(String username) {
	        usernameField.sendKeys(username);
	  }
	 
	 public void enterPassword(String password) {
		 WebDriverWait wait = new WebDriverWait(webDriver.get(), Duration.ofSeconds(10));
	        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(this.passwordField));

	        passwordField.sendKeys(password);
	    }

	 public void clickLoginButton() {
		 WebDriverWait wait = new WebDriverWait(webDriver.get(), Duration.ofSeconds(10));
	        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(this.loginButton));
	        loginButton.click();
	    }
	 
	 public void clickLogoutButton() {
	        logoutButton.click();
	    }
	 
	 public String getCurrentUrl() {
	        return driver.getCurrentUrl();
	    }
}


