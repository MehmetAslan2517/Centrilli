package com.cydeo.centrilli.pages;

import com.cydeo.centrilli.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehiclePage extends BasePage{

    public VehiclePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[@class='oe_menu_text'])[116]")
    public WebElement vehicleButton;

    @FindBy(xpath = "//button[@accesskey='c']")
    public WebElement createButton;

    @FindBy(xpath = "(//span[@class='o_dropdown_button'])[1]")
    public WebElement inputModelTriangle;

    @FindBy(xpath = "(//a[.='Acura/'])[1]")
    public WebElement AcuraModel;

    @FindBy(xpath = "(//input[@class='o_input ui-autocomplete-input'])[1]")
    public WebElement inputModel;

    @FindBy(xpath = "//input[@name='license_plate']")
    public WebElement inputLicencePlate;

    @FindBy(xpath = "//button[@accesskey='s']")
    public WebElement saveButton;

    @FindBy(xpath = "//button[@accesskey='j']")
    public WebElement discardButton;

    @FindBy(xpath = "//button[@accesskey='a']")
    public WebElement editButton;

    @FindBy(xpath = "(//div[@class='o_thread_message_content'])[1]")
    public WebElement newVehicleMessage;

    @FindBy(xpath = "//div[@class='o_searchview']")
    public WebElement searchBox;

    @FindBy(xpath = "//span[.='MA2517']")
    public WebElement newVehicle;

    @FindBy(xpath = "//span[@class='o_pager_limit']")
    public WebElement numberOfVehicles;

    @FindBy(xpath = "(//li[@class='active'])[3]")
    public WebElement titleVehicle;

    @FindBy(xpath = "(//input[@class='o_input ui-autocomplete-input'])[5]")
    public WebElement inputCreateModelMakeBox;

    @FindBy(xpath = "(//span[@draggable='false'])[5]")
    public WebElement createModelMakeTriangle; //create model kutusundaki Maeke boxının üçgeni

    @FindBy(xpath = "//button[@class='btn btn-sm btn-primary']")
    public WebElement saveButtonCreateModel;
    /*
    @FindBy()
    public WebElement y;
*/


}
