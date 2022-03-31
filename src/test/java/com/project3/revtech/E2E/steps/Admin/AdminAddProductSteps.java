package com.project3.revtech.E2E.steps.Admin;

import com.project3.revtech.E2E.runner.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class AdminAddProductSteps {
    @When("the admin clicks the add product button")
    public void the_admin_clicks_the_add_product_button() {
        TestRunner.adminAddProductPOM.addProductButton.click();
    }

    @When("the admin enters a product name")
    public void the_admin_enters_a_product_name() {
        TestRunner.adminAddProductPOM.productNameField.sendKeys("BLOOD FOR THE BLOOD GOD!");
    }

    @When("the admin enters a product category")
    public void the_admin_enters_a_product_category() {
        Select categorySelector = new Select(TestRunner.adminAddProductPOM.productTypeSelector);
        categorySelector.selectByVisibleText("Gaming Consoles");
    }

    @When("the admin enters a product cost")
    public void the_admin_enters_a_product_cost() {
        TestRunner.adminAddProductPOM.productCost.sendKeys("6.66");
    }

    @When("the admin enters a product quantity")
    public void the_admin_enters_a_product_quantity() {
        TestRunner.adminAddProductPOM.productQuantity.sendKeys("65");
    }

    @When("the admin selects an image file")
    public void the_admin_selects_an_image_file() {
        File imageFile = new File("src/test/resources/Khorne.jpg");
        String absolutePath = imageFile.getAbsolutePath();
        TestRunner.adminAddProductPOM.productImageUrl.sendKeys(absolutePath);
    }

    @When("the admin enters a product description")
    public void the_admin_enters_a_product_description() {
        TestRunner.adminAddProductPOM.productDescription.sendKeys("SKULLS FOR THE SKULL THRONE!");
    }

    @When("the admin clicks the modal add product button")
    public void the_admin_clicks_the_modal_add_product_button() {
        TestRunner.adminAddProductPOM.productAdd.click();
    }

    @Then("a new product is added to the end of the table")
    public void a_new_product_is_added_to_the_end_of_the_table() {
        String alertText = TestRunner.driver.switchTo().alert().getText();
        TestRunner.driver.switchTo().alert().accept();
        Assert.assertEquals("Product was added successfully", alertText);
}

}
