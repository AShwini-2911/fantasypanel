package Pages.DFS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;

public class LeaguePage extends DriverManager {
	
	private WebDriver driver;

	 public LeaguePage() {
			PageFactory.initElements(webDriver.get(), this);
		}
	 
	 //view League
	 @FindBy(xpath = "(//i[@class=\"fa fa-eye\"])[1]")
	 private WebElement viewLeague;
	 
	 @FindBy(xpath = "//div[@class=\"tab-content\"]")
	 private WebElement getViewLeagueDeatails;
	 
	 public void viewLeague() {
		 viewLeague.click();
	 }
	 
	 public void getViewLeagueDetails() {
		 String League = getViewLeagueDeatails.getText();
		 System.out.println(League);
	 }
	 
	 //update league
	 @FindBy(xpath = "(//i[@class=\"fa fa-edit\"])[1]")
	 private WebElement updateLeague;
	 
	 @FindBy(id = "title_en")
	 private WebElement updateLeagueTitle;
	 
	 @FindBy(xpath = "//button[.=\"Update\"]")
	 private WebElement updateLeagueBtn;
	 
	 public void updateLeague() {
		 updateLeague.click();
	 }
	 
	 public void updateLeagueTitle() {
		 updateLeagueTitle.clear();
		 updateLeagueTitle.sendKeys("England tour of India");
	 }
	 
	 public void updateLeagueBtn() {
		 updateLeagueBtn.click();
	 }
	 
	 //Filter League
	 @FindBy(id = "listing-filter-toggle")
	 private WebElement leagueFilter;
	 
	 @FindBy(id = "search_title")
	 private WebElement leagueFilterName;
	 
	 @FindBy(tagName = "table")
	 private WebElement leagueFilterBtn;
	 
	 public void leagueFilter() {
		 leagueFilter.click();
	 }
	 
	 public void leagueFilterName() {
		 leagueFilterName.sendKeys("England tour of India");
	 }
	 
	 public void leagueFilterBtn() {
		 leagueFilterBtn.click();
	 }
	 

}
