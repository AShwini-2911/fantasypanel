
@DFSModule

Feature: League Module Operations in DFS Module

  Background: 
    And I navigate to the DFS Module
    And I select the League Module

  Scenario: View League Details
    Given User click on View League button
    Then User should able to see the League details

  Scenario: Update League Details
    Given User click on Update League button
    Then User update title of the League
    And User click on update League button

  Scenario: Filter League Details
    Given User Click on Filter League button
    Then User enter title in Title League field
    And User should able to filtered League data
