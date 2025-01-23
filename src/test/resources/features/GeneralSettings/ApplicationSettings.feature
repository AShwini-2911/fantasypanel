#change inputs in ApplicationSettingsPage

Feature: Application Settingsmodule operations in General Settings module

  Background: 
    And User navigate to the General Settings Module
    And User select the Application SettingsModule

  @Feeds
  Scenario: Feeds details operation
    When User updated text1 in feeds
    And User click on Feeds Submit button
    Then User should able to see Feeds update message "Data Saved Successfully"

  @Runs
  Scenario: Runs details operation
    When User updated Active spin in runs
    And User click on Runs Submit button
    Then User should able to see Runs update message "Data Saved Successfully"

  @PlayMoreMultiplier
  Scenario: Play More Multiplier details operation
    When User updated Direct Deposit Multiplier in Play More Multiplier
    And User click on Play More Multiplier Submit button
    Then User should able to see Play More Multiplier update message "Data Saved Successfully"

  @Referrals
  Scenario: Referrals details operation
    When User updated Referred By in Referrals
    And User click on add Refer and Earn Additional Bonus button
    Then User Entered Referral Count and Bonus Amount
    And User click on Delete Refer and Earn Additional Bonus button
    And User click on Referrals Submit button
    Then User should able to see Referrals update message "Data Saved Successfully"
    
    @Referrals
  Scenario: Referrals duplicate operation
    When User updated Referred By in Referrals
    And User click on add Refer and Earn Additional Bonus button
    Then User Entered Referral Count 
    And User click on Referrals Submit button
    Then User should able to see unique Referrals update message "Please fill unique referral friend count"

  @SignUp
  Scenario: SignUp details operation
    When User updated SignUp Bonus in SignUp
    And User click on SignUp Submit button
    Then User should able to see SignUp update message "Data Saved Successfully"
