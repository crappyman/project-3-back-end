package com.project3.revtech.E2E.steps.User;

import com.project3.revtech.E2E.runner.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PutItemInCartSteps {

    @When("The user clicks on the view details button")
    public void the_user_clicks_on_the_view_details_button() {
        TestRunner.putItemInCartPOM.viewDetailsButton.click();
    }
    @When("The user is redirected to the product page")
    public void the_user_is_redirected_to_the_product_page() {
        TestRunner.explicitWait.until(ExpectedConditions.urlContains("http://localhost:4200/product-page"));
    }

    @When("The user clicks on the + icon")
    public void the_user_clicks_on_the_icon() {
        WebElement element = TestRunner.putItemInCartPOM.plusIcon;
        element.click();
    }

    @When("The user clicks on go to cart button")
    public void the_user_clicks_on_go_to_cart_button() {
        WebElement element = TestRunner.putItemInCartPOM.goToCartButton;
        JavascriptExecutor js = (JavascriptExecutor) TestRunner.driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(element));
        if(element.isDisplayed()){
            element.click();
        }
    }

    @Then("The user is redirected to the checkout page")
    public void the_user_is_redirected_to_the_checkout_page() {
        TestRunner.explicitWait.until(ExpectedConditions.urlContains("http://localhost:4200/checkout"));
    }

    @When("The user clicks on the remove button")
    public void the_user_clicks_on_the_remove_button() {
        TestRunner.putItemInCartPOM.removeButton.click();
    }

    @Then("The item should no longer display in the cart")
    public void the_item_should_no_longer_display_in_the_cart() {
        TestRunner.explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/app-root/app-checkout/section/div/div/div[1]/div")));
    }

    @When("The user clicks on the + icon three times")
    public void the_user_clicks_on_the_icon_three_times() throws InterruptedException {
        WebElement element = TestRunner.putItemInCartPOM.plusIcon;
        for(int i=0; i<3; i++){
            element.click();
            Thread.sleep(1000);
        }
    }

}
