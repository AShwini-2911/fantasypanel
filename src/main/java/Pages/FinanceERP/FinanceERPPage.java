package Pages.FinanceERP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;

public class FinanceERPPage extends DriverManager {
	 public FinanceERPPage() {
			PageFactory.initElements(webDriver.get(), this);
		}
	 
	 @FindBy(xpath = "//span[.=\"Finance ERP\"]")
	 private WebElement FinanceERP;
	 
	 @FindBy(partialLinkText = "Financial Category")
	 private WebElement FinancialCategory;
	 
	 @FindBy(xpath = "//a[.=\"Financial Transaction\"]")
	 private WebElement financialTransaction;
	 
	 public void navigateToFinanceERP() {
		 FinanceERP.click();
	 }
	 
	 public void navigateToFinancialCategory() {
		 FinancialCategory.click();
	 }

	 public void navigateToFinancialTransaction() {
		 financialTransaction.click();
	 }
}
