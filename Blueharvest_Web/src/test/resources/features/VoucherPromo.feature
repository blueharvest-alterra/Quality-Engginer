Feature: Voucher Promo
  As a admin
  I want to manage voucher promo
  So that user can use the voucher promo

  Background:
    Given I am on the sign in page
    When I input valid email
    And I input valid password
    And I click sign in button
    And I redirected to dashboard page
    Then I go to promo page

  Scenario: View all vouchers
    Then I see the list of vouchers

  Scenario: Add new voucher with valid inputs
    When I click add voucher button
    And I input valid voucher title
    And I input valid code
    And I input valid discount
    And I choose available status
    And I click save promo button
    Then I redirected to promo page

  Scenario: Add new voucher with empty inputs
    When I click add voucher button
    And I click save promo button
    Then I get empty error message "Harap isi bidang ini."

  Scenario: Cancel adding new voucher
    When I click add voucher button
    And I click cancel add promo button
    Then I redirected to promo page

  Scenario: View a voucher
    When I click three dots button of a voucher
    And I click view promo button
    Then I can see the detail of promo

  Scenario: Edit voucher with valid inputs
    When I click three dots button of a voucher
    And I click edit promo button
    And I edit voucher title
    And I edit voucher code
    And I edit discount
    And I click save edit promo button
    Then I redirected to promo page

  Scenario: Edit Voucher with empty inputs
    When I click three dots button of a voucher
    And I click edit promo button
    And I clear voucher title
    And I clear voucher code
    And I clear discount
    And I click save edit promo button
    Then I get empty error message "Harap isi bidang ini."

  Scenario: Cancel editing a voucher
    When I click three dots button of a voucher
    And I click edit promo button
    And I click cancel edit promo button
    Then I redirected to promo page

  Scenario: Delete voucher
    When I click three dots button of a voucher
    And I click delete voucher button
    And I click confirm delete voucher button
    Then I redirected to promo page