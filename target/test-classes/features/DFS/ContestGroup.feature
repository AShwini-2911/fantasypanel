@DFSModule


Feature: Contest Group Group Module Operations in DFS Module

  Background: 
    And I navigate to the DFS Module
    And I select the Contest Group Module

  Scenario: Add Contest Group Details
    Given User click on Add Contest Group button
    Then User fill all the Contest Group details
    And User click on Contest Group Submit

  Scenario: View Contest Group Details
    Given User click on View Contest Group button
    Then User should able to see the Contest Group details

  Scenario: Update Contest Group Details
    Given User click on Update Contest Group button
    Then User update title of the Contest Group
    And User click on update Contest Group button

  Scenario: Filter Contest Group Group Details
    Given User Click on Filter Contest Group button
    Then User enter title in Title Contest Group field
    And User should able to filtered Contest Group data
