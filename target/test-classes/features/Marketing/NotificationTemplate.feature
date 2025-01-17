Feature: Notification Template Module Operations in Marketing Module

  Background: 
    And I navigate to the Marketing Module
    And I select the Notification Template Module

  Scenario: Add Notification Template Details
    Given User click on Add Notification Template button
    Then User fill all the Notification Template details
    And User click on Notification Template Submit

  Scenario: View Notification Template Details
    Given User click on View Notification Template button
    Then User should able to see the Notification Template details

  Scenario: Update Notification Template Details
    Given User click on Update Notification Template button
    Then User update title of the Notification Template
    And User click on update Notification Template button

  Scenario: Filter Notification Template Details
    Given User Click on Filter Notification Template button
    Then User enter title in Title Notification Template field
   