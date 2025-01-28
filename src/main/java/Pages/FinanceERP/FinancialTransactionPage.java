package Pages.FinanceERP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.DriverManager;

public class FinancialTransactionPage extends DriverManager {
	
	public FinancialTransactionPage() {
		PageFactory.initElements(webDriver.get(), this);
	}

	//Add Financial Transaction
	@FindBy(xpath = "//i[@class=\"fa fa-plus\"]")
	private WebElement addFinancialTransaction;
	
	public void addFinancialTransaction() {
		addFinancialTransaction.click();
	}
	
	@FindBy(id = "financial_category")
	private WebElement selctFinancialCategory;
	
	public void selectFinancialCategory() {
		Select s = new Select(selctFinancialCategory);
		s.selectByVisibleText("Insurance");
	}
	
	@FindBy(id = "transaction_amount")
	private WebElement transaction_amount;
	
	public void transaction_amount() {
		transaction_amount.sendKeys("20");
	}
	
	@FindBy(xpath = "//input[@id=\"transaction_date\"]")
	private WebElement transaction_date;
	
	@FindBy(xpath = "//span[@aria-label=\"January 28, 2025\"]")
	private WebElement dateSelect;
	
	public void transaction_date() {
		transaction_date.click();
		dateSelect.click();
	}
	
	@FindBy(xpath = "//textarea[@id=\"description\"]")
	private WebElement transactionDescription;
	
	public void transactionDescription() {
		transactionDescription.sendKeys("test");
	}
	
	@FindBy(xpath = "//button[.=\"Submit\"]")
	private WebElement financialTransactionSubmit;
	
	public void financialTransactionSubmit() {
		financialTransactionSubmit.click();
	}
	
	@FindBy(xpath = "//p[.=\"Data Added Successfully\"]")
	private WebElement financialTransactionSuccess;
	
	public String financialTransactionSuccessMsg() {
		return financialTransactionSuccess.getText();
	}
	
	
	//View
	@FindBy(xpath = "(//i[@class=\"fa fa-eye\"])[1]")
	private WebElement viewFinancialTransaction;
	
	public void viewFinancialTransaction() {
		viewFinancialTransaction.click();
	}
	
	@FindBy(tagName = "table")
	private WebElement getViewedFinancialTransaction;
	
	public String getviewedFTransactionDetail() {
		return getViewedFinancialTransaction.getText();
	}
	
	@FindBy(xpath = "//i[@class=\"fa fa-filter\"]")
	private WebElement filterFinancialTransaction;
	
	public void filterFinancialTransaction() {
		filterFinancialTransaction.click();
	}
	
	@FindBy(id = "search_finantial_category")
	private WebElement search_finantial_category;
	
	public void filterFCategoryType() {
		
		Select s = new Select(search_finantial_category);
		s.selectByVisibleText("Insurance");
	}
	
	
	@FindBy(tagName = "table")
	private WebElement filterFinacialTransactiondata;
	
	public String filterFinacialTransactiondata() {
		return filterFinacialTransactiondata.getText();
	}
}
