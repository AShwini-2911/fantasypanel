package Pages.GeneralSettings;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.DriverManager;

public class AvatarPage extends DriverManager {
	
	public AvatarPage() {

		PageFactory.initElements(webDriver.get(), this);
    }

	//Add avatar
	@FindBy(xpath = "//i[@class=\"fa fa-plus\"]")
	private WebElement clickAddAvatar;
	
	@FindBy(id = "image")
	private WebElement imageUpload;
	
	String image ="E:\\Users\\Raj Rane\\Downloads\\A_simple_blank_image_with_dimensions_of_1500x900.jpeg";
	 
	String image1 ="E:\\Users\\Raj Rane\\Downloads\\playing-toys-concept-with-wooden-cubes-kid-toys-wooden-background-flat-lay.jpg";
	
	
	@FindBy(xpath = "//button[.=\"Submit\"]")
	private WebElement addAvatarSubmit;
	
	@FindBy(partialLinkText = "Cancel")
	private WebElement addAvatarCancel;
	
	@FindBy(xpath = "//p[.=\"Data Added Successfully\"]")
	private WebElement addAvatarSuccessMsg;
	
	@FindBy(xpath = "//p[.=\"The image must not be greater than 1 mb.\"]")
	private WebElement addAvatarLargeSizeMsg;

	@FindBy(tagName = "table")
	private WebElement tableData;
	
	
	
	public void clickAddAvatar() {
		clickAddAvatar.click();
		
	}
	
	public void imageUpload() {
		imageUpload.sendKeys(image);
	}
	
	public void clickAvatarSubmit() {
		addAvatarSubmit.click();
	}
	
	public void clickAvatarCancel() {
		addAvatarCancel.click();
	}
	
	public String addAvatarSuccessMsg() {
		return addAvatarSuccessMsg.getText();
	}
	
	public String addAvatarImageSizeErrorMsg() {
		return addAvatarLargeSizeMsg.getText();
	}
	
	public String imageBorderColor() throws InterruptedException {
		addAvatarSubmit.click();
		 Thread.sleep(2000);
	     return imageUpload.getCssValue("border-color");
	    }
	
	
	public void image1Upload() {
		imageUpload.sendKeys(image1);
	}
	
	 public String captureavatarDetails() {
	        return tableData.getText();
	 }
	 
	 
	 //view avatar
	 @FindBy(xpath = "(//i[@class=\"fa fa-eye\"])[1]")
	 private WebElement viewAvatar;
	 
	 @FindBy(tagName = "table")
	 private WebElement getViewAvatarDetails;
	 
	 public void viewAvatar() {
		 viewAvatar.click();
	 }
	 
	 public String getViewAvatarDetails() {
		 return getViewAvatarDetails.getText();
	 }
	 
	 //update Avatar
	 @FindBy(xpath = "(//i[@class=\"fa fa-edit\"])[1]")
	 private WebElement updateAvatar;
	 
	
	 @FindBy(xpath = "//i[@class=\"fa ft-eye\"]")
	 private WebElement previewImageBtn;
	 
	 @FindBy(xpath = "//img[contains(@src,\"https://gammingle-admin-file-s3.s3.amazonaws.com/avatar/c2af5ae3-3963-45c0-9370-bf7bc760f519.jpeg\")]")
	 private WebElement previewedImage;
	 
	 @FindBy(xpath = "//p[.=\"Data Updated Successfully\"]")
	 private WebElement updateAvatarSuccessMsg;
	 
	 public void updateAvatar() {
		 updateAvatar.click();
	 }
	 
	 public void upadateAvatarBtn() {
		 addAvatarSubmit.click();
	 }
	 
	 public String updateAvatarSuccessMsg() {
		return updateAvatarSuccessMsg.getText();
	 }
	 
	 public void clickPreviewImageBtn() {
		 previewImageBtn.click();
	 }
	 
	 public WebElement previewedImage() {
		 return previewedImage;
	 }
	 
	 public String getPreviewImageUrl() {
	        return previewedImage.getAttribute("src");
	    }
	 
	 
	 //Filter Avatar
	 @FindBy(id = "listing-filter-toggle")
	 private WebElement filterAvatar;
	 
	 @FindBy(id = "search_status")
	 private WebElement filterAvatarStatus;
	 
	 @FindBy(xpath = "//table/tbody/tr[2]/td[2]/span/span")
	 private WebElement Inactive;
	 public void filterAvatar() {
		 filterAvatar.click();
	 }
	 public void selectDropdownOption() {
		    Select dropdown = new Select(filterAvatarStatus);
		    dropdown.selectByVisibleText("Inactive");
		}
	 
	 public String inactiveStatus() {
		 return Inactive.getText();
	 }
	 

	 
}
