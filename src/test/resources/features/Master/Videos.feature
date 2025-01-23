@MasterModule 
Feature: Videos Module Operations in Master Module

  Background: 
    And I navigate to the Master Module
    And I select the Videos Module

  @Add @AddVideo
  Scenario: Add a video with valid data
    Given User click on Add Videos button
    Then User fill all the details
    And User click on Submit
    And a success message "Data Added Successfully" should be displayed

  @Add @AddVideo
  Scenario: Validate mandatory fields
    Given User click on Add Videos button
    When User clicks on the VideoSubmit button without filling any fields
    Then Video title border color should be RED indicating that field is mandatory

  @Add @AddVideo
  Scenario: Cancel adding a marketing category
    Given User click on Add Videos button
    Then User fill all the details
    And User clicks on Add videos Cancel button
    Then User should able to see video listing page "Videos Listing"

  @Add @AddVideo
  Scenario: Test back button functionality
    Given User click on Add Videos button
    Then User fill all the details
    And User clicks on Add videos Back button
    Then User should able to see video listing page "Videos Listing"

  @Add @AddVideo
  Scenario: Prevent SQL injection in URL
    Given User click on Add Videos button
    Then User enters title and Description
    When the user enters "https://example.com/video'; DROP TABLE videos; --" in the "URL" field
    And User click on Submit
    Then an error video URL message "Invalid URL Passed" should be displayed

  @Add @AddVideo
  Scenario: Validate duplicate title entry
    Given User click on Add Videos button
    When User enter "SubscriptionGame" in title
    And User enter URL and Description
    And User click on Submit
    Then An video already exist error message should be displayed indicating "Video already exist."

  @Update @UpdateVideo
  Scenario: Update Videos Details
    Given User click on Update Videos button
    Then User update title of the Video
    And User click on update button

  @View @ViewVideo
  Scenario: View Videos Details
    Given User click on View videos button
    Then User should able to see the details

  @Filter @FilterVideo
  Scenario: Filter Videos Details
    Given User Click on Filter button
    Then User enter title in Title field
    And User should able to filtered data
