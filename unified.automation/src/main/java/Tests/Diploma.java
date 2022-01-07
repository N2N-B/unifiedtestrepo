package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Common.Attributes;
import Common.CommonFunctions;
import Helper.GlobalProperties;
import Helper.OpentapsWrappers;
import Helper.Reporter;
import Pages.AcademicInfoPage;
import Pages.OnboardingPage;

public class Diploma extends OpentapsWrappers {

	@Test(priority = 1)
	public void clickAddDetailsAndDiplomaButton() {

		Reporter.testCaseName = "Academic: Diploma Details";
		Reporter.testDescription = "Check the save button to see the result";
		Reporter.startTestCase();
		GlobalProperties.webdriver.manage().window().maximize();
		OnboardingPage onboardingPage = new OnboardingPage(GlobalProperties.webdriver);
		onboardingPage.clickAcademicInformation().click();
		Helper.Reporter.reportStep("Entered into academic information", "PASS");
		AcademicInfoPage academicInfoPage = new AcademicInfoPage(GlobalProperties.webdriver);
		academicInfoPage.clickAddDetailsButton().click();
		academicInfoPage.clickDiplomoGradeButton().click();
		Helper.Reporter.reportStep("Entered into Diploma", "PASS");

	}

	@Test(priority = 2,groups = { "NegativeTests" })
	public void validateNegativeDiplomaInfo() {

		GlobalProperties.webdriver.manage().window().maximize();

		CommonFunctions commonFunctions = new CommonFunctions(GlobalProperties.webdriver);

		commonFunctions.getCollegeName().click();
		Helper.Reporter.reportStep("College Combo gets clicked", "PASS");


		FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(GlobalProperties.webdriver)
				.withTimeout(Duration.ofSeconds(4)).pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		fWait.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.Diploma.collegeXpath))).click();
		Helper.Reporter.reportStep("College Combo value clicked", "PASS");


		commonFunctions.getUniversityName().click();
		Helper.Reporter.reportStep("University Combo gets clicked", "PASS");


		FluentWait<WebDriver> fWait1 = new FluentWait<WebDriver>(GlobalProperties.webdriver)
				.withTimeout(Duration.ofSeconds(4)).pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		fWait1.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.Diploma.universityXpath))).click();
		Helper.Reporter.reportStep("University Combo value clicked", "PASS");


		commonFunctions.getFieldOfStudy().click();
		Helper.Reporter.reportStep("Field Of Study Combo gets clicked", "PASS");


		FluentWait<WebDriver> fWait3 = new FluentWait<WebDriver>(GlobalProperties.webdriver)
				.withTimeout(Duration.ofSeconds(4)).pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		fWait3.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.Diploma.fieldOfStudyXpath))).click();
		Helper.Reporter.reportStep("Field Of Study Combo value clicked", "PASS");


		commonFunctions.getStartDate().sendKeys(Attributes.Diploma.$start_Date);
		Helper.Reporter.reportStep("Start Date entered", "PASS");

		commonFunctions.getEndDate().sendKeys(Attributes.Diploma.$end_Date);
		Helper.Reporter.reportStep("End Date entered", "PASS");

		commonFunctions.gradeScale().click();
		Helper.Reporter.reportStep("Grade Scale Combo gets clicked", "PASS");

		WebDriverWait webDriverWait4 = new WebDriverWait(GlobalProperties.webdriver, Duration.ofSeconds(3));
		webDriverWait4.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.Diploma.$gradeScaleXpath)))
				.click();
		Helper.Reporter.reportStep("Grade Scale Combo value clicked", "PASS");


		commonFunctions.getPercentageCgpa().sendKeys(Attributes.Diploma.$cgpa);
		Helper.Reporter.reportStep("CGPA entered", "PASS");


		commonFunctions.getSaveButton().click();
		Helper.Reporter.reportStep("Save button is clicked", "PASS");

		commonFunctions.getErrorMessage();
		commonFunctions.clickOnBoarding();
		Helper.Reporter.reportStep("Back to onboarding", "PASS");


	}

	@Test(groups = { "PositiveTests" }, enabled = false)
	public void validateDiplomaInfo() {

		Reporter.testCaseName = "Enter the diploma info of the student";
		Reporter.testDescription = "Check the save button to see the result";
		Reporter.startTestCase();
		GlobalProperties.webdriver.manage().window().maximize();

		CommonFunctions commonFunctions = new CommonFunctions(GlobalProperties.webdriver);

		commonFunctions.getCollegeName().click();

		FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(GlobalProperties.webdriver)
				.withTimeout(Duration.ofSeconds(4)).pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		fWait.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.Diploma.collegeXpath))).click();

		commonFunctions.getUniversityName().click();

		FluentWait<WebDriver> fWait1 = new FluentWait<WebDriver>(GlobalProperties.webdriver)
				.withTimeout(Duration.ofSeconds(4)).pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		fWait1.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.Diploma.universityXpath))).click();

		commonFunctions.getDiplomaType().click();
		FluentWait<WebDriver> fWait2 = new FluentWait<WebDriver>(GlobalProperties.webdriver)
				.withTimeout(Duration.ofSeconds(4)).pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		fWait2.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.Diploma.diplomaXpath))).click();

		commonFunctions.getFieldOfStudy().click();

		FluentWait<WebDriver> fWait3 = new FluentWait<WebDriver>(GlobalProperties.webdriver)
				.withTimeout(Duration.ofSeconds(4)).pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		fWait3.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.Diploma.fieldOfStudyXpath))).click();

		commonFunctions.getStartDate().sendKeys(Attributes.Diploma.$start_Date);
		commonFunctions.getEndDate().sendKeys(Attributes.Diploma.$end_Date);

		commonFunctions.gradeScale().click();
		WebDriverWait webDriverWait4 = new WebDriverWait(GlobalProperties.webdriver, Duration.ofSeconds(3));
		webDriverWait4.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.Diploma.$gradeScaleXpath)))
				.click();

		commonFunctions.getPercentageCgpa().sendKeys(Attributes.Diploma.$cgpa);

		commonFunctions.getSaveButton().click();
		commonFunctions.getErrorMessage();

	}

}
