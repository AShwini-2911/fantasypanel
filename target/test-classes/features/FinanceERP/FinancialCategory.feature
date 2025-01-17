Feature: Financial Category Module Operations in Finance ERP Module

  Background: 
    And I navigate to the Finance ERP Module
    And I select the Financial Category Module

  Scenario: Add Financial Category Details
    Given User click on Add Financial Category button
    Then User fill all the Financial Category details
    And User click on Financial Category Submit

  Scenario: View Financial Category Details
    Given User click on View Financial Category button
    Then User should able to see the Financial Category details
#
  #Scenario: Update Financial Category Details
    #Given User click on Update Financial Category button
    #Then User update title of the Financial Category
    #And User click on update Financial Category button

  Scenario: Filter Financial Category Details
    Given User Click on Filter Financial Category button
    Then User enter title in Title Financial Category field
    And User should able to filtered Financial Category data
