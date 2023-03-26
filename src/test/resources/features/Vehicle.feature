@wip @CENT10-330
Feature: Centrilli Fleet vehicle feature
  User Story: As a PosManager, I should be able to create new vehicle.

  @CENT10-323
  Scenario: Verify that Posmanager can create a vehicle
    Given posmanager logged in the Centrilli page
    When posmanager clicks the fleet dropdown
    And posmanager clicks the create button
    And posmanager enters the model
    And posmanager enters License Plate
    And posmanager clicks the save button
    Then posmanager can create new vehicle

  @CENT10-324
  Scenario: Verify that, Posmanager can not create a vehicle without entering Model/Licence Plate.
    Given posmanager logged in the Centrilli page
    When posmanager clicks the fleet dropdown
    And posmanager clicks the create button
    And posmanager clicks the save button
    Then posmanager can not create vehicle

  @CENT10-325
  Scenario: Verify that user can cancel the process by clicking Discard button
    Given posmanager logged in the Centrilli page
    When posmanager clicks the fleet dropdown
    And posmanager clicks the create button
    And posmanager clicks the discard button to cancel the process
    Then posmanager should be able to cancel the process

  @CENT10-326
  Scenario: Verify that page title is changed to the new vehicle name after user create the vehicle
    Given posmanager logged in the Centrilli page
    When posmanager clicks the fleet dropdown
    And posmanager clicks the create button
    And posmanager enters the model
    And posmanager enters License Plate
    And posmanager clicks the save button
    Then posmanager can create new vehicle and can see the page title is changed to the new vehicle name

  @CENT10-327
  Scenario: Verify that (Vehicle name) has been added to the fleet! message is displayed at the bottom of the page.
    Given posmanager logged in the Centrilli page
    When posmanager clicks the fleet dropdown
    And posmanager clicks the create button
    And posmanager enters the model
    And posmanager enters License Plate
    And posmanager clicks the save button
    Then posmanager should see (Vehicle name) has been added to the fleet! message is displayed at the bottom of the page

  @CENT10-328
  Scenario: Verify that user can find the new created vehicle under Vehicles list
    Given posmanager logged in the Centrilli page
    When posmanager clicks the fleet dropdown
    And posmanager clicks the create button
    And posmanager enters the model
    And posmanager enters License Plate
    And posmanager clicks the save button
    And posmanager clicks vehicles button
    Then posmanager search the new created vehicle on the search box and find it

  @CENT10-329
  Scenario: Verify that the number of Vehicles increased 1
    Given posmanager logged in the Centrilli page
    When posmanager clicks the fleet dropdown
    Then posmanager creates new vehicle, sees that number of vehicle increase one
