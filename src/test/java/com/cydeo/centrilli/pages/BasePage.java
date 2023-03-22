package com.cydeo.centrilli.pages;

import com.cydeo.centrilli.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    LoginPage loginPage = new LoginPage();
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
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(),25);
            wait.until(ExpectedConditions.elementToBeClickable(moreDropdowns));
            moreDropdowns.click();
            wait.until(ExpectedConditions.elementToBeClickable(fleetButton));
            fleetButton.click();
        }
    }

}
