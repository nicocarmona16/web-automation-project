package com.saucedemo.automation.tests;

import com.saucedemo.automation.pages.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RemoveCartElementsTest extends BaseTest {

    @Test(testName = "Remove elements of the shopping cart", dataProvider = "cartData")
    public void removeElementsFromCartTest(String username, String password, int productsToAdd) {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = loginPage.login(username, password);

        inventoryPage.addMultipleProducts(productsToAdd);
        inventoryPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.removeAllItems();

        int itemsInCart = cartPage.getCartItemsCount();
        Assert.assertEquals(itemsInCart, 0, "The cart isn't empty, there are " + itemsInCart + " items left");
    }

    @DataProvider(name = "cartData")
    public Object[][] getCartData() {
        return new Object[][] {
                {"standard_user", "secret_sauce", 3}
        };
    }
}
