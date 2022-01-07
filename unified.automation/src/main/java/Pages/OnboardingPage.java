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

public class OnboardingPage {
	public WebDriver webdriver;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Onboarding Complete')]")
	private WebElement elm_onBoarding;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Personal Information')]")
	private WebElement elm_personalInformation;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Academic Information')]")
	private WebElement elm_academicInformation;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Tell us about your professional journey here.')]")
	private WebElement elm_workExperience;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Aspiration Details')]")
	private WebElement elm_aspirationalDetails;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Graduate Admission Test')]")
	private WebElement elm_graduateAdmissionTest;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Tests and Survey')]")
	private WebElement elm_testsAndSurvey;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Upload CV')]")
	private WebElement elm_uploadCv;

	public OnboardingPage(WebDriver webdriver) {
		this.webdriver = webdriver;
		PageFactory.initElements(webdriver, this);
	}

	public WebElement clickOnBoarding() {
		return elm_onBoarding;
	}

	public WebElement clickPersonalInformation() {
		FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(webdriver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class, TimeoutException.class);

		try {
			fWait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//*[contains(text(),'Personal Information')]")));
		} catch (Exception e) {

			System.out.println("Element Not found trying again - " + elm_personalInformation.toString().substring(70));
			e.printStackTrace();
		}
		return elm_personalInformation;

	}

	public WebElement clickAcademicInformation() {
		return elm_academicInformation;
	}

	public WebElement clickWorkExperience() {
		return elm_workExperience;
	}

	public WebElement clickAspirationalDetails() {
		return elm_aspirationalDetails;
	}

	public WebElement clickGraduateAdmissionTest() {
		return elm_graduateAdmissionTest;
	}

	public WebElement clickTestsAndSurvey() {
		return elm_testsAndSurvey;
	}

	public WebElement clickUploadCv() {
		return elm_uploadCv;
	}

}
