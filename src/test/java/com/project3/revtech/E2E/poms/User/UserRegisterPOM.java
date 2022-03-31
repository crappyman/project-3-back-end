package com.project3.revtech.E2E.poms.User;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserRegisterPOM {

    private WebDriver webDriver;

    public UserRegisterPOM(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    @FindBy(css = "button[class=\"btn btn-dark btn-sm\"]")
    public WebElement registerButton;

    @FindBy(xpath = "//input[@placeholder=\"First name\"]")
    public WebElement firstNameInput;

    @FindBy(xpath = "//input[@placeholder=\"Last name\"]")
    public WebElement lastNameInput;

    @FindBy(xpath = "//input[@placeholder=\"Username\"]")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@placeholder=\"example@domain.com\"]")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@placeholder=\"Must have at least 6 characters\"]")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@placeholder=\"123 Enterprise Way, Palo Alto, CA 94020\"]")
    public WebElement addressInput;

    @FindBy(xpath = "//input[@placeholder=\"Format: 555-555-5555\"]")
    public WebElement phoneNumberInput;

    @FindBy(css = "button[class=\"btn btn-danger btn-block\"]")
    public WebElement signUpButton;


}
