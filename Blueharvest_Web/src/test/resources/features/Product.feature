Feature: Product
  As a admin
  I want to manage product
  So that user can view and purchase them

  Background:
    Given I am on the sign in page
    When I input valid email
    And I input valid password
    And I click sign in button
    And I redirected to dashboard page
    Then I go to the product page

  Scenario: See list of products
    Then I see the list of products

  Scenario: Add new product with valid inputs
    When I click add product button
    And I input valid product title
    And I input valid stock
    And I input valid price
    And I input valid description
    And I input valid image
    And I click save button
    Then I redirected to product page

  Scenario: Add new product with empty inputs
    When I click add product button
    And I click save button
    Then I get error add product message "all fields are required"

  Scenario: Add new product with invalid price
    When I click add product button
    And I input valid product title
    And I input valid stock
    And I input invalid price
    And I input valid description
    And I click save button
    Then I get error product price message "invalid price"

  Scenario: Add new product with invalid stock
    When I click add product button
    And I input valid product title
    And I input invalid stock
    And I input valid price
    And I input valid description
    And I click save button
    Then I get error product stock message "invalid stock"

  Scenario: Cancel adding a new product
    When I click add product button
    And I input valid product title
    And I input valid stock
    And I input valid price
    And I input valid description
    And I click cancel add product button
    Then I redirected to product page

  Scenario: View a product
    When I click three dots button of a product
    And I click view product button
    Then I redirected to detail product page

  Scenario: Edit product with valid inputs
    When I click three dots button of a product
    And I click edit product page button
    And I edit product title
    And I edit product price
    And I edit product stock
    And I edit product description
    And I click save edit button
    Then I redirected to product page

  Scenario: Edit product with invalid price
    When I click three dots button of a product
    And I click edit product page button
    And I edit product title
    And I edit product with invalid price
    And I edit product stock
    And I edit product description
    And I click save edit button
    Then I get error edit product price message "invalid price"

  Scenario: Edit product with invalid stock
    When I click three dots button of a product
    And I click edit product page button
    And I edit product title
    And I edit product price
    And I edit product with invalid stock
    And I edit product description
    And I click save edit button
    Then I get error edit product stock message "invalid stock"

  Scenario: Cancel editing a product
    When I click three dots button of a product
    And I click edit product page button
    And I edit product title
    And I click cancel edit button
    Then I redirected to product page

  Scenario: Delete product
    When I click three dots button of a product
    And I click delete product button
    And I click confirm delete button
    Then I redirected to product page





