package scripts;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.UnitedMainMenuPage;

public class UnitedMainMenuTest extends BasePageTest {
    @BeforeMethod
    public void setupPage() {
        basePage = new BasePage();
        unitedMainMenuPage = new UnitedMainMenuPage();
    }
    @Test(priority = 1, description = "validate menu items")
    public void validateMenuItems(){
        String[] list = {"BOOK","MY TRIPS", "TRAVEL INFO","MILEAGEPLUS® PROGRAM","DEALS", "HELP"};
        for (int i = 0; i < unitedMainMenuPage.menuItems.size(); i++) {
            Assert.assertEquals(unitedMainMenuPage.menuItems.get(i).getText(), list[i]);
            Assert.assertTrue(unitedMainMenuPage.menuItems.get(i).isDisplayed());
        }
    }
    @Test(priority = 2, description = "validate Book travel menu")
    public void validateBookTravelMenu(){
        String[] lists = {"Book","Flight status","Check-in","My trips"};
        for (int i = 0; i < unitedMainMenuPage.bookTravelMenu.size(); i++) {
            Assert.assertEquals(unitedMainMenuPage.bookTravelMenu.get(i).getText(),lists[i]);
            Assert.assertTrue(unitedMainMenuPage.bookTravelMenu.get(i).isDisplayed());
        }
    }
    @Test(priority = 3, description = "validate radio buttons")
    public void validateRadioButtons(){
        for (int i = 0; i < unitedMainMenuPage.radioButtons.size(); i++) {
            Assert.assertTrue(unitedMainMenuPage.radioButtons.get(i).isEnabled());
            Assert.assertTrue(unitedMainMenuPage.radioButtons.get(i).isDisplayed());
            Assert.assertFalse(unitedMainMenuPage.radioButtons.get(i).isSelected());
        }
        Assert.assertTrue(unitedMainMenuPage.radioButtonsInput.get(0).isSelected());
        Assert.assertFalse(unitedMainMenuPage.radioButtonsInput.get(1).isSelected());
        unitedMainMenuPage.radioButtonsInput.get(1).click();
        Assert.assertTrue(unitedMainMenuPage.radioButtonsInput.get(1).isSelected());
        Assert.assertFalse(unitedMainMenuPage.radioButtonsInput.get(0).isSelected());
    }
    @Test(priority = 4, description = "validate checkbox")
    public void validateCheckbox(){
        unitedMainMenuPage.bookInput.click();
        unitedMainMenuPage.flexibleDateInput.click();
        unitedMainMenuPage.bookInput.click();
        unitedMainMenuPage.flexibleDateInput.click();
        Assert.assertFalse(unitedMainMenuPage.checkBoxInput.get(0).isSelected());
        Assert.assertFalse(unitedMainMenuPage.checkBoxInput.get(1).isSelected());
        for (int i = 0; i < unitedMainMenuPage.checkBoxInput.size(); i++) {
        Assert.assertTrue(unitedMainMenuPage.bookText.isDisplayed());
        Assert.assertTrue(unitedMainMenuPage.flexibleDateText.isDisplayed());
        Assert.assertTrue(unitedMainMenuPage.checkBoxInput.get(i).isEnabled());
        Assert.assertFalse(unitedMainMenuPage.checkBoxInput.get(i).isSelected());
        }
    }
    @Test(priority = 5, description = "validate departure info")
    public void validateDepartureInfo(){
        unitedMainMenuPage.radioButtonsInput.get(1).click();
        unitedMainMenuPage.bookFlightOriginInput.clear();
        unitedMainMenuPage.bookFlightOriginInput.sendKeys("Chicago, IL, US (ORD)" + Keys.ENTER);
        unitedMainMenuPage.bookFlightDestinationInput.sendKeys("Miami, FL, US (MIA)" + Keys.ENTER);
        unitedMainMenuPage.departDate.clear();
        unitedMainMenuPage.departDate.sendKeys("Feb 28");
        unitedMainMenuPage.departDate.click();
        unitedMainMenuPage.passengerSelectButton.click();
        unitedMainMenuPage.addAdultPassenger.click();
        unitedMainMenuPage.classDropDown.click();
        unitedMainMenuPage.clickOnCabinTypeOption("Business or First");
        unitedMainMenuPage.findFlightsButton.click();
        Assert.assertEquals(unitedMainMenuPage.departureMessage.getText(),"DEPART ON: February 28");
    }
    /**
     Given user is on "https://www.united.com/en/us"
     When user selects "One-way" ticket radio button
     And user enters "Chicago, IL, US (ORD)" to from input box
     And user enters "Miami, FL, US (MIA)" to to input box
     And user selects "Feb 28" to the dates input box
     And user selects "2 Adults" from travelers selector
     And user selects "Business or First" from cabin dropdown
     And user clicks on "Find Flights" button
     Then validate departure equals to "DEPART ON: February 28"

     *
     */
}
