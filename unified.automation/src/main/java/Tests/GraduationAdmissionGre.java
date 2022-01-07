package Tests;

import org.testng.annotations.Test;

import Helper.GlobalProperties;
import Helper.OpentapsWrappers;
import Helper.Reporter;
import Pages.GraduateAdmissionLandingPage;
import Pages.GreScorePage;
import Pages.OnboardingPage;

public class GraduationAdmissionGre extends OpentapsWrappers {

	@Test(groups = { "NegativeTests" })
	public void verifyGrePage() {
		String examDate = "30-01-2022";
		Reporter.testCaseName = "Verify that User attends Graduation Admission test[No scenario]";
		Reporter.testDescription = "Check the save button to see the result [A popup Message Box Shown Updated Successfully]";
		Reporter.startTestCase();
		GlobalProperties.webdriver.manage().window().maximize();
		OnboardingPage onBoardingPage = new OnboardingPage(GlobalProperties.webdriver);
		onBoardingPage.clickGraduateAdmissionTest().click();
		GraduateAdmissionLandingPage graduateAdmissionLandingPage = new GraduateAdmissionLandingPage(
				GlobalProperties.webdriver);
		graduateAdmissionLandingPage.clickAddGreExamButton().click();

		GreScorePage greScorePage = new GreScorePage(GlobalProperties.webdriver);
		greScorePage.clickNoRadioButton().click();
		greScorePage.enterExpectedExamDate().sendKeys(examDate);
		greScorePage.getSaveButton().click();
		greScorePage.getErrorMessage();
	}

	@Test(groups = { "PositiveTests" }, enabled = false)
	public void verifyPositiveGrePage() {
		Reporter.testCaseName = "Verify that User attends Graduation Admission test[Yes scenario]";
		Reporter.testDescription = "Check the save button to see the result [A popup Message Box Shown Updated Successfully]";
		Reporter.startTestCase();
		GlobalProperties.webdriver.manage().window().maximize();
		OnboardingPage onBoardingPage = new OnboardingPage(GlobalProperties.webdriver);
		onBoardingPage.clickGraduateAdmissionTest().click();
		GraduateAdmissionLandingPage graduateAdmissionLandingPage = new GraduateAdmissionLandingPage(
				GlobalProperties.webdriver);
		graduateAdmissionLandingPage.clickAddGreExamButton().click();

		GreScorePage greScorePage = new GreScorePage(GlobalProperties.webdriver);
		greScorePage.clickYesRadioButton().click();
		greScorePage.clickNoOfAttemptsDropDown().click();

		greScorePage.getSaveButton().click();
		greScorePage.getErrorMessage();
	}

}
