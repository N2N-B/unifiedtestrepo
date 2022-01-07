package Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import Helper.GlobalProperties;
import Helper.Reporter;
import Pages.TermsAndConditionsPage;
import Helper.OpentapsWrappers;

public class TermsAndConditions extends OpentapsWrappers {

	@Test
	public void getTermsAndConditionsPage() throws IOException {
		Reporter.testCaseName = "Login to the T&C page";
		Reporter.testDescription = "Click Agree and Accept button to see the products to explore";
		Reporter.startTestCase();
		GlobalProperties.webdriver.manage().window().maximize();
		TermsAndConditionsPage termsAndConditionsPage = new TermsAndConditionsPage(GlobalProperties.webdriver);
		termsAndConditionsPage.clickAgree().click();
		termsAndConditionsPage.clickAccept().click();
	}

}
