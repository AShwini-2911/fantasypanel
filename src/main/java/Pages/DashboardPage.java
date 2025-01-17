package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;

public class DashboardPage extends DriverManager   {
	private WebDriver driver;

	 public DashboardPage() {
		 
			PageFactory.initElements(webDriver.get(), this);
		}
	 
	 @FindBy(xpath = "(//h3[@class=\"mb-1 warning\"])[1]")
	 private WebElement RegisteredUser;
	 
	 public Object registeredUser() {
		String test = RegisteredUser.getText();
		return test;
	 }
	 
	 @FindBy(xpath = "(//h3[@class=\"mb-1 warning\"])[2]")
	 private WebElement ActiveUser;
	 
	 public Object ActiveUser() {
		 String count = ActiveUser.getText();
		return count;
		 
	 }
	 
	 @FindBy(xpath = "(//h3[@class=\"mb-1 warning\"])[3]")
	 private WebElement PassiveUser;
	 public Object passiveUser() {
		 String passive = PassiveUser.getText();
		return passive;
	 }
	 
	 @FindBy(xpath = "(//h3[@class=\"mb-1 warning\"])[4]")
	 private WebElement AmountDeposited;
	 public Object amountDeposited() {
		String amount = AmountDeposited.getText();
		return amount;
		
		 
	 }
	
	

}
