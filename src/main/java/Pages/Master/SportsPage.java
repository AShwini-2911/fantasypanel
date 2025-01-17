package Pages.Master;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Base.DriverManager;

public class SportsPage extends DriverManager {

	public SportsPage() {
		PageFactory.initElements(webDriver.get(), this);
	}
	
	//View Sports
	@FindBy(xpath = "(//i[@class=\"fa fa-eye\"])[1]")
	private WebElement ViewSport;
	
	@FindBy(xpath = "//div[@class=\"card-content\"]")
	private WebElement getdetails;
	
	public void Click_View_Sports() {
		ViewSport.click();
	}
	
	public String Get_details_Sports() {
		return getdetails.getText();
	}
	
	//Update Sports
	@FindBy(xpath = "(//i[@class=\"fa fa-edit\"])[1]")
	private WebElement updateSports;
	
	@FindBy(id = "commission_rate")
	private WebElement updateCommissionRate;
	
	@FindBy(xpath = "//button[.=\"Submit\"]")
	private WebElement submitbtnsports;
	
	public void click_update_sports() {
		updateSports.click();
	}
	
	public void update_commission_rate() {
		updateCommissionRate.clear();
		updateCommissionRate.sendKeys("10");
	}
	
	public void click_sports_submit() {
		submitbtnsports.click();
	}
	
	//Fiter Sports
	@FindBy(id = "listing-filter-toggle")
	private WebElement sportsFilter;
	
	@FindBy(id = "search_name")
	private WebElement sportsFilterName;
	
	@FindBy(tagName = "table")
	private WebElement getSportsFiltered;
	
	public void sportsFilter() {
		sportsFilter.click();
	}
	
	public void sportsFilterName() {
		sportsFilterName.sendKeys("Basketball");
	}
	
	public String getSportsFilteredData() {
		return getSportsFiltered.getText();
		
		
	}
	
	//publish sports
	@FindBy(xpath = "(//span[@class=\"switchery switchery-small\"])[1]")
	private WebElement clickPublish;
	
	public void clickPublish() {
		clickPublish.click();
	}
	
}
