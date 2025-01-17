package Pages.Master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;

public class MasterPage extends DriverManager {
	
	 private WebDriver driver;
	 
	 public MasterPage() {
			PageFactory.initElements(webDriver.get(), this);
		}
	@FindBy(xpath = "//span[.=\"Master\"]")
	private WebElement Master;
	
	@FindBy(partialLinkText = "Marketing Category")
	private WebElement Marketing_Category;
	
	@FindBy(partialLinkText = "Sports")
	private WebElement Sports;
	
	@FindBy(partialLinkText = "Player Position")
	private WebElement Player_Position;
	
	@FindBy(xpath = "//span[.=\"Videos\"]")
	private WebElement Videos;
	
	@FindBy(xpath = "//span[.=\"Games\"]")
	private WebElement Games;
	
	@FindBy(xpath = "//span[.=\"Grade Level\"]")
	 private WebElement GradeLevel;
	
	 public void navigateToMasterModule() {
       Master.click();
    }
	 
	 public void navigateToMarketingCategory() {
		 Marketing_Category.click();
	 }

	 public void navigateToSportsModule() {
		 Sports.click();
	 }
	 
	 public void navigateToPlayerPositionModule() {
		 Player_Position.click();
	 }
	 
	 public void navigateToVideosModule() {
		 Videos.click();
	 }

	 public void navigateToGamesModule() {
		 Games.click();
	 }
	 
	 public void navigateToGradeLevelModule() {
		 GradeLevel.click();
	 }
	 
}
