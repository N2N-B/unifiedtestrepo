package Pages;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class ProductSelectPage {
	public WebDriver webdriver;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Continue')]")
	private WebElement elm_continueButton;

	@FindBy(how = How.XPATH, using = "//*[@class='round']//following-sibling::label")
	private WebElement elm_roundButton;

	@FindBy(how = How.CSS, using = "label[for='0']")
	private WebElement elm_stageRoundButton;

	public ProductSelectPage(WebDriver webdriver) {
		this.webdriver = webdriver;
		PageFactory.initElements(webdriver, this);
	}

	public WebElement clickContinue() {
		return elm_continueButton;
	}

	public WebElement clickRoundButton() {
		FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(webdriver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class, TimeoutException.class);

		try {
			fWait.until(ExpectedConditions.visibilityOf(elm_roundButton));
		} catch (Exception e) {

			System.out.println("Element Not found trying again - " + elm_roundButton.toString().substring(70));
			e.printStackTrace();
		}

		return elm_roundButton;
	}

	public WebElement clickStageRoundButton() {
		FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(webdriver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class, TimeoutException.class);

		try {
			fWait.until(ExpectedConditions.visibilityOf(elm_stageRoundButton));
		} catch (Exception e) {

			System.out.println("Element Not found trying again - " + elm_stageRoundButton.toString().substring(70));
			e.printStackTrace();
		}

		return elm_stageRoundButton;
	}
}
