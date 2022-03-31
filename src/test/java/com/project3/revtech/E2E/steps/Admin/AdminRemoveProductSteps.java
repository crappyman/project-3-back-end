package com.project3.revtech.E2E.steps.Admin;

import com.project3.revtech.E2E.runner.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.jsonwebtoken.lang.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdminRemoveProductSteps {
    @When("the admin clicks the delete product button")
    public void the_admin_clicks_the_delete_product_button() {
        TestRunner.adminRemoveProductPOM.deleteProductButton.click();
    }
    @Then("the product is no longer in the table")
    public void the_product_is_no_longer_in_the_table() {
        TestRunner.explicitWait.until(ExpectedConditions.textToBePresentInElement( TestRunner.adminRemoveProductPOM.productTableElement,"Xbox One Controller"));
        String rowName = TestRunner.adminRemoveProductPOM.productTableElement.getText();
        Assert.isTrue(!rowName.contains("Beats Wireless Studio Headphones"));
}
}
