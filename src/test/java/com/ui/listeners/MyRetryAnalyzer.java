package com.ui.listeners;

import com.constants.Env;
import com.utility.PropertiesUtil;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.util.Properties;

public class MyRetryAnalyzer implements IRetryAnalyzer {

    private static final int MAX_ATTEMPTS = Integer.parseInt(PropertiesUtil.readProperties(Env.QA,"MAX_NUMBER_OF_ATTEMPTS"));
    private static int currentAttempt = 1;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (currentAttempt <= MAX_ATTEMPTS) {
            currentAttempt++;
            return true;
        }
        return false;
    }
}
