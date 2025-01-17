#Feature: Login functionality
#
  #Scenario Outline: Login with valid credentials and  Logout
    #Given the user is on the login page
    #When the user enters "<username>" and "<password>"
    #And clicks on the login button
    #Then clicks on Logout button
#
    #Examples: 
      #| username        | password   |
      #| admin@admin.com | Admin@1122 |
#
  #Scenario Outline: Login with invalid credentials
    #Given the user is on the login page
    #When the user enters "<username>" and "<password>"
    #And clicks on the login button
    #Then the user should see "<Expected result>"
#
    #Examples: 
      #| username       | password | Expected result                                    |
      #| test@gmail.com | test@112 | http://skyonliners.com/demo/gammingle-web/webadmin |
