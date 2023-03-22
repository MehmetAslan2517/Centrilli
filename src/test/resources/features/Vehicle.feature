
Feature: Centrilli Fleet vehicle feature
  User Story: As a PosManager, I should be able to create new vehicle.


  @wip
  Scenario: Verify that Posmanager can create a vehicle
    Given posmanager logged in the Centrilli page
    When posmanager clicks the fleet dropdown
    And posmanager clicks the create button
    And posmanager enters the model
    And posmanager enters License Plate
    And posmanager clicks the save button
    Then posmanager can create new vehicle

  Scenario: Verify that, Posmanager can not create a vehicle without entering Model/Licence Plate.
    When posmanager clicks the fleet dropdown
    And posmanager clicks the create button
    And posmanager clicks the save button
    Then posmanager can not create vehicle

  Scenario: Verify that user can cancel the process by clicking Discard button
    When posmanager clicks the fleet dropdown
    And posmanager clicks the create button
    And posmanager clicks the discard button to cancel the process
    Then posmanager should be able to cancel the process

  Scenario: Verify that page title is changed to the new vehicle name after user create the vehicle
    When posmanager clicks the fleet dropdown
    And posmanager clicks the create button
    And posmanager selects the model
    And posmanager enters License Plate
    And posmanager clicks the save button
    Then posmanager can create new vehicle and can see the page title is changed to the new vehicle name

  Scenario: Verify that "(Vehicle name) has been added to the fleet!" message is displayed at the bottom of the page.
    When posmanager clicks the fleet dropdown
    And posmanager clicks the create button
    And posmanager selects the model
    And posmanager enters License Plate
    And posmanager clicks the save button
    Then posmanager should see (Vehicle name) has been added to the fleet! message is displayed at the bottom of the page

  Scenario: Verify that user can find the new created vehicle under Vehicles list
    When posmanager clicks the fleet dropdown
    And posmanager clicks the create button
    And posmanager enters the model
    And posmanager enters License Plate
    And posmanager clicks the save button
    Then posmanager search the new created vehicle on the search box and find it


  Scenario: Verify that the number of Vehicles increased 1
    When posmanager clicks the fleet dropdown
    And posmanager clicks the create button
    And posmanager selects the model
    And posmanager enters License Plate
    Then posmanager clicks the save button, sees that number of vehicle increase one
