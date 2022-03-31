package com.project3.revtech.E2E.steps.User;

import com.project3.revtech.E2E.runner.TestRunner;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ListOfAvailableProductsSteps {

    @Then("The user should see a list of available products")
    public void the_user_should_see_a_list_of_available_products() {
        TestRunner.explicitWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("card"), 5));
    }

}
