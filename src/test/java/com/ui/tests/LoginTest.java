package com.ui.tests;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver wd = new ChromeDriver();

        BrowserUtility browserUtility = new BrowserUtility(wd);
        browserUtility.goToWebsite("http://www.automationpractice.pl");

        By signInLinkLocator = By.xpath("//a[contains(text(), \"Sign in\")]");
        browserUtility.clickOn(signInLinkLocator);

        By emailTextBoxLocator = By.id("email");
        browserUtility.enterText(emailTextBoxLocator, "nitinpatil@test.com");

        By passwordTextBoxLocator = By.id("passwd");
        browserUtility.enterText(passwordTextBoxLocator,"Test@1234");


        By submitLoginButtonLocator = By.id("SubmitLogin");
        browserUtility.clickOn(submitLoginButtonLocator);

        Thread.sleep(5000);
        wd.quit();


    }
}
