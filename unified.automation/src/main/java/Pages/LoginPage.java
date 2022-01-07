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

public class LoginPage {

	public WebDriver webdriver;

	@FindBy(how = How.XPATH, using = "//*[@name='email']")
	private WebElement elm_userName;

	@FindBy(how = How.XPATH, using = "//*[@name='password']")
	private WebElement elm_password;

	@FindBy(how = How.XPATH, using = "//*[text()='Login']")
	private WebElement elm_logIn;

	@FindBy(how = How.XPATH, using = "//*[text()='Invalid Password!']")
	private WebElement elm_errorMessage;

	public LoginPage(WebDriver webdriver) {
		this.webdriver = webdriver;
		PageFactory.initElements(webdriver, this);
	}

	public WebElement getEmail() {
		return elm_userName;
	}

	public WebElement getPassword() {
		return elm_password;
	}

	public WebElement LogIn() {
		return elm_logIn;
	}

	public WebElement getErrorMessage() {
		WebElement element = null;

		try {
			FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(webdriver).withTimeout(Duration.ofSeconds(10))
					.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class, TimeoutException.class);
			try {
				element = fWait.until(
						ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Invalid Password!']")));
			} catch (Exception e) {
				element = null;
			}

			if (element == null) {
				Reporter.reportStep("Login Successful", "PASS");
			} else {
				Reporter.reportStep("Invalid Password [Popup Detected]", "FAIL");
			}

		}

		catch (Exception ex) {

		}

		return elm_errorMessage;
	}
}
