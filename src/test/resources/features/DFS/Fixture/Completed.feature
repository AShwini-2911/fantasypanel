@DFSModule
Feature: Fixture Module Operations in DFS Module

  Background: 
    And I navigate to the DFS Module
    And user navigate to Fixture Module
    Then User navigate to Completed module
    
    @Filter @FilterCompletedMatch
    Scenario: Filter Completed match details
    Given User Click on Filter Completed match button
    When User Select League of Completed match
    And User Select League match 
    Then User should able to get filtered completed match data
    
    @Statistics
    Scenario: Statistics validation
    Given user click on Statistics Completed match button
    When user click on Filter Statistics button
    And user select innings of Statistics
    Then user should able to get filtered Statistics data 