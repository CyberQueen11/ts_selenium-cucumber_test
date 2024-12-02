package se.yrgo.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import se.yrgo.selenium.utils.CustomConditions;

public class DoneItemsStepDefinitions {

    @Given("that the list contains the following {string} <items>")
    public void that_the_list_contains_the_following_items(String status, List<String> items) {
        final WebDriver driver = GeneralStepDefinitions.driver;

        boolean done = false;
        if ("done".equals(status)) {
            done = true;
        }

        List<String> objects = new ArrayList<>();
        for (String item : items) {
            objects.add(String.format("{\"name\":\"%s\",\"done\":%b}", item, done));
        }

        String data = "[" + String.join(",", objects) + "]";
        ((JavascriptExecutor) driver)
                .executeScript("localStorage.setItem('todolist', '" + data + "')");
        driver.navigate().refresh();

    }

    @When("the user navigates to the done page")
    public void the_user_navigates_to_the_done_page() {
        final WebDriverWait wait = new WebDriverWait(GeneralStepDefinitions.driver,
                Duration.ofSeconds(10));

        final By done = By.linkText("Done");
        WebElement doneElem = wait.until(ExpectedConditions.presenceOfElementLocated(done));
        wait.until(CustomConditions.elementHasBeenClicked(doneElem));
    }

    @Then("the <items> are visible.")
    public void the_items_are_visible(List<String> items) {
        final WebDriverWait wait = new WebDriverWait(GeneralStepDefinitions.driver,
                Duration.ofSeconds(10));
        // make sure the done list has loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("todolist__done")));

        final By todoList = By.cssSelector(".todolist");
        final By todoItem = By.cssSelector("li span");
        List<WebElement> itemElems = wait
                .until(ExpectedConditions.presenceOfNestedElementsLocatedBy(todoList,
                        todoItem));

        int found = 0;
        for (String itemText : items) {
            for (WebElement elem : itemElems) {
                if (elem.getText().equals(itemText)) {
                    found++;
                    break;
                }
            }
        }
        assertEquals(items.size(), found, "Not all items were found");
    }
}
