package com.project3.revtech.E2E.poms.User;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PutItemInCartPOM {

    private WebDriver webDriver;

    public PutItemInCartPOM(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//button[contains(text(), \"View Details\")]")
    public WebElement viewDetailsButton;

    @FindBy(xpath = "//span[@class=\"up\" and contains(text(), \"+\")]")
    public WebElement plusIcon;

    @FindBy(xpath = "/html/body/app-root/app-product-page/section/div/article[1]/div/div/main/article/div[5]/button")
    public WebElement goToCartButton;

    @FindBy(xpath = "//button[@class=\"remove\"]")
    public WebElement removeButton;


}
