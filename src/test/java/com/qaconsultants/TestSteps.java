package com.qaconsultants;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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

    @Given("user is on login page")
    public void user_is_on_login_page() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }

    @When("user enters valid id and password")
    public void user_enters_valid_id_and_password() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }

    @When("click on login button")
    public void click_on_login_button() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }
    @Then("user should land on home page")
    public void user_should_land_on_home_page() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }

}
