package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UnitedMainMenuPage extends BasePage{
    public UnitedMainMenuPage(){super();}

    @FindBy(css = "div[role='tablist'] a")
    public List<WebElement> menuItems;

    @FindBy(css = "ul[class*='app-components-BookTr'] li")
    public List<WebElement> bookTravelMenu;

    @FindBy(css = "div[class*='radioContainer'] label")
    public List<WebElement> radioButtons;

    @FindBy(css = "div[class*='radioContainer'] input")
    public List<WebElement> radioButtonsInput;

    @FindBy(xpath = "//div[contains(@class,'bookFlightForm__f')]//div/input")
    public List<WebElement> checkBoxInput;

    @FindBy(xpath = "//span[text()='Book with miles']")
    public WebElement bookText;

    @FindBy(xpath = "//span[text()='Flexible dates']")
    public WebElement flexibleDateText;

    @FindBy(css = "label[for='award']")
    public WebElement bookInput;

    @FindBy(css = "label[for='flexibleDates']")
    public WebElement flexibleDateInput;

    @FindBy(css = "#bookFlightOriginInput")
    public WebElement bookFlightOriginInput;

    @FindBy(css = "#bookFlightDestinationInput")
    public WebElement bookFlightDestinationInput;

    @FindBy(css = "#DepartDate")
    public WebElement departDate;

    @FindBy(xpath = "strong")
    public List<WebElement> month;

    @FindBy(css = "button[aria-labelledby='stuff']")
    public WebElement passengerSelectButton;

    @FindBy(css = "button[aria-label='Substract one Adult']")
    public WebElement addAdultPassenger;

    @FindBy(css = "div[aria-label='Economy']")
    public WebElement classDropDown;


    @FindBy(css = "li[id^='cabinType_item-']")
    public List<WebElement> cabinType;

    public void clickOnCabinTypeOption(String optionText){
        for(WebElement element : cabinType){
            if(element.getText().equals(optionText)){
                element.click();
                break;
            }
        }
    }

    @FindBy(css = "button[class*='bookFlightForm__findFlightBtn']")
    public WebElement findFlightsButton;

    //@FindBy(xpath = "//div[@id='flightResults-content']/div[2]/div/div/div/div/div/span")
    @FindBy(xpath = "(//div[contains(@class,'app-components-Shopping-ColumnSortResultHeader-styles__d')]/span)[2]")
    public WebElement departureMessage;



}
