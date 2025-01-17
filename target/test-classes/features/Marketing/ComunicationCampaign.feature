Feature: Communication campaign Module Operations in Marketing Module

  Background: 
    And I navigate to the Marketing Module
    And I select the Communication campaign Module

  Scenario: All devices Details Notification
    Given user click on All device
    When user select Noification template
    And user click on Send All Devices for Notification Template
    

  Scenario: Login Activity details
  Given user click on Login Activity
  When user selct android Device
  And user get the total num of devices 
  
  Scenario: SignUp Activity
  Given user click on Sign Up activity
  Then user click on android 
  
 #@Smoke 
  Scenario: By Contest Participation actions
  Given user click on By Contest Participation
  When user select League
  And user select Teams
  
  
  
