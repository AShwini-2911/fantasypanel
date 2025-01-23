@StaffModule
Feature: Manage Roles Module Operations in Staff Module

  Background: 
    And I navigate to the Staff Module
    And I select the Manage Roles Module

  @Add @AddRoles
    Scenario: Add Role with valid details
    Given User navigates to the Add Role page
    When User add Role name in Staff 
    And User add Role description in Staff 
    Then User Select the Role permission toggles
    And User click on Add Role submit button
    Then User should able to see Role added message "Data Added Successfully"
    
    @Add @AddRoles
    Scenario: Duplicate Staff Role validation message
    Given User navigates to the Add Role page
    When User add Role name in Staff 
    And User add Role description in Staff 
    Then User Select the Role permission toggles
    And User click on Add Role submit button
    Then User should able to see duplicate Role added message "Name already exist."
    
    @Add @AddRoles
  Scenario: Role name and description Error message Validation 
    Given User navigates to the Add Role page
    When User clicks on the Submit button without filling role name and description
    Then Add Role error message should display "Please enter a role name and description."
    
    
     @Add @AddRoles
  Scenario: Role permission Error message Validation 
    Given User navigates to the Add Role page
    When User add Role name in Staff 
    And User add Role description in Staff 
    And User clicks on the Submit button without selecting permission toogle
    Then Add Role permission error message should display "Please select at least one permission."
    
     @Update @UpdateRole
  Scenario: Role name update 
    Given User navigates to the Update Role page
    When User update the role name
    And User click on Add Role update button
    Then Update Role message should display "Data Updated Successfully"
    
    @Filter @FilterRole
    Scenario: Filter role operation
    Given User navigates to the Filter role
    When User Selects Admin Role
    Then User should get filtered Admin role data
    
   
   