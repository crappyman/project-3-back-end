package com.project3.revtech.E2E.steps.User;

import com.project3.revtech.E2E.runner.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class UserSearchProductsSteps {

    @When("The user clicks on the search bar")
    public void the_user_clicks_on_the_search_bar() {
        TestRunner.userSearchProductsPOM.searchBar.click();
    }
    @When("The user enters a {string} into the search bar")
    public void the_user_enters_a_into_the_search_bar(String string) {
        TestRunner.userSearchProductsPOM.searchBar.sendKeys(string);
    }
    @When("The user clicks the enter key")
    public void the_user_clicks_the_enter_key() {
        TestRunner.userSearchProductsPOM.searchBar.sendKeys(Keys.ENTER);
    }
    @Then("The user should see the product list for the specified item\\(s)")
    public void the_user_should_see_the_product_list_for_the_specified_item_s() {
        TestRunner.driver.findElements(By.className("card"));
    }
}
