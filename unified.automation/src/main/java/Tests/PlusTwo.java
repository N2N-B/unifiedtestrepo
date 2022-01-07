package Tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Common.Attributes;
import Common.CommonFunctions;
import Helper.GlobalProperties;
import Helper.OpentapsWrappers;
import Helper.Reporter;
import Pages.AcademicInfoPage;
import Pages.OnboardingPage;
import Pages.PlusTwoPage;

public class PlusTwo extends OpentapsWrappers {

	@Test(priority = 1)
	public void clickAddDetailsAndPlus2GradeButton() {

		Reporter.testCaseName = "Academic: 12th Grade";
		Reporter.testDescription = "Check the save button to see the result";
		Reporter.startTestCase();
		GlobalProperties.webdriver.manage().window().maximize();
		OnboardingPage onboardingPage = new OnboardingPage(GlobalProperties.webdriver);
		onboardingPage.clickAcademicInformation().click();
		Helper.Reporter.reportStep("Entered into academic information", "PASS");
		AcademicInfoPage academicInfoPage = new AcademicInfoPage(GlobalProperties.webdriver);
		academicInfoPage.clickAddDetailsButton().click();
		academicInfoPage.clickPlus2GradeButton().click();
		Helper.Reporter.reportStep("Entered into 12th grade", "PASS");

	}

	@Test(priority = 2, groups = { "NegativeTests" })
	public void validateNegativePlus2GradeInfo() throws AWTException {

		GlobalProperties.webdriver.manage().window().maximize();

		CommonFunctions commonFunctions = new CommonFunctions(GlobalProperties.webdriver);
		PlusTwoPage plusTwoPage = new PlusTwoPage(GlobalProperties.webdriver);
		plusTwoPage.getSchoolName().sendKeys(Attributes.PlusTwo.schoolXpath);
		Helper.Reporter.reportStep("School Name Entered", "PASS");
		plusTwoPage.getExamBoardDropDown().click();
		Helper.Reporter.reportStep("Examination Board Combo gets clicked", "PASS");
		WebDriverWait webDriverWait = new WebDriverWait(GlobalProperties.webdriver, Duration.ofSeconds(3));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.PlusTwo.examBoardXpath)))
				.click();
		Helper.Reporter.reportStep("Examination Board Combo value clicked", "PASS");
		plusTwoPage.getStartDate().sendKeys(Attributes.PlusTwo.$start_Date);
		Helper.Reporter.reportStep("Start Date entered", "PASS");
		plusTwoPage.getEndDate().sendKeys(Attributes.PlusTwo.$end_Date);
		Helper.Reporter.reportStep("End Date entered", "PASS");

		Robot ro_bot = new Robot();

		WebDriverWait webDriverWait3 = new WebDriverWait(GlobalProperties.webdriver, Duration.ofSeconds(3));
		webDriverWait3.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.PlusTwo.uploadFileXpath)))
				.click();
		Helper.Reporter.reportStep("Upload file is clicked", "PASS");

		ro_bot.setAutoDelay(2000);

		StringSelection stringSelection = new StringSelection(Attributes.PlusTwo.fileUpload);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		ro_bot.setAutoDelay(3000);

		ro_bot.keyPress(KeyEvent.VK_CONTROL);
		ro_bot.keyPress(KeyEvent.VK_V);

		ro_bot.setAutoDelay(3000);

		ro_bot.keyPress(KeyEvent.VK_ENTER);
		ro_bot.keyRelease(KeyEvent.VK_ENTER);
		Helper.Reporter.reportStep("File is uploaded", "PASS");

		commonFunctions.getSaveButton().click();
		Helper.Reporter.reportStep("Save button is clicked", "PASS");

		commonFunctions.getErrorMessage();
		commonFunctions.clickOnBoarding();
		Helper.Reporter.reportStep("Back to onboarding", "PASS");

	}

	@Test(groups = { "PositiveTests" }, enabled = false)
	public void validatePlus2GradeInfo() throws AWTException {

		GlobalProperties.webdriver.manage().window().maximize();

		CommonFunctions commonFunctions = new CommonFunctions(GlobalProperties.webdriver);
		PlusTwoPage plusTwoPage = new PlusTwoPage(GlobalProperties.webdriver);
		plusTwoPage.getSchoolName().sendKeys(Attributes.PlusTwo.schoolXpath);
		plusTwoPage.getExamBoardDropDown().click();
		WebDriverWait webDriverWait = new WebDriverWait(GlobalProperties.webdriver, Duration.ofSeconds(3));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.PlusTwo.examBoardXpath)))
				.click();

		plusTwoPage.getStartDate().sendKeys(Attributes.PlusTwo.$start_Date);
		plusTwoPage.getEndDate().sendKeys(Attributes.PlusTwo.$end_Date);
		plusTwoPage.gradingScale().click();

		WebDriverWait webDriverWait1 = new WebDriverWait(GlobalProperties.webdriver, Duration.ofSeconds(3));
		webDriverWait1.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.PlusTwo.$gradeScaleXpath)))
				.click();

		plusTwoPage.getPercentageCgpa().sendKeys(Attributes.PlusTwo.$cgpa);

		Robot ro_bot = new Robot();

		WebDriverWait webDriverWait3 = new WebDriverWait(GlobalProperties.webdriver, Duration.ofSeconds(3));
		webDriverWait3.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.PlusTwo.uploadFileXpath)))
				.click();

		ro_bot.setAutoDelay(2000);

		StringSelection stringSelection = new StringSelection(Attributes.PlusTwo.fileUpload);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		ro_bot.setAutoDelay(3000);

		ro_bot.keyPress(KeyEvent.VK_CONTROL);
		ro_bot.keyPress(KeyEvent.VK_V);

		ro_bot.setAutoDelay(3000);

		ro_bot.keyPress(KeyEvent.VK_ENTER);
		ro_bot.keyRelease(KeyEvent.VK_ENTER);

		commonFunctions.getSaveButton().click();
		commonFunctions.getErrorMessage();

	}

}
