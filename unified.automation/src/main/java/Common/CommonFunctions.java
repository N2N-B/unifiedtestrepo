package Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Helper.Reporter;
import Helper.SeleniumHelper;

public class CommonFunctions {
	public WebDriver webdriver;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Save')]")
	private WebElement elm_saveButton;

	@FindBy(how = How.XPATH, using = "//p[text()='Onboarding']")
	private WebElement elm_onBoarding;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Continue')]")
	private WebElement elm_continueButton;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Cancel')]")
	private WebElement elm_cancelButton;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'School Name')]/following::input[@name='schoolName']")
	private WebElement elm_schoolName;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Start Date')]/following::input[@id='startDate']")
	private WebElement elm_startDate;

	@FindBy(how = How.XPATH, using = "//*[@name='cgpa']")
	private WebElement elm_percentageCgpa;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'College Name')]/following::input")
	private WebElement elm_collegeName;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'University Name')]/following::input")
	private WebElement elm_universityName;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Diploma Type')]/following::input")
	private WebElement elm_diplomaType;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Degree Type')]/following::input")
	private WebElement elm_degreeType;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Field of Study')]/following::input")
	private WebElement elm_fieldOfStudy;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Add semester')]")
	private WebElement elm_addSemester;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Please Fill The Required Field')]")
	private WebElement elm_errorMessage;

	@FindBy(how = How.XPATH, using = "//*[name()='path' and contains(@d,'M7')]")
	private WebElement elm_gradingScale;

	@FindBy(how = How.XPATH, using = "//label[text()='Grading Scale']/following::input[@type='text']")
	private WebElement elm_gradeScale;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'End Date')]/following::input[@id = 'endDate']")
	private WebElement elm_endDate;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'End Date')]/following::input[@type= 'date']")
	private WebElement elm_endDate1;

	public CommonFunctions(WebDriver webdriver) {
		this.webdriver = webdriver;
		PageFactory.initElements(webdriver, this);
	}

	public void clickOnBoarding() {
		elm_onBoarding.click();
		SeleniumHelper.WaitForPageToLoad(30);
	}

	public WebElement getSaveButton() {
		return elm_saveButton;
	}

	public WebElement getContinueButton() {
		return elm_continueButton;
	}

	public WebElement getCancelButton() {
		return elm_cancelButton;
	}

	public WebElement getSchoolName() {
		return elm_schoolName;
	}

	public WebElement getStartDate() {
		return elm_startDate;
	}

	public WebElement getPercentageCgpa() {
		return elm_percentageCgpa;
	}

	public WebElement getCollegeName() {
		return elm_collegeName;
	}

	public WebElement getUniversityName() {
		return elm_universityName;
	}

	public WebElement getDiplomaType() {
		return elm_diplomaType;
	}

	public WebElement getDegreeType() {
		return elm_degreeType;
	}

	public WebElement getFieldOfStudy() {
		return elm_fieldOfStudy;
	}

	public WebElement getAddSemester() {
		return elm_addSemester;
	}

	public WebElement gradingScale() {
		return elm_gradingScale;
	}

	public WebElement gradeScale() {
		return elm_gradeScale;
	}

	public WebElement getEndDate() {
		return elm_endDate;
	}

	public WebElement getEndDate1() {
		return elm_endDate1;
	}

	public WebElement getErrorMessage() {
		WebElement element = null;

		try {
			try {
				element = SeleniumHelper.fluentWaitForElement(Attributes.Common.fillTheReqField,
						"presenceOfElementLocated", 10, 2);
			} catch (Exception e) {
				element = null;
			}

			if (element != null) {
				Reporter.reportStep("Please fill the required field [Popup Detected]", "FAIL");
			}

		} catch (Exception ex) {
			Reporter.reportStep(ex.getMessage(), "FAIL");
		}

		return elm_errorMessage;
	}

}
