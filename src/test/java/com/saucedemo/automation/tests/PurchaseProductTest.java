package com.saucedemo.automation.tests;

import com.saucedemo.automation.pages.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PurchaseProductTest extends BaseTest {

    @Test(testName = "Purchase product", dataProvider = "purchaseData")
    public void purchaseProductTest(String username, String password, String firstName, String lastName, String zipCode, String expectedMessage) {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = loginPage.login(username, password);
        inventoryPage.clickRandomProduct();

        ProductDetailPage productPage = new ProductDetailPage(driver);
        productPage.addToCart();
        productPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillPersonalDataAndContinue(firstName, lastName, zipCode);

        OverviewCheckoutPage overviewCheckoutPage = new OverviewCheckoutPage(driver);
        overviewCheckoutPage.finishPurchase();
        Assert.assertEquals(overviewCheckoutPage.getConfirmationMessage(), expectedMessage, "The confirmation message doesn't match");
    }

    @DataProvider(name = "purchaseData")
    public Object[][] getPurchaseData() {
        return new Object[][] {
                {"standard_user", "secret_sauce", "test", "test", "252525", "Thank you for your order!"}
        };
    }
}
