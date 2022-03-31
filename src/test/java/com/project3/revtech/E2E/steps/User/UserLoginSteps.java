package com.project3.revtech.E2E.steps.User;

import com.project3.revtech.E2E.runner.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserLoginSteps {

    @When("The user enters username into the login form")
    public void the_user_enters_username_into_the_login_form() {
        TestRunner.userLoginPOM.loginUsernameInput.sendKeys("RevatureTech");
    }

    @When("The user enters password into the login form")
    public void the_user_enters_password_into_the_login_form() {
        TestRunner.userLoginPOM.loginPasswordInput.sendKeys("123456");
    }

    @When("The user clicks on the login button")
    public void the_user_clicks_on_the_login_button() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userLoginPOM.loginButton));
        TestRunner.userLoginPOM.loginButton.click();
    }

    @Then("The user is redirected to the home page")
    public void the_user_is_redirected_to_the_home_page() {
        TestRunner.explicitWait.until(ExpectedConditions.urlContains("http://localhost:4200/product"));;
    }
}
