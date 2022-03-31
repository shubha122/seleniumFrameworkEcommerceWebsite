Feature: Verify Login page Functionality

  Scenario: Verify user is able to login with email and password
    Given click on LoginSignup button
    When click on Login button
    And click on Use Email Address button
    Then enter the username "qaassignment@shopback.com"
    And click on next button
    Then enter the password "Shopback22"
    And click on next button
    Then user is successfully logged in
    And dismiss the popup from home page

#    how to validate about the logged in line no 50
