Feature: Marking items as done
    Can the system keep track of done status

Scenario: Viewing done items
    Given the user is on the start page.
    And that the list contains the following "done" <items>
        | Item 1 |
        | Item 2 |
        | Item 3 |
    When the user navigates to the done page
    Then the <items> are visible.
        | Item 1 |
        | Item 2 |
        | Item 3 |