package datadrivenframework.reports;

import java.util.HashMap;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
	
	public static ExtentTest test;
	
	public synchronized static void createTest(String testName) {
		test = ExtentManager.extentReports.createTest(testName);
	}
	
	public synchronized static ExtentTest getTest() {
		return test;
	}

}
