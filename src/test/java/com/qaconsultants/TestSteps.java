package com.qaconsultants;

import Utils.BaseTests;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.*;

public class TestSteps{

    private BaseTests driverManager = new BaseTests();
    private LogIn login = new LogIn(driverManager.getDriver());
    private Product product = new Product(driverManager.getDriver());
    private Cart cart = new Cart(driverManager.getDriver());

    private Checkout checkout = new Checkout(driverManager.getDriver());

    private Payment payment = new Payment(driverManager.getDriver());

    private OrderConfirmation orderConfirmation = new OrderConfirmation(driverManager.getDriver());

    private AdBlock adBlock = new AdBlock(driverManager.getDriver());
    @Given("user is on login page")
    public void user_is_on_login_page() {

        try {
            adBlock.closeAd();
        } catch (Exception e) {

        }
        driverManager.launchApplication();

    }

    @When("user enters valid id and password")
    public void user_enters_valid_id_and_password() {


        login.setLoginEmailAddress("qwerty123@example.com");
        login.setLoginPassword("qwerty123");

    }

    @When("click on login button")
    public void click_on_login_button() {

        login.submit();

    }
    @Then("user should land on home page")
    public void user_should_land_on_home_page() {

        try {
            adBlock.closeAd();
        } catch (Exception e) {

        }
        String loggedUserName = login.loggedUserNameVisible();
        Assert.assertEquals(loggedUserName, "Logged in as qwerty123");

    }

    @When("user go to Product Page")
    public void user_go_to_product_page() {

        login.openProductPage();

    }

    @When("search tshirts")
    public void search_tshirts() {

        try {
            adBlock.closeAd();
        } catch (Exception e) {

        }
        product.searchProductFromSearchBar("tshirts");
        product.clickSearchButton();

    }

    @When("add two tshirts to cart")
    public void add_two_tshirts_to_cart() {

        product.addTshirtsToCart();

    }

    @Then("user is able to remove one tshirt")
    public void user_is_able_to_remove_one_tshirt() {

        try {
            adBlock.closeAd();
        } catch (Exception e) {

        }
        cart.deleteOneTshirtFromCart();


    }

    @Then("user is able to proceed to checkout and place the order")
    public void user_is_able_to_proceed_to_checkout_and_place_the_order() {

        cart.proceedToCheckout();
        checkout.placeTheOrder();

    }

    @When("user is redirected to Payments page after placing order")
    public void user_is_redirected_to_payments_page_after_placing_order() {
        String name = payment.getPageName();
        Assert.assertEquals(name, "Payment");
    }

    @Then("user is able to fill the card details")
    public void user_is_able_to_fill_the_card_details() {

        try {
            adBlock.closeAd();
        } catch (Exception e) {

        }
        payment.enterCardName();
        payment.enterCardNumer();
        payment.enterCvcNumber();
        payment.enterExpirationMonth();
        payment.enterExpirationYear();

    }

    @Then("user is able to click the Pay and Confirm button")
    public void user_is_able_to_click_the_pay_and_confirm_button() {

        payment.payAndConfirmButton();

    }

    @Then("user downloads the invoice")
    public void user_downloads_the_invoice() {

        try {
            adBlock.closeAd();
        } catch (Exception e) {

        }
        orderConfirmation.downloadInvoice();

    }


    @After
    public void cleanup() {
        if (driverManager.getDriver() != null) {
//            driverManager.getDriver().close();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
            driverManager.getDriver().quit();
        }
    }
}
