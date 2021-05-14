package datadrivenframework.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import datadrivenframework.constants.UIconstants;

public class ExtentManager {
	public static ExtentReports extentReports;
	public static ExtentSparkReporter sparkReporter;

	public synchronized static ExtentReports getReporter() {
		String reportPath = UIconstants.USER_DIR + "\\reports\\extentReport\\report.html";
		sparkReporter = new ExtentSparkReporter(reportPath);
		sparkReporter.config().setReportName("Address Book Report");
		sparkReporter.config().setDocumentTitle("Test Address Book");
		if (extentReports == null) {
			extentReports = new ExtentReports();
			extentReports.attachReporter(sparkReporter);
		}
		return extentReports;
	}

	public synchronized static void printResult() {
		extentReports.flush();
	}

}
