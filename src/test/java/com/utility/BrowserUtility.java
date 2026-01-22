package com.utility;

import com.constants.Browser;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class BrowserUtility {

    private static ThreadLocal <WebDriver> driver = new ThreadLocal<WebDriver>();
    Logger logger = LoggerUtility.getLogger(this.getClass());


    public WebDriver getDriver() {
        return getDriver();
    }

    public BrowserUtility(WebDriver driver) {
        super();
        this.driver.set(driver);
    }

    public BrowserUtility (Browser browserName, boolean isHeadless) {
        logger.info("Launching Browser for + browserName);
        if (browserName == Browser.CHROME ) {
            if(isHeadless) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=old"); //headless
                options.addArguments("--window-size=1920,1080");
                driver.set(new ChromeDriver(options));
            }
            else {
                driver.set(new ChromeDriver());

            }
        }
        else if (browserName == Browser. EDGE) {
            if(isHeadless) {
                EdgeOptions options = String... arguments ons();

                options.addArguments("");}

        else {
            System.err.print("Invalid Browser Name.... Please select Chrome or Edge only");
        }
    }

    public BrowserUtility (Browser browserName) {
        if (browserName == Browser.CHROME) {
            driver.set(new ChromeDriver());
        }
        else  if (browserName == Browser.EDGE) {
            driver.set(new EdgeDriver());
        }
        else  if (browserName == Browser.FIREFOX) {
            driver.set(new FirefoxDriver());
        }
        else {
            System.err.print("Invalid Browser Name.... Please select Chrome or Edge only");
        }
    }

    public void goToWebsite(String URL) {
        driver.get().get(URL);
    }

    public void maximizeWindow() {
        driver.get().manage().window().maximize();
    }
    public void clickOn(By locator) {
        WebElement element =driver.get().findElement(locator);
        element.click();
    }
    public void enterText(By locator, String text) {
        WebElement emailTextBoxWebElement = driver.get().findElement(locator);
        emailTextBoxWebElement.sendKeys(text);
    }

    public String getVisibleText(By locator) {
        WebElement element = driver.get().findElement(locator);
        return element.getText();
    }

    public String takeScreenShot(String name) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "\\screenshots\\" + name + ".png";
        File screenshotFile =  new File(path);
        try {
            FileUtils.copyFile(screenshotData,screenshotFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;
    }

}
