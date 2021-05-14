package datadrivenframework.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import datadrivenframework.reports.ExtentManager;
import datadrivenframework.reports.ExtentTestManager;
import datadrivenframework.reports.TakeScreenShots;

public class TestListener implements ITestListener {

	WebDriver driver;

	@Override
	public void onStart(ITestContext context) {
		ExtentManager.getReporter();
		System.out.println("Test  started");
	}

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		ExtentTestManager.createTest(methodName);
		System.out.println("Test started::" + methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTestManager.getTest().pass("Test pass");
		System.out.println("Test success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentTestManager.getTest().fail("Test Fail");
		String methodName = result.getMethod().getMethodName();
		driver = (WebDriver) result.getTestContext().getAttribute("driver");
        TakeScreenShots.takeScreenShot(driver, methodName);
		System.out.println("Test Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTestManager.getTest().skip("Test skip");
		System.out.println("Test skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test Finished");
		ExtentManager.printResult();
	}

}
