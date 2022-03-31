package com.project3.revtech.E2E.poms.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminAddProductPOM {
    private WebDriver webDriver;

    public AdminAddProductPOM(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "button[id=\"addProdBtn\"]")
    public WebElement addProductButton;

    @FindBy(id="InputProductName")
    public WebElement productNameField;

    @FindBy(css = "select[id=\"categoryTypes\"]")
    public WebElement productTypeSelector;

    @FindBy(id="InputProductCost")
    public WebElement productCost;

    @FindBy(xpath="/html/body/app-root/app-admin/div[1]/div/div/div[2]/form/div[5]/input")
    public WebElement productQuantity;

    @FindBy(id="InputProductImgUrl")
    public WebElement productImageUrl;

    @FindBy(css ="textarea[id=\"InputProductDescription \"]")
    public WebElement productDescription;

    @FindBy(xpath="/html/body/app-root/app-admin/div[1]/div/div/div[3]/button[2]")
    public WebElement productAdd;


}
