package com.saucedemo.automation.tests;

import com.saucedemo.automation.data.TestDataProvider;
import com.saucedemo.automation.pages.InventoryPage;
import com.saucedemo.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{

    @Test(testName = "Logout", dataProvider = "logoutData", dataProviderClass = TestDataProvider.class)
    public void logoutTest(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = loginPage.login(username, password);

        inventoryPage.logout();

        Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "didn't redirect to the login page");
    }
}
