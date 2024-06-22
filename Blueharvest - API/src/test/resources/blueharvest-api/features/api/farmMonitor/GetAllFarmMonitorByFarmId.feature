Feature: Get All Farm Monitor By FarmId
  As a user
  I want to retrieve all farm monitors by FarmId
  So that I can view specific farm monitor information

  Scenario: User retrieves all farm monitors by valid FarmId
    Given I set farm monitor API endpoint for get all monitors by FarmId
    When I send GET request to get all farm monitors by valid FarmId
    Then I receive status code 200
    And I receive a list of farm monitors with the given FarmId

  Scenario: User fails to retrieve all farm monitors by invalid FarmId
    Given I set farm monitor API endpoint for get all monitors by FarmId
    When I send GET request to get all farm monitors by invalid FarmId
    Then I receive status code 404

  Scenario: User fails to retrieve all farm monitors with missing FarmId
    Given I set farm monitor API endpoint for get all monitors by FarmId
    When I send GET request to get all farm monitors with missing FarmId
    Then I receive status code 404
