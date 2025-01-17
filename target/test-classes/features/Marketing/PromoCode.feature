Feature: Promo code Module Operations in Marketing Module

  Background: 
    And I navigate to the Marketing Module
    And I select the Promo code Module

  Scenario: Add Promo code Details
    Given User click on Add Promo code button
    Then User fill all the Promo code details
    And User click on Promo code Submit

  Scenario: View Promo code Details
    Given User click on View Promo code button
    Then User should able to see the Promo code details

  Scenario: Update Promo code Details
    Given User click on Update Promo code button
    Then User update title of the Promo code
    And User click on update Promo code button

  Scenario: Filter Promo code Details
    Given User Click on Filter Promo code button
    Then User enter title in Title Promo code field
