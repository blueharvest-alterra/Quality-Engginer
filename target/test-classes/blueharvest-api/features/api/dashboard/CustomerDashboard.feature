Feature: Customer Dashboard
  As a customer
  I want to view my dashboard
  So that I can manage my account and activities

  @Ignore
  Scenario: Customer views their dashboard successfully
    Given I want to view my dashboard as a customer
    When I send a GET request to retrieve my dashboard
    Then I receive status code 200
    And I should receive valid customer dashboard data

  Scenario: Customer fails to view dashboard due to invalid endpoint
    Given I want to view my dashboard as a customer
    When I send a GET request to an invalid dashboard endpoint
    Then I receive status code 404
    And I should receive status code 404 for invalid endpoint


  @Ignore
  Scenario: Customer fails to view dashboard due to unauthorized access
    Given I want to view my dashboard as a customer
    When I send a GET request to retrieve my dashboard without proper authorization
    Then I receive status code 401
    And I receive an error message about unauthorized access
