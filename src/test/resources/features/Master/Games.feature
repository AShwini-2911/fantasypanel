@MasterModule
Feature: Games Module Operations in Master Module

  Background: 
    And I navigate to the Master Module
    And I select the Games Module

  @Add @AddGames
  Scenario: Add Games Details
    Given User click on Add Games button
    Then User fill all the Games details
    And User click on Games Submit
    Then User should able to see games success message "Data Added Successfully"

  @Add @AddGames
  Scenario: Add an empty marketing category
    Given User click on Add Games button
    When the user leaves the games Hindi Name field empty
    And User click on Games Submit
    Then Games name border color should be RED

  @Add @AddGames
  Scenario: Cancel adding game
    Given User click on Add Games button
    When the user leaves the games Hindi Name field empty
    And User click on Add Games Cancel
    Then User should able to see Games listing page "Games Listing"

  @Add @AddGames
  Scenario: Validation for duplicate Game name
    Given User click on Add Games button
    Then User fill all the Games details
    And User click on Games Submit
    Then an Game name error message "Name already exist." should be display

  @Add @AddGames
  Scenario: Validation for larg MB size image uplad
    Given User click on Add Games button
    When User fill details uplaod image larger than one MB
    Then an Game image should less than one MB "The image must not be greater than 1 mb." should display

  @View @ViewGames
  Scenario: View Games Details
    Given User click on View Games button
    Then User should able to see the Games details

  @Update @UpdateGames
  Scenario: Update Games Details
    Given User click on Update Games button
    Then User update image of the Games
    And User click on update Games button
    Then an Game updated successfully "Data Updated Successfully" should display

  @Filter @FilterGames
  Scenario: Filter Games Details
    Given User Click on Filter Games button
    Then User enter title in Title Games field
    And User should able to filtered Games data
