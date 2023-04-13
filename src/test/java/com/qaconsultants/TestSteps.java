package com.qaconsultants;

import Utils.BaseTests;
import ch.qos.logback.classic.Logger;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.slf4j.LoggerFactory;
import pages.*;

public class TestSteps{

    static Logger log = (Logger) LoggerFactory.getLogger(TestSteps.class);
    private BaseTests driverManager = new BaseTests();
    private LogIn login;
    private Product product;
    private Cart cart;

    private Checkout checkout;

    private Payment payment;

    private OrderConfirmation orderConfirmation;

    private AdBlock adBlock = new AdBlock(driverManager.getDriver());
    @Given("user is on login page")
    public void user_is_on_login_page() {

        try {
            adBlock.closeAd();
        } catch (Exception e) {
            log.info("*****************************************************************");
            log.info("Error closing the ad: " + e);
            log.info("*****************************************************************");
        }
        driverManager.launchApplication();

    }

    @When("user enters valid id and password")
    public void user_enters_valid_id_and_password(DataTable userCredentials) {

        login = new LogIn(driverManager.getDriver());
        login.setLoginEmailAddress(userCredentials.cell(0,0));
        login.setLoginPassword(userCredentials.cell(0,1));

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
            log.info("*****************************************************************");
            log.info("Error closing the ad: " + e);
            log.info("*****************************************************************");
        }
        String loggedUserName = login.loggedUserNameVisible();
        Assert.assertEquals(loggedUserName, "Logged in as qwerty123");

    }

    @When("user go to Product Page")
    public void user_go_to_product_page() {

        login.openProductPage();

    }

    @When("search tshirts")
    public void search_tshirts(DataTable searchItem) {

        try {
            adBlock.closeAd();
        } catch (Exception e) {
            log.info("*****************************************************************");
            log.info("Error closing the ad: " + e);
            log.info("*****************************************************************");
        }
        product = new Product(driverManager.getDriver());
        product.searchProductFromSearchBar(searchItem.cell(0,0));
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
            log.info("*****************************************************************");
            log.info("Error closing the ad: " + e);
            log.info("*****************************************************************");
        }
        cart = new Cart(driverManager.getDriver());
        cart.deleteOneTshirtFromCart();


    }

    @Then("user is able to proceed to checkout and place the order")
    public void user_is_able_to_proceed_to_checkout_and_place_the_order() {

        cart.proceedToCheckout();
        checkout = new Checkout(driverManager.getDriver());
        checkout.placeTheOrder();

    }

    @When("user is redirected to Payments page after placing order")
    public void user_is_redirected_to_payments_page_after_placing_order() {
        payment = new Payment(driverManager.getDriver());
        String name = payment.getPageName();
        Assert.assertEquals(name, "Payment");
    }

    @Then("user is able to fill the card details")
    public void user_is_able_to_fill_the_card_details() {

        try {
            adBlock.closeAd();
        } catch (Exception e) {
            log.info("*****************************************************************");
            log.info("Error closing the ad: " + e);
            log.info("*****************************************************************");
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
            log.info("*****************************************************************");
            log.info("Error closing the ad: " + e);
            log.info("*****************************************************************");
        }
        orderConfirmation = new OrderConfirmation(driverManager.getDriver());
        orderConfirmation.downloadInvoice();

    }


    @After
    public void cleanup() {
        if (driverManager.getDriver() != null) {
//            driverManager.getDriver().close();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                log.info("*****************************************************************");
                log.info("Error closing the webdriver: " + e);
                log.info("*****************************************************************");
            }
            driverManager.getDriver().quit();
        }
    }
}
