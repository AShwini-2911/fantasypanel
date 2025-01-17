package stepDefinitions.FinanceERP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;
import Pages.FinanceERP.FinanceERPPage;
import io.cucumber.java.en.*;

public class FinanceERPSteps extends DriverManager{
	
WebDriver driver;
	
	FinanceERPPage financePage = new FinanceERPPage();
	
	public FinanceERPSteps() {
		PageFactory.initElements(webDriver.get(), this);
	}
	
	@Given("I navigate to the Finance ERP Module")
	public void i_navigate_to_the_finance_erp_module() {
	    financePage.navigateToFinanceERP();
	}

	@Given("I select the Financial Category Module")
	public void i_select_the_financial_category_module() {
	    financePage.navigateToFinancialCategory();
	}
	

}
