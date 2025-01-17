@ContentManagementModule
Feature: CMS Page Module Operations in Content Management Module

  Background: 
    And I navigate to the Content Management Module
    And I select the CMS Page Module

  Scenario: View CMS Page Details
    Given User click on View CMS Page button
    When User should able to see the CMS Page details
    And User should able to see the CMS Page English details
    Then User should able to see the CMS Page Hindi details
    

  Scenario: Update CMS Page Details
    Given User click on Update CMS Page button
    Then User update title of the CMS Page
    And User click on update CMS Page button

  #Scenario: Filter CMS Page Details
    #Given User Click on Filter CMS Page button
    #Then User enter title in Title CMS Page field
    #And User should able to filtered CMS Page data
