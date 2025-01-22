package Pages.FAQ;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.DriverManager;

public class FAQPage extends DriverManager {
	
	public FAQPage() {

		PageFactory.initElements(webDriver.get(), this);
    }

	//add FAQ
	@FindBy(xpath = "//span[.=\"FAQs\"]")
	private WebElement ClickFAQ;
	
	@FindBy(xpath = "//i[@class=\"fa fa-plus\"]")
	private WebElement addFAQ;
	
	@FindBy(id = "sequence")
	private WebElement enterSeq;
	
	@FindBy(partialLinkText = "English")
	private WebElement EnglishLang;
	
	@FindBy(id = "question_en")
	private WebElement enterEngQues;
	
	@FindBy(id = "answer_en")
	private WebElement enterEngAns;
	
	@FindBy(partialLinkText = "Hindi")
	private WebElement HindiLang;
	
	@FindBy(id = "question_hi")
	private WebElement enterHiQues;
	
	@FindBy(id = "answer_hi")
	private WebElement enterHiAns;
	
	@FindBy(xpath = "//button[.=\"Submit\"]")
	private WebElement FAQSubmit;
	
	@FindBy(xpath = "//a[.=\" Cancel\"]")
	private WebElement FAQCancel;
	
	@FindBy(xpath = "//p[.=\"Data Added Successfully\"]")
	private WebElement FAQSuccesMsg;
	
	@FindBy(tagName = "table")
	private WebElement tableData;
	
	@FindBy(xpath = "//p[.=\"Title already exist.\"]")
	private WebElement duplicateErrorMsg;
	
	public void clickFAQ() {
		ClickFAQ.click();
	}
	
	public void clickAddFAQ() {
		addFAQ.click();
	}
	
	public void enterSequence() {
		enterSeq.sendKeys("15");
		
	}
	
	public void clickEnglish() {
		EnglishLang.click();
	}
	
	public void clickHindi() {
		HindiLang.click();
	}
	
	public void enterQandAEng() {
		enterEngQues.sendKeys("Why I receive my free bet?");
		enterEngAns.sendKeys("When you try and claim a free bet.");
	}
	
	public void enterQandAHi() {
		enterHiQues.sendKeys("Why I receive my free bet?");
		enterHiAns.sendKeys("When you try and claim a free bet.");
	}
	
	public void submitFAQ() {
		FAQSubmit.click();
	}
	
	public void cancelFAQ() {
		FAQCancel.click();
	}
	
	public String getFAQSuccessMsg() {
		return FAQSuccesMsg.getText();
	}
	
	public String getFAQDuplicateDataMsg() {
		return duplicateErrorMsg.getText();
	}
	public String SequenceFAQColor() throws InterruptedException {
		FAQSubmit.click();
		 Thread.sleep(2000);
	     return enterHiQues.getCssValue("border-color");
	    }
	
	public String getFAQListing() {
		return tableData.getText();
	}
	
	//view FAQ
	@FindBy(xpath = "(//i[@class=\"fa fa-eye\"])[1]")
	private WebElement viewFAQ;
	
	public void clickViewFAQ() {
		viewFAQ.click();
	}
	
	//Update FAQ
	@FindBy(xpath = "(//i[@class=\"fa fa-edit\"])[1]")
	private WebElement updateFAQ;
	
	@FindBy(xpath = "//p[.=\"Data Updated Successfully\"]")
	private WebElement updateFAQSuccessMsg;
	
	public void updateFAQ() {
		updateFAQ.click();
	}
	
	public void updatesequence() {
		enterSeq.clear();
		enterSeq.sendKeys("1");
	}
	
	public String updateFAQSuccessMsg() {
		return updateFAQSuccessMsg.getText();
	}
	
	//filter
	@FindBy(xpath = "//i[@class=\"fa fa-filter\"]")
	private WebElement filterFAQ;
	
	@FindBy(id = "search_question")
	private WebElement filterFAQQuestion;
	
	@FindBy(id = "search_status")
	private WebElement filterFAQStatus;
	
	public void clickFilterFAQ() {
		filterFAQ.click();
	}
	
	public void filterFAQQues() {
		filterFAQQuestion.sendKeys("bonuses?");
	}
	
	 public void selectInactiveDropdownOption() {
		    Select dropdown = new Select(filterFAQStatus);
		    dropdown.selectByVisibleText("Inactive");
		}
}
