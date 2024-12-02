package se.yrgo.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddItemStepDefinitions {

    @Given("the user is on the start page.")
    public void the_user_is_on_the_start_page() {
        GeneralStepDefinition.startPage.open();
    }

    @When("the user adds a todo with text {string}")
    public void the_user_adds_a_todo_with_text(String input) {
        GeneralStepDefinition.startPage.addTodoItem(input);
    }

    @Then("the todo item list should contain {string}")
    public void the_todo_item_list_should_contain(String itemText) {
        assertTrue(GeneralStepDefinition.startPage.containsTodoItem(itemText));
    }

}
