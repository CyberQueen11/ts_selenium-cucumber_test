package se.yrgo.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewYearStepDefinition {

    private DateHandler theDate;
    private boolean result;

    @Given("today is {int}\\/{int}")
    public void today_is(Integer dayOfMonth, Integer month) {
        theDate = new DateHandler(month, dayOfMonth);
    }

    @When("I ask whether it is new year yet")
    public void i_ask_whether_it_is_new_year_yet() {
        result = theDate.isNewYear();
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String answer) {
        if ("yes".equals(answer)) {
            assertTrue(result);
        } else if ("no".equals(answer)) {
            assertFalse(result);
        } else {
            fail(answer + " is not a valid answer");
        }
    }

}
