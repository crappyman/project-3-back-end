package com.project3.revtech.E2E.steps.Admin;

import com.project3.revtech.E2E.runner.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.jsonwebtoken.lang.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AdminRemoveDiscountSteps {

    @When("the admin clicks the display product discounts button")
    public void the_admin_clicks_the_display_product_discounts_button() {
        TestRunner.adminRemoveDiscountPOM.displayDiscountButton.click();
    }

    @When("the admin clicks the delete button")
    public void the_admin_clicks_the_delete_button() {
        TestRunner.adminRemoveDiscountPOM.deleteButton.click();
    }

    @When("the admin clicks the delete discount button")
    public void the_admin_clicks_the_delete_discount_button() {
        TestRunner.adminRemoveDiscountPOM.deleteDiscountButton.click();
    }

    @When("the admin clicks ok on the are you sure alert")
    public void the_admin_clicks_ok_on_the_are_you_sure_alert() {
        TestRunner.driver.switchTo().alert().accept();
    }

    @Then("the discount is removed from the discount list")
    public void the_discount_is_removed_from_the_discount_list() {
        TestRunner.explicitWait.until(ExpectedConditions.textToBePresentInElement(TestRunner.adminRemoveDiscountPOM.discountTableElement, "Macbook Pro"));
        String rowName = TestRunner.adminRemoveDiscountPOM.discountTableElement.getText();
        Assert.isTrue(!rowName.contains("Xbox One"));
    }
}
