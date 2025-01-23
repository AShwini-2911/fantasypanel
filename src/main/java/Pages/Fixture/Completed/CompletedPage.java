package Pages.Fixture.Completed;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.DriverManager;

public class CompletedPage extends DriverManager {
	
	public CompletedPage() {

		PageFactory.initElements(webDriver.get(), this);
    }
	
	@FindBy(xpath = "//i[@class=\"fa fa-filter\"]")
	private WebElement filterCompleted;
	
	@FindBy(id = "contest_league")
	private WebElement filter_contest_league;
	
	@FindBy(id = "matchId")
	private WebElement filter_matchId;
	
	@FindBy(tagName = "table")
	private WebElement filterCompletedMatchData;
	
	public void filtercompleted() {
		filterCompleted.click();
	}
	
	public void filter_contest_league() {
		Select s= new Select(filter_contest_league);
		s.selectByVisibleText("Australia tour of England (Eng vs AUS)");
	}
	
	public void filter_matchId() {
		Select s = new Select(filter_matchId);
		s.selectByVisibleText("ENG vs AUS ( 2024-09-11 23:00:00 )");
	}
	
	public String filterCompletedMatchData() {
		return filterCompletedMatchData.getText();
	}

	
	//statistics
	@FindBy(xpath = "(//a[@title=\"Statistics\"])[1]")
	private WebElement Statistics;
	
	@FindBy(xpath = "//i[@class=\"fa fa-filter\"]")
	private WebElement StatisticsFilter;
	
	@FindBy(id = "search_inning")
	private WebElement search_inning;
	
	public void Statistics() throws InterruptedException {
		Statistics.click();
		Thread.sleep(2000);
	}
	
	public void statisticsFilterBtn() {
		StatisticsFilter.click();
	}
	
	public void StatisticsFilter() {
		Select s = new Select(search_inning);
		s.selectByVisibleText("Inning 2");
	}
	
	public String StatisticsFilteredData() {
		return filterCompletedMatchData.getText();
	}
	
}
