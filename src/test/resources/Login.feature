Feature: Task 1

  Scenario Outline: Login with wrong values
    Given I Open Basler Kantonalbank main page
    When I press login page
    And I enter username "<user>"
    And I enter password "<pass>"
    When I click on login button
    Then I receive an error which contains "<text>"
    Examples:
      | user | pass | text                                                     |
      | toy  | baby | Ihre eingegebene Identifikationsnummer und/oder Passwort |