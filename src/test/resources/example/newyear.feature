Feature: Is it new year's day yet?
    We need to know if it is new year's day yet.

Scenario: Halloween isn't new year's day.
    Given today is 31/10
    When I ask whether it is new year yet
    Then I should be told no