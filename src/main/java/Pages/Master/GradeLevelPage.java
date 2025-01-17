package Pages.Master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;

public class GradeLevelPage extends DriverManager {
	

	private WebDriver driver;

	 public GradeLevelPage() {
			PageFactory.initElements(webDriver.get(), this);
		}
	 
	 //View Grade Level
	 @FindBy(xpath = "(//i[@class=\"fa fa-eye\"])[1]")
	 private WebElement viewGradeLevel;
	 
	 @FindBy(xpath = "//div[@class=\"tab-content\"]")
	 private WebElement GradeLevelDetails;
	 
	 public void clickViewGradeLevel() {
		 viewGradeLevel.click();
	 }
	 
	 public String getGradeLevelDetails() {
		String T = GradeLevelDetails.getText();
		return T;
	 }
	 
	 
	 //update Grade Level
	 @FindBy(xpath = "(//i[@class=\"fa fa-edit\"])[1]")
	 private WebElement updateGradeLevel;
	 
	 @FindBy(id = "accumulated_deposite")
	 private WebElement accumulatedDeposite;
	 
	 @FindBy(xpath = "//button[.=\"Update\"]")
	 private WebElement updateGradeLevelBtn;
	 
	 @FindBy(xpath = "//p[.=\"Data Updated Successfully\"]")
	 private WebElement updateGradeMsg;
	 
	 public void updateGradeLevel() {
		 updateGradeLevel.click();
	 }
	  
	 public void accumulatedDeposite() {
		 accumulatedDeposite.clear();
		 accumulatedDeposite.sendKeys("100000000");
	 }
	 
	 public void updateGradeLevelBtn() {
		 updateGradeLevelBtn.click();
	 }
	 
	 public String Get_update_gradeLevel() {
			return updateGradeMsg.getText();
		}
}
