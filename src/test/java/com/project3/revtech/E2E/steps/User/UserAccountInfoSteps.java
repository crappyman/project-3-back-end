package com.project3.revtech.E2E.steps.User;

import com.project3.revtech.E2E.runner.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserAccountInfoSteps {

    @When("The user clicks on the profile button")
    public void the_user_clicks_on_the_profile_button() {
        TestRunner.userAccountInfoPOM.profileButton.click();
    }
    @When("The user is redirected to the profile page")
    public void the_user_is_redirected_to_the_profile_page() {
        TestRunner.explicitWait.until(ExpectedConditions.urlContains("profile"));
    }
    @Then("The user should see their account information")
    public void the_user_should_see_their_account_information() {
        WebElement element = TestRunner.driver.findElement(By.xpath("//div[@class=\"panel-body inf-content\"]"));
        TestRunner.explicitWait.until(ExpectedConditions.visibilityOf(element));
    }
}
