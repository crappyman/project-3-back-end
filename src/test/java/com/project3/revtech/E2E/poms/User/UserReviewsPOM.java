package com.project3.revtech.E2E.poms.User;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserReviewsPOM {
    private WebDriver webDriver;

    public UserReviewsPOM(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//input[@id=\"title\" and @type=\"text\"]")
    public WebElement titleInput;

    @FindBy(xpath = "//textarea[@id=\"subject\"]")
    public WebElement reviewTextArea;

    @FindBy(xpath = "//span[@type=\"hidden\"][4]")
    public WebElement fourStarRating;

    @FindBy(xpath = "//input[@type=\"submit\" and @value=\"Submit\"]")
    public WebElement submitButton;

}
