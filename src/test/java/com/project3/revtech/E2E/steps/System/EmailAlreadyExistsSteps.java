package com.project3.revtech.E2E.steps.System;

import com.project3.revtech.E2E.runner.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.testng.AssertJUnit.assertTrue;

public class EmailAlreadyExistsSteps {

    @When("The user enters a username into the register form")
    public void the_user_enters_username_into_the_register_form() {
        TestRunner.userRegisterPOM.usernameInput.sendKeys("Rev");
    }

    @When("The user enters an existing email into the register form")
    public void the_user_enters_an_existing_email_into_the_register_form() {
        TestRunner.userRegisterPOM.emailInput.sendKeys("admin@example.com");
    }

    @Then("The user should receive an email is already taken error message")
    public void the_user_should_receive_an_email_is_already_taken_error_message() {
        WebElement element = TestRunner.driver.findElement(By.xpath("//div[contains(text(), \"Signup failed!: Email\")]"));
        JavascriptExecutor js = (JavascriptExecutor) TestRunner.driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        String text = element.getText();
        assertTrue(text.contains("Signup failed!: Email is already in use!"));
    }
}
