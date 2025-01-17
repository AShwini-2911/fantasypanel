package Pages.DFS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;

public class TeamsPage extends DriverManager {
	

	private WebDriver driver;

	 public TeamsPage() {
			PageFactory.initElements(webDriver.get(), this);
		}
	 
	 //View Team
	 @FindBy(xpath = "(//i[@class=\"fa fa-eye\"])[1]")
	 private WebElement viewTeam;
	 
	 @FindBy(xpath = "//div[@class=\"tab-content\"]")
	 private WebElement viewTeamDetails;
	 
	 public void clickViewTeam() {
		 viewTeam.click();
	 }
	 
	 public void getViewTeamDetail() {
		 String team = viewTeamDetails.getText();
		 System.out.println(team);
	 }
	 
	 
	 //update Team
	 @FindBy(xpath = "(//i[@class=\"fa fa-edit\"])[1]")
	 private WebElement updateTeam;
	 
	 @FindBy(id = "title_en")
	 private WebElement updateTitleTeam;
	 
	 @FindBy(xpath = "//button[.=\"Submit\"]")
	 private WebElement submitUpdate;
	 
	 public void clickUpdateTeam() {
		 updateTeam.click();
	 }
	 
	 public void updateTeamTitle() {
		 updateTitleTeam.clear();
		 updateTitleTeam.sendKeys("South Africa Women");
	 }
	 
	 public void updateTeamSubmit() {
		 
		submitUpdate.click();
	 }
	 
	 
	 //Filter Team
	 @FindBy(id = "listing-filter-toggle")
	 private WebElement FilterTeam;
	 
	 @FindBy(id = "search_team_name")
	 private WebElement FilterteamName;
	 
	 @FindBy(tagName = "table")
	 private WebElement getFilteredTeam;
	 
	 public void clickFilterTeam() {
		 FilterTeam.click();
	 }
	 
	 public void filterTeamName() {
		 FilterteamName.sendKeys("South Africa Women");
	 }
	 
	 public void getFilteredTeamData() {
		String getFilteredTeamData = getFilteredTeam.getText();
		System.out.println(getFilteredTeamData);
	 }
	 
}
