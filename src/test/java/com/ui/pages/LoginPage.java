package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BrowserUtility {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    final static private By EMAIL_TEXT_BOX_LOCATOR = By.xpath("//input[@data-qa=\"login-email\"]");
    final static private  By PASSWORD_TEXT_BOX_LOCATOR = By.xpath("//input[@data-qa=\"login-password\"]");
    final static private By SUBMIT_TEXT_BOX_LOCATOR = By.xpath("//button[contains(text(), \"Login\")]");

    public MyAccountPage doLoginWith(String email, String password) {
        enterText(EMAIL_TEXT_BOX_LOCATOR, email);
        enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
        clickOn(SUBMIT_TEXT_BOX_LOCATOR);
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        return myAccountPage;
    }
}

