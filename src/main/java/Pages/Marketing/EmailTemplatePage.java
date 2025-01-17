package Pages.Marketing;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;

public class EmailTemplatePage extends DriverManager {
	
	WebDriver driver;
	
	public EmailTemplatePage() {
		PageFactory.initElements(webDriver.get(), this);
	}
	
	/* Manual */
	
	//Add Email Template
	@FindBy(xpath = "//i[@class=\"fa fa-plus\"]")
	private WebElement addEmailTemplate;
	
	@FindBy(id = "select2-marketingCategoryId-container")
	private WebElement addMarketingDropDown;
	
	@FindBy(xpath = "//li[.=\"Affiliate marketing\"]")
	private WebElement AffiliateMarketing;
	
	@FindBy(id = "title")
	private WebElement titleAddEmailTemplate;
	
	@FindBy(id = "subject")
	private WebElement subject;
	
	@FindBy(xpath = "//textarea[@dir=\"ltr\"]")
	private WebElement BodyContent;
	
	@FindBy(xpath = "//button[.=\"Submit\"]")
	private WebElement submitAddEmailTemplate;
	
	@FindBy(css = "iframe")
	private WebElement iframeElement;
	
	@FindBy(tagName = "body")
    private WebElement bodyElement;
	
	
	
	public void addEmailTemplate() {
		addEmailTemplate.click();
	}
	
	public void fillFormAddEmailTemplate() throws AWTException, InterruptedException {
		addMarketingDropDown.click();
		AffiliateMarketing.click();
		titleAddEmailTemplate.sendKeys("Testing");
		subject.sendKeys("Testing");
		Robot robot = new Robot();

        // Simulate PAGE_DOWN key press
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        Thread.sleep(3000);
		BodyContent.sendKeys("Testingggggg");
		Thread.sleep(3000);
		
	}
	
	public void addEmailTemplatebtn() throws InterruptedException {
		
		submitAddEmailTemplate.click();
		Thread.sleep(3000);
	}
	
	 public void setDriver(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	 public void enterBodyContent() throws InterruptedException {
	        // Switch to the iframe
	        driver.switchTo().frame(iframeElement);

	        // Clear and enter data into the body content
	        bodyElement.clear(); // Clear existing content, if needed
	        bodyElement.sendKeys("body content");

	        // Switch back to the default content
	        driver.switchTo().defaultContent();
	        Thread.sleep(3000);
	    }
	
	// Filter Email Template
	@FindBy(id = "listing-filter-toggle")
	private WebElement filterEmailTemplate;
	
	@FindBy(id = "search_title_name")
	private WebElement filterTitleEmailTemplate;
	
	
	
	

}