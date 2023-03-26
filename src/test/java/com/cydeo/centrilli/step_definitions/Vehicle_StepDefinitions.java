package com.cydeo.centrilli.step_definitions;

import com.cydeo.centrilli.pages.BasePage;
import com.cydeo.centrilli.pages.LoginPage;
import com.cydeo.centrilli.pages.VehiclePage;
import com.cydeo.centrilli.utilities.BrowserUtil;
import com.cydeo.centrilli.utilities.ConfigurationReader;
import com.cydeo.centrilli.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Vehicle_StepDefinitions {

    BasePage basePage = new BasePage();
    LoginPage loginpage = new LoginPage();
    VehiclePage vehiclePage = new VehiclePage();

    Faker faker = new Faker();

    @Given("posmanager logged in the Centrilli page")
    public void posmanager_logged_in_the_centrilli_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");
        loginpage.login(username, password);
        BrowserUtil.sleep(5);
    }

    @When("posmanager clicks the fleet dropdown")
    public void posmanager_clicks_the_fleet_dropdown() {
        basePage.clickFleet();
    }

    @When("posmanager clicks the create button")
    public void posmanager_clicks_the_create_button() throws InterruptedException {
        BrowserUtil.waitForClickAbility(vehiclePage.createButton, 15);
        vehiclePage.createButton.click();
    }

    @When("posmanager enters the model")
    public void posmanager_enters_the_model() {
        BrowserUtil.waitForVisibility(vehiclePage.inputModel, 15);
        vehiclePage.inputModel.click();
        vehiclePage.AcuraModel.click();
    }

    @When("posmanager enters License Plate")
    public void posmanager_enters_license_plate()  {
        BrowserUtil.waitForVisibility(vehiclePage.inputLicencePlate, 15);
        vehiclePage.inputLicencePlate.sendKeys("MA2517");
    }

    @When("posmanager clicks the save button")
    public void posmanager_clicks_the_save_button() {
        BrowserUtil.waitForClickAbility(vehiclePage.saveButton,15);
        vehiclePage.saveButton.click();
    }

    @Then("posmanager can create new vehicle")
    public void posmanager_can_create_new_vehicle() {
        BrowserUtil.waitForClickAbility(vehiclePage.editButton,15);
        String actualTitle = vehiclePage.titleVehicle.getText();
        String expectedTitle = "Acura/ /MA2517";
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Then("posmanager can not create vehicle")
    public void posmanager_can_not_create_vehicle() {
        String actualTitle = vehiclePage.titleVehicle.getText();
        String expectedTitle = "Acura/ /MA2517 - Odoo";
        Assert.assertNotEquals(expectedTitle, actualTitle);
    }

    @When("posmanager clicks the discard button to cancel the process")
    public void posmanager_clicks_the_discard_button_to_cancel_the_process() {
        BrowserUtil.waitForClickAbility(vehiclePage.discardButton,15);
        vehiclePage.discardButton.click();
    }

    @Then("posmanager should be able to cancel the process")
    public void posmanager_should_be_able_to_cancel_the_process() {
        BrowserUtil.waitForVisibility(vehiclePage.createButton,15);
        BrowserUtil.verifyTitle("Vehicles - Odoo");
    }

    @Then("posmanager can create new vehicle and can see the page title is changed to the new vehicle name")
    public void posmanager_can_create_new_vehicle_and_can_see_the_page_title_is_changed_to_the_new_vehicle_name() {
        BrowserUtil.waitForClickAbility(vehiclePage.editButton,15);
        BrowserUtil.verifyTitle("Acura/ /MA2517 - Odoo");
    }

    @Then("posmanager should see \\(Vehicle name) has been added to the fleet! message is displayed at the bottom of the page")
    public void posmanager_should_see_vehicle_name_has_been_added_to_the_fleet_message_is_displayed_at_the_bottom_of_the_page() {
        BrowserUtil.waitForVisibility(vehiclePage.newVehicleMessage,15);
        Assert.assertTrue(vehiclePage.newVehicleMessage.isDisplayed());
    }

    @When("posmanager clicks vehicles button")
    public void posmanager_clicks_vehicles_button() {
        vehiclePage.vehicleButton.click();
    }

    @Then("posmanager search the new created vehicle on the search box and find it")
    public void posmanager_search_the_new_created_vehicle_on_the_search_box_and_find_it() {
        vehiclePage.vehicleButton.click();
        BrowserUtil.waitForClickAbility(vehiclePage.searchBox, 15);
        vehiclePage.searchBox.sendKeys("MA2517" + Keys.ENTER);
        BrowserUtil.waitForVisibility(vehiclePage.newVehicle,15);
        vehiclePage.newVehicle.isDisplayed();
    }

    @Then("posmanager creates new vehicle, sees that number of vehicle increase one")
    public void posmanager_creates_new_vehicle_sees_that_number_of_vehicle_increase_one() {

        BrowserUtil.waitForVisibility(vehiclePage.numberOfVehicles,15);
        String numOfVehicles = vehiclePage.numberOfVehicles.getText();

        int num1 = Integer.parseInt(numOfVehicles);
        num1=num1+1;

        BrowserUtil.waitForClickAbility(vehiclePage.createButton, 15);
        vehiclePage.createButton.click();

        BrowserUtil.waitForVisibility(vehiclePage.inputModel, 15);
        vehiclePage.inputModel.click();
        vehiclePage.AcuraModel.click();

        BrowserUtil.waitForVisibility(vehiclePage.inputLicencePlate, 15);
        vehiclePage.inputLicencePlate.sendKeys("MA2517");
        vehiclePage.vehicleButton.click();

        BrowserUtil.waitForClickAbility(vehiclePage.saveButton,15);
        vehiclePage.saveButton.click();
        vehiclePage.vehicleButton.click();

        BrowserUtil.waitForVisibility(vehiclePage.importButton,15);
        String numOfVehiclesAfterSaving = vehiclePage.numberOfVehicles.getText();

        int num2 = Integer.parseInt(numOfVehiclesAfterSaving);

        Assert.assertEquals(num2, num1);
    }



}
