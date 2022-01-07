package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import Common.Attributes;
import Helper.GlobalProperties;
import Helper.OpentapsWrappers;
import Helper.Reporter;
import Pages.AspirationDetailsPage;

public class AspirationDetails extends OpentapsWrappers {

	@Test(groups = { "PositiveTests" })
	public void verifyAspirationalDetails() {

		Reporter.testCaseName = "Verify the aspirational details of the student";
		Reporter.testDescription = "Check the save button to see the result";
		Reporter.startTestCase();
		GlobalProperties.webdriver.manage().window().maximize();

		AspirationDetailsPage aspirationDetailsPage = new AspirationDetailsPage(GlobalProperties.webdriver);

		aspirationDetailsPage.clickNoOfSchoolsDropDown().click();
		FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(GlobalProperties.webdriver)
				.withTimeout(Duration.ofSeconds(4)).pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		fWait.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.Aspirational.noOfSchools))).click();

		aspirationDetailsPage.clickAdditionalIntakesDropDown().click();
		FluentWait<WebDriver> fWait1 = new FluentWait<WebDriver>(GlobalProperties.webdriver)
				.withTimeout(Duration.ofSeconds(4)).pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		fWait1.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.Aspirational.intakesXpath))).click();

		aspirationDetailsPage.clickDegreeDropDown().click();
		FluentWait<WebDriver> fWait3 = new FluentWait<WebDriver>(GlobalProperties.webdriver)
				.withTimeout(Duration.ofSeconds(4)).pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		fWait3.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.Aspirational.degreeXpath))).click();

		aspirationDetailsPage.clickFieldOfStudyDropDown().click();
		FluentWait<WebDriver> fWait4 = new FluentWait<WebDriver>(GlobalProperties.webdriver)
				.withTimeout(Duration.ofSeconds(4)).pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		fWait4.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.Aspirational.$fieldOfStudyXpath)))
				.click();

		aspirationDetailsPage.clickSpecializationDropDown().click();
		FluentWait<WebDriver> fWait5 = new FluentWait<WebDriver>(GlobalProperties.webdriver)
				.withTimeout(Duration.ofSeconds(4)).pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		fWait5.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.Aspirational.$specializationXpath)))
				.click();

		aspirationDetailsPage.clickPreferredRegionDropDown().click();
		FluentWait<WebDriver> fWait6 = new FluentWait<WebDriver>(GlobalProperties.webdriver)
				.withTimeout(Duration.ofSeconds(4)).pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		fWait6.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.Aspirational.$preferredRegionXpath)))
				.click();

		aspirationDetailsPage.clickPreferredGradSchoolDropDown().click();
		FluentWait<WebDriver> fWait7 = new FluentWait<WebDriver>(GlobalProperties.webdriver)
				.withTimeout(Duration.ofSeconds(4)).pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		fWait7.until(
				ExpectedConditions.elementToBeClickable(By.xpath(Attributes.Aspirational.$preferredGradSchoolXpath)))
				.click();

		aspirationDetailsPage.getSaveButton().click();
		aspirationDetailsPage.getErrorMessage();

	}

}
