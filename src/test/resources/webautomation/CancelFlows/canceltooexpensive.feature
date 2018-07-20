@US67593 @acceptance


Feature: User cancels subscription because it's too expensive
  Scenario: User clicks the Too Expensive reason

    Given I am on the cancel subscription reasons page
    When I click the "Too Expensive" icon
    Then The page displays "Tell us more...we're listening"

