@GeneralSettingsModule
Feature: Spin Wheel module operations in General Settings module

  Background: 
    And User navigate to the General Settings Module
    And User select the Spin Wheel Module

  @View @ViewSpinWheel
  Scenario: View Spin Wheel Details
    When User click on View spin wheel button
    Then User should able to see spin wheel details

  @Update @UpdateAvatar
  Scenario: Clear prize in Spin Wheel then border color should be RED
    Given User is on the Edit Spin Wheel form page
    When User clear the prize and click on update button
    Then prize field border color should be RED

  @Update @UpdateAvatar
  Scenario: Edit prize in Spin Wheel
    Given User is on the Edit Spin Wheel form page
    When User updates prize in Spin Wheel
    And clicks on the Spin Wheel update button
