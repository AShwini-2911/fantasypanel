Feature: Depositors Leaderboard module operations in Leaderboard  module

  Background: 
    Given User navigate to the Leaderboard Module
    Given User navigate to the Depositors Leaderboard Module

  @FilterDepositorsLeaderboard
  Scenario: Filter Depositors Leaderboard module operation
    Given User click on Filter Depositors Leaderboard
    When User Enter filter name in Depositors Leaderboard
    And User Enter filter Mobile no in Depositors Leaderboard
    Then filtered data should display in Depositors Leaderboard
    And User Enter date range in Depositors Leaderboard
    Then print the filtered data according to the date range in depositors leaderboard

  @NavigateToUserName
  Scenario: Navigate to User and perform operations in personal page
    Given User click on user name in depositors leaderboard
    When User is on Personal page of user name
    And User print Account Verification data in depositors leaderboard
    And User print Basic Details data in depositors leaderboard
    Then User print KYC data in depositors leaderboard

  #@NavigateToUserName
  #Scenario: Verify amount deposited details in dashboard page
    #Given User click on user name in depositors leaderboard
    #When User is on Dashboard page of user name
    #And User view the "Amount Deposited" section
    #And  User should see the rank as "#1"
    #Then the total deposited amount as "11.02K till date"
    #And User click on Recent transaction view all button 
    #And User should redirected to the transaction page
    #Then print the Transaction page data
    #When User click on Dashboard page of user name
    #And User click on Contest Details view all button
    #And User should redirected to the Games Stats page
    #Then print the Games Stats page data
    #
    
    
