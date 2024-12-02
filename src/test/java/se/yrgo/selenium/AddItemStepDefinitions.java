package se.yrgo.selenium;

import java.time.Duration;

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
import se.yrgo.CustomConditions;

public class AddItemStepDefinitions {
    private WebDriver driver;

    public AddItemStepDefinitions() {
        driver = new ChromeDriver();
    }

    @After
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("the user is on the start page.")
    public void the_user_is_on_the_start_page() {
        driver.get("https://yrgo-amazing-todo-app.netlify.app");
        if (!driver.getTitle().equals("Todo App")) {
            throw new IllegalStateException("not on the start page");
        }
    }

    @When("the user adds a todo with text {string}")
    public void the_user_adds_a_todo_with_text(String input) {
        final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        final By textInput = By.cssSelector("form input[type=\"text\"]");
        final By button = By.cssSelector("form input[value=\"Add todo\"]");
        WebElement textElem = wait.until(ExpectedConditions.presenceOfElementLocated(textInput));
        textElem.sendKeys(input);
        WebElement buttonElem = wait.until(ExpectedConditions.presenceOfElementLocated(button));
        wait.until(CustomConditions.elementHasBeenClicked(buttonElem));
    }

    @Then("the todo item list should contain {string}")
    public void the_todo_item_list_should_contain(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
