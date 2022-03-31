package com.project3.revtech.E2E.poms.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminAddDiscountPOM {
    private WebDriver webDriver;

    public AdminAddDiscountPOM(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "a[routerlink=\"admin\"]")
    public WebElement manageStoreButton;

    @FindBy(id = "displayProdBtn")
    public WebElement displayProductInventory;

    @FindBy(xpath = "/html/body/app-root/app-admin/div[2]/div[2]/table/tr[6]/td[12]/button")
    public WebElement addDiscountButton;

    @FindBy(css = "input[formcontrolname=\"discount_percentage\"]")
    public WebElement discountPercentageBox;

    @FindBy(css = "textarea[formcontrolname=\"discount_description\"]")
    public WebElement discountDescriptionBox;

    @FindBy(xpath = "/html/body/app-root/app-admin/div[2]/div[4]/div/div/div[3]/button[2]")
    public WebElement addDiscountModalButton;
}
