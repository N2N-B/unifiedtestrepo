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

public class AspirationDetailsPage {
	public WebDriver webdriver;

	@FindBy(how = How.XPATH, using = "//self::label[contains(text(),'Number Of Schools')]//parent::div//*[name()='path' and contains(@d,'M7')]")
	private WebElement elm_noOfSchoolsDropDown;

	@FindBy(how = How.XPATH, using = "//self::label[contains(text(),'Additional Intakes')]//parent::div//*[name()='path' and contains(@d,'M7')]")
	private WebElement elm_additionalIntakesDropDown;

	@FindBy(how = How.XPATH, using = "//self::label[contains(text(),'Degree')]//parent::div//*[name()='path' and contains(@d,'M7')]")
	private WebElement elm_degreeDropDown;

	@FindBy(how = How.XPATH, using = "//self::label[contains(text(),'Field of Study')]//parent::div//*[name()='path' and contains(@d,'M7')]")
	private WebElement elm_fieldOfStudyDropDown;

	@FindBy(how = How.XPATH, using = "//self::label[contains(text(),'Area of Specialization')]//parent::div//*[name()='path' and contains(@d,'M7')]")
	private WebElement elm_specializationDropDown;

	@FindBy(how = How.XPATH, using = "//self::label[contains(text(),'Preferred Region')]//parent::div//*[name()='path' and contains(@d,'M7')]")
	private WebElement elm_preferredRegionDropDown;

	@FindBy(how = How.XPATH, using = "//self::label[contains(text(),'Preferred Grad-Schools')]//parent::div//*[name()='path' and contains(@d,'M7')]")
	private WebElement elm_preferredGradSchoolDropDown;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Please Fill The Required Field')]")
	private WebElement elm_errorMessage;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Save')]")
	private WebElement elm_saveButton;

	public AspirationDetailsPage(WebDriver webdriver) {
		this.webdriver = webdriver;
		PageFactory.initElements(webdriver, this);
	}

	public WebElement getSaveButton() {
		return elm_saveButton;
	}

	public WebElement clickNoOfSchoolsDropDown() {
		return elm_noOfSchoolsDropDown;
	}

	public WebElement clickAdditionalIntakesDropDown() {
		return elm_additionalIntakesDropDown;
	}

	public WebElement clickDegreeDropDown() {
		return elm_degreeDropDown;
	}

	public WebElement clickFieldOfStudyDropDown() {
		return elm_fieldOfStudyDropDown;
	}

	public WebElement clickSpecializationDropDown() {
		return elm_specializationDropDown;
	}

	public WebElement clickPreferredRegionDropDown() {
		return elm_preferredRegionDropDown;
	}

	public WebElement clickPreferredGradSchoolDropDown() {
		return elm_preferredGradSchoolDropDown;
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
				Reporter.reportStep("A popup Message Box Shown Updated Successfully", "PASS");
			} else {
				Reporter.reportStep("Please fill the required field [Popup Detected]", "FAIL");
			}

		}

		catch (Exception ex) {

		}

		return elm_errorMessage;
	}

}
