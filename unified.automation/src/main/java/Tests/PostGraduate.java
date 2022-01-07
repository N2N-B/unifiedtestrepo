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
import Helper.SeleniumHelper;
import Pages.AcademicInfoPage;
import Pages.OnboardingPage;

public class PostGraduate extends OpentapsWrappers {

	@Test(priority = 1)
	public void clickAddDetailsAndPostGradGradeButton() {

		Reporter.testCaseName = "Academic: Postgraduate Details";
		Reporter.testDescription = "Check the save button to see the result";
		Reporter.startTestCase();
		GlobalProperties.webdriver.manage().window().maximize();
		OnboardingPage onboardingPage = new OnboardingPage(GlobalProperties.webdriver);
		SeleniumHelper.WaitForPageToLoad(30);
		onboardingPage.clickAcademicInformation().click();
		Helper.Reporter.reportStep("Entered into academic information", "PASS");
		AcademicInfoPage academicInfoPage = new AcademicInfoPage(GlobalProperties.webdriver);
		academicInfoPage.clickAddDetailsButton().click();
		academicInfoPage.clickPostGradGradeButton().click();
		Helper.Reporter.reportStep("Entered into postgraduate", "PASS");

	}

	@Test(priority = 2, groups = { "NegativeTests" })
	public void validateNegativePostGradInfo() {

		GlobalProperties.webdriver.manage().window().maximize();

		CommonFunctions commonFunctions = new CommonFunctions(GlobalProperties.webdriver);

		commonFunctions.getCollegeName().click();
		Helper.Reporter.reportStep("College Combo gets clicked", "PASS");

		FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(GlobalProperties.webdriver)
				.withTimeout(Duration.ofSeconds(4)).pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		fWait.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.PostGraduate.collegeListXpath)))
				.click();
		Helper.Reporter.reportStep("College Combo value clicked", "PASS");

		commonFunctions.getUniversityName().click();
		Helper.Reporter.reportStep("University Combo gets clicked", "PASS");

		FluentWait<WebDriver> fWait1 = new FluentWait<WebDriver>(GlobalProperties.webdriver)
				.withTimeout(Duration.ofSeconds(4)).pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		fWait1.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.PostGraduate.universityListXpath)))
				.click();
		Helper.Reporter.reportStep("University Combo value clicked", "PASS");

		commonFunctions.getFieldOfStudy().click();
		Helper.Reporter.reportStep("Field Of Study Combo gets clicked", "PASS");

		FluentWait<WebDriver> fWait3 = new FluentWait<WebDriver>(GlobalProperties.webdriver)
				.withTimeout(Duration.ofSeconds(4)).pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		fWait3.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.PostGraduate.courseListXpath)))
				.click();
		Helper.Reporter.reportStep("Field Of Study Combo value clicked", "PASS");

		commonFunctions.getStartDate().sendKeys(Attributes.PostGraduate.start_Date);
		Helper.Reporter.reportStep("Start Date entered", "PASS");

		commonFunctions.getEndDate().sendKeys(Attributes.PostGraduate.end_Date);
		Helper.Reporter.reportStep("End Date entered", "PASS");

		commonFunctions.gradeScale().click();
		Helper.Reporter.reportStep("Grade Scale Combo gets clicked", "PASS");
		WebDriverWait webDriverWait4 = new WebDriverWait(GlobalProperties.webdriver, Duration.ofSeconds(3));
		webDriverWait4.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.PostGraduate.gradeListXpath)))
				.click();
		Helper.Reporter.reportStep("Grade Scale Combo value clicked", "PASS");

		commonFunctions.getPercentageCgpa().sendKeys(Attributes.PostGraduate.$cgpa);
		Helper.Reporter.reportStep("CGPA entered", "PASS");

		commonFunctions.getSaveButton().click();
		Helper.Reporter.reportStep("Save button is clicked", "PASS");

		commonFunctions.getErrorMessage();
		GlobalProperties.webdriver.quit();

	}

	@Test(groups = { "PositiveTests" }, enabled = false)
	public void validatePostGradInfo() {

		Reporter.testCaseName = "Enter the post graduate info of the student";
		Reporter.testDescription = "Check the save button to see the result";
		Reporter.startTestCase();
		GlobalProperties.webdriver.manage().window().maximize();

		CommonFunctions commonFunctions = new CommonFunctions(GlobalProperties.webdriver);

		commonFunctions.getCollegeName().click();

		FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(GlobalProperties.webdriver)
				.withTimeout(Duration.ofSeconds(4)).pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		fWait.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.PostGraduate.collegeListXpath)))
				.click();

		commonFunctions.getUniversityName().click();

		FluentWait<WebDriver> fWait1 = new FluentWait<WebDriver>(GlobalProperties.webdriver)
				.withTimeout(Duration.ofSeconds(4)).pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		fWait1.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.PostGraduate.universityListXpath)))
				.click();

		commonFunctions.getDegreeType().click();

		FluentWait<WebDriver> fWait2 = new FluentWait<WebDriver>(GlobalProperties.webdriver)
				.withTimeout(Duration.ofSeconds(4)).pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		fWait2.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.PostGraduate.degreeListXpath)))
				.click();

		commonFunctions.getFieldOfStudy().click();

		FluentWait<WebDriver> fWait3 = new FluentWait<WebDriver>(GlobalProperties.webdriver)
				.withTimeout(Duration.ofSeconds(4)).pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		fWait3.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.PostGraduate.courseListXpath)))
				.click();

		commonFunctions.getStartDate().sendKeys(Attributes.PostGraduate.start_Date);
		commonFunctions.getEndDate().sendKeys(Attributes.PostGraduate.end_Date);

		commonFunctions.gradeScale().click();
		WebDriverWait webDriverWait4 = new WebDriverWait(GlobalProperties.webdriver, Duration.ofSeconds(3));
		webDriverWait4.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.PostGraduate.gradeListXpath)))
				.click();

		commonFunctions.getPercentageCgpa().sendKeys(Attributes.PostGraduate.$cgpa);

		commonFunctions.getSaveButton().click();
		commonFunctions.getErrorMessage();

	}

}
