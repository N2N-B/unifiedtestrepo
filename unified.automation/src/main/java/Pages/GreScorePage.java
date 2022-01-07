package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import Helper.Reporter;

public class GreScorePage {

	public WebDriver webdriver;

	@FindBy(how = How.XPATH, using = "//self::h6[contains(text(),'Add GRE Exam Details')]//parent::div//*[name()='path' and contains(@d,'M12')]")
	private WebElement elm_addGreExamDetailsButton;

	@FindBy(how = How.XPATH, using = "//*[@type='radio' and @value='no']")
	private WebElement elm_noRadioButton;

	@FindBy(how = How.XPATH, using = "//*[@type='radio' and @value='yes']")
	private WebElement elm_yesRadioButton;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Expected Exam Date')]/following::input[@type= 'date']")
	private WebElement elm_expectedExamDate;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Please Fill The Required Field')]")
	private WebElement elm_errorMessage;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Save')]")
	private WebElement elm_saveButton;

	@FindBy(how = How.XPATH, using = "//self::label[contains(text(),'Attempt')]//parent::div//*[name()='path' and contains(@d,'M7')]")
	private WebElement elm_noOfAttemptsDropDown;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Exam Date')]/following::input[@type= 'date']")
	private WebElement elm_examDate;

	@FindBy(how = How.XPATH, using = "//*[@name='verbalReasoning']")
	private WebElement elm_verbalReasoning;

	@FindBy(how = How.XPATH, using = "//*[@name='quantitativeReasoning']")
	private WebElement elm_quantitativeReasoning;

	@FindBy(how = How.XPATH, using = "//self::label[contains(text(),'Analytical Writing')]//parent::div//*[name()='path' and contains(@d,'M7')]")
	private WebElement elm_analyticalWritingDropDown;

	@FindBy(how = How.XPATH, using = "//*[@name='score']")
	private WebElement elm_totalScore;

	@FindBy(how = How.XPATH, using = "//self::p[contains(text(),'Upload Test Score Card')]//parent::div//*[name()='path' and contains(@d,'M5')]")
	private WebElement elm_uploadMarkSheet;

	public GreScorePage(WebDriver webdriver) {
		this.webdriver = webdriver;
		PageFactory.initElements(webdriver, this);
	}

	public WebElement clickNoOfAttemptsDropDown() {
		return elm_noOfAttemptsDropDown;
	}

	public WebElement enterExamDate() {
		return elm_examDate;
	}

	public WebElement enterVerbalReasoning() {
		return elm_verbalReasoning;
	}

	public WebElement enterQuantitativeReasoning() {
		return elm_quantitativeReasoning;
	}

	public WebElement clickAnalyticalWritingDropDown() {
		return elm_analyticalWritingDropDown;
	}

	public WebElement clickUploadMarkSheet() {
		return elm_uploadMarkSheet;
	}

	public WebElement enterTotalScore() {
		return elm_totalScore;
	}

	public WebElement getSaveButton() {
		return elm_saveButton;
	}

	public WebElement clickAddProfessionalExperienceButton() {
		return elm_addGreExamDetailsButton;
	}

	public WebElement clickNoRadioButton() {
		return elm_noRadioButton;
	}

	public WebElement clickYesRadioButton() {
		return elm_yesRadioButton;
	}

	public WebElement enterExpectedExamDate() {
		return elm_expectedExamDate;
	}

	public WebElement getErrorMessage() {
		WebElement element = null;

		try {
			FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(webdriver).withTimeout(Duration.ofSeconds(10))
					.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class, TimeoutException.class);
			try {
				element = fWait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//*[contains(text(),'Please Fill The Required Field')]")));
			} catch (Exception e) {
				element = null;
			}

			if (element == null) {
				Reporter.reportStep("A popup Message Box Shown Updated Successfully", "PASS");
			} else {
				Reporter.reportStep("Please fill the required field [Popup Detected]", "FAIL");
			}

		}

		catch (Exception ex) {

		}

		return elm_errorMessage;
	}

}
