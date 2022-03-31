package com.project3.revtech.E2E.steps.System;

import com.project3.revtech.E2E.runner.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.testng.AssertJUnit.assertTrue;

public class InvalidCredentialsSteps {

    @When("The user enters an incorrect username")
    public void the_user_enters_an_incorrect_username() {
        TestRunner.userLoginPOM.loginUsernameInput.sendKeys("Invalid");
    }
    @When("The user enters an incorrect password")
    public void the_user_enters_an_incorrect_password() {
        TestRunner.userLoginPOM.loginPasswordInput.sendKeys("Credentials");
    }
    @Then("The user should receive a bad credentials error message")
    public void the_user_should_receive_a_bad_credentials_error_message() {
        WebElement element = TestRunner.driver.findElement(By.xpath("//div[contains(text(), \"Login failed\")]"));
        String text = element.getText();
        assertTrue(text.contains("Login failed: Bad credentials"));
    }
}
