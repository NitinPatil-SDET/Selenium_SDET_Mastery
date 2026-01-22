package com.ui.pages;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;
import org.openqa.selenium.By;

import static com.constants.Env.QA;
import static com.utility.PropertiesUtil.readProperties;

public class HomePage extends BrowserUtility {


    public HomePage(Browser driver) {
        super(driver);
        goToWebsite(JSONUtility.readJson(QA));
    }

    final static private By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(), \"Signup / Login\")]"); // Signup / Login

    public LoginPage goToLoginPage()
    {
        clickOn(SIGN_IN_LINK_LOCATOR);
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }
}
