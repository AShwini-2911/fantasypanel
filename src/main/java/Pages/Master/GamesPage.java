package Pages.Master;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;
import Utility.GamesUtil;

public class GamesPage extends DriverManager {
	
	private WebDriver driver;

	 public GamesPage() {
			PageFactory.initElements(webDriver.get(), this);
		}
	
	 //Add Games
	 @FindBy(xpath = "//i[@class=\"fa fa-plus\"]")
	 private WebElement AddGames;
	 
	 @FindBy(id = "sequence")
	 private WebElement Sequence;
	 
	 @FindBy(id = "link")
	 private WebElement Link;
	 
	 @FindBy(id = "image")
	 private WebElement imageUpload;
	 
	 @FindBy(xpath = "//a[.=\"English\"]")
	 private WebElement English;
	 
	 @FindBy(id = "name_en")
	 private WebElement nameEnglish;
	 
	 @FindBy(xpath = "//a[.=\"Hindi\"]")
	 private WebElement Hindi;
	 
	 @FindBy(id = "name_hi")
	 private WebElement nameHindi;
	 
	 @FindBy(xpath = "//button[.=\"Submit\"]")
	 private WebElement AddGamesSubmit;
	 
	 @FindBy(xpath = "//p[.=\"Data Added Successfully\"]")
	private WebElement GamesSuccessMsg;
	 
	 
	 @FindBy(xpath = "//a[.=\" Cancel\"]")
	 private WebElement AddGamesCancel;
	 
	 @FindBy(xpath = "//p[.=\"Name already exist.\"]")
	 private WebElement nameExist;
	 
	 @FindBy(xpath = "//p[.=\"The image must not be greater than 1 mb.\"]")
	 private WebElement imageSizeErrorMsg;
	 
	 //View Game
	 @FindBy(xpath = "(//i[@class=\"fa fa-eye\"])[1]")
	 private WebElement gameView;
	 
	 @FindBy(xpath = "//div[@class=\"tab-content\"]")
	 private WebElement gameDetails;
	
	 
	 //update Game
	 @FindBy(xpath = "(//i[@class=\"fa fa-edit\"])[1]")
	 private WebElement updateGame;
	 
	 @FindBy(id = "sequence")
	 private WebElement updateSequence;
	 
	 @FindBy(xpath = "//button[.=\"Submit\"]")
	 private WebElement gameupdatesubmit;
	 
	 @FindBy(xpath = "//p[.=\"Data Updated Successfully\"]")
	 private WebElement gameupdateSuccessMsg;
	 
	 
	 
	 //Filter
	 @FindBy(id = "listing-filter-toggle")
	 private WebElement gameFilter;
	 
	 @FindBy(id = "search_name")
	 private WebElement gameFilterName;
	 
	 @FindBy(tagName = "table")
	 private WebElement filteredGameDetails;
	 
	 
	 //Method
	 //Add games
	 public void clickAddGame() {
			AddGames.click();
	}
	 
	 public void enterSequence(String Seq) {
	        Sequence.sendKeys(Seq);
	        
	   }
	 public void enterLink(String link) {
		    Link.sendKeys(link);
	 }
	 public void uploadImage() {
//		 String imagePath = GamesUtil.getGameImagePath();
//	        imageUpload.sendKeys(imagePath);
		 imageUpload.sendKeys("C:\\Users\\Raj Rane\\Desktop\\Uno.jpg");
	 }
	 
	 public void uploadLargeSizeImage() {
		 imageUpload.sendKeys("E:\\Users\\Raj Rane\\Downloads\\playing-toys-concept-with-wooden-cubes-kid-toys-wooden-background-flat-lay.jpg");
	 }
	 
	 
	 
	 public void EnglishName(String EngName) {
		 English.click();
		 nameEnglish.sendKeys(EngName);
	 }
	 
	 public void HindiName(String HiName) {
		 Hindi.click();
		 nameHindi.sendKeys(HiName);
	 }
	 
	 public void AddGamesSubmit() {
		 AddGamesSubmit.click();
	 }
	 
	 public String addGamesSuccessMsg() {
		 AddGamesSubmit.click();
		 return GamesSuccessMsg.getText();
	 }
	 
	 public String HindiNameBorderColor() throws InterruptedException {
		 AddGamesSubmit.click();
		 Thread.sleep(2000);
	        return nameHindi.getCssValue("border-color");
	    }
	 
	 public void addGamesCancel() {
		 AddGamesCancel.click();
	 }
	 
	 public String addGamesExistsMsg() {
		 AddGamesSubmit.click();
		 return nameExist.getText();
	 }
	 
	 public String addGamesImageSizeMsg() throws InterruptedException {
		 AddGamesSubmit.click();
		 
		 Thread.sleep(12000);
		 return imageSizeErrorMsg.getText();
	 }
	 //view Game
	 public void ViewGamesClick() {
		 gameView.click();
	 }
	 
	 public String GetDetailsGames() {
		return gameDetails.getText();
	 }
	
	 
	//update Game
	 public void UpdateGamesClick() {
		 updateGame.click();
	 }
	 
	 public void updateGamesSequence(String Seq) {
		 updateSequence.sendKeys(Seq);
	 }
	 
	 public void updateGamesBtn() {
		 gameupdatesubmit.click();
	 }
	 
	 public String gameUpdateSuccessMsg() {
		 gameupdatesubmit.click();
		 return gameupdateSuccessMsg.getText();
	 }
		
	 //filter Game
	 public void filterGame() {
		 gameFilter.click();
	 }
	 
	 public void filterGameName(String FGName) {
		 gameFilterName.sendKeys(FGName);
	 }
	 
	 public String getFilteredGameDetails() {
		 return filteredGameDetails.getText();
	 }
}
