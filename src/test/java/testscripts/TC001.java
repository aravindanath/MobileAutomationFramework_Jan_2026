package testscripts;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;
import pages.HomePage;

public class TC001 extends BaseTest{

    @Test
    public void sampleTest() {
        HomePage hp = new HomePage((AppiumDriver) driver);
        hp.clickExploreButton();
        hp.searchCity("Bangalore");
    }
}
