@GeneralSettingsModule
Feature: Settings Module Operations in General settings Module

  Background: 
    Given User navigate to the General Settings Module
    Given User select the settings Module

  Scenario: Update System Email and Contact Number
    Given user is on General info page
    When user updates the system email and contact number
    And user saves the changes
    Then user should see General info success message "Data Saved Successfully"

  Scenario: Update Social media links
    Given user is on Social media links page
    When user updates the facebook , twitter and youtube links
    And user saves the changes
    Then user should see social media success message "Data Saved Successfully"

  Scenario: Update Deposite and withdraw amount
    Given user is on deposite and withdraw page
    When user updates the deposite and withdraw amount
    And user saves the changes
    Then user should see deposite and withdraw amount success message "Data Saved Successfully"

  Scenario: Update App links
    Given user is on App links page
    When user updates the android and iOS links
    And user saves the changes
    Then user should see app link success message "Data Saved Successfully"

  Scenario: Update versions
    Given user is on app version page
    When user updates the android and iOS versions
    And user saves the changes
    Then user should see app version success message "Data Saved Successfully"
