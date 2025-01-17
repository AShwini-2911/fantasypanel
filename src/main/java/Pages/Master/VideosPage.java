package Pages.Master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;

public class VideosPage extends DriverManager {
	
	 private WebDriver driver;

	 public VideosPage() {
			PageFactory.initElements(webDriver.get(), this);
		}
	
	 //Add video
	@FindBy(xpath = "//i[@class=\"fa fa-plus\"]")
	private WebElement AddVideo;
	
	@FindBy(id = "title")
    private WebElement Title;
	
	@FindBy(id = "description")
	private WebElement Description;
	
	@FindBy(id = "url")
	private WebElement url;
	
	@FindBy(xpath = "//button[.=\"Submit\"]")
	private WebElement VideoSubmit;
	
	@FindBy(xpath = "//p[.=\"Data Added Successfully\"]")
	private WebElement videoSuccessMsg;
	
	@FindBy(xpath = "//p[.=\"Video already exist.\"]")
	private WebElement videoTitleExist; 
	
	@FindBy(partialLinkText = "Cancel")
	private WebElement videoCancel;
	
	@FindBy(xpath = "//i[@class=\"fa fa-arrow-left\"]")
	private WebElement videoBackbtn;
	
	@FindBy(xpath = "//p[.=\"Invalid Url Passed\"]")
	private WebElement videoURLInvalid;
	
	//Upadate video
	
	@FindBy(xpath = "(//i[@class=\"fa fa-edit\"])[1]")
	private WebElement UpdateVideo;
	
	@FindBy(id = "title")
	private WebElement UpdateTitle;
	
	@FindBy(xpath = "//button[.=\"Update\"]")
	private WebElement UpdateBtn;
	
	
	//View Video
	@FindBy(xpath = "(//i[@class=\"fa fa-eye\"])[1]")
	private WebElement ViewVideo;
	
	@FindBy(tagName = "tbody")
	private WebElement GetVideoDetails;
	
	
	//Filter video
	@FindBy(id = "listing-filter-toggle")
	private WebElement clickVideoFilter;
	
	@FindBy(id = "search_title")
	private WebElement titleFilter;
	
	@FindBy(tagName = "tbody")
	private WebElement FilteredData;
	
	
	
	
	
    //methods
	//Add Video
	public void clickAddVideo() {
		AddVideo.click();
	}
	public void enterTitle(String title) {
        
        Title.sendKeys(title);
    }
	
	public void enterDescription(String description) {
	        
	        Description.sendKeys(description);
	    }
	
	public void enterURL(String URL) {
	    url.sendKeys(URL);
	    
	}
	
	public void videoSubmit() {
		VideoSubmit.click();
		
	}
	
	public String videoSuccessMsg() {
		return videoSuccessMsg.getText();
	}
	
	public String VideoTitleBorderColor() throws InterruptedException {
		 VideoSubmit.click();
		 Thread.sleep(2000);
	        return Title.getCssValue("border-color");
	    }
	
	public String videoTitleExistsMsg() {
		return videoTitleExist.getText();
	}
	
	public String videoURLInvalidMsg() {
		return videoURLInvalid.getText();
	}
	
	public void clickCancelVideo() {
		videoCancel.click();
	}
	
	public void clickBackBtnVideo() {
		videoBackbtn.click();
	}
	
	//update video
	public void clickUpdateVideo() {
		UpdateVideo.click();
	}
	
	public void updateTitle(String title) {
        
        UpdateTitle.sendKeys(title);
    }
	
	public void VideoUpdateBtn() {
		UpdateBtn.click();
	}
	
	
	
	
	//View Video
	public void clickViewVideo() {
		ViewVideo.click();
	}
	
	public void getVideoDetails() {
		String text = GetVideoDetails.getText();
		System.out.println(text);
	}
	
	
	//Filter Video
	public void clickVideoFilter() {
		clickVideoFilter.click();
	}
	
	public void titleFilter(String updateTitle) {
		
		titleFilter.sendKeys(updateTitle);
	}
	
	public void filteredData() {
		String filteredData = FilteredData.getText();
		System.out.println(filteredData);
	}
}
	
