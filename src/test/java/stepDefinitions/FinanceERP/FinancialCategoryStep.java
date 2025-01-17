package stepDefinitions.FinanceERP;

import Pages.FinanceERP.FinancialCategoryPage;
import io.cucumber.java.en.*;

public class FinancialCategoryStep {
	
	FinancialCategoryPage financialPage = new FinancialCategoryPage();

	@Given("User click on Add Financial Category button")
	public void user_click_on_add_financial_category_button() {
	    financialPage.AddFinancialCat();
	}

	@Then("User fill all the Financial Category details")
	public void user_fill_all_the_financial_category_details() {
	    financialPage.FinancialCatName();
	    financialPage.income();
	}

	@Then("User click on Financial Category Submit")
	public void user_click_on_financial_category_submit() {
	    financialPage.AddFinancialCatSubmit();
	}
	
	@Given("User click on View Financial Category button")
	public void user_click_on_view_financial_category_button() {
	    financialPage.viewFinacialCategory();
	}

	@Then("User should able to see the Financial Category details")
	public void user_should_able_to_see_the_financial_category_details() {
	    financialPage.getFinancialCategoyDetails();
	}

	@Given("User click on Update Financial Category button")
	public void user_click_on_update_financial_category_button1() throws InterruptedException {
		
	    financialPage.updateFinancialCat();
	}

	@Then("User update title of the Financial Category")
	public void user_update_title_of_the_financial_category() {
	   financialPage.updateFinancialCatName();
	}

	@Then("User click on update Financial Category button")
	public void user_click_on_update_financial_category_button() {
	    financialPage.updatefinancialCatBtn();
	}

	@Given("User Click on Filter Financial Category button")
	public void user_click_on_filter_financial_category_button() {
	    financialPage.filterFinancialCat();
	}

	@Then("User enter title in Title Financial Category field")
	public void user_enter_title_in_title_financial_category_field() throws InterruptedException {
		Thread.sleep(3000);
	    financialPage.filterFinancialCatName();
	}

	@Then("User should able to filtered Financial Category data")
	public void user_should_able_to_filtered_financial_category_data() {
	    financialPage.filterFinancialCatBtn();
	}


}
