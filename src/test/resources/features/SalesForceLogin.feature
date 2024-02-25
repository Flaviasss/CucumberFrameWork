Feature: Salesforce Functionality

  Background: 
    Given the user is on the Salesforce login page

  Scenario: Login with valid user and valid password
    Given User open firebase application
    When user on "LoginPage"
    When User enters value into text box username as "sowjanya@tekarch.com"
    When User enters value into text box password as "Sudeep@17!"
    When Click on Login button
    When user on "Homepage"
    Then verify we can see "Student Registration Form"
