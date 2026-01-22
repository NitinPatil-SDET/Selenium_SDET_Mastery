package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BrowserUtility {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    final static private By USER_NAME_LOCATOR = By.xpath("//a[contains(text(),'Logged in as')]/b");
    public String getUserName(){
        String userName= getVisibleText(USER_NAME_LOCATOR);
        return userName;
    }


}
