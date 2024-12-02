Feature: Adding TODO items.
    Can we add TODO items?
    
Scenario Outline: Adding a TODO item
    Given the user is on the start page.
    When the user adds a todo with text "<item>"
    Then the todo item list should contain "<item>"
    
    Examples:
    | item |
    | Item 1 |
    | Q |
    | Xxxxxxxxxxxxxxxxxxxxxx |

Scenario: Adding multiple TODO items
    Given the user is on the start page.
    When the user adds a todo with text "Todo Item 1"
    And the user adds a todo with text "Todo Item 2"
    Then the todo item list should contain "Todo Item 1"
    And the todo item list should contain "Todo Item 2"

