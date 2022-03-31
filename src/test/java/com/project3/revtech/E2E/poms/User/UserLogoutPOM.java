package com.project3.revtech.E2E.poms.User;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLogoutPOM {
    private WebDriver webDriver;

    public UserLogoutPOM(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//a[contains(text(), \"Logout\")]")
    public WebElement logoutButton;

}
