@FAQ
Feature: FAQ Module Operations

  Background: 
    Given User navigate to the FAQ Module

  @Add @AddFAQ
  Scenario: Enter valid details of FAQ
    Given User is on the Add FAQ
    When User select the sequence of FAQ
    And User clicks English lang FAQ
    Then User fill the Question and answer in FAQ in English
    And User clicks Hindi lang FAQ
    Then User fill the Question and answer in FAQ in Hindi
    And User click on Submit FAQ button
    Then User should see a success message "Data Added Successfully" in FAQ

  @Add @AddFAQ
  Scenario: Submit FAQ without filling data
    Given User is on the Add FAQ
    When User clicks the Add FAQ Submit button without filling data
    Then add FAQ sequence field border color should be RED

  @Add @AddFAQ
  Scenario: Cancel the FAQ changes
    Given User is on the Add FAQ
    When User clicks the Add FAQ Cancel  button
    Then User should be FAQ listing page

  @Add @AddFAQ
  Scenario: Duplicate data error msg
    Given User is on the Add FAQ
    When User select the sequence of FAQ
    And User clicks English lang FAQ
    Then User fill the Question and answer in FAQ in English
    And User clicks Hindi lang FAQ
    Then User fill the Question and answer in FAQ in Hindi
    And User click on Submit FAQ button
    Then User should see a Error message "Title already exist." in FAQ

  @View @ViewFAQ
  Scenario: View FAQ Details
    When User click on View FAQ button
    Then User should able to see the FAQ details

  @Update @UpdateFAQ
  Scenario: Edit FAQ with a valid image
    Given User is on the Edit FAQ form page
    When User update FAQ sequence
    And clicks on the FAQ update button
    Then FAQ update success message "Data Updated Successfully" should be displayed

  @Filter @FilterFAQ
  Scenario: Filter FAQ Question name and which has In-active status
    Given User click on FAQ Filter button
    When User enter Question on Filter Question FAQ
    And User select FAQ Filter Status In-active
    Then User should able to see filtered listing of FAQ
