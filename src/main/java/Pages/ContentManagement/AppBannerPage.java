package Pages.ContentManagement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;

public class AppBannerPage extends DriverManager {
	
	public AppBannerPage() {
		PageFactory.initElements(webDriver.get(), this);
	}

	//view App Banner
	@FindBy(xpath = "(//i[@class=\"fa fa-eye\"])[1]")
	private WebElement viewAppBanner;
	
	@FindBy(tagName = "table")
	private WebElement viewAppBannerDetails;
	
	public void viewAppBanner() {
		viewAppBanner.click();
	}
	
	public String viewAppBannerDetails() throws InterruptedException {
		Thread.sleep(5000);
		String test = viewAppBannerDetails.getText();
		return test;
	}
	
	//filter App Banner
	@FindBy(id = "listing-filter-toggle")
	private WebElement filterAppBanner;
	
	@FindBy(id = "search_title")
	private WebElement filterTitleAppBanner;
	
	@FindBy(tagName = "table")
	private WebElement filterAppBannerData;
	
	public void filterAppBanner() {
		filterAppBanner.click();
	}
	
	public void filterTitleAppBanner() {
		filterTitleAppBanner.sendKeys("Test");
	}
	
	public String filterAppBannerDetails() throws InterruptedException {
		Thread.sleep(5000);
		String print = filterAppBannerData.getText();
		return print;
	}
	
	//update App Banner
	@FindBy(xpath = "(//i[@class=\"fa fa-edit\"])[1]")
	private WebElement updateAppBanner;
	
	@FindBy(id = "title")
	private WebElement updateTitleAppBanner;
	
	@FindBy(xpath = "//button[.=\"Submit\"]")
	private WebElement updateSubmitAppBanner;
	
	public void updateAppBanner() {
		updateAppBanner.click();
	}
	
	public void updateTitleAppBanner() {
		updateTitleAppBanner.clear();
		updateTitleAppBanner.sendKeys("Test 1");
	}
	
	public void updateBtnAppBanner() {
		updateSubmitAppBanner.click();
	}
	
	//add App Banner
	@FindBy(xpath = "//i[@class=\"fa fa-plus\"]")
	private WebElement addAppBanner;
	
	@FindBy(id = "title")
	private WebElement addTitleAppBanner;
	
	@FindBy(id = "target_link")
	private WebElement addLinkAppBanner;
	
	@FindBy(id = "image")
	private WebElement imageAppBanner;
	
	String imagepath = "D:\\automation\\practice\\Images\\Uno.jpg";

	@FindBy(xpath = "//button[.=\"Submit\"]")
	private WebElement addAppBannerSubmit;
	
	public void addAppBanner() {
		addAppBanner.click();
	}
	
	public void addTitleAppBanner() {
		addTitleAppBanner.sendKeys("Testing");
	}
	
	public void addLinkAppBanner() {
		addLinkAppBanner.sendKeys("http://skyonliners.com/demo/gammingle-web/webadmin/promo_banner");
		
	}
	
	public void ImageAppBanner() {
		imageAppBanner.sendKeys(imagepath);
	}
	
	public void addAppBannerSubmit() {
		addAppBannerSubmit.click();
		
	}

	
}
