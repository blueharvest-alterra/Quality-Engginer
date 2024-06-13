Feature: GET Admin Dashboard
  As an admin
  I want to view the admin dashboard
  So that I can monitor and manage system activities

  @Ignore
  Scenario: I retrieve the admin dashboard successfully
    Given I want to view the admin dashboard
    When I send a GET request to the admin dashboard endpoint
    Then I receive status code 200
    And I should receive valid admin dashboard data

  Scenario: I fail to retrieve the admin dashboard due to an invalid endpoint
    Given I want to view the admin dashboard with an invalid endpoint
    When I send a GET request to an invalid endpoint
    Then I receive status code 404
    And I should receive status code 404 for invalid endpoint

  @Ignore
  Scenario: I fail to retrieve the admin dashboard due to unauthorized access
    Given I want to view the admin dashboard
    When I send a GET request to the admin dashboard without proper authorization
    Then I receive status code 401
    And I receive an error message about unauthorized access
