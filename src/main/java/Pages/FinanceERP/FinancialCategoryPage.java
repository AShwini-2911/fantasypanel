package Pages.FinanceERP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;

public class FinancialCategoryPage extends DriverManager {
	
	public FinancialCategoryPage() {
		PageFactory.initElements(webDriver.get(), this);
	}
	

	//Add FinancialCategory
	@FindBy(xpath = "//i[@class=\"fa fa-plus\"]")
	private WebElement AddFinancialCategory;
	
	@FindBy(id = "category_name")
	private WebElement FinancialCategoryName;
	
	@FindBy(id = "type_income")
	private WebElement income;
	
	@FindBy(xpath = "//button[.=\"Submit\"]")
	private WebElement AddFinancialCatSubmit;
	
	public void AddFinancialCat() {
		AddFinancialCategory.click();
	}
	
	public void FinancialCatName() {
		FinancialCategoryName.sendKeys("Insurance");
		
	}
	
	public void income() {
		income.click();
	}
	
	public void AddFinancialCatSubmit() {
		AddFinancialCatSubmit.click();
	}
	
	//View Financial Category
	
	@FindBy(xpath = "(//i[@class=\"fa fa-eye\"])[2]")
	private WebElement viewFinancialCategory;
	
	@FindBy(xpath = "//div[@class=\"tab-content\"]")
	private WebElement getFinancialCategory;
	
	public void viewFinacialCategory() {
		viewFinancialCategory.click();
	}
	
	public void getFinancialCategoyDetails() {
		String financial = getFinancialCategory.getText();
		System.out.println(financial);
	}
	
	//update Financial Category
	@FindBy(xpath = "(//i[@class=\"fa fa-edit\"])[1]")
	private WebElement updateFinancialCat;
	
	@FindBy(id = "category_name")
	private WebElement updateFinancialCatName;
	
	@FindBy(xpath = "//button[.=\"Submit\"]")
	private WebElement updatefinancialcatbtn;
	
	public void updateFinancialCat() throws InterruptedException {
		Thread.sleep(5000);
		updateFinancialCat.click();
	}

	public void updateFinancialCatName() {
		updateFinancialCat.clear();
		updateFinancialCatName.sendKeys("Insurance");
	}
	
	public void updatefinancialCatBtn() {
		updatefinancialcatbtn.click();
	}
	
	//Filter Financial Category
	@FindBy(id = "listing-filter-toggle")
	private WebElement filterFinancialCat;
	
	@FindBy(id = "search_category_name")
	private WebElement filterFinancialCatName;
	
	@FindBy(tagName = "table")
	private WebElement fiterFinancialCatBtn;
	
	public void filterFinancialCat() {
		filterFinancialCat.click();
	}
	
	public void filterFinancialCatName() {
		filterFinancialCat.clear();
		filterFinancialCatName.sendKeys("Insurance");
	}
	public void filterFinancialCatBtn() {
		fiterFinancialCatBtn.click();
	}
}
