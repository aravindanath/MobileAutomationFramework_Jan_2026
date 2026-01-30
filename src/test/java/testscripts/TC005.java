package testscripts;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;
import pages.HomePage;

public class TC005 extends BaseTest {

    @Test(description = "Beauty and Heigiene category selection")
    public void BeautyAndHygiene() {


        HomePage hp = new HomePage((AppiumDriver) driver);
        hp.clickExploreButton();
        hp.searchCity("Bangalore");
        hp.openHamburgerMenu();
        hp.selectMenuItem("Shop By Category");
        hp.selectBeautyAndHygiene();
        hp.selectDettol();
        hp.select250ml();

    }
}