package com.project3.revtech.E2E.steps.User;

import com.project3.revtech.E2E.runner.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserRegisterSteps {

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        TestRunner.driver.get("http://localhost:4200/login");
    }

    @When("The user clicks on the register button")
    public void the_user_clicks_on_the_register_button() {
        TestRunner.userRegisterPOM.registerButton.click();
    }

    @When("The user is redirected to the register page")
    public void the_user_is_redirected_to_the_register_page() {
        TestRunner.explicitWait.until(ExpectedConditions.urlContains("http://localhost:4200/register"));
    }

    @When("The user enters first name into the register form")
    public void the_user_enters_first_name_into_the_register_form() {
        TestRunner.userRegisterPOM.firstNameInput.sendKeys("Revature");
    }

    @When("The user enters last name into the register form")
    public void the_user_enters_last_name_into_the_register_form() {
        TestRunner.userRegisterPOM.lastNameInput.sendKeys("Tech");
    }

    @When("The user enters username into the register form")
    public void the_user_enters_username_into_the_register_form() {
        TestRunner.userRegisterPOM.usernameInput.sendKeys("RevatureTech");
    }

    @When("The user enters email into the register form")
    public void the_user_enters_email_into_the_register_form() {
        TestRunner.userRegisterPOM.emailInput.sendKeys("Revature@Tech.com");
    }

    @When("The user enters password into the register form")
    public void the_user_enters_password_into_the_register_form() {
        TestRunner.userRegisterPOM.passwordInput.sendKeys("123456");
    }

    @When("The user enters address into the register form")
    public void the_user_enters_address_into_the_register_form() {
        TestRunner.userRegisterPOM.addressInput.sendKeys("123 Enterprise Way, Palo Alto, CA 94020");
    }

    @When("The user enters phone number into the register form")
    public void the_user_enters_phone_number_into_the_register_form() {
        TestRunner.userRegisterPOM.phoneNumberInput.sendKeys("555-555-5555");
    }

    @When("The user scrolls down the page")
    public void the_user_scrolls_down_the_page(){
        WebElement element = TestRunner.userRegisterPOM.signUpButton;
        JavascriptExecutor js = (JavascriptExecutor) TestRunner.driver;
        js.executeScript("arguments[0].scrollIntoView();", element);

    }
    @When("The user clicks on the sign up button")
    public void the_user_clicks_on_the_sign_up_button() {
        TestRunner.driver.findElement(By.xpath("//body")).sendKeys(Keys.CONTROL, Keys.END);
        WebElement element = TestRunner.userRegisterPOM.signUpButton;
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(element));
        if(element.isDisplayed() && element.isEnabled()){
            element.click();
        }
    }

    @Then("The user is redirected to the login page")
    public void the_user_is_redirected_to_the_login_page() {
        TestRunner.explicitWait.until(ExpectedConditions.urlContains("http://localhost:4200/login"));
        TestRunner.driver.findElement(By.xpath("//input[@name=\"username\"]"));
    }

}
