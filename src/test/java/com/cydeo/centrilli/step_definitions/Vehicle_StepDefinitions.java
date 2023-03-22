package com.cydeo.centrilli.step_definitions;

import com.cydeo.centrilli.pages.BasePage;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    }

    @When("posmanager clicks the fleet dropdown")
    public void posmanager_clicks_the_fleet_dropdown() {
        basePage.clickFleet();
    }

    @When("posmanager clicks the create button")
    public void posmanager_clicks_the_create_button() throws InterruptedException {
        //WebDriverWait wait = new WebDriverWait(Driver.getDriver(),25);
        //wait.until(ExpectedConditions.elementToBeClickable(vehiclePage.createButton));
        Thread.sleep(15000);
        vehiclePage.createButton.click();
    }

    @When("posmanager enters the model")
    public void posmanager_enters_the_model() throws InterruptedException {
       // WebDriverWait wait = new WebDriverWait(Driver.getDriver(),90);
       // wait.until(ExpectedConditions.visibilityOf(vehiclePage.inputModel));
        Thread.sleep(30000);
        vehiclePage.inputModelTriangle.click();
        vehiclePage.AcuraModel.click();
    }

    @When("posmanager enters License Plate")
    public void posmanager_enters_license_plate() throws InterruptedException {
        //vehiclePage.inputLicencePlate.sendKeys(faker.bothify("MA###"));
       // WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
        //wait.until(ExpectedConditions.visibilityOf(vehiclePage.inputLicencePlate));
        Thread.sleep(30000);
        vehiclePage.inputLicencePlate.sendKeys("MA2517");
    }

    @When("posmanager clicks the save button")
    public void posmanager_clicks_the_save_button() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
        wait.until(ExpectedConditions.elementToBeClickable(vehiclePage.saveButton));
        vehiclePage.saveButton.click();
    }

    @Then("posmanager can create new vehicle")
    public void posmanager_can_create_new_vehicle() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
        wait.until(ExpectedConditions.elementToBeClickable(vehiclePage.editButton));
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Acura/ /MA2517 - Odoo";
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("posmanager can not create vehicle")
    public void posmanager_can_not_create_vehicle() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
        wait.until(ExpectedConditions.elementToBeClickable(vehiclePage.editButton));
        String actualTitle = vehiclePage.titleVehicle.getText();
        String expectedTitle = "Acura/ /MA2517 - Odoo";
        Assert.assertFalse(expectedTitle.equals(actualTitle));
    }

    @When("posmanager clicks the discard button to cancel the process")
    public void posmanager_clicks_the_discard_button_to_cancel_the_process() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
        wait.until(ExpectedConditions.elementToBeClickable(vehiclePage.discardButton));
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
       // WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
       // wait.until(ExpectedConditions.visibilityOfElementLocated(vehiclePage.newVehicleMessage));
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
       // WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
       // wait.until(ExpectedConditions.visibilityOfElementLocated(vehiclePage.numberOfVehicles));
        String numOfVehicles = vehiclePage.numberOfVehicles.getText();
        System.out.println(numOfVehicles);
       // Integer num = (Integer) numOfVehicles;
    }


}
