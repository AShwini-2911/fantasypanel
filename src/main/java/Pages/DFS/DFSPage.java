package Pages.DFS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;

public class DFSPage extends DriverManager{

 private WebDriver driver;
	 
	 public DFSPage() {
			PageFactory.initElements(webDriver.get(), this);
		}
	 
	  @FindBy(xpath = "//span[.=\"DFS\"]")
	  private WebElement DFS;

	  @FindBy(partialLinkText = "Teams")
	  private WebElement Teams;
	  
	  @FindBy(partialLinkText = "Players")
	  private WebElement Players;
	  
	  @FindBy(xpath = "//a[.=\"Contest\"]")
	  private WebElement Contest;
	  
	  @FindBy(xpath = "//span[.=\"Contest Group\"]")
	  private WebElement ContestGrp;
	  
	  @FindBy(xpath = "//a[.=\"Contest Dashboard\"]")
	  private WebElement ContestDashboard;
	  
	  @FindBy(xpath = "//span[.=\"League\"]" )
	  private WebElement League;
	  
	  @FindBy(xpath = "//span[.=\"Fixture\"]")
	  private WebElement Fixture;
	  
	  @FindBy(xpath = "//a[.=\"Completed\"]")
	  private WebElement fixtureCompleted;
	  
	  public void navigateToFixture() throws InterruptedException {
		  Fixture.click();
		  Thread.sleep(3000);
	  }
	  
	  public void navigateToCompleted() {
		  fixtureCompleted.click();
	  }
	  
	  public void clickDFS() {
		  DFS.click();
	  }
	  
	  public void clickTeams() {
		  Teams.click();
	  }
	  
	  public void clickPlayers() {
		  Players.click();
	  }
	  
	  public void clickContest() {
		  Contest.click();
	  }
	  
	  public void clickContestGroup() {
		  ContestGrp.click();
	  }
	  
	  public void clickContestDashboard() {
		  ContestDashboard.click();
	  }
	  
	  public void clickLeague() {
		  League.click();
	  }
	  
}
