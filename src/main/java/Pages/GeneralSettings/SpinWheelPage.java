package Pages.GeneralSettings;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;

public class SpinWheelPage extends DriverManager{
	
	public SpinWheelPage() {

		PageFactory.initElements(webDriver.get(), this);
    }
	
	@FindBy(xpath = "(//i[@class=\"fa fa-eye\"])[1]")
	private WebElement viewSpinWheel;
	
	@FindBy(tagName = "table")
	private WebElement getSpinWheeldetails;
	
	public void viewSpinWheel() {
		viewSpinWheel.click();
	}
	
	public String getSpinWheelDetails() {
		return getSpinWheeldetails.getText();
	}
	
	//update Spin Wheel
	@FindBy(xpath = "(//i[@class=\"fa fa-edit\"])[1]")
	private WebElement updateSpinWheel;
	
	@FindBy(id = "prize")
	private WebElement prize;
	
	@FindBy(xpath = "//button[.=\"Update\"]")
	private WebElement spinWheelUpdate;
	
	@FindBy(xpath = "//p[.=\" Data Updated Successfully\"]")
	private WebElement updateSuccessmsgSpinWheel;
	
	public void updateSpinWheel() {
		updateSpinWheel.click();
	}
	
	public void prizeUpdate() {
		prize.clear();
		prize.sendKeys("0");
		
	}
	
	public void spinWheelUpdateBtn() {
		spinWheelUpdate.click();
	}
	
	public String updateSpinWheelSmsg() {
		return updateSuccessmsgSpinWheel.getText();
	}
	
	public void clearPrize() {
		prize.clear();

	}
	
	public String prizeColor() throws InterruptedException {
		
		 Thread.sleep(2000);
	     return prize.getCssValue("border-color");
	    }
	
	

}
