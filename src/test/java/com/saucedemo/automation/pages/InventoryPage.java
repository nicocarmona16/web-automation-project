package com.saucedemo.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class InventoryPage extends BasePage{

    @FindBy(className = "inventory_item_name")
    private List<WebElement> productLinks;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(className = "btn_inventory")
    private List<WebElement> addToCartButtons;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void clickRandomProduct() {
        Random random = new Random();
        int randomIndex = random.nextInt(productLinks.size());
        productLinks.get(randomIndex).click();
    }

    public void goToCart() {
        cartIcon.click();
    }

    public void addMultipleProducts(int count) {
        for (int i = 0; i < count; i++) {
            addToCartButtons.get(i).click();
        }
    }
}
