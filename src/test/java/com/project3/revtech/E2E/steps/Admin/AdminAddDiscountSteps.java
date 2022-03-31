package com.project3.revtech.E2E.steps.Admin;

import com.project3.revtech.E2E.runner.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdminAddDiscountSteps {

    @Given("the admin is on the home page.")
    public void the_admin_is_on_the_home_page() {
        TestRunner.driver.get("http://localhost:4200/product");
    }

    @When("the admin clicks the manage store button")
    public void the_admin_clicks_the_manage_store_button() {
        TestRunner.adminAddDiscountPOM.manageStoreButton.click();
    }

    @When("the admin clicks the display product inventory button")
    public void the_admin_clicks_the_display_product_inventory_button() {
        TestRunner.adminAddDiscountPOM.displayProductInventory.click();
    }
    @When("the admin clicks the add discount button")
    public void the_admin_clicks_the_add_discount_button() {
        TestRunner.adminAddDiscountPOM.addDiscountButton.click();
    }
    @When("the admin enters a product discount percentage")
    public void the_admin_enters_a_product_discount_percentage() {
        TestRunner.adminAddDiscountPOM.discountPercentageBox.sendKeys("25");
    }
    @When("the admin enters a discount description")
    public void the_admin_enters_a_discount_description() {
        TestRunner.adminAddDiscountPOM.discountDescriptionBox.sendKeys("Blood for the blood god!");
    }

    @When("the admin clicks the add modal discount button")
    public void the_admin_clicks_the_add_modal_discount_button() {
        TestRunner.adminAddDiscountPOM.addDiscountModalButton.click();
    }

    @Then("a popup appears that says {string}")
    public void a_popup_appears_that_says(String string) {
        String alertText = TestRunner.driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, string);
        TestRunner.driver.switchTo().alert().accept();
    }
}
