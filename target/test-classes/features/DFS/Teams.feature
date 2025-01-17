@DFSModule

Feature: Teams Module Operations in DFS Module

  Background: 
    And I navigate to the DFS Module
    And I select the Teams Module

  Scenario: View Teams Details
    Given User click on View Teams button
    Then User should able to see the Teams details

  Scenario: Update Teams Details
    Given User click on Update Teams button
    Then User update title of the Teams
    And User click on update Teams button

  Scenario: Filter Teams Details
    Given User Click on Filter Teams button
    Then User enter title in Title Teams field
    And User should able to filtered Teams data
