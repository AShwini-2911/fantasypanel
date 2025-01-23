@GeneralSettingsModule
Feature: General Settings Module Operations in avatar Module

  Background: 
    And User navigate to the General Settings Module
    And User select the avatar Module

  @Add @AddAvatar
  Scenario: Successfully upload a valid Avatar image
    Given User is on the Add Avatar form page
    When User uploads a valid image file with dimensions 1200x700 pixels
    And User clicks the Add avatar Submit button
    Then User should see a success message "Data Added Successfully"

  @Add @AddAvatar
  Scenario: Submit without uploading an image
    Given User is on the Add Avatar form page
    When User clicks the Add avatar Submit  button without uploading any file
    Then add avatar image field border color should be RED

  @Add @AddAvatar
  Scenario: Cancel the upload process
    Given User is on the Add Avatar form page
    When User clicks the Add avatar Cancel  button
    Then User should be avatar listing page

  #@Add @AddStaff
  #Scenario: Upload an image with invalid dimensions
  #Given User is on the Add Avatar form page
  #When User uploads an image file with dimensions less than 1200x700 pixels
  #And User clicks the Add avatar Submit button
  #Then User should see an error message "The image must not be greater than 1 mb."
  
  @View @ViewAvatar
  Scenario: View Avatar Details
    When User click on View Avatar button
    Then User should able to see the avatar details

  @Update @UpdateAvatar
  Scenario: Edit avatar with a valid image
    Given User is on the Edit Avatar form page
    When User uploads a valid image file with dimensions 1200x700 pixels
    And clicks on the avatar update button
    Then avatar update success message "Data Updated Successfully" should be displayed

  @Update @UpdateAvatar
  Scenario: Verify preview image functionality opens in a new tab
    Given User is on the Edit Avatar form page
    And clicks on the Preview button
    Then the image preview should open in a new browser tab
    Then the preview image URL should be correct
    Then the user should return to the Edit Avatar page

  @Filter @FilterAvatar
  Scenario: Verify that the filter displays only Inactive status
    Given user clicks on the Filter Avatar button
    When user clicks on the filter dropdown button and select Inactive status
    Then user clicks on the View Avatar button
    And the status from the viewed data is verified as Inactive
