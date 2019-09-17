import driver.Driver;
import driver.DriversEnum;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected static HomePage homePage;

    private static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = Driver.getInstance(DriversEnum.CHROME);
        assert driver != null;
        driver.manage().window().maximize();
        initPages();
    }

    @AfterClass
    public static void quit(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private static void initPages(){
        homePage = new HomePage(driver);
    }



}
