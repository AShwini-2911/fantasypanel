package Pages.ContentManagement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;

public class CMSPage extends DriverManager {

	public CMSPage() {
		PageFactory.initElements(webDriver.get(), this);
	}
	
	@FindBy(xpath = "(//i[@class=\"fa fa-eye\"])[1]")
	private WebElement viewCMSPage;
	
	@FindBy(tagName = "table")
	private WebElement viewCMSDetails;
	
	@FindBy(xpath = "//a[.=\"English\"]")
	private WebElement viewCMSEnglish;
	
	@FindBy(tagName = "table")
	private WebElement viewCMSEnglishDetails;
	
	@FindBy(xpath = "//a[.=\"Hindi\"]")
	private WebElement viewCMSHindi;
	
	@FindBy(tagName = "table")
	private WebElement viewCMSHindiDetails;
	
	public void clickViewCMSPage() {
		viewCMSPage.click();

	}
	
	public String getCMSDetails() throws InterruptedException {
		Thread.sleep(5000);

		String test = viewCMSDetails.getText();
		return test;
	}
	
	public void clickCMSEnglish() throws InterruptedException {
		viewCMSEnglish.click();
		Thread.sleep(2000);

		
	}
	
	public String getCMSEnglish() throws InterruptedException {
		Thread.sleep(2000);
		String output = viewCMSEnglishDetails.getText();
		return output;
	}
	
	public void clickCMSHindi() {
		viewCMSHindi.click();
		

	}
	
	public String getCMSHindi() {
		String output1 = viewCMSHindiDetails.getText();
		return output1;
	}
	
	
	

}
