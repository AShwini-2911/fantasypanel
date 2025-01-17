package Pages.ContentManagement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;

public class PromoBannerPage extends DriverManager {
	
	public PromoBannerPage() {
		PageFactory.initElements(webDriver.get(), this);
	}
	
	//view Promo Banner 
	@FindBy(xpath = "(//i[@class=\"fa fa-eye\"])[1]")
	private WebElement viewPromoBanner;
	
	@FindBy(xpath = "//div[@class=\"card-content\"]")
	private WebElement viewPromoBannerDetails;
	
	public void viewPromoBanner() {
		viewPromoBanner.click();
	}
	
	public String viewPromoBannerDetails() throws InterruptedException {
		Thread.sleep(5000);
		String test = viewPromoBannerDetails.getText();
		return test;
	}
	
	//filter Promo Banner
	@FindBy(id = "listing-filter-toggle")
	private WebElement filterPromoBanner;
	
	@FindBy(id = "search_title")
	private WebElement filterTitlePromoBanner;
	
	@FindBy(tagName = "table")
	private WebElement filterPromoBannerdetails;
	
	
	public void filterPromoBanner() {
		filterPromoBanner.click();
	}
	
	public void filterTitlePromoBanner() {
		filterTitlePromoBanner.sendKeys("Test Banner");
	}
	
	public String filterPromoBannerDetails() throws InterruptedException {
		Thread.sleep(5000);
		String print = filterPromoBannerdetails.getText();
		return print;
	}
	
	//update Promo Banner
	@FindBy(xpath = "(//i[@class=\"fa fa-edit\"])[1]")
	private WebElement updatePromoBanner;
	
	@FindBy(id = "title")
	private WebElement updateTitlePromoBanner;
	
	@FindBy(xpath = "//button[.=\"Submit\"]")
	private WebElement updatebtnPromoBanner;
	
	public void updatePromoBanner() {
		updatePromoBanner.click();
	}
	
	public void updateTitlePromoBanner() {
		updateTitlePromoBanner.clear();
		updateTitlePromoBanner.sendKeys("Test");
	}
	
	public void updateBtnPromoBanner() {
		updatebtnPromoBanner.click();
	}

	//add Promo Banner
	@FindBy(xpath = "//i[@class=\"fa fa-plus\"]")
	private WebElement addPromoBanner;
	
	@FindBy(id = "title")
	private WebElement addTitlePromoBanner;
	
	@FindBy(id = "target_link")
	private WebElement addLinkPromoBanner;
	
	@FindBy(id = "image")
	private WebElement addImagePromoBanner;
	
	String imagepath = "D:\\automation\\practice\\Images\\Uno.jpg";
	
	@FindBy(xpath = "//button[.=\"Submit\"]")
	private WebElement addPromoBannerSubmit;
	
	public void addPromoBanner() {
		addPromoBanner.click();
	}
	
	public void addTitlePromoBanner() {
		addTitlePromoBanner.sendKeys("Testing");
	}
	
	public void addLinkPromoBanner() {
		addLinkPromoBanner.sendKeys("http://skyonliners.com/demo/gammingle-web/webadmin/promo_banner");
		
	}
	
	public void ImagePromoBanner() {
		addImagePromoBanner.sendKeys(imagepath);
	}
	
	public void addPromoBannerSubmit() {
		addPromoBannerSubmit.click();
		
	}
}

