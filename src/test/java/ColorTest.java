import org.junit.Test;
import org.testng.Assert;


public class ColorTest extends BaseTest{

    @Test
    public void colorTest() throws InterruptedException{

        final int X_OFFSET = 10;
        final int Y_OFFSET = 10;

        homePage.goToHomePage();
        homePage.moveToElement(HomePage.letterR, X_OFFSET, Y_OFFSET);

        Assert.assertTrue(homePage.isElementHasClass(HomePage.letterR, "black"));
        Assert.assertTrue(homePage.isElementPresent(HomePage.redBackground));

        homePage.moveToElement(HomePage.letterG,  X_OFFSET, Y_OFFSET);
        Assert.assertTrue(homePage.isElementHasClass(HomePage.letterG, "black"));
        Assert.assertTrue(homePage.isElementPresent(HomePage.greenBackground));

        homePage.moveToElement(HomePage.letterB, X_OFFSET, Y_OFFSET);
        Assert.assertTrue(homePage.isElementHasClass(HomePage.letterB, "black"));
        Assert.assertTrue(homePage.isElementPresent(HomePage.blueBackground));

    }

}
