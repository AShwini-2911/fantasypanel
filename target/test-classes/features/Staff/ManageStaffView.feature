@StaffModule
Feature: Manage Staff Module Operations in Staff Module

  Background: 
    And I navigate to the Staff Module
    And I select the Manage Staff Module

  @View @ViewStaff
  Scenario: View Staff Details
    When User click on View Staff button
    Then User should able to see the Staff details

  @Update @UpdateStaff
  Scenario: Update Staff Details
    Given User click on Update Staff button
    When User update staff first and last name
    And User Click on submit button
    Then User should able to print "Data Updated Successfully" message
    When User click on Filter button
    And User search for updated user name
    Then User should able to see user name in filtered data

  @Update @UpdateStaff
  Scenario: Cancel Updated Staff Details
    Given User click on Update Staff button
    When User update staff first and last name
    And User click on Cancel button
    Then User should able to see staff listing page "Staff Listing"
    And User search for invalid updated user name
    Then User should not get filtered data

  @ChangePassword @ChangePasswordStaff
  Scenario: Successfully change password with matching new and confirm passwords
    Given User click on change password button
    When User Enter valid new passwod "Admin@2017"
    And User Enter valid Confirm password "Admin@2017"
    Then User click on Update button
    And User should able to see updated reset password "Password updated successfully" message

  @ChangePassword @ChangePasswordStaff
  Scenario: New password and confirm password do not match
    Given User click on change password button
    When User Enter valid new passwod "Admin@2017"
    And User Enter valid Confirm password "Admin@2011"
    Then User click on Update button
    And User should able to mismatch password "Both password and confirm password should be matched!" message

  @ChangePassword @ChangePasswordStaff
  Scenario: Change password with a weak new password
    Given User click on change password button
    When User Enter valid new passwod "Admin"
    And User Enter valid Confirm password "Admin"
    Then User click on Update button
    And User should able to see weak password "The new password must be at least 8 characters.,The confirm password must be at least 8 characters." message

  @ChangePassword @ChangePasswordStaff
  Scenario: Change password with empty new password field
    Given User click on change password button
    When User Enter valid new passwod "Admin@2017"
    And User Enter valid Confirm password ""
    Then User click on Update button
    And The Confirm Password field border color should be RED

  @ChangePassword @ChangePasswordStaff
  Scenario: Cancel password change
    Given User click on change password button
    When User Enter valid new passwod "Admin@2017"
    And User Enter valid Confirm password "Admin@2017"
    Then User click on back button
    Then User should able to see staff listing page "Staff Listing"

  @Add @AddStaff
  Scenario: Add staff user with valid details
    Given User navigates to the Add Staff User page
    When User selects a role as "Data"
    And User enters "Jamess" in the First Name field
    And User enters "Paul" in the Last Name field
    And User enters "james@paul.com" in the Email ID field
    And User enters "8585852323" in the Phone field
    And User enters "Password@122365" in the Password field
    And User clicks on the Submit button
    Then User should able to see "Data Added Successfully" message

  @Add @AddStaff
  Scenario: Validate mandatory fields
    Given User navigates to the Add Staff User page
    When User clicks on the Submit button without filling any fields
    Then The First Name field border color should be RED

  @Add @AddStaff
  Scenario: Validate invalid email format
    Given User navigates to the Add Staff User page
    When User selects a role as "Data"
    And User enters "Jast" in the First Name field
    And User enters "De" in the Last Name field
    When User enters "invalidemail.com" in the Email ID field
    And User enters "8527419630" in the Phone field
    And User enters "Password@12" in the Password field
    And User clicks on the Submit button
    Then The Email field border color should be RED

  @Add @AddStaff
  Scenario: Validate password masking and toggle
    Given User navigates to the Add Staff User page
    When User selects a role as "Data"
    And User enters "Jast" in the First Name field
    And User enters "De" in the Last Name field
    And User enters "jast@de.com" in the Email ID field
    And User enters "8527419630" in the Phone field
    When User enters "Password@123" in the Password field
    Then The Password field should mask the input
    When User clicks on the toggle visibility icon
    Then The Password field should display the input

  @Add @AddStaff
  Scenario: Test cancel button functionality
    Given User navigates to the Add Staff User page
    When User fills in the form with valid details
    And User clicks on the Cancel button
    Then User should able to see staff listing page "Staff Listing"

  @Add @AddStaff
  Scenario: Validate duplicate phone entry
    Given User navigates to the Add Staff User page
    When User enters an existing phone "7538964120" in the phone number field
    And User fills other valid details
    And User clicks on the Submit button
    Then An error message should be displayed indicating "Mobile number already exist."

  @Add @AddStaff
  Scenario: Validate unselected role
    Given User navigates to the Add Staff User page
    When User fills other valid details without selecting Role
    And User clicks on the Submit button
    Then An error message should be displayed "The role field is required." on the Role field

  @Add @AddStaff
  Scenario: Validate special characters in name fields
    Given User navigates to the Add Staff User page
    When the user enter "Abhi@123" in the "First Name" field
    Then the actual value displayed in the "First Name" field should be "Abhi"
    And the expected value should match the actual value

  @Add @AddStaff
  Scenario: Test back button functionality
    Given User navigates to the Add Staff User page
    When User clicks on the Back button
    Then User should able to see staff listing page "Staff Listing"
    
    
@Filter @FilterStaff
 Scenario: Test Filter functionality
   	When User click on Filter button
    And User search for updated user name
    Then User should able to see user name in filtered data
    
    
    
    
    #Scenario: Validate phone number with invalid format
    #Given User navigates to the Add Staff User page
    #When User enters "12345ABCD" in the Phone field
    #And User clicks on the Submit button
    #Then An error message should be displayed for the Phone field
    #
    #
   #Scenario: Validate the regex for the password field
    #Given User navigates to the Add Staff User page
    #When the user checks the regex for the Password field
    #Then the regex for the Password field should be "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$"
 #
