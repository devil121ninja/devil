package com.banking.utilities;

import java.io.File;
//
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport implements ITestListener {

	ExtentSparkReporter htmlroport;
	ExtentReports reports;
	ExtentTest test;

	public void configurereport() {
//		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
//		String reportname ="MyBankTestReports-"+ timestamp + ".html";
//		htmlroport = new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\"+reportname);
		htmlroport = new ExtentSparkReporter("Ectenteports.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlroport);

//	add system information/environment info to report
		reports.setSystemInfo("Machine", "testc1");
		reports.setSystemInfo("os", "windows 10");
		reports.setSystemInfo("browser", "chrome");
		reports.setSystemInfo("user name", "sanju");

//	configuration to change look and of report
		htmlroport.config().setDocumentTitle("Extent Listner Report Demo");
		htmlroport.config().setReportName("this is my first report");
		htmlroport.config().setTheme(Theme.DARK);

	}

	public void onStart(ITestContext result) {
		configurereport();
		System.out.println("on start method invoked.....");
	}

	public void onFinish(ITestContext result) {
		reports.flush();
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Name of test method failed"+ result.getName());
		test = reports.createTest(result.getName());// create entry in html report
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is :" +result.getName(), ExtentColor.RED));
		
		
		String screenShotpath = System.getProperty(("user.dir")+"\\Screenshots\\"+result.getName()+ ".png"); 

		File screenshotfile = new File(screenShotpath);
		//		test.addScreenCaptureFromPath(System.pro)
		
		if (screenshotfile.exists()) {
			test.fail("capture screenshot is below:"+test.addScreenCaptureFromPath(screenShotpath));
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Name of test method failed" + result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.SKIP,
				MarkupHelper.createLabel("name of the skip test case is" + result.getName(), ExtentColor.YELLOW));
	}

	public void onTestStart(ITestResult result) {

		System.out.println("name of test method started :" + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("name of test method started :" + result.getName());
		test.log(Status.PASS,
				MarkupHelper.createLabel("Name of the failed test case is :" + result.getName(), ExtentColor.GREEN));
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

}
