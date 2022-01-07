package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import Common.CommonFunctions;
import Helper.GlobalProperties;
import Helper.OpentapsWrappers;
import Helper.Reporter;
import Helper.SeleniumHelper;
import Pages.OnboardingPage;
import Pages.ProfessionDetailsPage;
import Pages.ProfessionalExperiencePage;

public class WorkExperience extends OpentapsWrappers {
	@Test
	public void getOnboardingDashBoardPage() {
		GlobalProperties.webdriver.manage().window().maximize();
		OnboardingPage onBoardingPage = new OnboardingPage(GlobalProperties.webdriver);
		onBoardingPage.clickWorkExperience().click();
	}

	@Test(groups = { "PositiveTests" })
	public void clickAddProExperienceButtonAndVerifyWorkExperience() {
		String employmentXpath = "//li[contains(.,'Full Time')]";
		String organisationXpath = "SAP infotech";
		String designationXpath = "Tester";
		String roleDescriptionXpath = "Software testing";
		String start_Date = "03-01-2022";
		String end_Date = "24-03-2023";
		Reporter.testCaseName = "Enter the professional experience";
		Reporter.testDescription = "Check the save button to see the result";
		Reporter.startTestCase();
		GlobalProperties.webdriver.manage().window().maximize();

		ProfessionalExperiencePage professionalExperiencePage = new ProfessionalExperiencePage(
				GlobalProperties.webdriver);
		GlobalProperties.webdriver.get(SeleniumHelper.properties.getProperty("proExperienceUrl"));

		professionalExperiencePage.clickAddProfessionalExperienceButton().click();

		ProfessionDetailsPage professionDetailsPage = new ProfessionDetailsPage(GlobalProperties.webdriver);
		professionDetailsPage.clickEmploymentDropDown().click();
		FluentWait<WebDriver> fWait2 = new FluentWait<WebDriver>(GlobalProperties.webdriver)
				.withTimeout(Duration.ofSeconds(4)).pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		fWait2.until(ExpectedConditions.elementToBeClickable(By.xpath(employmentXpath))).click();

		professionDetailsPage.enterDetailsInOrganisationTextBox().sendKeys(organisationXpath);
		professionDetailsPage.enterDetailsInDesignationTextBox().sendKeys(designationXpath);
		professionDetailsPage.enterDetailsInRoleDescriptionTextBox().sendKeys(roleDescriptionXpath);

		CommonFunctions commonFunctions = new CommonFunctions(GlobalProperties.webdriver);
		commonFunctions.getStartDate().sendKeys(start_Date);
		commonFunctions.getEndDate1().sendKeys(end_Date);
		commonFunctions.getSaveButton().click();

	}

}
