@DFSModule
Feature: Contests Module Operations in DFS Module

  Background: 
    And I navigate to the DFS Module
    And I select the Contest Module

  Scenario: Add Contest Details
    Given User click on Add Contest button
    Then User fill all the Contest details
    And User click on Contest Submit

  Scenario: View Contest Details
    Given User click on View Contests button
    Then User should able to see the Contests details

  Scenario: Update Contests Details
    Given User click on Update Contests button
    Then User update title of the Contests
    And User click on update Contests button

  Scenario: Filter Contests Details
    Given User Click on Filter Contests button
    Then User enter title in Title Contests field
    And User should able to filtered Contests data
