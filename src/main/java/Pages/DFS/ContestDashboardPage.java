package Pages.DFS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;

public class ContestDashboardPage extends DriverManager {
	
	private WebDriver driver;

	 public ContestDashboardPage() {
			PageFactory.initElements(webDriver.get(), this);
		}
	 //Filter
	 @FindBy(id = "listing-filter-toggle")
	 private WebElement filtercontestDashboard;
	 
	 @FindBy(id = "select2-contest_league-container")
	 private WebElement filterLeauge;
	 
	 @FindBy(xpath = "//li[.=\"ICC Men's T20 WC EAP Sub-regional Qualifier A (ICCMT20WCEAPQA)\"]")
	 private WebElement filterLeaugeName;
	 
	 @FindBy(tagName = "table")
	 private WebElement getFilteredContestDash;
	 
	 public void filterContestDashboard() {
		 filtercontestDashboard.click();
	 }
	 
	 public void filterLeague() {
		 filterLeauge.click();
		 filterLeaugeName.click();
	 }
	 
	 public void getFilteredcontestDash() {
		 String data = getFilteredContestDash.getText();
		 System.out.println(data);
	 }

	 //pin
	 @FindBy(id = "1")
	 private WebElement Onepin;
	 
	 @FindBy(id = "0")
	 private WebElement Zeropin;
	 
	 
	 @FindBy(xpath = "//p[.=\"Unpinned Successfully!\"]")
	 private WebElement UnpinMessge;
	 
	 @FindBy(xpath = "//p[.=\"Pinned Successfully!\"]")
	 private WebElement pinMessage;
	 
	 public void Onepin() {
		 Onepin.click();
	 }
	 
	 public void Zeropin() {
		 Zeropin.click();
	 }
	 
//	 public String unpinnedMsg() {
//		 return UnpinMessge.getText();
//	 }
//	 
//	 public String pinnedMsg() {
//		 return pinMessage.getText();
//	 }
//	 
	 public String clickPinButton(int contestId) throws InterruptedException {
	        String message = "";
	        if (contestId == 1) {
	            Onepin.click();  // Clicking on Unpin button for ID 1
	            Thread.sleep(4000);
	            message = UnpinMessge.getText();  // Get the message after clicking
	        } else if (contestId == 0) {
	            Zeropin.click();  // Clicking on Pin button for ID 0
	            Thread.sleep(4000);
	            message = pinMessage.getText();  // Get the message after clicking
	        }
	        return message;  // Return the message displayed after clicking
	    }
}
