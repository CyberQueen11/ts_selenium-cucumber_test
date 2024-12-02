package se.yrgo.selenium.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import se.yrgo.selenium.utils.CustomConditions;

public class StartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By textInput = By.cssSelector("input[type='text']");
    private By addButton = By.cssSelector("input[type='submit']");
    private By todoList = By.cssSelector(".todolist li");

    public StartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://yrgo-amazing-todo-app.netlify.app");
        if (!driver.getTitle().equals("Todo App")) {
            throw new IllegalStateException("Not on the start page");
        }
    }

    public void addTodoItem(String input) {
        WebElement textElem = wait.until(ExpectedConditions.presenceOfElementLocated(textInput));
        textElem.sendKeys(input);
        WebElement buttonElem = wait.until(ExpectedConditions.presenceOfElementLocated(addButton));
        wait.until(CustomConditions.elementHasBeenClicked(buttonElem));
    }

    public List<WebElement> getTodolist() {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(todoList));
    }

    public boolean containsTodoItem(String itemText) {
        for (WebElement item : getTodolist()) {
            if (item.getText().equals(itemText)) {
                return true;
            }
        }
        return false;
    }

}
