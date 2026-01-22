package com.utility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LambdaTestUtlity {
    private static final String HUB_URL = "https://hub.lambdatest.com/wd/hub";
    private static ThreadLocal<WebDriver> driverLocal = new ThreadLocal<WebDriver>();;
    private static ThreadLocal<DesiredCapabilities> capabilitiesLocal = new ThreadLocal<DesiredCapabilities>();

    public static WebDriver intializeLambdaTestSession(String browser, String testName) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("browserVersion", "127");
        Map<String, Object> ItOptions = new HashMap();
        ItOptions.put("user", "jatinvsharma");
        ItOptions.put("accessKey", "OILU72VIA5YNGOCya9yRyq0FzIU9yU1hRfqEHo6Xoxz2UQ9g04");
        ItOptions.put("build", "Selenium 4");
        ItOptions.put("name", testName);
        ItOptions.put("platformName", "Windows 10");
        ItOptions.put("seCdp", true);
        ItOptions.put("selenium_version", "4.23.0");
        capabilities.setCapability("LT:Options", ItOptions);
        capabilitiesLocal.set(capabilities);
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver (new URL(HUB_URL), capabilitiesLocal.get());
        } catch (MalformedURLException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        driverLocal.set(driver);
        return driverLocal.get();
    }

    public static void quitSession(){
        if (driverLocal.get() != null) {
            driverLocal.get().quit();
        }
    }
}