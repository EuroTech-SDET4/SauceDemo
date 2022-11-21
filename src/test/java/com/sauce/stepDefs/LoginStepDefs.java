package com.sauce.stepDefs;

import com.sauce.pages.CheckoutPage;
import com.sauce.pages.LoginPage;
import com.sauce.pages.ProductPage;
import com.sauce.utilities.ConfigurationReader;
import com.sauce.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));

    }
    @When("The user is enters {string} and {string}")
    public void the_user_is_enters_and(String username, String password) {

        loginPage.login(username, password);

    }
    @Then("The user should be able to login and see {string} header")
    public void the_user_should_be_able_to_login_and_see_header(String expectedHeader) {
        Assert.assertEquals("Verify that header is ",expectedHeader,productPage.productHeader.getText());



    }

    @And("The user should be able to sort the products {string}")
    public void theUserShouldBeAbleToSortTheProducts(String sortType) {
        productPage.sortProduct(sortType);
    }

    @And("The user clicks cheapest as {string} and second costliest as {string} products")
    public void theUserClicksCheapestAsAndSecondCostliestAsProducts(String cheapest, String secondProduct) {
        productPage.addProduct(cheapest);
        productPage.addProduct(secondProduct);

    }

    @Then("The user opens basket")
    public void theUserOpensBasket() {
        productPage.basket.click();
    }

    @And("The user clicks checkout")
    public void theUserClicksCheckout() {
        checkoutPage.checkout.click();
    }

    @And("The user enters details {string} {string} {string}  and finish the purchase")
    public void theUserEntersDetailsAndFinishThePurchase(String firstname, String lastname, String postcode) {
        checkoutPage.enterDetails(firstname, lastname, postcode);
        checkoutPage.continueBtn.click();
    }

    @Then("The user verify that items are {string} and able to total is {string}")
    public void theUserVerifyThatItemsAreAndAbleToTotalIs(String price , String expectedTotal) {

        System.out.println("checkoutPage.getTotalPrice(price) = " + checkoutPage.getTotalPrice(price));
        Assert.assertEquals(expectedTotal,checkoutPage.getTotalPrice(price));
    }
}
