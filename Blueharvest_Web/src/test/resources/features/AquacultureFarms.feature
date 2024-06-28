
Feature: Aquaculture Farms
  As an admin
  I want to manage aquaculture farms
  So that users can view and purchase them

  Background:
    Given I am on the sign in page
    When I input valid email
    And I input valid password
    And I click sign in button
    And I redirected to dashboard page
    And I go to the farms page
    Then I am redirected to the farms page

  Scenario: Add new farms with valid inputs
    Given I am on the farms page
    When I click add farm button
    And I input valid farm title
    And I input valid farm starting price
    And I input valid farm count investment
    And I input valid image for the farm
    And I input valid farm description
    And I click save button farm
    Then I am redirected to the farms page

  Scenario: Add new farms with input is empty
    Given I am on the farms page
    When I click add farm button
    And I click save button farm
    Then I am redirected to the farms page

  Scenario: Cancel adding farms with valid inputs
    Given I am on the farms page
    When I click add farm button
    And I input valid farm title
    And I input valid farm description
    And I click cancel button farm
    Then I am redirected to the farms page

  Scenario: Edit existing farm with valid inputs
    Given I am on the farms page
    When I select a farm to edit
    And I click on edit button farm
    And I update the farm description
    And I click save button edit farm
    Then I am redirected to the farms page

  Scenario: Cancel editing a farm
    Given I am on the farms page
    When I select a farm to edit
    And I click on edit button farm
    And I change my mind and click cancel button farm
    Then I am redirected to the farms page

  Scenario: Delete existing farm
    Given I am on the farms page
    When I select a farm to delete
    And I click on delete button farm
    And I confirm the farm deletion
    Then the farm is deleted
    And I am redirected to the farms page

  Scenario: View details of a farm
    Given I am on the farms page
    When I select a farm to view
    And I click on view details farm button
    Then I am redirected to the farm details page