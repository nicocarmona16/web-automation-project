package com.saucedemo.automation.tests;

import com.saucedemo.automation.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveCartElementsTest extends BaseTest {

    @Test(testName = "Remove elements of the shopping cart ")
    public void removeElementsFromCartTest() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = loginPage.login("standard_user", "secret_sauce");

        inventoryPage.addMultipleProducts(3);
        inventoryPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.removeAllItems();

        int itemsInCart = cartPage.getCartItemsCount();
        Assert.assertEquals(itemsInCart, 0, "The cart isn't empty, there are " + itemsInCart + " items left");
    }
}
