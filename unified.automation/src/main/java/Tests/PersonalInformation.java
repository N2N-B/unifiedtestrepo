package Tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Common.Attributes;
import Helper.DataInputProvider;
import Helper.GlobalProperties;
import Helper.OpentapsWrappers;
import Helper.Reporter;
import Helper.SeleniumHelper;
import Pages.AdmissionsServicesMastersProductsPage;
import Pages.BasicDetailsPage;
import Pages.LoginPage;
import Pages.OnboardingPage;
import Pages.PersonalInformationPage;
import Pages.ProductSelectPage;

public class PersonalInformation extends OpentapsWrappers {

	@BeforeTest
	public void initDriver() throws IOException {
		SeleniumHelper.initializeDriver();
	}

	@Test(priority = 1, dataProvider = "LoginData")
	public void doLogIn(String userName, String passWord, String loginResult) throws IOException {

		GlobalProperties.webdriver.get(SeleniumHelper.properties.getProperty(Attributes.Login.loginPageUrl));
		GlobalProperties.webdriver.manage().window().maximize();
		LoginPage loginPage = new LoginPage(GlobalProperties.webdriver);

		loginPage.getEmail().sendKeys(userName);
		loginPage.getPassword().sendKeys(passWord);
		loginPage.LogIn().click();
	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {

		DataInputProvider excelDataDrivenFramework = new DataInputProvider(Attributes.Login.testDataPath);

		int totalrows = excelDataDrivenFramework.getRowCount(Attributes.Login.sheet_Name);
		int totalcols = excelDataDrivenFramework.getCellCount(Attributes.Login.sheet_Name, 1);

		String loginData[][] = new String[totalrows][totalcols];

		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				loginData[i - 1][j] = excelDataDrivenFramework.getCellData(Attributes.Login.sheet_Name, i, j);
			}

		}
		return loginData;
	}

	@Test(priority = 2)
	public void getBasicPage() {
		GlobalProperties.webdriver.manage().window().maximize();
		BasicDetailsPage basicDetailsPage = new BasicDetailsPage(GlobalProperties.webdriver);
		basicDetailsPage.getContinueButton().click();
		ProductSelectPage productSelectPage = new ProductSelectPage(GlobalProperties.webdriver);
		productSelectPage.clickStageRoundButton().click();
		productSelectPage.clickContinue().click();
	}

	@Test(priority = 3)
	public void getAdmissionsServicesMastersProductsPage() {
		GlobalProperties.webdriver.manage().window().maximize();
		AdmissionsServicesMastersProductsPage admissionsServicesMastersProductsPage = new AdmissionsServicesMastersProductsPage(
				GlobalProperties.webdriver);
		admissionsServicesMastersProductsPage.clickOnBoarding().click();
		Helper.Reporter.reportStep("Onboarding gets clicked", "PASS");

	}

	@Test(priority = 4)
	public void clickonBoardAcademicInfoPage() {
		GlobalProperties.webdriver.manage().window().maximize();
		OnboardingPage onBoardingPage = new OnboardingPage(GlobalProperties.webdriver);
		onBoardingPage.clickPersonalInformation().click();
		Helper.Reporter.reportStep("Personal Information gets clicked", "PASS");

	}

	@Test(priority = 5, enabled = true)
	public void validateNegativeOnboardingPersonalInfo() throws AWTException {
		Reporter.testCaseName = "Enter the personal information of the student";
		Reporter.testDescription = "Check the response of the user";
		Reporter.startTestCase();
		GlobalProperties.webdriver.manage().window().maximize();

		PersonalInformationPage personalInformationPage = new PersonalInformationPage(GlobalProperties.webdriver);

		personalInformationPage.enterLinkedInName().sendKeys(Attributes.PersonalInformation.linkedIn_Name);
		personalInformationPage.enterFacebookName().sendKeys(Attributes.PersonalInformation.fb_Name);
		personalInformationPage.enterTwitterName().sendKeys(Attributes.PersonalInformation.twitter_Name);

		personalInformationPage.clickSave().click();
		personalInformationPage.getErrorMessage();
		GlobalProperties.webdriver.navigate().back();
	}

	@Test(priority = 6, groups = { "PositiveTests" }, enabled = false)
	public void validateOnboardingPersonalInfo() throws AWTException {

		Reporter.testCaseName = "Enter the personal information of the student";
		Reporter.testDescription = "Check the response of the user";
		Reporter.startTestCase();
		GlobalProperties.webdriver.manage().window().maximize();

		Robot $robot = new Robot();

		WebDriverWait webDriverWait_3 = new WebDriverWait(GlobalProperties.webdriver, Duration.ofSeconds(3));
		webDriverWait_3
				.until(ExpectedConditions.elementToBeClickable(By.xpath(Attributes.PersonalInformation.editXpath)))
				.click();

		$robot.setAutoDelay(2000);

		StringSelection stringSelection = new StringSelection(Attributes.PersonalInformation.imageFile);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		$robot.setAutoDelay(3000);

		$robot.keyPress(KeyEvent.VK_CONTROL);
		$robot.keyPress(KeyEvent.VK_V);

		$robot.setAutoDelay(3000);

		$robot.keyPress(KeyEvent.VK_ENTER);
		$robot.keyRelease(KeyEvent.VK_ENTER);

		WebElement saveUpload = GlobalProperties.webdriver
				.findElement(By.xpath(Attributes.PersonalInformation.saveXpath));
		saveUpload.click();

		PersonalInformationPage personalInformationPage = new PersonalInformationPage(GlobalProperties.webdriver);
		personalInformationPage.enterAltEmailId().clear();

		personalInformationPage.enterAltPhoneNumber().sendKeys(Keys.CONTROL + "a");
		personalInformationPage.enterAltPhoneNumber().sendKeys(Keys.DELETE);

		personalInformationPage.enterLinkedInName().sendKeys(Attributes.PersonalInformation.linkedIn_Name);
		personalInformationPage.enterFacebookName().sendKeys(Attributes.PersonalInformation.fb_Name);
		personalInformationPage.enterTwitterName().sendKeys(Attributes.PersonalInformation.twitter_Name);

		/*
		 * personalInformationPage.enterApartmentName().sendKeys(Keys.CONTROL + "a");
		 * personalInformationPage.enterApartmentName().sendKeys(Keys.DELETE);
		 * 
		 * personalInformationPage.enterAddressOne().sendKeys(Keys.CONTROL + "a");
		 * personalInformationPage.enterAddressOne().sendKeys(Keys.DELETE);
		 * 
		 * personalInformationPage.enterAddressTwo().sendKeys(Keys.CONTROL + "a");
		 * personalInformationPage.enterAddressTwo().sendKeys(Keys.DELETE);
		 * 
		 * personalInformationPage.enterLandMark().sendKeys(Keys.CONTROL + "a");
		 * personalInformationPage.enterLandMark().sendKeys(Keys.DELETE);
		 * 
		 * personalInformationPage.enterPinCode().sendKeys(Keys.CONTROL + "a");
		 * personalInformationPage.enterPinCode().sendKeys(Keys.DELETE);
		 * 
		 * personalInformationPage.enterStateName().sendKeys(Keys.CONTROL + "a");
		 * personalInformationPage.enterStateName().sendKeys(Keys.DELETE);
		 * 
		 * personalInformationPage.enterCityName().sendKeys(Keys.CONTROL + "a");
		 * personalInformationPage.enterCityName().sendKeys(Keys.DELETE);
		 */

		personalInformationPage.clickSave().click();
		personalInformationPage.getErrorMessage();

	}

	@AfterTest
	public void tearDown() {
		// GlobalProperties.webdriver.quit();
	}

}
