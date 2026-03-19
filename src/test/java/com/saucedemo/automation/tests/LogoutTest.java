package com.saucedemo.automation.tests;

import com.saucedemo.automation.pages.InventoryPage;
import com.saucedemo.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{

    @Test(testName = "Logout", dataProvider = "logoutData")
    public void logoutTest(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = loginPage.login(username, password);

        inventoryPage.logout();

        Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "didn't redirect to the login page");
    }

    @DataProvider(name = "logoutData")
    public Object[][] getlogoutData() {
        return new Object[][] {
                {"standard_user", "secret_sauce"}
        };
    }
}
