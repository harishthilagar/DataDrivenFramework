package datadrivenframework.reports;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import datadrivenframework.constants.UIconstants;


public class TakeScreenShots {

	public static void takeScreenShot(WebDriver driver,String methodName) {
		TakesScreenshot screenShot = (TakesScreenshot) driver;
        File screenshotFile =  screenShot.getScreenshotAs(OutputType.FILE);
        long random = System.currentTimeMillis();
        String destination = UIconstants.USER_DIR+"//reports//screenshots//"+methodName+random+".png";
        try {
			FileUtils.copyFile(screenshotFile,new File(destination));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ExtentTestManager.getTest().addScreenCaptureFromPath(destination);
	}
}