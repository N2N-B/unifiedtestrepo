package Tests;

import java.io.IOException;

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
import Pages.LoginPage;

public class Login extends OpentapsWrappers {

	@BeforeTest
	public void initDriver() throws IOException {
		SeleniumHelper.initializeDriver();
		System.out.println("Driver for Login Page is initialized");
	}

	@Test(priority = 1, dataProvider = "LoginData")
	public void doLogIn(String userName, String passWord, String loginResult) throws IOException {
		Reporter.testCaseName = "Login to the Unified portal";
		Reporter.testDescription = "Login to the unified portal with the given username and password";
		Reporter.startTestCase();
		GlobalProperties.webdriver.get(SeleniumHelper.properties.getProperty(Attributes.Login.loginPageUrl));
		GlobalProperties.webdriver.manage().window().maximize();
		LoginPage loginPage = new LoginPage(GlobalProperties.webdriver);

		loginPage.getEmail().sendKeys(userName);
		loginPage.getPassword().sendKeys(passWord);
		loginPage.LogIn().click();
		loginPage.getErrorMessage();
	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {

		DataInputProvider dataInput = new DataInputProvider(Attributes.Login.testDataPath);

		int totalrows = dataInput.getRowCount(Attributes.Login.sheet_Name);
		int totalcols = dataInput.getCellCount(Attributes.Login.sheet_Name, 1);

		String loginData[][] = new String[totalrows][totalcols];

		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				loginData[i - 1][j] = dataInput.getCellData(Attributes.Login.sheet_Name, i, j);
			}

		}
		return loginData;
	}

	@AfterTest
	public void tearDown() {
		GlobalProperties.webdriver.quit();
	}
}
