package Pages.DFS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;

public class ContestPage extends DriverManager {
	private WebDriver driver;

	 public ContestPage() {
			PageFactory.initElements(webDriver.get(), this);
		}

	 //Add contest
	 @FindBy(xpath = "//i[@class=\"fa fa-plus\"]")
	 private WebElement addContest;
	 
	 @FindBy(xpath = "(//span[@class=\"select2-selection__arrow\"])[1]")
	 private WebElement ContestGrpDropdown;
	 
	 @FindBy(xpath = "//li[.=\"High Entry = High Rewards\"]")
	 private WebElement SelectContestGrp;
	 
	 @FindBy(id = "entry_fee")
	 private WebElement EntryFee;
	 
	 @FindBy(id = "actual_pool")
	 private WebElement ActualPrizePool;
	 
	 @FindBy(id = "participant_min")
	 private WebElement ParticipantMin;
	 
	 @FindBy(id = "participant_max")
	 private WebElement ParticipantMax;
	 
	 @FindBy(xpath = "(//span[@class=\"select2-selection__arrow\"])[2]")
	 private WebElement EntriesDropdown;
	 
	 @FindBy(id = "type_auto")
	 private WebElement ContestType;
	 
	 @FindBy(id = "rank_max")
	 private WebElement rankMax;
	 
	 @FindBy(id = "distribution_amount")
	 private WebElement distributionAmount;
	 
	 @FindBy(id = "total")
	 private WebElement total;
	 
	 @FindBy(xpath = "//button[.=\"Submit\"]")
	 private WebElement addContestSubmit;
	 
	 public void clickAddContest() {
		 addContest.click();
	 }
	 
	 public void selectContestGrp() {
		 ContestGrpDropdown.click();
		 SelectContestGrp.click();
		 
	 }
	 
	 public void entryFee() {
		 EntryFee.sendKeys("1000");
		 
	 }
	 
	 public void actualPrizePool() {
		 ActualPrizePool.click();
		 
	 }
	 
	 public void participantMin() {
		 ParticipantMin.sendKeys("10");
	 }
	 
	 public void participantMax() {
		 ParticipantMax.sendKeys("12");
	 }
	 
	 public void contestType() {
		 ContestType.click();
	 }
	 
	 public void rankMax() {
		 rankMax.sendKeys("2");
	 }
	 
	 public void distributionAmount() {
		 distributionAmount.sendKeys("10");
	 }
	 
	 public void total() {
		 total.click();
	 }
	 
	 public void addContestSubmit() {
		 addContestSubmit.click();
	 }
	
	 
	 //view Contest
	 @FindBy(xpath = "(//i[@class=\"fa fa-eye\"])[1]")
	 private WebElement viewContest;
	 
	 @FindBy(xpath = "//div[@class=\"tab-content\"]")
	 private WebElement getViewedContest;
	 
	 public void viewContest() {
		 viewContest.click();
	 }
	 
	 public void getViewedContestDetails() {
		 String getViewedContestdata = getViewedContest.getText();
		 System.out.println(getViewedContestdata);
	 }
	 
	 //update Contest
	 @FindBy(xpath = "(//i[@class=\"fa fa-edit\"])[1]")
	 private WebElement updateContest;
	 
	 
	 @FindBy(id = "entry_fee")
	 private WebElement updateEntryFee;
	 
	 @FindBy(xpath = "//button[.=\"Submit\"]")
	 private WebElement updateContestbtn;
	 
	 public void updateContest() {
		 updateContest.click();
	 }
	 
	 public void updateEntryFee() {
		 updateEntryFee.clear();
		 updateEntryFee.sendKeys("10");
	 }
	 
	 public void updateContestBtn() {
		 updateContestbtn.click();
	 }
	 
	 //Filter Contest
	 @FindBy(id = "listing-filter-toggle")
	 private WebElement filterContest;
	 
	 @FindBy(id = "search_name")
	 private WebElement filterContestTemplateName;
	 
	 @FindBy(tagName = "table")
	 private WebElement FilteredContest;
	 
	 public void filterContest() {
		 filterContest.click();
	 }

	 public void filterContestTemplateName() {
		 filterContestTemplateName.sendKeys("Auto Percentage");
		 
	 }
	 
	 public void filterContestData() {
		 String text = FilteredContest.getText();
		 System.out.println(text);
	 }
	 
}