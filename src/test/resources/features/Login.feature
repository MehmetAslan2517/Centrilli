
Feature: Centrilli login feature
  User Story: As a user, I should be able to login with correct credentials to different
  accounts. And dashboard should be displayed.

  Background: For the scenarios in the feature file, user is expected to be on the login page
    Given user is on centrilli login page


  Scenario: Login as POSMANAGER
    When posmanager enters "posmanager10@info.com" into inputUsername
    And posmanager enters "posmanager" into inputPassword
    And posmanager click the loginbutton
    Then posmanager can login the centrilli homepage



