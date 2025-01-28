Feature: Global Leaderboard module operations in Leaderboard  module

  Background: 
    Given User navigate to the Leaderboard Module
    Given User navigate to the Global Leaderboard Module

  @AddPayoutLeaderboard
  Scenario: Add payout leaderboard with valid data
    Given user click on add payout leaderboard
    When user user select leaderboard type of payout leaderboard
    And user select start date of payout leaderderboard
    And user select end date of payout leaderboard
    And user enter max rank in payout data
    And user enter distribution amount in payout data
    And user click on total amount in payout data
    And user click on add button in payout data
    And user click on delete button in payout data
    And user click on submit button of add payout leaderboard
    Then user should able to see payout leaderboard success message "Data Added Successfully"
    
    @AddPayoutLeaderboard
  Scenario: Add payout leaderboard with duplicate data
    Given user click on add payout leaderboard
    When user user select leaderboard type of payout leaderboard
    And user select start date of payout leaderderboard
    And user select end date of payout leaderboard
    And user enter max rank in payout data
    And user enter distribution amount in payout data
    And user click on total amount in payout data
    And user click on add button in payout data
    And user click on delete button in payout data
    And user click on submit button of add payout leaderboard
    Then user should able to see payout leaderboard duplicate message "leaderboard already exist."
    
    @View @ViewLeaderboard
    Scenario: view payout leaderboard
    Given user click on view payout leaderboard
    Then user should able to see details of view leaderboard
    When user click on Winners
    Then user should able to see winners details
    
    @Update @UpdateLeaderboard
    Scenario: update global leaderboard rank
    Given user click on update global leaderboard
    When user update the rank of global leaderboard
    And user click on update global leaderboard button 
    Then user should able to see update global leaderboard message "Data Updated Successfully"
    
    @Filter @FilterLeaderboard
    Scenario: Filter global leaderboard data
    Given user click on filter global leaderboard
    When user select filter leaderboard type
    Then user should able to filtered data of global leaderboard


    
    
    
   
