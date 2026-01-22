package com.ui.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.ExtentReportUtility;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.core.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListener implements ITestListener {
    Logger logger = LoggerUtility.getLogger(this.getClass());
    ExtentSparkReporter extentSparkReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;

    public void onTestStart(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + ": Started");
        logger.info(result.getMethod().getDescription());
        logger.info(Arrays.toString(result.getMethod().getGroups()));
        ExtentReportUtility.createExtentTest(result.getMethod().getMethodName());

        //extentTest = extentReports.createTest(result.getMethod().getMethodName());
    }
    public void onTestSuccess(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + ": Test Passed");
        ExtentReportUtility.getExtentTest().log(Status.PASS, result.getMethod().getMethodName() + ": Test Passed");
    }
    public void onTestFailure(ITestResult result) {
        logger.error(result.getMethod().getMethodName() + ": Test Failed");
        logger.error(result.getThrowable().getMessage());
        ExtentReportUtility.getExtentTest().log(Status.FAIL, result.getMethod().getMethodName() + ": Test Failed");
        ExtentReportUtility.getExtentTest().log(Status.FAIL, result.getThrowable().getMessage());
    }
    public void onTestSkipped(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + ": Test Skipped");
        ExtentReportUtility.getExtentTest().log(Status.SKIP, result.getMethod().getMethodName() + ": Test Skipped");
    }
    public void onTestFinished(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + ": Test Finished");

    }
    public void onStart(ITestContext context) {
        logger.info("Starting test Suite");
        ExtentReportUtility.setUpSparkReport("Report");

    }
    public void onFinish(ITestContext context) {
        ExtentReportUtility.flushReport();
    }

}
