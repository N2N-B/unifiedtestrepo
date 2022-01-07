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

public class AdmissionsServicesMastersProductsPage {
	public WebDriver webdriver;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Onboarding')]")
	private WebElement elm_onBoarding;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Profile Gap Analysis')]")
	private WebElement elm_pgAnalysis;

	public AdmissionsServicesMastersProductsPage(WebDriver webdriver) {
		this.webdriver = webdriver;
		PageFactory.initElements(webdriver, this);
	}

	public WebElement clickOnBoarding() {
		FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(webdriver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class, TimeoutException.class);

		try {
			fWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Onboarding')]")));
		} catch (Exception e) {

			System.out.println("Element Not found trying again - " + elm_onBoarding.toString().substring(70));
			e.printStackTrace();
		}
		return elm_onBoarding;
	}

	public WebElement clickPgAnalysis() {
		return elm_pgAnalysis;
	}

}
