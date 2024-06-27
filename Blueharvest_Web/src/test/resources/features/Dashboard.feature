@Ignore

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

  Scenario: Search for a Product
    Given I am on the Dashboard page
    When I search for product
    Then I should see the product displayed in the search results

  Scenario: Saw the earnings summary on June 1st
    Given I am on the Dashboard page
    Then I see income summary on dashboard page

  Scenario: Navigate to Chat Page
    Given I am on the Dashboard page
    When I click on Chat button
    Then I should be redirected to the Chat page

  Scenario: Navigate to Notification Page
    Given I am on the Dashboard page
    When I click on Notification button
    Then I should be redirected to the Notification page

  Scenario: Navigate to Profile Page
    Given I am on the Dashboard page
    When I click on Profile button
    Then I should be redirected to the Profile page

  Scenario: Invalid Dashboard Access
    Given I am on the sign in page
    When I input valid email
    And I input invalid password
    And I click sign in button
    Then I should see an error message "Invalid credentials"
