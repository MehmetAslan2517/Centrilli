package com.cydeo.centrilli.step_definitions;

import com.cydeo.centrilli.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    //import from cucumber @After not junit @After
    @After
    public void teardownScenario(Scenario scenario){

        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png",scenario.getName());
        }
        Driver.closeDriver();
        //System.out.println("===Closing browser using cucumber @After");
        //System.out.println("===Scenario ended take screenshot if it is failed");
    }
}
