package com.qaconsultants;

import Utils.BaseTests;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LogIn;
import pages.Product;

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
//        throw new io.cucumber.java.PendingException();
    }

    @After
    public void cleanup() {
        if (driverManager.getDriver() != null)
            driverManager.getDriver().close();
    }
}
