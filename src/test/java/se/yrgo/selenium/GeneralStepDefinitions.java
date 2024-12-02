package se.yrgo.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import se.yrgo.selenium.pages.StartPage;

public class GeneralStepDefinitions {
    public static WebDriver driver;
    public static StartPage startPage;

    @Before
    public void setupDriver() {
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

}
