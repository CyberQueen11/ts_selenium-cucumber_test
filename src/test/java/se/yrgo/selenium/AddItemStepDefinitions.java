package se.yrgo.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import se.yrgo.selenium.pages.StartPage;
import se.yrgo.selenium.utils.CustomConditions;

public class AddItemStepDefinitions {
    private StartPage startPage;
    private WebDriver driver;

    public AddItemStepDefinitions() {
        driver = new ChromeDriver();
        startPage = new StartPage(driver);
    }

    @After
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("the user is on the start page.")
    public void the_user_is_on_the_start_page() {
        startPage.open();
    }

    @When("the user adds a todo with text {string}")
    public void the_user_adds_a_todo_with_text(String input) {
        startPage.addTodoItem(input);
    }

    @Then("the todo item list should contain {string}")
    public void the_todo_item_list_should_contain(String itemText) {
        assertTrue(startPage.containsTodoItem(itemText));
    }

}
