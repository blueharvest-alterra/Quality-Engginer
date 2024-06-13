Feature: GET All Addresses
  As a user
  I want to retrieve all my addresses
  So that I can view and manage my saved addresses

  Scenario: I retrieve all addresses successfully
    Given I want to retrieve all addresses
    When I send a GET request to retrieve all addresses
    Then I receive status code 200
    And I should receive valid address data

  Scenario: I fail to retrieve all addresses due to an invalid endpoint
    Given I want to retrieve all addresses with an invalid endpoint
    When I send a GET request to an invalid endpoint
    Then I receive status code 404
    And I should receive status code 404 for invalid endpoint

  Scenario: I fail to retrieve all addresses due to unauthorized access
    Given I want to retrieve all addresses
    When I send a GET request to retrieve all addresses without proper authorization
    Then I receive status code 403
    And I receive an error message about unauthorized access
