package com.project3.revtech.E2E.steps.User;

import com.project3.revtech.E2E.runner.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserReviewsSteps {

    @When("The user enters a review title")
    public void the_user_enters_a_review_title() {
        WebElement title = TestRunner.userReviewsPOM.titleInput;
        JavascriptExecutor js = (JavascriptExecutor) TestRunner.driver;
        js.executeScript("arguments[0].scrollIntoView();", title);
        if(title.isDisplayed()){
            title.sendKeys("Excellent Product");
        }
    }

    @When("The user enters a review")
    public void the_user_enters_a_review() {
        TestRunner.userReviewsPOM.reviewTextArea.sendKeys("I could not have been happier with this product");
    }

    @When("The user clicks on a star rating")
    public void the_user_clicks_on_a_star_rating() {
        WebElement element = TestRunner.userReviewsPOM.fourStarRating;
        JavascriptExecutor js = (JavascriptExecutor) TestRunner.driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        js.executeScript("arguments[0].click();", element);
    }

    @When("the user clicks the submit button")
    public void the_user_clicks_the_submit_button() {
        WebElement element = TestRunner.userReviewsPOM.submitButton;
        JavascriptExecutor js = (JavascriptExecutor) TestRunner.driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        element.sendKeys(Keys.ENTER);
    }

    @Then("the user should see the review at the bottom of the page")
    public void the_user_should_see_the_review_at_the_bottom_of_the_page() {
        WebElement element = TestRunner.driver.findElement(By.xpath("//div[@class=\"row justify-content-center\"]"));
        JavascriptExecutor js = (JavascriptExecutor) TestRunner.driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        TestRunner.explicitWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@class=\"card\"]"),1));
    }

}
