package testscripts;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.HomePage;

public class TC004 extends BaseTest{

    @Test(description = "Verify all shop categories and count")
    public void verifyShopCategoriesList() {


        HomePage hp = new HomePage((AppiumDriver) driver);
        hp.clickExploreButton();
        hp.searchCity("Bangalore");
        hp.openHamburgerMenu();
        hp.selectMenuItem("Shop By Category");


        CategoryPage cp = new CategoryPage((AppiumDriver) driver);


        int totalCategories = cp.getCategoryCount();
        System.out.println("Total Categories: " + totalCategories);


        cp.printAllCategories();
    }
}
