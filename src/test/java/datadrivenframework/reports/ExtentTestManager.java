package datadrivenframework.reports;

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
