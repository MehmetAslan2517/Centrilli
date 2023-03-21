package com.cydeo.centrilli.step_definitions;

import com.cydeo.centrilli.pages.LoginPage;
import com.cydeo.centrilli.pages.VehiclePage;
import com.cydeo.centrilli.utilities.ConfigurationReader;
import com.cydeo.centrilli.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Vehicle_StepDefinitions {

    LoginPage loginpage = new LoginPage();
    VehiclePage vehiclePage = new VehiclePage();

    Faker faker = new Faker();

    @Given("Posmanager is expected to be login")
    public void posmanager_is_expected_to_be_login() {
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");
        loginpage.login(username, password);
    }

    @When("posmanager clicks the fleet dropdown")
    public void posmanager_clicks_the_fleet_dropdown() {
        vehiclePage.clickFleet();
    }

    @When("posmanager clicks the vehicle button")
    public void posmanager_clicks_the_vehicle_button() {
        vehiclePage.vehicleButton.click();
    }

    @When("posmanager clicks the create button")
    public void posmanager_clicks_the_create_button() {
        vehiclePage.createButton.click();
    }

    @When("posmanager selects the model")
    public void posmanager_selects_the_model() {
        vehiclePage.inputModel.sendKeys("Toyota");
    }

    @When("posmanager enters License Plate")
    public void posmanager_enters_license_plate() {
        //vehiclePage.inputLicencePlate.sendKeys(faker.bothify("MA###"));
        vehiclePage.inputLicencePlate.sendKeys("MA2517");
    }

    @When("posmanager clicks the save button")
    public void posmanager_clicks_the_save_button() {
        vehiclePage.saveButton.click();
    }

    @Then("posmanager can create new vehicle")
    public void posmanager_can_create_new_vehicle() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Toyota/ /MA2517 - Odoo";
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("posmanager can not create vehicle")
    public void posmanager_can_not_create_vehicle() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Toyota/ /MA2517 - Odoo";
        Assert.assertFalse(expectedTitle.equals(actualTitle));
    }

    @When("posmanager clicks the discard button to cancel the process")
    public void posmanager_clicks_the_discard_button_to_cancel_the_process() {
        vehiclePage.discardButton.click();
    }

    @Then("posmanager should be able to cancel the process")
    public void posmanager_should_be_able_to_cancel_the_process() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Vehicles - Odoo";
        Assert.assertTrue(expectedTitle.equals(actualTitle));
    }

    @Then("posmanager can create new vehicle and can see the page title is changed to the new vehicle name")
    public void posmanager_can_create_new_vehicle_and_can_see_the_page_title_is_changed_to_the_new_vehicle_name() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Toyota/ /MA2517 - Odoo";
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("posmanager should see (Vehicle name) has been added to the fleet! message is displayed at the bottom of the page")
    public void posmanager_should_see_message_is_displayed_at_the_bottom_of_the_page(String string) {
        vehiclePage.newVehicleMessage.isDisplayed();
    }

    @Then("posmanager search the new created vehicle on the search box and find it")
    public void posmanager_search_the_new_created_vehicle_on_the_search_box_and_find_it() {
        vehiclePage.vehicleButton.click();
        vehiclePage.searchBox.sendKeys("MA2157"+ Keys.ENTER);
        vehiclePage.newVehicle.isDisplayed();
    }

    @Then("posmanager clicks the save button, sees that number of vehicle increase one")
    public void posmanager_clicks_the_save_button_sees_that_number_of_vehicle_increase_one() {
        String numOfVehicles = vehiclePage.numberOfVehicles.getText();
        System.out.println(numOfVehicles);
       // Integer num = (Integer) numOfVehicles;
    }


}
