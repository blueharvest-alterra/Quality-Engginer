
@Ignore

Feature: Article
  As a admin
  I want to manage article
  So that user can view and purchase them

  Background:
    Given I am on the sign in page
    When I input valid email
    And I input valid password
    And I click sign in button
    And I redirected to dashboard page
    And I go to the article page
    Then I redirected to article page

  Scenario: Add new article with valid inputs
    Given I am on the Article page
    When I click add article button
    And I input valid article title
    And I input valid image article
    And I input valid description
    And I click save button article
    Then I redirected to article page

  Scenario: Cancel adding articles with valid inputs
    Given I am on the Article page
    When I click add article button
    And I input valid article title
    And I input valid image article
    And I input valid description
    And I click cancle button
    Then I redirected to article page

  Scenario: Edit existing article with valid inputs
    Given I am on the Article page
    When I select an article to edit
    And I click on edit button
    And I update description
    And I click save button article
    Then I redirected to edit article page

  Scenario: Cancel editing an article
    Given I am on the Article page
    When I select an article to edit
    And I click on edit button
    And I change my mind and click cancel button
    Then I redirected to article page

  Scenario: Delete existing article
    Given I am on the Article page
    When I select an article to delete
    And I click on delete button
    And I confirm the deletion
    Then the article is deleted
    And I redirected to article page

  Scenario: View details of an article
    Given I am on the Article page
    When I select an article to edit
    And I click on view detail article
    Then I am redirected to the article details page

