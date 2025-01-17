package Pages.DFS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;

public class ContestGroupPage  extends DriverManager{
	
	private WebDriver driver;

	 public ContestGroupPage() {
			PageFactory.initElements(webDriver.get(), this);
		}
	 
	 //add Contest Group
	 @FindBy(xpath = "//i[@class=\"fa fa-plus\"]")
	 private WebElement  AddContestGroup;
	 
	 @FindBy(id = "sequence")
	 private WebElement sequenceContentGroup;
	 
	 @FindBy(partialLinkText = "English")
	 private WebElement LangEnglish;
	 
	 @FindBy(id = "name_en")
	 private WebElement enName;
	 
	 @FindBy(id = "description_en")
	 private WebElement enDescription;
	 
	 @FindBy(partialLinkText = "Hindi")
	 private WebElement LangHindi;
	 
	 @FindBy(id = "name_hi")
	 private WebElement hnName;
	 
	 @FindBy(id = "description_hi")
	 private WebElement hnDescription;
	 
	 @FindBy(xpath = "//button[.=\"Submit\"]")
	 private WebElement addContestGroupBtn;
	 
	 public void clickAddContestGroup() {
		 AddContestGroup.click();
	 }
	 
	 public void formDetails() {
		 sequenceContentGroup.sendKeys("10");
		 LangEnglish.click();
		 enName.sendKeys("Mega");
		 enDescription.sendKeys("Mega ");
		 LangHindi.click();
		 hnName.sendKeys("प्रतियोगिता");
		 hnDescription.sendKeys("प्रतियोगिता");
	 }

	 public void addContestGroupSubmit() {
		 addContestGroupBtn.click();

	 }
	 
	 // View ContestGroup
	 
	 @FindBy(xpath = "(//i[@class=\"fa fa-eye\"])[1]")
	 private WebElement viewContestGroup;
	 
	 @FindBy(xpath = "//div[@class=\"tab-content\"]")
	 private WebElement getContestGroup;
	 
	 public void viewContestGroup() {
		 viewContestGroup.click();
		 
	 }
	 
	 public void getContestGroupDetails() {
		 String getContest = getContestGroup.getText();
		 System.out.println(getContest);
	 }
	 
	 
	 //update ContestGroup
	 @FindBy(xpath = "(//i[@class=\"fa fa-edit\"])[1]")
	 private WebElement updateContestGroup;
	 
	 @FindBy(id = "sequence")
	 private WebElement updateContestSeq;
	 
	 @FindBy(xpath = "//button[.=\"Submit\"]")
	 private WebElement submitContestGrp;
	 
	 public void updateContestGroup() {
		 updateContestGroup.click();
	 }
	 
	 public void updateContestSequence() {
		 updateContestSeq.sendKeys("12");
	 }
	 
	 public void submitContestGroup() {
		 submitContestGrp.click();
	 }
	 
	 //Filter ContestGrp
	 @FindBy(id = "listing-filter-toggle")
	 private WebElement filterContestGroup;
	 
	 @FindBy(id = "search_name")
	 private WebElement filterContestGrpName;
		 
	 @FindBy(tagName = "table")
	 private WebElement filteredContestGrp;
	 
	 public void filterContestGroup() {
		 filterContestGroup.click();
	 }
	 
	 public void filterContestGroupName() {
		 filterContestGrpName.sendKeys("High");
	 }
	 
	 public void getFilteredContestGrpData() {
		 String test = filteredContestGrp.getText();
		 System.out.println(test);
	 }

}
