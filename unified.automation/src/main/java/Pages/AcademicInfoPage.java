package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AcademicInfoPage {

	public WebDriver webdriver;

	@FindBy(how = How.XPATH, using = "//*[@type='button']//*[text()='+ Start Adding Details']")
	private WebElement elm_addDetailsButton;

	@FindBy(how = How.XPATH, using = "//*[@type='button']//*[text()='10th Grade']")
	private WebElement elm_tenthGradeButton;

	@FindBy(how = How.XPATH, using = "//*[@type='button']//*[text()='12th Grade']")
	private WebElement elm_plus2GradeButton;

	@FindBy(how = How.XPATH, using = "//*[@type='button']//*[text()='Diploma Course']")
	private WebElement elm_diplomoGradeButton;

	@FindBy(how = How.XPATH, using = "//*[@type='button']//*[text()='Undergraduate Degree']")
	private WebElement elm_underGradGradeButton;

	@FindBy(how = How.XPATH, using = "//*[@type='button']//*[text()='Postgraduate Degree']")
	private WebElement elm_postGradGradeButton;

	public AcademicInfoPage(WebDriver webdriver) {
		this.webdriver = webdriver;
		PageFactory.initElements(webdriver, this);
	}

	public WebElement clickAddDetailsButton() {
		return elm_addDetailsButton;
	}

	public WebElement clickTenthGradeButton() {
		return elm_tenthGradeButton;
	}

	public WebElement clickPlus2GradeButton() {
		return elm_plus2GradeButton;
	}

	public WebElement clickDiplomoGradeButton() {
		return elm_diplomoGradeButton;
	}

	public WebElement clickUnderGradGradeButton() {
		return elm_underGradGradeButton;
	}

	public WebElement clickPostGradGradeButton() {
		return elm_postGradGradeButton;
	}

}
