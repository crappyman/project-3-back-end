package com.project3.revtech.E2E.steps.System;

import com.project3.revtech.E2E.runner.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.testng.AssertJUnit.assertTrue;

public class UsernameAlreadyExistsSteps {

    @When("The user enters an existing username into the register form")
    public void the_user_enters_an_existing_username_into_the_register_form() {
        TestRunner.userRegisterPOM.usernameInput.sendKeys("admin");
    }
    @Then("The user should receive an username is already taken error message")
    public void the_user_should_receive_an_username_is_already_taken_error_message() {
        WebElement element = TestRunner.driver.findElement(By.xpath("//div[contains(text(), \"Signup failed!: Username\")]"));
        JavascriptExecutor js = (JavascriptExecutor) TestRunner.driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        String text = element.getText();
        assertTrue(text.contains("Signup failed!: Username is already taken!"));
    }

}
