package com.saucedemo.automation.data;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    private static final String USERNAME = "standard_user";
    private static final String NAME = "testName";
    private static final String LASTNAME = "testLastname";
    private static final String ZIPCODE = "252525";
    private static final String PASSWORD = "secret_sauce";
    private static final String EXPECTED_MESSAGE = "Thank you for your order!";
    private static final int PRODUCTS_COUNT = 3;

    @DataProvider(name = "checkoutData")
    public static Object[][] getCheckoutData() {
        return new Object[][] {
                {USERNAME, PASSWORD, NAME, LASTNAME, ZIPCODE, EXPECTED_MESSAGE}
        };
    }

    @DataProvider(name = "cartData")
    public static Object[][] getCartData() {
        return new Object[][] {
                {USERNAME, PASSWORD, PRODUCTS_COUNT}
        };
    }

    @DataProvider(name = "logoutData")
    public static Object[][] getLogoutData() {
        return new Object[][] {
                {USERNAME, PASSWORD}
        };
    }
}
