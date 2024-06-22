Feature: Transaction
  As a admin
  I want to view transaction in the e-commerce
  So that I can processing the data

  Background:
    Given I am on the sign in page
    When I input valid email
    And I input valid password
    And I click sign in button
    And I redirected to dashboard page
    Then I go to transaction page

  Scenario: See the list of all transactions
    Then I can see the list of all transactions

  Scenario: See the next page of list transactions
    When I click next button
    Then I see the next page of list transactions