Feature: Monitoring farms
  As a admin
  I want to monitor farms
  So that I can get up to date about farms condition

  Background:
    Given I am on the sign in page
    When I input valid email
    And I input valid password
    And I click sign in button
    And I redirected to dashboard page
    And I go to the farms page
    And I am redirected to the farms page
    And I select a farm to edit
    Then I click on edit button farm


  Scenario: View an update farm condition
    When I redirected to edit farm page
    Then I see update farms condition

  Scenario: Edit farm condition with valid inputs
    When I redirected to edit farm page
    And I click edit condition farm
    And I input valid temperature
    And I input valid PH
    And I input valid water oxygen
    And I click save update button
    Then I see update farms condition

  Scenario: Edit farm condition with invalid inputs
    When I redirected to edit farm page
    And I click edit condition farm
    And I input invalid temperature
    And I input invalid PH
    And I input invalid water oxygen
    And I click save update button
    Then I see error message "Invalid inputs."

  Scenario: Edit farm condition with empty inputs
    When I redirected to edit farm page
    And I click edit condition farm
    And I clear temperature
    And I clear PH
    And I clear water oxygen
    And I click save update button
    Then I see error message "All fields are required"

  Scenario: Cancel update farms condition
    When I redirected to edit farm page
    And I click edit condition farm
    And I click cancel update condition farm
    Then I redirected to edit farm page







