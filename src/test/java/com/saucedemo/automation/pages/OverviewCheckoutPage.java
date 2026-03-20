package com.saucedemo.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OverviewCheckoutPage extends BasePage {

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(className = "complete-header")
    private WebElement completeHeaderMessage;

    public OverviewCheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void finishPurchase() {
        finishButton.click();
    }

    public String getConfirmationMessage() {
        return completeHeaderMessage.getText();
    }
}
