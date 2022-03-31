package com.project3.revtech.E2E.steps.User;

import com.project3.revtech.E2E.runner.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderHistorySteps {

    @When("The user clicks on the orders button")
    public void the_user_clicks_on_the_orders_button() {
        TestRunner.orderHistoryPOM.ordersButton.click();
    }
    @When("The user is redirected to the order history page")
    public void the_user_is_redirected_to_the_order_history_page() {
        TestRunner.explicitWait.until(ExpectedConditions.urlContains("order-history"));
    }
    @Then("The user should see their purchase history")
    public void the_user_should_see_their_purchase_history() {
        WebElement element = TestRunner.driver.findElement(By.xpath("//h3[contains(text(), \"Purchase History\")]"));
        TestRunner.explicitWait.until(ExpectedConditions.visibilityOf(element));
    }
}
