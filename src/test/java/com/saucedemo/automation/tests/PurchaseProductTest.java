package com.saucedemo.automation.tests;

import com.saucedemo.automation.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseProductTest extends BaseTest {

    @Test(testName = "Purchase product")
    public void purchaseProductTest() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = loginPage.login("standard_user", "secret_sauce");
        inventoryPage.clickRandomProduct();

        ProductDetailPage productPage = new ProductDetailPage(driver);
        productPage.addToCart();
        productPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillPersonalDataAndContinue("test", "test", "252525");

        OverviewCheckoutPage overviewCheckoutPage = new OverviewCheckoutPage(driver);
        overviewCheckoutPage.finishPurchase();
        String expectedMessage = "Thank you for your order!";
        Assert.assertEquals(overviewCheckoutPage.getConfirmationMessage(), expectedMessage, "The confirmation message doesn't match");
    }
}
