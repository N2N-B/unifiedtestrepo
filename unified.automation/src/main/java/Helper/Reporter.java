package Helper;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reporter extends OpentapsWrappers {

	private static ExtentTest test;
	private static ExtentReports extent;

	public static void reportStep(String desc, String status) {
		org.testng.Reporter.log(desc, true);
		// Write if it is successful or failure or information
		if (status.toUpperCase().equals("PASS")) {
			test.log(LogStatus.PASS, desc);
		} else if (status.toUpperCase().equals("FAIL")) {
			long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
			try {
				FileUtils.copyFile(((TakesScreenshot) GlobalProperties.webdriver).getScreenshotAs(OutputType.FILE),
						new File("./reports/images/" + number + ".jpg"));
			} catch (WebDriverException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			test.log(LogStatus.FAIL, desc + test.addScreenCapture("./../reports/images/" + number + ".jpg"));
			throw new RuntimeException("FAILED");
		} else if (status.toUpperCase().equals("INFO")) {
			test.log(LogStatus.INFO, desc);
		}
	}

	public static void startResult() {
		extent = new ExtentReports("./reports/result_" + Reporter.getCurrentDateTime() + ".html", true);
		extent.loadConfig(new File("./extent-config.xml"));
	}

	public static void startTestCase() {
		test = extent.startTest(testCaseName, testDescription);
	}

	public static void endResult() {
		extent.flush();
	}

	public static void endTest() {
		extent.endTest(test);
	}

	public static String getCurrentDateTime() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH__mm__ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

}
