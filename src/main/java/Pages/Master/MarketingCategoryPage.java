package Pages.Master;



import java.time.Duration;

import javax.xml.xpath.XPath;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.DriverManager;

public class MarketingCategoryPage extends DriverManager{
	 private WebDriver driver;
	 
	 public MarketingCategoryPage() {
			PageFactory.initElements(webDriver.get(), this);
		}
	 
	@FindBy(xpath = "//i[@class=\"fa fa-plus\"]")
	private  WebElement Add_Marketing_Category;
	
	@FindBy(id = "name")
	private WebElement Category_Name;
	
	@FindBy(xpath = "//button[.=\"Submit\"]")
	private WebElement Submit;
	
	@FindBy(xpath = "(//i[@class=\"fa fa-eye\"])[1]")
	private WebElement ViewCategory;
	
	@FindBy(xpath = "//div[@class=\"card-body\"]")
	private WebElement getdetails;

	@FindBy(xpath = "(//i[@class=\"fa fa-edit\"])[1]")
	private WebElement UpdateCategoy;
	
	@FindBy(id = "name")
	private WebElement updateName;
	 
	@FindBy(xpath = "//button[.=\"Update\"]")
	private WebElement updateBtn;
	
	@FindBy(id = "listing-filter-toggle")
	private WebElement Filter;
	
	@FindBy(id = "search_name")
	private WebElement FilterName;
	
	@FindBy(id = "clear-form-data")
	private WebElement ClearSearch;
	
	@FindBy(partialLinkText = "Cancel")
	private WebElement cancelMarketingCategory;
	
	@FindBy(xpath = "//i[@class=\"fa fa-arrow-left\"]")
	private WebElement backMarketingCategory;
	
	@FindBy(xpath = "//p[.=\"Category already exist.\"]")
	private WebElement CategoryExistMsg;
	
	@FindBy(xpath = "//p[.=\"Data Added Successfully\"]")
	private WebElement categorySuccessMsg;
	
	@FindBy(xpath = "//p[.=\"Data Updated Successfully\"]")
	private WebElement categoryUpdateMsg;
	
	
	public void Add_Marketing_Category() throws InterruptedException {
		Thread.sleep(3000);
		Add_Marketing_Category.click();
		
	}
	
	public void Category_Name() {
		Category_Name.sendKeys("Social media marketing");
	}
	
	public void blank_CN() {
		Category_Name.sendKeys("");
	}

	public void Category_Submit() {
		Submit.click();	
		
	}
	
	public String marketingCategoryExistMsg() {
		return CategoryExistMsg.getText();
	}
	
	public void cancelMarketingCategory() {
		cancelMarketingCategory.click();
	}
	
	public void backMarketingCategory() {
		backMarketingCategory.click();
	}
	
	public String MarketingNameBorderColor() throws InterruptedException {
		 Submit.click();
		 Thread.sleep(2000);
	        return Category_Name.getCssValue("border-color");
	    }
	
	public String MarketingSuccessMessage() throws InterruptedException {
		 Submit.click();
		 Thread.sleep(2000);

		 String pageSource = categorySuccessMsg.getText();
		return pageSource;
	 }
	 
	
	public void View_Marketing_Category() {
		ViewCategory.click();
	}
	
	public String Get_Detials_ofViewCategory() {
		
		return getdetails.getText();
	}
	
	public void Update_MArketing_Category() {
		UpdateCategoy.click();
		
	}
	public String MarketingUpdateMessage() throws InterruptedException {
		 Submit.click();
		 Thread.sleep(2000);

		 String pageSource = categoryUpdateMsg.getText();
		return pageSource;
	 }
	
	public void Update_Name_Marketing() {
		updateName.clear();
		updateName.sendKeys("Print");
		
	}
	
	public void Update_Btn() {
		updateBtn.click();
	}
	
	public void click_Filter() {
		Filter.click();
	}
	
	public void Filter_Name() throws InterruptedException {
		FilterName.sendKeys("Affiliate marketing");
        Thread.sleep(3000);;  // Wait for the login button to be visible

	}
	
	public void Marketing_Clear_Search() {
		ClearSearch.click();
	}
	
	
	
}
