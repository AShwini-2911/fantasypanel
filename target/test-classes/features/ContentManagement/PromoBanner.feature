@ContentManagementModule
Feature: Promo Banner Module Operations in Content Management Module

  Background: 
    And I navigate to the Content Management Module
    And I select the Promo Banner Module

  Scenario: Add Promo Banner Details
    Given User click on Add Promo Banner button
    Then User fill all the Promo Banner details
    And User click on Promo Banner Submit

  Scenario: View Promo Banner Details
    Given User click on View Promo Banner button
    Then User should able to see the Promo Banner details

  Scenario: Update Promo Banner Details
    Given User click on Update Promo Banner button
    Then User update title of the Promo Banner
    And User click on update Promo Banner button

  Scenario: Filter Promo Banner Details
    Given User Click on Filter Promo Banner button
    Then User enter title in Title Promo Banner field
    And User should able to filtered Promo Banner data
