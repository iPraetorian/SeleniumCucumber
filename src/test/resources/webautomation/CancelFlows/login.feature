@loginTest @smoke

Feature: User log in

  Scenario: As a user I should be able to log in to application

    Given I am on the login page
    When I enter default credentials
    Then I am sent to the /start page
