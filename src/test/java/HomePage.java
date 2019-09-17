import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

    private static final String HOME_URL = "https://www.rrrgggbbb.com/";

    static String letterR = "//*[@id='R']";
    static String letterG = "//*[@id='G']";
    static String letterB = "//*[@id='B']";

    static String redBackground = "//body[@class='r']";
    static String greenBackground = "//body[@class='g']";
    static String blueBackground = "//body[@class='b']";

    private WebDriver driver;

    HomePage(WebDriver driver){
        this.driver = driver;
    }

    void goToHomePage() {
        driver.get(HOME_URL);
    }

    void moveToElement(String elementLocation, final int X, final int Y) {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath(elementLocation)), X, Y).build().perform();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isElementHasClass(String elementLocation, String clazz) {
        return driver.findElement(By.xpath(elementLocation)).
                findElements(By.xpath(String.format(".//*[contains(@class,'%s')]", clazz)))
                .size() > 0;
    }

    public boolean isElementPresent(String element) {
        try {
            driver.findElement(By.xpath(element));
            return true;
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }


}
