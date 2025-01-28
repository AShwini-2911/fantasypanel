Feature: Financial Transaction Module Operations in Finance ERP Module

  Background: 
    And I navigate to the Finance ERP Module
    And I select the Financial Transaction Module

  @Add @AddFinancialTransaction
  Scenario: Add Financial Transaction Details
    Given User click on Add Financial Transaction button
    When User select finacial category in financial transaction
    And User enter amount in financial transaction
    And User enter date in financial transaction
    And User enter description in financial transaction
    And User click on submit button of financial transaction
    Then user should able to see succes message of financial transaction "Data Added Successfully"

  #@Add @AddFinancialTransaction
  #Scenario: Add Financial Transaction Details with empty amount field
    #Given User click on Add Financial Transaction button
    #When User select finacial category in financial transaction
    #And User enter date in financial transaction
    #And User enter description in financial transaction
    #And User click on submit button of financial transaction
    #Then The amount field border color should be RED

  @View @ViewFinancialTransaction
  Scenario: View Financial Transaction Details
    Given User click on view Financial transaction details
    Then user should able to see viewed Finacial transaction details

  @Filter @FilterFinancialTransaction
  Scenario: Filter Financial Transaction details
    Given User click on filter financial transaction
    When User select financial category type filter
    Then User should able to see filtered data according to the category type Insurance
