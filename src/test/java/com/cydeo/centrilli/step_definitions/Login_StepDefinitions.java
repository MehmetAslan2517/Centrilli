package com.cydeo.centrilli.step_definitions;

import com.cydeo.centrilli.pages.LoginPage;
import com.cydeo.centrilli.utilities.ConfigurationReader;
import com.cydeo.centrilli.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDefinitions {

    LoginPage loginpage = new LoginPage();
    @Given("user is on centrilli login page")
    public void user_is_on_centrilli_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    @When("posmanager enters {string} into inputUsername")
    public void posmanager_enters_into_input_username(String username) {
        loginpage.inputUsername.sendKeys(username);
    }
    @When("posmanager enters {string} into inputPassword")
    public void posmanager_enters_into_input_password(String password) {
        loginpage.inputPassword.sendKeys(password);
    }
    @When("posmanager click the loginbutton")
    public void posmanager_click_the_loginbutton() {
        loginpage.loginButton.click();

    }
    @Then("posmanager can login the centrilli homepage")
    public void posmanager_can_login_the_centrilli_homepage() {
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Odoo"));
    }
}
