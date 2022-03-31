package com.project3.revtech.E2E.steps.Admin;

import com.project3.revtech.E2E.runner.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdminLoginSteps {

    @Given("The admin is on the login page")
    public void the_admin_is_on_the_login_page() {
        TestRunner.driver.get("http://localhost:4200/login");
    }
    @When("The admin enters username into the login form")
    public void the_user_enters_username_into_the_login_form() {
        TestRunner.userLoginPOM.loginUsernameInput.sendKeys("admin");
    }
    @When("The admin enters password into the login form")
    public void the_user_enters_password_into_the_login_form() {
        TestRunner.userLoginPOM.loginPasswordInput.sendKeys("123456");
    }
    @When("The admin clicks on the login button")
    public void the_user_clicks_on_the_login_button() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.userLoginPOM.loginButton));
        TestRunner.userLoginPOM.loginButton.click();
    }
    @Then("The admin is redirected to the home page")
    public void the_user_is_redirected_to_the_home_page() {
        TestRunner.explicitWait.until(ExpectedConditions.urlContains("http://localhost:4200/product"));;
    }
}
