Feature: Dashboard Functionality
  As a user
  I want to interact with various features on the dashboard
  So that I can view and manage different details and pages

  Background:
    Given I am on the sign in page
    When I input valid email
    And I input valid password
    And I click sign in button
    And I redirected to dashboard page

  Scenario: Navigate to Income Details Page
    Given I am on the Dashboard page
    When I click on Income Details button
    Then I should be redirected to the Income Details page

  Scenario: Navigate to Product Total Details Page
    Given I am on the Dashboard page
    When I click on Product Total Details button
    Then I should be redirected to the Product Total Details page

  Scenario: Navigate to Farm Total Details Page
    Given I am on the Dashboard page
    When I click on Farm Total Details button
    Then I should be redirected to the Farm Total Details page

  Scenario: Navigate to Latest Article Details Page
    Given I am on the Dashboard page
    When I click on Latest Article Details button
    Then I should be redirected to the Latest Article Details page

  Scenario: Navigate to Latest Product Details Page
    Given I am on the Dashboard page
    When I click on Latest Product Details button
    Then I should be redirected to the Latest Product Details page

  Scenario: Validate Blueharvest Icon on Dashboard
    Given I am on the Dashboard page
    Then I should see the Blueharvest icon on the Dashboard page

  # Negative Scenarios
  Scenario: Invalid Income Details Button Click
    Given I am on the Dashboard page
    When I click on a non-existent Income Details button
    Then I should see an error message "Expected enabled element was not enabled"

  Scenario: Invalid Product Total Details Button Click
    Given I am on the Dashboard page
    When I click on a non-existent Income Details button
    Then I should see an error message "Expected enabled element was not enabled"

  Scenario: Invalid Farm Total Details Button Click
    Given I am on the Dashboard page
    When I click on a non-existent Income Details button
    Then I should see an error message "Expected enabled element was not enabled"

  Scenario: Invalid Latest Article Details Button Click
    Given I am on the Dashboard page
    When I click on a non-existent Income Details button
    Then I should see an error message "Expected enabled element was not enabled"

  Scenario: Invalid Latest Product Details Button Click
    Given I am on the Dashboard page
    When I click on a non-existent Income Details button
    Then I should see an error message "Expected enabled element was not enabled"

  Scenario: Invalid Dashboard Access
    Given I am on the sign in page
    When I input valid email
    And I input invalid password
    And I click sign in button
    Then I should see an error message "Invalid credentials"
