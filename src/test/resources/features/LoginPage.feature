Feature: Verify Login page Functionality

  Background:
    Given Go to url
  Scenario: Verify user is able to login with email and passowrd
    Given click on Login Signup button
    When click on Login button
    And click on Use Email Address button
    Then enter the username "qaassignment@shopback.com"
    And click on next button
    Then enter the password "Shopback22"
    And click on next button
    Then user is successfully logged in
    And dismiss the popup from home page
