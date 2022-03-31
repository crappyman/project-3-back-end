package com.project3.revtech.E2E.poms.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminRemoveProductPOM {
    private WebDriver webDriver;

    public AdminRemoveProductPOM(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath="/html/body/app-root/app-admin/div[2]/div[2]/table/tr[7]/td[11]/button")
    public WebElement deleteProductButton;

    @FindBy(xpath="/html/body/app-root/app-admin/div[2]/div[2]/table/tr[7]/td[2]")
    public WebElement productTableElement;
}
