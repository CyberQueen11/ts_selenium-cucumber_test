package se.yrgo.selenium;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DoneItemsStepDefinitions {

    @Given("that the list contains the following {string} <items>")
    public void that_the_list_contains_the_following_items(String status, List<String> items) {
        throw new io.cucumber.java.PendingException();
    }

    @When("the user navigates to the done page")
    public void the_user_navigates_to_the_done_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the <items> are visible.")
    public void the_items_are_visible(List<String> items) {
        throw new io.cucumber.java.PendingException();
    }
}
