package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import Helper.Reporter;

public class PersonalInformationPage {
	public WebDriver webdriver;

	@FindBy(how = How.XPATH, using = "//*[@name='altEmailId']")
	private WebElement elm_altEmailId;

	@FindBy(how = How.XPATH, using = "//*[@name='altPhoneNumber']")
	private WebElement elm_altPhoneNumber;

	@FindBy(how = How.XPATH, using = "//*[@name='linkedIn']")
	private WebElement elm_linkedInProfile;

	@FindBy(how = How.XPATH, using = "//*[@name='facebook']")
	private WebElement elm_facebookProfile;

	@FindBy(how = How.XPATH, using = "//*[@name='twitter']")
	private WebElement elm_twitterProfile;

	@FindBy(how = How.XPATH, using = "//*[@name='apartmentName']")
	private WebElement elm_apartmentName;

	@FindBy(how = How.XPATH, using = "//*[@name='streetAddress1']")
	private WebElement elm_addressOne;

	@FindBy(how = How.XPATH, using = "//*[@name='streetAddress2']")
	private WebElement elm_addressTwo;

	@FindBy(how = How.XPATH, using = "//*[@name='landmark']")
	private WebElement elm_landMark;

	@FindBy(how = How.XPATH, using = "//*[@name='pincode']")
	private WebElement elm_pinCode;

	@FindBy(how = How.XPATH, using = "//*[@name='state']")
	private WebElement elm_stateName;

	@FindBy(how = How.XPATH, using = "//*[@name='currentCity']")
	private WebElement elm_cityName;

	@FindBy(how = How.XPATH, using = "//*[@text='Save']")
	private WebElement elm_saveButton;

	@FindBy(how = How.XPATH, using = "//*[@text='Cancel']")
	private WebElement elm_cancelButton;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Please Fill The Required Field')]")
	private WebElement elm_errorMessage;

	@FindBy(how = How.XPATH, using = "//*[contains(@src,'backbutton')]")
	private WebElement elm_backButton;

	public PersonalInformationPage(WebDriver webdriver) {
		this.webdriver = webdriver;
		PageFactory.initElements(webdriver, this);
	}

	public WebElement clickBackButton() {
		return elm_backButton;
	}

	public WebElement enterAltEmailId() {
		return elm_altEmailId;
	}

	public WebElement enterAltPhoneNumber() {
		return elm_altPhoneNumber;
	}

	public WebElement enterLinkedInName() {
		return elm_linkedInProfile;
	}

	public WebElement enterFacebookName() {
		return elm_facebookProfile;
	}

	public WebElement enterTwitterName() {
		return elm_twitterProfile;
	}

	public WebElement enterApartmentName() {
		return elm_apartmentName;
	}

	public WebElement enterAddressOne() {
		return elm_addressOne;
	}

	public WebElement enterAddressTwo() {
		return elm_addressTwo;
	}

	public WebElement enterLandMark() {
		return elm_landMark;
	}

	public WebElement enterPinCode() {
		return elm_pinCode;
	}

	public WebElement enterStateName() {
		return elm_stateName;
	}

	public WebElement enterCityName() {
		return elm_cityName;
	}

	public WebElement clickSave() {
		return elm_saveButton;
	}

	public WebElement clickCancel() {
		return elm_cancelButton;
	}

	public WebElement getErrorMessage() {
		WebElement element = null;

		try {
			FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(webdriver).withTimeout(Duration.ofSeconds(10))
					.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class, TimeoutException.class);
			try {
				element = fWait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//*[contains(text(),'Please Fill The Required Field')]")));
			} catch (Exception e) {
				element = null;
			}

			if (element == null) {
				Reporter.reportStep("Login Successful", "PASS");
			} else {
				Reporter.reportStep("Please fill the required field [Popup Detected]", "FAIL");
			}

		}

		catch (Exception ex) {

		}

		return elm_errorMessage;
	}
}
