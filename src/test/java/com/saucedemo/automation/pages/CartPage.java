package com.saucedemo.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(className = "cart_button")
    private List<WebElement> removeButtons;

    @FindBy(className = "cart_item")
    private List<WebElement> cartItems;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void proceedToCheckout() {
        checkoutButton.click();
    }

    public void removeAllItems() {
        int totalItems = removeButtons.size();
        for (int i = 0; i < totalItems; i++) {
            removeButtons.get(0).click();
        }
    }

    public int getCartItemsCount() {
        return cartItems.size();
    }
}
