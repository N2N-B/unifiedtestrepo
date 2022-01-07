package Pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Helper.GlobalProperties;

public class TermsAndConditionsPage {
	public WebDriver webdriver;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Agree')]")
	private WebElement elm_agreeButton;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Accept')]")
	private WebElement elm_acceptButton;

	public TermsAndConditionsPage(WebDriver webdriver) {
		this.webdriver = webdriver;
		PageFactory.initElements(webdriver, this);
	}

	public WebElement clickAgree() throws IOException {
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		FileUtils.copyFile(((TakesScreenshot) GlobalProperties.webdriver).getScreenshotAs(OutputType.FILE),
				new File("./reports/images/" + number + ".jpg"));
		return elm_agreeButton;
	}

	public WebElement clickAccept() {
		return elm_acceptButton;
	}

}
