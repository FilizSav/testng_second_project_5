package scripts;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import pages.UnitedMainMenuPage;
import utilities.ConfigReader;
import utilities.Driver;



public class BasePageTest {
    WebDriver driver;
    BasePage basePage;
    UnitedMainMenuPage unitedMainMenuPage;

    @BeforeMethod
    public void setup(){

        driver = Driver.getDriver();
        basePage = new BasePage();
        driver.get(ConfigReader.getProperty("url"));
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }
}
