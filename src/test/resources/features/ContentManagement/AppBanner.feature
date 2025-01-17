@ContentManagementModule
Feature: App Banner Module Operations in Content Management Module

  Background: 
    And I navigate to the Content Management Module
    And I select the App Banner Module

  Scenario: Add App Banner Details
    Given User click on Add App Banner button
    Then User fill all the App Banner details
    And User click on App Banner Submit

  Scenario: View App Banner Details
    Given User click on View App Banner button
    Then User should able to see the App Banner details

  Scenario: Update App Banner Details
    Given User click on Update App Banner button
    Then User update title of the App Banner
    And User click on update App Banner button

  Scenario: Filter App Banner Details
    Given User Click on Filter App Banner button
    Then User enter title in Title App Banner field
    And User should able to filtered App Banner data
