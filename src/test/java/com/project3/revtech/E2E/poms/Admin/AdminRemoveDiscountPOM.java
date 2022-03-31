package com.project3.revtech.E2E.poms.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminRemoveDiscountPOM {
    private WebDriver webDriver;

    public AdminRemoveDiscountPOM(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id="displayDiscountBtn")
    public WebElement displayDiscountButton;

    @FindBy(css="button[data-bs-target=\"#exampleModal5\"]")
    public WebElement deleteButton;

    @FindBy(xpath = "/html/body/app-root/app-admin/div[2]/div[5]/div/div/div[3]/button[2]")
    public WebElement deleteDiscountButton;

    @FindBy(xpath = "/html/body/app-root/app-admin/div[2]/div[2]/table/tr[2]/td[2]")
    public WebElement discountTableElement;

}
