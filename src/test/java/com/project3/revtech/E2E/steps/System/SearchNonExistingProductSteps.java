package com.project3.revtech.E2E.steps.System;

import com.project3.revtech.E2E.runner.TestRunner;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchNonExistingProductSteps {

    @Then("The user should see nothing in the product list")
    public void the_user_should_see_nothing_in_the_product_list() {
        TestRunner.explicitWait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.className("card"), 1));
    }
}
