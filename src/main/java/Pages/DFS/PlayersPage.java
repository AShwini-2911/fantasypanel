package Pages.DFS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Base.DriverManager;

public class PlayersPage extends DriverManager {
	
	private WebDriver driver;

	 public PlayersPage() {
			PageFactory.initElements(webDriver.get(), this);
		}
	 

	 //View Player
	 @FindBy(xpath = "(//i[@class=\"fa fa-eye\"])[1]")
	 private WebElement ViewPlayer;
	 
	 @FindBy(xpath = "//div[@class=\"tab-content\"]")
	 private WebElement GetPlayerdetails;
	 
	 public void clickViewPlayer() {
		 ViewPlayer.click();
	 }
	 
	 public void getPlayerDetails() {
		 String GetPlayerdetailsData = GetPlayerdetails.getText();
		 System.out.println(GetPlayerdetailsData);
		 
	 }
	 
	 //UpdatePlayer
	 @FindBy(xpath = "(//i[@class=\"fa fa-edit\"])[1]")
	 private WebElement UpdatePlayer;
	 
	 @FindBy(id = "name_en")
	 private WebElement updatePlayerName;
	 
	 @FindBy(xpath = "//button[.=\"Submit\"]")
	 private WebElement updatePlayerSubmit;
	 
	 public void updatePlayer() {
		 UpdatePlayer.click();
	 }
	 
	 public void updatePlayerName() {
		 updatePlayerName.clear();
		 updatePlayerName.sendKeys("Spencer Johnson");
	 }
	 
	 public void updatePlayerSubmit() {
		 updatePlayerSubmit.click();
	 }
	 
	 //Filter Player
	 @FindBy(id = "listing-filter-toggle")
	 private WebElement filterPlayer;
	 
	 @FindBy(id = "search_name")
	 private WebElement filterPlayerName;
	 
	 @FindBy(tagName = "table")
	 private WebElement filteredPlayerData;
	 
	 public void filterPlayer() {
		 filterPlayer.click();
	 }
	 
	 public void filterPlayerName() {
		 filterPlayerName.sendKeys("Spencer Johnson");
	 }
	 
	 public void filteredPlayerData() {
		 String getfilteredPlayerData = filteredPlayerData.getText();
		 System.out.println(getfilteredPlayerData);
	 }
}
