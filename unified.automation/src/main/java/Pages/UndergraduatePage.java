package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class UndergraduatePage {

	public WebDriver webdriver;

	public UndergraduatePage(WebDriver webdriver) {
		this.webdriver = webdriver;
		PageFactory.initElements(webdriver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Start Date')]/following::input")
	private WebElement elm_startDate;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'End Date')]/following::input")
	private WebElement elm_EndDate;

	public WebElement getStartDate() {
		return elm_startDate;
	}

	public WebElement getEndDate() {
		return elm_EndDate;
	}

}
