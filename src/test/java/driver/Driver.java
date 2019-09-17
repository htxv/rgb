package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.SystemEnum;
import utils.Utils;

public class Driver {

    private volatile static WebDriver instance;

    private Driver() {
    }

    public static synchronized WebDriver getInstance(DriversEnum browser) {
        switch (browser) {
            case FIREFOX:
                return instantiateDriver(new FirefoxDriver());
            case CHROME:
                initChromeDriverPath();
                return instantiateDriver(new ChromeDriver(DesiredCapabilities.chrome()));
            case OPERA:
                return instantiateDriver(new OperaDriver());
            default:
                return null;
        }
    }

    private static WebDriver instantiateDriver(WebDriver driver) {
        if (instance == null) {
            instance = driver;
        }
        return instance;
    }

    private static void initChromeDriverPath(){
        String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers";
        SystemEnum system = Utils.getSystemEnum();

        chromeDriverPath += system == SystemEnum.WINDOWS ? "/windows/chromedriver.exe" :
                            system == SystemEnum.MAC ?     "/mac/chromedriver" :
                                                           "/linux/chromedriver";

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
    }
}