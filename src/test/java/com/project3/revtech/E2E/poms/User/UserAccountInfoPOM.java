package com.project3.revtech.E2E.poms.User;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAccountInfoPOM {
    private WebDriver webDriver;

    public UserAccountInfoPOM(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//a[@href=\"/profile\"]")
    public WebElement profileButton;
}
