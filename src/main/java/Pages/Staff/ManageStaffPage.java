package Pages.Staff;


import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.DriverManager;

public class ManageStaffPage extends DriverManager{

	public ManageStaffPage() {

		PageFactory.initElements(webDriver.get(), this);
    }

	
	@FindBy(xpath = "(//i[@class=\"fa fa-eye\"])[10]")
	private WebElement viewStaff;
	
	@FindBy(tagName = "table")
	private WebElement tableData;
	
	@FindBy(xpath = "//table/tbody/tr")
    private List<WebElement> rows;

    @FindBy(xpath = "//table/thead/tr/th")
    private List<WebElement> headers;
	
	public void clickViewStaff() throws InterruptedException {
		viewStaff.click();
		Thread.sleep(5000);
	}

	 
	 public String captureStaffDetails() {
	        return tableData.getText();
	    }
	 
	 //Update staff details
	 
	 @FindBy(xpath = "(//i[@class=\"fa fa-edit\"])[10]")
	 private WebElement updateStaff;
	 
	 @FindBy(id = "first_name")
	 private WebElement updateFirstName;
	 
	 @FindBy(id = "last_name")
	 private WebElement updateLastName;
	 
	 @FindBy(xpath = "//button[.=\"Update\"]")
	 private WebElement updateStaffBtn;
	 
	 @FindBy(xpath = "//p[.=\"Data Updated Successfully\"]")
	 private WebElement updateSuccessMsg;
	 
	 @FindBy(partialLinkText = "Cancel")
	 private WebElement cancelStaffBtn;
	 
	 public void clickUpdateStaff() throws InterruptedException {
		 updateStaff.click();
		 Thread.sleep(5000);
	 }
	 
	 public void name() {
		 updateFirstName.clear();
		 updateFirstName.sendKeys("Test");
		 updateLastName.clear();
		 updateLastName.sendKeys("user");
	 }
	 
	 public void updateStaffBtn() {
		 updateStaffBtn.click();
	 }
	  
	 public String updateSuccessMsg() {
		 return updateSuccessMsg.getText();
	 }
	 
	 public void cancelStaffBtn() {
		 cancelStaffBtn.click();
	 }
	 
	
	 
	 
	 
	 //Filter 
	 @FindBy(id = "listing-filter-toggle")
	 private WebElement FilterStaff;
	 
	 @FindBy(id = "search_first_name")
	 private WebElement FilterFirstName;
	 
	 @FindBy(id = "search_last_name")
	 private WebElement FilterLastName;
	 
	 @FindBy(id = "search_role")
	 private WebElement FilterRole;
	 
	 @FindBy(xpath = "//table//tbody/tr/td")
	 private WebElement NoFilteredData;
	 
	 public void filterStaff() {
		 FilterStaff.click();
		 
	 }
	 
	 public void filterFirstNameStaff() {
		 FilterFirstName.sendKeys("Test");
		 FilterLastName.sendKeys("user");
	 }
	 
	 public String captureStaffFilterDetails() {
	        return tableData.getText();
	    }
	 
	 public void selectRoleByIndex(int index) throws InterruptedException {
	        // Initialize the Select class and select by index
	        Select select = new Select(FilterRole);
	        select.selectByIndex(index);
	        Thread.sleep(3000);
	    }


	 public void searchInvalidUserName() {
		 FilterFirstName.sendKeys("Teste");
	 }	
	 
	 public String getNoData() {
		 return NoFilteredData.getText();
	 }
	 
	 //Change Password
	 @FindBy(xpath = "(//i[@class=\"fa fa-key\"])[10]")
	 private WebElement changePassword;
	 
	 @FindBy(name = "new_password")
	 private WebElement newPassword;
	 
	 @FindBy(name = "confirm_password")
	 private WebElement confirmPassword;
	 
	 @FindBy(xpath = "//button[.=\"Reset Password\"]")
	 private WebElement resetPassword;
	 
	 @FindBy(xpath = "//p[.=\"Password updated successfully\"]")
	 private WebElement message;
	 
	 @FindBy(xpath = "//p[.=\"Both password and confirm password should be matched!\"]")
	 private WebElement mismatchMessage;
	 
	 @FindBy(xpath = "//i[@class=\"fa fa-arrow-left\"]")
	 private WebElement backbtn;
	 
	 @FindBy(xpath = "//p[.=\"The new password must be at least 8 characters.,The confirm password must be at least 8 characters.\"]")
	 private WebElement weakPassMsg;
	 
	 
	 public void clickChangePassword() {
		 changePassword.click();
	 }
	 
	 public void enterNewPassword(String newPass) {
	        newPassword.sendKeys(newPass);

	    }
	 
	 public void enterConfirmPassword(String confirmPass) {
	        confirmPassword.sendKeys(confirmPass);

	    }
	 
	 
	 public String resetPasswordBtn() throws InterruptedException {
		 resetPassword.click();
		 Thread.sleep(2000);
		 String pageSource = message.getText();
		 return pageSource;
	 }
	 
	 public String mismatchMessage() throws InterruptedException {
		 resetPassword.click();
		 Thread.sleep(2000);

		 String pageSource = mismatchMessage.getText();
		return pageSource;
	 }
	 
	 public String getConfirmPasswordBorderColor() throws InterruptedException {
		 resetPassword.click();
		 Thread.sleep(2000);
	        return confirmPassword.getCssValue("border-color");
	    }
	 
	 public void backButton() {
		 backbtn.click();
	 }
	 
	 public String weakPassMessage() throws InterruptedException {
		 resetPassword.click();
		 Thread.sleep(2000);

		 String pageSource = weakPassMsg.getText();
		return pageSource;
	 }
	 
	 
     //Add Staff 
	 @FindBy(xpath = "//i[@class=\"fa fa-plus\"]")
	 private WebElement addStaff;
	 
	 @FindBy(id = "select2-role-container")
	 private WebElement addRoledropdown;
	 
	 @FindBy(xpath = "//li[.=\"Data\"]")
	 private WebElement adminRole;
	 
	 @FindBy(id = "first_name")
	 private WebElement addFirstName;
	 
	 @FindBy(id = "last_name")
	 private WebElement addLastName;
	 
	 @FindBy(id = "email")
	 private WebElement addEmail;
	 
	 @FindBy(id = "phone")
	 private WebElement addPhone;
	 
	 @FindBy(name = "password")
	 private WebElement addPassword;
	 
	 @FindBy(xpath = "//span[@class=\"input-group-text input-password-hide\"]")
	 private WebElement passwordEye;
	 
	 @FindBy(xpath = "//button[.=\"Submit\"]")
	 private WebElement submitStaff;
	 
	 @FindBy(partialLinkText = "Cancel")
	 private WebElement cancelStaff;
	 
	 @FindBy(xpath = "//i[@class=\"fa fa-arrow-left\"]")
	 private WebElement addStaffBackbtn;
	 
	 @FindBy(xpath = "//p[.=\"Data Added Successfully\"]")
	 private WebElement addStaffSuccessMsg;
	 
	 @FindBy(xpath = "//p[.=\"Mobile number already exist.\"]")
	 private WebElement mobileNumExist;
	 
	 @FindBy(xpath = "//p[.=\"The role field is required.\"]")
	 private WebElement roleMsg;
	 
	 
	 public void clickAddStaff() {
		 addStaff.click();
	 }
	 
	 public void selectRoleByVisibleText(String admin) throws InterruptedException {
		 Thread.sleep(3000);
//	        addRoledropdown.click();
//
//	        Select select = new Select(addRoledropdown);
//	        
//	        select.selectByVisibleText(admin);
//			 Thread.sleep(3000);

		 addRoledropdown.click();
		 adminRole.click();
		 
	    }
	 
	 public void firstName(String firstN ) {
		 addFirstName.sendKeys(firstN);
	 }

	 public void lastName(String lastN ) {
		 addLastName.sendKeys(lastN);
	 }
	 
	 public void email(String Email) {
		 addEmail.sendKeys(Email);
	 }
	 
	 public void phone(String phone) {
		 addPhone.sendKeys(phone);
	 }
	 
	 public void password(String pass) {
		 addPassword.sendKeys(pass);
	 }

	 public void submitStaff() {
		 submitStaff.click();
	 }
	 
	 public void addStaffBackbtn() {
		 addStaffBackbtn.click();
	 }
	 
	 public String addStaffMsg() throws InterruptedException {
		 
		 submitStaff();
		 Thread.sleep(2000);
		 String pageSource = addStaffSuccessMsg.getText();
		 return pageSource;
	 }
	 
	 public String getFirstNameBorderColor() throws InterruptedException {
		 submitStaff.click();
		 Thread.sleep(2000);
	     return addFirstName.getCssValue("border-color");
	    }
	 
	 public String getEmailColor() throws InterruptedException {
		 submitStaff.click();
		 Thread.sleep(2000);
	     return addEmail.getCssValue("border-color");
	    }
	 
	 public String passwordFieldType() {
		 return addPassword.getAttribute("type");
	 }
	 
	 public void clickPassEye() {
		 passwordEye.click();
	 }
	 
	 public String mobileNumExistMsg() throws InterruptedException {
		 
		 submitStaff();
		 Thread.sleep(2000);
		 String pageSource = mobileNumExist.getText();
		 return pageSource;
	 }
	 
 
	 public String roleMsg() throws InterruptedException {
		 
		 submitStaff();
		 Thread.sleep(2000);
		 String pageSource = roleMsg.getText();
		 return pageSource;
	 }
//	 public String getPasswordFieldRegex() {
//	        JavascriptExecutor js = (JavascriptExecutor) driver;
//	        System.out.println(js);
//	        // Use JavaScript to fetch the regex from the password field (if it's in JS)
//	        String regex = (String) js.executeScript(
//	            "return document.getElementById(arguments[0]).pattern;", 
//	            addPassword.toString()
//	        );
//	        return regex;
//	    }
	 
	 public void enterFirstName(String name) {
	        String sanitizedName = sanitizeName(name); // Sanitizing the input to allow only alphabets
	       
	        firstName(sanitizedName); // Send the sanitized value to the field
	    }

	    // Method to get the value of the first name field
	    public String getFirstName() {
	    	return addFirstName.getAttribute("value");
//	        return firstNameElement.getAttribute("value"); // Return the current value of the field
	    }

	    // Sanitize the input to remove non-alphabetic characters
	    private String sanitizeName(String name) {
	        // Remove all non-alphabetic characters
	        return name.replaceAll("[^a-zA-Z]", "");
	    }
}


