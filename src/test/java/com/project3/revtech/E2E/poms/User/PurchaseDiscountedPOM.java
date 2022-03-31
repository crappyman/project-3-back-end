package com.project3.revtech.E2E.poms.User;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseDiscountedPOM {

    private WebDriver webDriver;

    public PurchaseDiscountedPOM(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//button[contains(text(), \"Proceed to checkout\")]")
    public WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//a[contains(text(), \"Discounted Items\")]")
    public WebElement discountedItemsButton;
}
