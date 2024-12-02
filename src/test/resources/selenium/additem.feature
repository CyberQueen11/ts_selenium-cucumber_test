Feature: Adding TODO items.
    Can we add TODO items?

Scenario: Adding a TODO item
    Given the user is on the start page.
    When the user adds a todo with text "Todo Item 1"
    Then the todo item list should contain "Todo Item 1"