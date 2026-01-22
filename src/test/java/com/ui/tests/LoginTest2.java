package com.ui.tests;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver wd = new ChromeDriver();
/*

        HomePage homePage = new HomePage(wd);
        homePage.maximizeWindow();
        LoginPage loginPage = homePage.goToLoginPage();

        String username = loginPage.doLoginWith("nitinpatil@test.com","Test@1234").getUserName();


        HomePage homePage = new HomePage(wd);
        String username = homePage.goToLoginPage().doLoginWith("nitinpatil@test.com","Test@1234").getUserName();
        System.out.println("Logged in as " + username);
        Thread.sleep(5000);
        wd.quit();
*/
    }
}
