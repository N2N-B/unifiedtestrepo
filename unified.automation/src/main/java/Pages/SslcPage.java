package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Helper.GlobalProperties;

public class SslcPage {

	public WebDriver webdriver;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'School Name')]/following::input[@name='schoolName']")
	private WebElement elm_schoolName;

	@FindBy(how = How.XPATH, using = "//input[@name='examBoardName']")
	private WebElement elm_examBoardDropDown;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Start Date')]/following::input[@id='startDate']")
	private WebElement elm_startDate;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'End Date')]/following::input[@id = 'endDate']")
	private WebElement elm_endDate;

	@FindBy(how = How.XPATH, using = "//input[@name='scoreScale']")
	private WebElement elm_gradingScale;

	@FindBy(how = How.XPATH, using = "//*[contains(@class,'endAdorn')]//*[name()='path' and contains(@d,'M7')]")
	private WebElement elm_gradeScale;

	@FindBy(how = How.XPATH, using = "//*[@name='cgpa']")
	private WebElement elm_percentageCgpa;

	@FindBy(how = How.XPATH, using = "//*[name()='path' and contains(@d,'M5')]")
	private WebElement elm_uploadMarkSheet;

	@FindBy(how = How.XPATH, using = "//*[text()='Please Fill The Required Field']")
	private WebElement elm_errorMessage;

	public SslcPage(WebDriver webdriver) {
		this.webdriver = webdriver;
		PageFactory.initElements(webdriver, this);
	}

	public WebElement getSchoolName() {
		return elm_schoolName;
	}

	public WebElement getExamBoardCombo() {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) GlobalProperties.webdriver;
		javascriptExecutor.executeScript("arguments[0].click()", elm_examBoardDropDown);
		return elm_examBoardDropDown;
	}

	public WebElement getStartDate() {
		return elm_startDate;
	}

	public WebElement getEndDate() {
		return elm_endDate;
	}

	public WebElement gradingScale() {
		return elm_gradingScale;
	}

	public WebElement getPercentageCgpa() {
		return elm_percentageCgpa;
	}

	public WebElement uploadSheet() {
		return elm_uploadMarkSheet;
	}

}
