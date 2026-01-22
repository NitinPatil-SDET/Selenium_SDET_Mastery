package com.ui.tests;


import com.ui.pages.HomePage;

import static com.constants.Browser.CHROME;

import static org.testng.Assert.*;

import com.ui.pojo.User;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({com.ui.listeners.TestListener.class})

public class Login_Test extends TestBase {





    @Test(description = "Verified with the valid user is able to login into application",
            groups = {"e2e","sanity"},
                    dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,
            dataProvider = "LoginTestDataProvider"
    )
    public void loginTest(User user){
/*
        String username = homePage.goToLoginPage().doLoginWith("nitinpatil@test.com","Test@1234").getUserName();
        System.out.println("Logged in as " + username);
        Assert.assertEquals(username,"Nitin Patil");
        */

        //Test Aftere Clean code principle
        assertEquals(homePage.goToLoginPage()
                .doLoginWith(user.getEmailAddress(), user.getPassword())
                .getUserName(), "Nitin Patil");


    }

    @Test(description = "Verified with the read data from csv file and able to login into application",
            groups = {"e2e","sanity"},
            dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,
            dataProvider = "LoginCSVTestDataProvider"
    )
    public void loginCSVTest(User user){

        assertEquals(homePage.goToLoginPage()
                .doLoginWith(user.getEmailAddress(), user.getPassword())
                .getUserName(), "Nitin Patil");


    }

    @Test(description = "Verified with the read data from csv file and able to login into application",
            groups = {"e2e","sanity"},
            dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,
            dataProvider = "LoginExcelTestDataProvider",
            retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class
    )
    public void loginExcelTest(User user){

        assertEquals(homePage.goToLoginPage()
                .doLoginWith(user.getEmailAddress(), user.getPassword())
                .getUserName(), "Nitin Patil");

    }

}
