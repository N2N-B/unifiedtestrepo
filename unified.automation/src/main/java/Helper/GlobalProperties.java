package Helper;

import org.openqa.selenium.WebDriver;

public class GlobalProperties {
	
	public static WebDriver webdriver;
	public static String pageURL;

	public WebDriver getDriver() {
		return webdriver;
	}

	public void setDriver(WebDriver _driver) {
		GlobalProperties.webdriver = _driver;
	}
}
