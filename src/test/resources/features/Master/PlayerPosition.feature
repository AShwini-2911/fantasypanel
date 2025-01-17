@MasterModule @P3

Feature: Player Position Module Operations in Master Module

  Background: 
    And I navigate to the Master Module
    And I select the PlayerPosion Module

 @View @ViewCricket
  Scenario:  View All Rounder(Cricket) Details
    Given I click view btn of all rounder button
    Then I should see the details of all rounder
   
   @Update @UpdateCricket
    Scenario: Update All Rounder(Cricket) Details
    Given I click on update of all rounder
    When user update sport name
    And user click on submit of sport update
    Then user should able to see Cricket details updated message "Data Updated Successfully"
    
    @Update @UpdateCricket
    Scenario: Validation error for invalid player numbers
    Given I click on update of all rounder
    When user update Maximum player "0"
    And user click on submit of sport update
    Then user should see an max player should greater than minimum error message "Min player should not be greater than Max player."

     @Filter @FilterCricket
    Scenario: Filter operation
    Given user click on Filter button
    Then user enter the title "Bowler"
