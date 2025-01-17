@MasterModule @P6

Feature: Grade Level Module Operations in Master Module

  Background: 
    And I navigate to the Master Module
    And I select the Grade Level Module

  @View @ViewGradeLevel
  Scenario: View Grade Level Details
    Given User click on View Grade Level button
    Then User should able to see the Grade Level details

  @Update @UpdateGradeLevel
  Scenario: Update Grade Level Details
    Given User click on Update Grade Level button
    Then User update title of the Grade Level
    And User click on update Grade Level button
    Then an Grade Level updated successfully "Data Updated Successfully" should display
    