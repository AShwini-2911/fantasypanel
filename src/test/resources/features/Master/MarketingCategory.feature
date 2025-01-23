@MasterModule
Feature: MarketingCategory Module Operations in Master Module

  Background: 
    And I navigate to the Master Module
    And I select the MarketingCategory Module

  @Add @AddMarketingCategory
  Scenario: Add MarketingCategory Details
    Given I click on Add MarketingCategory button
    Then fill all the details
    And click on Submit button
    Then User should able to see marketing category success message "Data Added Successfully"

  @Add @AddMarketingCategory
  Scenario: Add an empty marketing category
    Given I click on Add MarketingCategory button
    When the user leaves the Name field empty
    And click on Submit button
    Then Marketing Category name border color should be RED

  @Add @AddMarketingCategory
  Scenario: Cancel adding a marketing category
    Given I click on Add MarketingCategory button
    Then fill all the details
    And User clicks on Marketing Category Cancel button
    Then User should able to see category listing page "Marketing Category Listing"

  @Add @AddMarketingCategory
  Scenario: Validation for duplicate category name
    Given I click on Add MarketingCategory button
    When the user enters already an existing Marketing category
    And click on Submit button
    Then an category error message "Category already exist." should be display

  @Add @AddMarketingCategory
  Scenario: Test back button functionality
    Given I click on Add MarketingCategory button
    Then fill all the details
    And User clicks on Marketing Category Back button
    Then User should able to see category listing page "Marketing Category Listing"

  @View @ViewMarketingCategory
  Scenario: View MarketingCategory Details
    When I click on a MarketingCategory titled "Affiliate marketing"
    Then I should see the details of the category

  @Update @UpdateMarketingCategory
  Scenario: Update MarketingCategory Information
    Given I am on the MarketingCategory Details page for "Aut"
    When I update the MarketingCategory name to "Brand Marketing"
    And I click the save button
    Then an category update message "Data Updated Successfully" should be display

  @Filter @FilterMarketingCategory
  Scenario: Filter operation
    Given I click on Filter
    Then Enter name as "Print"
    And Click on Clear search
