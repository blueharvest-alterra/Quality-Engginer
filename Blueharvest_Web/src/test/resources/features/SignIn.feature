Feature: Sign In
  As a admin
  I want to Sign In
  So that I can manage dashboard

  Scenario: User can sign in with all valid credentials
    Given I am on the sign in page
    When I input valid email
    And I input valid password
    And I click sign in button
    Then I get success sign in message "Berhasil login!"

  Scenario: User cannot sign in with unregistered email
    Given I am on the sign in page
    When I input unregistered email
    And I input valid password
    And I click sign in button
    Then I get error sign in message "Invalid email or password"

  Scenario: User cannot sign in with incorrect password
    Given I am on the sign in page
    When I input valid email
    And I input invalid password
    And I click sign in button
    Then I get error sign in message "Invalid email or password"

  Scenario: User cannot sign in with invalid email form
    Given I am on the sign in page
    When I input invalid email form
    And I input valid password
    And I click sign in button
    Then I get email error message "Sertakan '@' pada alamat email."

  Scenario: User cannot sign in with empty inputs
    Given I am on the sign in page
    And I click sign in button
    Then I get empty error message "Harap isi bidang ini."