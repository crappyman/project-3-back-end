package com.project3.revtech.E2E.poms.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPOM {
    private WebDriver webDriver;

    public AdminLoginPOM(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    //See UserLoginPOM
}
