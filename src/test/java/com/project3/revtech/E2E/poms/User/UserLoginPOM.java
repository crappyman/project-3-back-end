package com.project3.revtech.E2E.poms.User;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPOM {

    private WebDriver webDriver;

    public UserLoginPOM(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//input[@type=\"text\" and @name=\"username\"]")
    public WebElement loginUsernameInput;

    @FindBy(xpath = "//input[@type=\"password\" and @name=\"password\"]")
    public WebElement loginPasswordInput;

    @FindBy(xpath = "//button[contains(text(), \"Login\")]")
    public WebElement loginButton;
}
