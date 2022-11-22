Feature: Login and E2E Test
  @wip
  Scenario: Login and End to End Test
    Given The user is on the login page
    When The user is enters "standard_user" and "secret_sauce"
    Then The user should be able to login and see "PRODUCTS" header
    And  The user should be able to sort the products "Price (high to low)"
    And The user clicks cheapest as "7.99" and second costliest as "29.99" products
    And The user opens basket
    And The user clicks checkout
    And The user enters details "John" "Snow" "BB101HR"  and finish the purchase
    Then The user verify that items are "41.02" and able to total is "Total: $41.02"
    And The user clicks finish button
    Then The user able to see conformation message as a "THANK YOU FOR YOUR ORDER"









