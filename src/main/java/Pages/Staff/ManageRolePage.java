package Pages.Staff;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.DriverManager;

public class ManageRolePage extends DriverManager{
	
	public ManageRolePage() {

		PageFactory.initElements(webDriver.get(), this);
    }

	//Add Role
	@FindBy(xpath = "//i[@class=\"fa fa-plus\"]")
	private WebElement addRole;
	
	@FindBy(id = "role_name")
	private WebElement role_name;
	
	@FindBy(id = "description")
	private WebElement role_description;
	
	@FindBy(xpath = "(//div[@class=\"custom-control custom-switch\"])[1]")
	private WebElement rolePermission;
	
	@FindBy(xpath = "(//div[@class=\"custom-control custom-switch\"])[6]")
	private WebElement staffPermission;
	
	@FindBy(xpath = "//button[.=\"Submit\"]")
	private WebElement addRoleSubmit;
	
	@FindBy(xpath = "//p[.=\"Data Added Successfully\"]")
	private WebElement addRoleSuccessMsg;
	
	@FindBy(xpath = "//p[@class=\"alert-message\"]")
	private WebElement addRoleErrorMsg;
	
	@FindBy(xpath = "//p[@class=\"alert-message\"]")
	private WebElement addRolePermissionErrorMsg;
	
	@FindBy(xpath = "//p[@class=\"alert-message\"]")
	private WebElement duplicateStaffRoleErrorMsg;
	
	public void addRole() {
		addRole.click();
	}
	public void roleName() {
		role_name.sendKeys("Mgr");
	}
	
	public void roleDescription() {
		role_description.sendKeys("Mgr");
	}
	public void rolePermission() {
		rolePermission.click();
		staffPermission.click();
	}
	
	public void addRoleSubmit() {
		addRoleSubmit.click();
	}
	
	public String addRoleSuccessMsg() {
		return addRoleSuccessMsg.getText();
	}
	
	public String addRoleErrorMsg() {
		return addRoleErrorMsg.getText();
	}
	
	public String addRolePermissionErrorMsg() {
		return addRolePermissionErrorMsg.getText();
	}
	
	public String duplicateStaffRoleErrorMsg() {
		return duplicateStaffRoleErrorMsg.getText();
	}
	
	//update Role
	@FindBy(xpath = "(//i[@class=\"fa fa-edit\"])[1]")
	private WebElement updateRole;
	
	@FindBy(id = "role_name")
	private WebElement updateRoleName;
	
	@FindBy(xpath = "//p[.=\"Data Updated Successfully\"]")
	private WebElement updateRoleMsg;
	
	public void updateRole() {
		updateRole.click();
	}
	
	public void updateRoleName() {
		updateRoleName.clear();
		updateRoleName.sendKeys("Mgr");
	}
	
	public String updateRoleMsg() {
		return updateRoleMsg.getText();
	}
	
	//Filter
	@FindBy(xpath = "//i[@class=\"fa fa-filter\"]")
	private WebElement filterRole;
	
	@FindBy(id = "search_role")
	private WebElement filterStaffRole;
	
	@FindBy(tagName = "table")
	private WebElement filterstaffRoleData;
	
	public void filterRole() {
		filterRole.click();
	}
	
	public void filterStaffRole() {
		Select s= new Select(filterStaffRole);
		s.selectByVisibleText("admin");
	}
	
	public String filterstaffRoleData() {
		return filterstaffRoleData.getText();
	}
}
