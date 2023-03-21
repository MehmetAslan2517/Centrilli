package com.cydeo.centrilli.pages;

import com.cydeo.centrilli.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    public WebElement moreDropdowns;

    @FindBy(xpath = "(//span[@class='oe_menu_text'])[21]")
    public WebElement fleetButton;

    public void clickFleet(){
        if (fleetButton.isDisplayed()){
            fleetButton.click();
        }else{
            moreDropdowns.click();
            fleetButton.click();
        }
    }

}
