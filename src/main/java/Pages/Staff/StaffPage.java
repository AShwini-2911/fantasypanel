package Pages.Staff;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;

public class StaffPage extends DriverManager {
	
	public StaffPage() {
        PageFactory.initElements(webDriver.get(), this);
    }
	
	@FindBy(xpath = "//span[.=\"Staff\"]")
	private WebElement staff;
	
	public void navigateToStaff() {
		staff.click();
	}
	
	@FindBy(partialLinkText = "Manage Staff")
	private WebElement manageStaff;
	
	public void navigateToManageStaff() {
		manageStaff.click();
	}

	@FindBy(partialLinkText = "Manage Roles")
	private WebElement ManageRoles;
	
	public void navigateToManageRoles() {
		ManageRoles.click();
	}
	
	
}
