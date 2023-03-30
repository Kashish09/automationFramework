package com.qaconsultants;

import Utils.BaseTests;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.*;

public class TestSteps{
//    public TestSteps() {
//        Given("^I open login page$", () -> {
//            System.out.println("I open login page");
//            Configuration.browser = "firefox";
//            Configuration.browserBinary = "C:/Program Files/Mozilla Firefox/firefox.exe";
//            System.setProperty("webdriver.gecko.driver", "E:/!!!!/geckodriver.exe");
//            open("https://www.google.com/");
//            sleep(1000);
//        });
//    }
//    private static WebDriver driver;
    private BaseTests driverManager = new BaseTests();
    private LogIn login = new LogIn(driverManager.getDriver());
    private Product product = new Product(driverManager.getDriver());
    private Cart cart = new Cart(driverManager.getDriver());

    private Checkout checkout = new Checkout(driverManager.getDriver());

    private Payment payment = new Payment(driverManager.getDriver());

    private OrderConfirmation orderConfirmation = new OrderConfirmation(driverManager.getDriver());

    @Given("user is on login page")
    public void user_is_on_login_page() {
        // Write code here that turns the phrase above into concrete actions

        driverManager.launchApplication();

//        throw new io.cucumber.java.PendingException();
    }

    @When("user enters valid id and password")
    public void user_enters_valid_id_and_password() {
        // Write code here that turns the phrase above into concrete actions

        login.setLoginEmailAddress("qwerty123@example.com");
        login.setLoginPassword("qwerty123");
//        throw new io.cucumber.java.PendingException();
    }

    @When("click on login button")
    public void click_on_login_button() {
        // Write code here that turns the phrase above into concrete actions
        login.submit();
//        throw new io.cucumber.java.PendingException();
    }
    @Then("user should land on home page")
    public void user_should_land_on_home_page() {
        // Write code here that turns the phrase above into concrete actions
//        System.out.println(driver.getTitle());
        String loggedUserName = login.loggedUserNameVisible();
        Assert.assertEquals(loggedUserName, "Logged in as qwerty123");
//        throw new io.cucumber.java.PendingException();
    }

    @When("user go to Product Page")
    public void user_go_to_product_page() {
        // Write code here that turns the phrase above into concrete actions
        driverManager.productPageLaunch();
//        throw new io.cucumber.java.PendingException();
    }

    @When("search tshirts")
    public void search_tshirts() {
        // Write code here that turns the phrase above into concrete actions
        product.searchProductFromSearchBar("tshirts");
        product.clickSearchButton();
//        throw new io.cucumber.java.PendingException();
    }

    @When("add two tshirts to cart")
    public void add_two_tshirts_to_cart() {
        // Write code here that turns the phrase above into concrete actions
        product.addTshirtsToCart();
//        throw new io.cucumber.java.PendingException();
    }

    @Then("tshirts are visible in the cart")
    public void tshirts_are_visible_in_the_cart() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }

    @Then("user is able to remove one tshirt")
    public void user_is_able_to_remove_one_tshirt() {
        // Write code here that turns the phrase above into concrete actions
        cart.deleteOneTshirtFromCart();

//        throw new io.cucumber.java.PendingException();
    }

    @Then("user is able to proceed to checkout and place the order")
    public void user_is_able_to_proceed_to_checkout_and_place_the_order() {
        // Write code here that turns the phrase above into concrete actions
        cart.proceedToCheckout();
        checkout.placeTheOrder();
//        throw new io.cucumber.java.PendingException();
    }

    @When("user is redirected to Payments page after placing order")
    public void user_is_redirected_to_payments_page_after_placing_order() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }

    @Then("user is able to fill the card details")
    public void user_is_able_to_fill_the_card_details() {
        // Write code here that turns the phrase above into concrete actions
//        driverManager.getDriver().switchTo().frame(0);
//        int size = driverManager.getDriver().findElements(By.tagName("iframe")).size();
//        System.out.println(size);
//        driverManager.getDriver().switchTo().defaultContent();
        WebElement frame = driverManager.getDriver().findElement(By.xpath("//iframe[contains(@name,'aswift') and contains(@style,'visibility: visible')]"));
        if(frame.isDisplayed()){
            
            driverManager.getDriver().switchTo().frame(frame);
            WebElement frame1 = driverManager.getDriver().findElement(By.id("ad_iframe"));
            driverManager.getDriver().switchTo().frame(frame1);
            System.out.println(driverManager.getDriver().findElement(By.id("dismiss-button")).getText());
//            actions.click(driverManager.getDriver().findElement(By.id("dismiss-button"))).perform();
            driverManager.getDriver().findElement(By.id("dismiss-button")).click();
            driverManager.getDriver().switchTo().defaultContent();
        }
//        payment.adPopUpClose();
        payment.enterCardName();
        payment.enterCardNumer();
        payment.enterCvcNumber();
        payment.enterExpirationMonth();
        payment.enterExpirationYear();
//        throw new io.cucumber.java.PendingException();
    }

    @Then("user is able to click the Pay and Confirm button")
    public void user_is_able_to_click_the_pay_and_confirm_button() {
        // Write code here that turns the phrase above into concrete actions
        payment.payAndConfirmButton();
//        throw new io.cucumber.java.PendingException();
    }

    @Then("user downloads the invoice")
    public void user_downloads_the_invoice() {
        // Write code here that turns the phrase above into concrete actions
        orderConfirmation.downloadInvoice();
//        throw new io.cucumber.java.PendingException();
    }


//    @After
//    public void cleanup() {
//        if (driverManager.getDriver() != null) {
//            driverManager.getDriver().close();
//            driverManager.getDriver().quit();
////        driverManager.tearDown();
//        }
//    }
}
