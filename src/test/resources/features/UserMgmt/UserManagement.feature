@UserManagementModule
Feature: User Management Module

  #Background: 
    #And I navigate to the User Management Module
#
  #Scenario: Filter User management Details
    #Given User Click on Filter User management button
    #Then User enter name in User management page
    #And User should able to filter data according to name
#
    #Feature: User Management Module

  #Scenario: Filter users by name
    #Given I navigate to the User Management Module
    #And User clicks on the Filter button
    #Then User enters "Test" in the name filter
    #Then User should see filtered data displayed in the table
    #And User data comparison
    

  Scenario: Filter users and verify the filtered data
    Given I navigate to the User Management Module
    And User clicks on the Filter button
    And User enters "Test" in the name filter
    Then User should see filtered data displayed in the table
    And User data comparison with "Test"
    