package Pages.Marketing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;

public class PromoCodePage extends DriverManager {
	private WebDriver driver;

	 public PromoCodePage() {
			PageFactory.initElements(webDriver.get(), this);
		}

	 //Add Promo Code
	 @FindBy(xpath = "//i[@class=\"fa fa-plus\"]")
	 private WebElement addPromoCode;
	 
	 @FindBy(id = "select2-type-container")
	 private WebElement TypeDropDown;
	 
	 @FindBy(xpath = "//li[.=\"Deposite\"]")
	 private WebElement Deposite;
	 
	 @FindBy(id = "promo_code")
	 private WebElement promoCode;
	 
	 @FindBy(id = "discount_value_rs")
	 private WebElement Amount;
	 
	 @FindBy(id = "allow_per_user")
	 private WebElement allowPerUser;
	 
	 
	 @FindBy(id = "promo_code_start_date")
	 private WebElement promo_code_start_date;
	 
	 @FindBy(xpath = "(//span[@class=\"flatpickr-day today\"])[1]")
	 private WebElement dateSelect;
	 
	 @FindBy(id = "promo_code_end_date")
	 private WebElement promo_code_end_date;
	 
	 @FindBy(id = "capping_of_user")
	 private WebElement capping_of_user;
	 
	 
	 @FindBy(tagName = "html")
	 private WebElement description;
	 
	 @FindBy(id = "image")
	 private WebElement uploadImage;
		
	String image = "C:\\Users\\Raj Rane\\Desktop\\Uno.jpg";
	
	@FindBy(xpath = "//button[.=\"Submit\"]")
	private WebElement AddPromoSubmit;

	 
	 public void addPromoCode() {
		 addPromoCode.click();
	 }
	 
	 public void Type() {
		 TypeDropDown.click();
		 Deposite.click();
	 }
	 
	 public void promoCode() {
		 promoCode.sendKeys("PROMO");
	 }
	 
	 public void amount() {
		 Amount.sendKeys("10000");
		 
	 }
	 
	 public void promo_code_start_date() {
		 promo_code_start_date.click();
		 dateSelect.click();
	 }
	 
	 public void promo_code_end_date() {
		 promo_code_end_date.click();
		 dateSelect.click();
	 }
	 
	 public void capping_of_user() {
		 capping_of_user.sendKeys("10");
		 
	 }
	 
	 public void description() {
		 description.sendKeys("Test");
	 }
	 
	 public void imageupload() {
		 uploadImage.sendKeys(image);
		 
	 }
	 
	 public void addPromosubmit() {
		 AddPromoSubmit.click();
	 }
	 
	 // view Promo Code
	 @FindBy(xpath = "(//i[@class=\"fa fa-eye\"])[1]")
	 private WebElement viewPromoCode;
	 
	 @FindBy(xpath = "//table[@class=\"table table-bordered table-striped\"]")
	 private WebElement getDetailsPromo;
	 
	 public void viewPromoCode() {
		 viewPromoCode.click();
	 }
	 
	 public void getViewPromoCode() {
		String tes = getDetailsPromo.getText();
		System.out.println(tes);
		
	}

	 //filter Promo Code
	 @FindBy(id = "listing-filter-toggle")
	 private WebElement filterPromoCode;
	 
	 @FindBy(id = "search_promo_code")
	 private WebElement search_promo_code;
	 
	 public void filterPromoCode() {
		filterPromoCode.click();
		
	}
	 
	 public void filterPromoCodeSearch() {
		 search_promo_code.sendKeys("promo500");
	 }

	 //Update Promo code
	 @FindBy(xpath = "(//i[@class=\"fa fa-edit\"])[1]")
	 private WebElement updatePromoCode;
	 
	 @FindBy(id = "promo_code")
	 private WebElement updateData;
	 
	 @FindBy(xpath = "//button[.=\"Submit\"]")
	 private WebElement updatePromoBtn;
	 
	 public void updatePromoCode() {
		 updatePromoCode.click();
		
	}
	 
	 public void updateData() {
		 updateData.clear();
		 updateData.sendKeys("promo500");
		
	}
	 
	 public void updatePromoBtn() {
		 updatePromoBtn.click();
	 }
	 
	 
}
