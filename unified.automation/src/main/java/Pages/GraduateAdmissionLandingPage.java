package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GraduateAdmissionLandingPage {
	public WebDriver webdriver;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Add GRE Exam Details')]")
	private WebElement elm_addGreExamDetailsButton;

	public GraduateAdmissionLandingPage(WebDriver webdriver) {
		this.webdriver = webdriver;
		PageFactory.initElements(webdriver, this);
	}

	public WebElement clickAddGreExamButton() {
		return elm_addGreExamDetailsButton;
	}

}
