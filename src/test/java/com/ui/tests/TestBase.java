package com.ui.tests;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtlity;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class testBase {
    protected HomePage homePage;
    Logger logger = LoggerUtility.getLogger(this.getClass());
    private boolean isLambdaTest = false;
    private boolean isHeadless = true;

    @BeforeMethod(description = "Load the Homepage of the website")
    public void setup (ITestResult result) {
        WebDriver lambdaDriver;

        if (isLambdaTest) {
            lambdaDriver = LambdaTestUtlity.intializeLambdaTestSession("chrome", result.getMethod().getMethodName());
            homePage = new HomePage (lambdaDriver);
        } else {
            // Running the test on local machine!!!
            logger.info("Load the Homepage of the website");
            homePage = new HomePage (Browser.CHROME, isHeadless);
        }
    }

    public BrowserUtility getInstance() {
        return homePage;
    }


    @AfterMethod(description = "Tear Down the browser")
    public void tearDown() {
        if(isLambdaTest){
            LambdaTestUtlity.quitSession();
        }
        homePage.quit();
    }
}

