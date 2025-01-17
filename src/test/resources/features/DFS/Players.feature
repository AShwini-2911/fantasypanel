@DFSModule

Feature: Players Module Operations in DFS Module

  Background: 
    And I navigate to the DFS Module
    And I select the Players Module

  Scenario: View Players Details
    Given User click on View Players button
    Then User should able to see the Players details

  Scenario: Update Players Details
    Given User click on Update Players button
    Then User update name of the Players
    And User click on update Players button

  Scenario: Filter Players Details
    Given User Click on Filter Players button
    Then User enter title in Title Players field
    And User should able to filtered Players data
