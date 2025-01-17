package Pages.Marketing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;

public class NotificationTemplatePage extends DriverManager {
	
	public NotificationTemplatePage() {
		PageFactory.initElements(webDriver.get(), this);
	}
	
	//Add Notification template
	@FindBy(xpath = "//i[@class=\"fa fa-plus\"]")
	private WebElement  AddNotificationTemplate;
	
	@FindBy(xpath = "//span[@class=\"select2-selection select2-selection--single\"]")
	private WebElement SelectDrop;
	
	@FindBy(xpath = "//li[.=\"Print\"]")
	private WebElement PrintDropDown;
	
	@FindBy(id = "templateName")
	private WebElement TemplateName;
	
	@FindBy(xpath = "(//iframe[@class=\"cke_wysiwyg_frame cke_reset\"])[1]")
	private WebElement headerContent;
	
	@FindBy(xpath = "(//iframe[@class=\"cke_wysiwyg_frame cke_reset\"])[2]")
	private WebElement bodyContent;
	
	@FindBy(id = "bodyImage")
	private WebElement uploadImage;
	
	
	
	String image = "C:\\Users\\Raj Rane\\Desktop\\Uno.jpg";
	
	@FindBy(xpath = "//button[.=\"Submit\"]")
	private WebElement addNotificationSubmit;
	
	public void AddNotificationTemp() {
		AddNotificationTemplate.click();
	}
	
	public void PrintDropDown() {
		SelectDrop.click();
		PrintDropDown.click();
	}
	
	public void TemplateName() {
		TemplateName.sendKeys("Test");
	}
	
	public void headerContent() {
		headerContent.sendKeys("testingg");
	}
	
	public void bodyContent() {
		bodyContent.sendKeys("Testeee");
	}
	
	public void image() {
		uploadImage.sendKeys(image);
	}
	
	public void submitAddNotification() {
		addNotificationSubmit.click();
	}
	
	
	//View Notification template
	@FindBy(xpath = "(//i[@class=\"fa fa-eye\"])[1]")
	private WebElement view;
	
	@FindBy(tagName = "table")
	private WebElement viewDetails;
	
	public void viewNotificationTemp() {
		view.click();
	}
	
	public void viewDetailsNotificationTemp() {
		String test = viewDetails.getText();
		System.out.println(test);
	}

	//Update Notification Template
	@FindBy(xpath = "(//i[@class=\"fa fa-edit\"])[1]")
	private WebElement updateNotificationTemp;
	
	@FindBy(id = "templateName")
	private WebElement updateTemplateName;
	
	@FindBy(xpath = "//button[.=\"Update\"]")
	private WebElement updateNotificationTempBtn;
	
	public void updateNotificationTemp() {
		updateNotificationTemp.click();

	}
	
	public void updateTemplateName() {
		updateTemplateName.clear();
		updateTemplateName.sendKeys("Email testing 000");
	}
	
	public void updateNotificationTempBtn() {
		updateNotificationTempBtn.click();
	}
	
	//Filter Notification Template
	@FindBy(id = "listing-filter-toggle")
	private WebElement filter;
	
	@FindBy(id = "search_template_name")
	private WebElement filterTemplateName;
	
	public void filterNotificationTemp() {
		filter.click();
	}
	
	public void filterTemplateName() {
		filterTemplateName.sendKeys("Temp vivek");
	}
}
