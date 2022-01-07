package Helper;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


public class OpentapsWrappers {
	
	protected String browserName;
	protected static String testCaseName;
	protected static String testDescription;
	
	@BeforeSuite
	public void beforeSuite() throws FileNotFoundException, IOException{
		Reporter.startResult();
	}

	@BeforeTest
	public void beforeTest(){
		
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}
		
	@AfterSuite
	public void afterSuite(){
		Reporter.endResult();
	}

	@AfterTest
	public void afterTest(){
		
	}
	
	}
