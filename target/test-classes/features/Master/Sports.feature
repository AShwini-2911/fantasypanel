@MasterModule @P5
Feature: Sports Module Operations in Master Module

  Background: 
    And I navigate to the Master Module
    And I select the Sports Module

  @View @ViewSport
  Scenario: View Sports Details
    When I click on a Sports titled "Cricket"
    Then I should see the details of the sports

  @Update @UpdateSport
  Scenario: Update Sports Details
    Given User click on Update Sports button
    Then User update title of the sports
    And User click on update Sports button
    Then User Should able to see sports updated "Data Updated Successfully" message

  @Filter @FilterSport
  Scenario: Filter Sports Details
    Given User Click on Filter Sports button
    Then User enter title in Title Sports field
    And User should able to filtered Sports data

  @Publish
  Scenario: Publish sport
    Given User click on publish sport button
