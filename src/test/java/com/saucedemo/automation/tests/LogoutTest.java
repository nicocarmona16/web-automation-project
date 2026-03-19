package com.saucedemo.automation.tests;

import com.saucedemo.automation.pages.InventoryPage;
import com.saucedemo.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{

    @Test(testName = "Logout")
    public void logoutTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.logout();

        Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "didn't redirect to the login page");
    }
}
