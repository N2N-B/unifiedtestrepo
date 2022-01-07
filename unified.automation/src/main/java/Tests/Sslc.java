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
import Pages.SslcPage;

public class Sslc extends OpentapsWrappers {

	

	@Test(priority = 1)
	public void clickAddDetailsAndTenthGradeButton() {
		Reporter.testCaseName = "Academic: 10th Grade";
		Reporter.testDescription = "Check the save button to see the result";
		Reporter.startTestCase();
		GlobalProperties.webdriver.manage().window().maximize();
		OnboardingPage onboardingPage = new OnboardingPage(GlobalProperties.webdriver);
		onboardingPage.clickAcademicInformation().click();
		Helper.Reporter.reportStep("Entered into academic information", "PASS");
		AcademicInfoPage academicInfoPage = new AcademicInfoPage(GlobalProperties.webdriver);
		academicInfoPage.clickAddDetailsButton().click();
		academicInfoPage.clickTenthGradeButton().click();
		Helper.Reporter.reportStep("Entered into 10th grade", "PASS");

	}

	@Test(priority = 2,groups = { "NegativeTests" })
	public void validateNegativeTenthGradeInfo() throws AWTException {

		
		GlobalProperties.webdriver.manage().window().maximize();

		SslcPage sscPage = new SslcPage(GlobalProperties.webdriver);
		sscPage.getSchoolName().sendKeys(Attributes.Ssctenth.schoolXpath);
		Helper.Reporter.reportStep("School Name Entered", "PASS");
		sscPage.getExamBoardCombo().click();
		Helper.Reporter.reportStep("Examination Board Combo gets clicked", "PASS");

		WebDriverWait webDriverWait = new WebDriverWait(GlobalProperties.webdriver, Duration.ofSeconds(3));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.Ssctenth.examBoardXpath)))
				.click();
		Helper.Reporter.reportStep("Examination Board Combo value clicked", "PASS");


		sscPage.getStartDate().sendKeys(Attributes.Ssctenth.$start_Date);
		Helper.Reporter.reportStep("Start Date entered", "PASS");

		sscPage.getEndDate().sendKeys(Attributes.Ssctenth.$end_Date);
		Helper.Reporter.reportStep("End Date entered", "PASS");

		Robot ro_bot = new Robot();

		WebDriverWait webDriverWait3 = new WebDriverWait(GlobalProperties.webdriver, Duration.ofSeconds(3));
		webDriverWait3.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.Ssctenth.uploadFileXpath)))
				.click();
		Helper.Reporter.reportStep("Upload file is clicked", "PASS");


		ro_bot.setAutoDelay(2000);

		StringSelection stringSelection = new StringSelection(Attributes.Ssctenth.fileUpload);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		ro_bot.setAutoDelay(3000);

		ro_bot.keyPress(KeyEvent.VK_CONTROL);
		ro_bot.keyPress(KeyEvent.VK_V);

		ro_bot.setAutoDelay(3000);

		ro_bot.keyPress(KeyEvent.VK_ENTER);
		ro_bot.keyRelease(KeyEvent.VK_ENTER);
		Helper.Reporter.reportStep("File is uploaded", "PASS");


		CommonFunctions commonFunctions = new CommonFunctions(GlobalProperties.webdriver);
		commonFunctions.getSaveButton().click();
		Helper.Reporter.reportStep("Save button is clicked", "PASS");

		commonFunctions.getErrorMessage();
		commonFunctions.clickOnBoarding();
		Helper.Reporter.reportStep("Back to onboarding", "PASS");

	}

	@Test(groups = { "PositiveTests" }, enabled = false)
	public void validateTenthGradeInfo() throws AWTException {
		Reporter.testCaseName = "Enter the 10th grade info of the student";
		Reporter.testDescription = "Check the save button to see the result";
		Reporter.startTestCase();
		GlobalProperties.webdriver.manage().window().maximize();

		SslcPage sscPage = new SslcPage(GlobalProperties.webdriver);
		sscPage.getSchoolName().sendKeys(Attributes.Ssctenth.schoolXpath);
		sscPage.getExamBoardCombo().click();
		WebDriverWait webDriverWait = new WebDriverWait(GlobalProperties.webdriver, Duration.ofSeconds(3));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.Ssctenth.examBoardXpath)))
				.click();

		sscPage.getStartDate().sendKeys(Attributes.Ssctenth.$start_Date);
		sscPage.getEndDate().sendKeys(Attributes.Ssctenth.$end_Date);
		sscPage.gradingScale().click();
		WebDriverWait webDriverWait2 = new WebDriverWait(GlobalProperties.webdriver, Duration.ofSeconds(3));
		webDriverWait2.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.Ssctenth.gradeScale))).click();

		Robot ro_bot = new Robot();

		WebDriverWait webDriverWait3 = new WebDriverWait(GlobalProperties.webdriver, Duration.ofSeconds(3));
		webDriverWait3.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.Ssctenth.uploadFileXpath)))
				.click();

		ro_bot.setAutoDelay(2000);

		StringSelection stringSelection = new StringSelection(Attributes.Ssctenth.fileUpload);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		ro_bot.setAutoDelay(3000);

		ro_bot.keyPress(KeyEvent.VK_CONTROL);
		ro_bot.keyPress(KeyEvent.VK_V);

		ro_bot.setAutoDelay(3000);

		ro_bot.keyPress(KeyEvent.VK_ENTER);
		ro_bot.keyRelease(KeyEvent.VK_ENTER);

		CommonFunctions commonFunctions = new CommonFunctions(GlobalProperties.webdriver);
		commonFunctions.getSaveButton().click();
		commonFunctions.getErrorMessage();

	}

}
