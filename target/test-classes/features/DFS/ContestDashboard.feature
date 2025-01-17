@DFSModule
Feature: Contests Module Operations in DFS Module

  Background: 
    And I navigate to the DFS Module
    And I select the Contest Dashboard Module

  @Filter @FilterContest
  Scenario: Filter Contests Details
    Given User Click on Filter Contest Dashboard button
    Then User enter title in Title Contest Dashboard field
    And User should able to filtered Contest Dashboard data

  @PinContest
  Scenario: Unpin a contest (ID 1)
    Given User clicks on UnPin contest which has id 1
    Then User gets a unpinned contest message

  @UnPinContest
  Scenario: Pin a contest (ID 0)
    When User clicks on Pin contest which has id 0
    Then User gets a pinned contest message
