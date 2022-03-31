package com.project3.revtech.E2E.steps.User;

import com.project3.revtech.E2E.runner.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PurchaseDiscountedSteps {

    @When("The user clicks on the discounted items button")
    public void the_user_clicks_on_the_discounted_items_button() {
        TestRunner.purchaseDiscountedPOM.discountedItemsButton.click();
    }
    @When("The user clicks on the proceed to checkout button")
    public void the_user_clicks_on_the_proceed_to_checkout_button() {
        TestRunner.purchaseDiscountedPOM.proceedToCheckoutButton.click();
    }
    @Then("The user is redirected to the confirmation page")
    public void the_user_is_redirected_to_the_confirmation_page() {
        TestRunner.explicitWait.until(ExpectedConditions.urlContains("http://localhost:4200/confirmation-checkout"));
    }

}
