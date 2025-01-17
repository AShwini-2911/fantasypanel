package Pages.Master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import Base.DriverManager;


public class PlayerPositionPage extends DriverManager{
	
	public PlayerPositionPage() {
		PageFactory.initElements(webDriver.get(), this);
	}
	
	@FindBy(xpath = "(//i[@class=\"fa fa-eye\"])[1]")
	private WebElement View_AllRounder;
	
	@FindBy(xpath = "//div[@class=\"card-content\"]")
	private WebElement Get_details;
	
	@FindBy(xpath = "(//a[@class=\"btn btn-success btn-sm src_data\"])[1]")
	private WebElement Update_AllRounder1;
	
	@FindBy(xpath = "//span[@class=\"select2-selection__arrow\"]")
	private WebElement Dropdown;
	
	@FindBy(xpath = "(//li[@class=\"select2-results__option\"])[1]")
	private WebElement Update_SportName;
	
	@FindBy(xpath = "//button[.=\"Submit\"]")
	private WebElement Update_AllRounder_Submit;
	
	@FindBy(id = "listing-filter-toggle")
	private WebElement Filter_PlayerPosition;
	
	@FindBy(id = "search_position")
	private WebElement Filter_Name;
	
	public void View_AllRounder() {
		View_AllRounder.click();
		System.out.println(View_AllRounder);
	}
	
	public void Get_Details_ofAllRounder(){
		// Initialize Extent Reports (only once for the session)
//        extent = new ExtentReports();
//        extent.attachReporter(new ExtentSparkReporter("SparkReport/Spark.html"));
        
        // Start a test
//        test = extent.createTest("Sample Test with Console Output Capture");
//
//        // Start capturing console output
//        Util.startConsoleCapture();
//
		String tes = Get_details.getText();
		System.out.println(tes);
//		
//		Util.stopConsoleCapture();
//        String consoleOutput = Util.getConsoleOutput();
//
//        // Log captured output to Extent Report
//        test.log(Status.INFO, "Captured Console Output:");
//        test.log(Status.INFO, consoleOutput.replaceAll("\n", "<br>"));

 
	}
	
	public void Update_AllRounder() {
		Update_AllRounder1.click();
	}
	
	public void Update_AllRounder_Sport() {
		Dropdown.click();
		Update_SportName.click();
	}
	
	public void All() {
		Update_AllRounder_Submit.click();
	}

	public void Filter_PlayerPosition() {
		Filter_PlayerPosition.click();
	}
	
	public void Filter_Name(String string) {
		Filter_Name.sendKeys(string);;
	}
}
