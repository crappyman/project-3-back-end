package com.project3.revtech.E2E.steps.Admin;

import com.project3.revtech.E2E.runner.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdminLogoutSteps {

    @When("the admin clicks the logout button")
    public void the_admin_clicks_the_logout_button() {
        TestRunner.adminLogoutPOM.logoutButton.click();
    }

    @Then("the admin is redirected to the login page")
    public void the_admin_is_redirected_to_the_login_page() {
        TestRunner.explicitWait.until(ExpectedConditions.urlToBe("http://localhost:4200/login"));
        String url = TestRunner.driver.getCurrentUrl();
        Assert.assertEquals("http://localhost:4200/login", url);
}
}
