package Helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;
import org.testng.Reporter;

public class SeleniumHelper {

	public static Properties properties;

	public static void initializeDriver() throws IOException {
		File sourceFile = new File(System.getProperty("user.dir") + "/src/main/java/resources/data.properties");
		FileInputStream fileInputStream = new FileInputStream(sourceFile);
		properties = new Properties();
		properties.load(fileInputStream);

		String browserName = properties.getProperty("browser");

		if (browserName.contains("Chrome")) {
			String chromeExecutablePath = "src/main/resources/chromedriver.exe";
			String chromeWebDriver = "webdriver.chrome.driver";
			System.setProperty(chromeWebDriver, chromeExecutablePath);
			ChromeOptions chromeOptions = new ChromeOptions();
			if (browserName.contains("headless")) {
				chromeOptions.addArguments("headless");
			}
			GlobalProperties.webdriver = new ChromeDriver(chromeOptions);

		}
	}

	public static boolean WaitForPageToLoad(int timeoutSecs) {
		boolean status = false;
		try {
			status = new WebDriverWait(GlobalProperties.webdriver, Duration.ofSeconds(timeoutSecs))
					.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
							.executeScript("return document.readyState").equals("complete"));

			Helper.Reporter.reportStep("Document is in ready state", "PASS");

			status = new WebDriverWait(GlobalProperties.webdriver, Duration.ofSeconds(timeoutSecs))
					.until((ExpectedCondition<Boolean>) x -> ((JavascriptExecutor) x)
							.executeScript("return jQuery.active == 0").equals(true));

			Helper.Reporter.reportStep("None of the jquery is in active state", "PASS");

		} catch (Exception ex) {
			if (ex.getMessage().contains("jQuery is not defined"))
				Helper.Reporter.reportStep("This page is not defined with JQuery","INFO");
			else
				Helper.Reporter.reportStep(ex.getMessage(), "FAIL");
		}
		return status;
	}

	public static boolean waitForNewWindow(int timeout) {

		boolean flag = false;

		int counter = 0;
		String currentHandle = GlobalProperties.webdriver.getWindowHandle();

		while (!flag) {

			try {

				Set<String> handles = GlobalProperties.webdriver.getWindowHandles();

				if (handles.size() > 1) {

					flag = true;

					for (String actual : handles) {

						if (!actual.equalsIgnoreCase(currentHandle)) {
							// switching to the opened tab
							GlobalProperties.webdriver = GlobalProperties.webdriver.switchTo().window(actual);
							SeleniumHelper.WaitForPageToLoad(60);
							Helper.Reporter.reportStep("Waited successfully for new tab", "PASS");
						}
					}
					return flag;
				}

				Thread.sleep(1000);

				counter++;

				if (counter > timeout) {
					return flag;
				}

			} catch (Exception e) {

				System.out.println(e.getMessage());

				return false;

			}
		}
		return flag;
	}

	public static WebDriver FocusDriver(WebDriver driver, String windowName) {
		WebDriver returnDriver = null;
		try {
			returnDriver = driver.switchTo().window(windowName);
			Reporter.log("Focused to the new window");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return returnDriver;
	}

	public static void Highlight(WebDriver driver, WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style',arguments[1])", element,
					"border: 3px solid blue;");
			((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style',arguments[1])", element, "");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static WebElement fluentWaitForElement(String xPath, String expectedConditions, int timeOut, int pollingInterval) {
		FluentWait<WebDriver> fWait=null;
		WebElement element =null;
		try {

			fWait= new FluentWait<WebDriver>(GlobalProperties.webdriver)
					.withTimeout(Duration.ofSeconds(timeOut)).pollingEvery(Duration.ofSeconds(pollingInterval))
					.ignoring(NoSuchElementException.class, TimeoutException.class);
			switch (expectedConditions) {
			case "elementToBeClickable":
				element = fWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
				break;
			case "presenceOfElementLocated":
				element = fWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));				
			}
			Helper.Reporter.reportStep("Successfully wait for the element : " + xPath, "PASS");

		} catch (Exception ex) {
			Helper.Reporter.reportStep("Failed to wait for en element \n"+ex.getMessage(), "FAIL");
		}
		return element;
	}

	public static void setText(WebElement element, String text) {
		try {
			((JavascriptExecutor) GlobalProperties.webdriver).executeScript("return arguments[0].value;", element);
			Helper.Reporter.reportStep("Successfully entered the text : " + text, "PASS");

		} catch (Exception ex) {
			Helper.Reporter.reportStep("Failed to enter text \n"+ex.getMessage(), "FAIL");
		}

	}

	public static void clickElement(WebElement element, boolean... shouldUseBaseClick) {
		try {
			if (shouldUseBaseClick.length > 0)
				element.click();
			else
				((JavascriptExecutor) GlobalProperties.webdriver).executeScript("arguments[0].click();", element);

			Helper.Reporter.reportStep("Successfully clicked", "PASS");

		} catch (Exception ex) {
			Helper.Reporter.reportStep("Failed to click \n" + ex.getMessage(), "FAIL");
		}

	}

}
