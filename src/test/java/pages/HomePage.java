package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

public class HomePage {

   private AppiumDriver driver;

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.raincan.android.hybrid:id/explore_now\"]")
    private WebElement exploreNowButton;

    @AndroidFindBy(className = "android.widget.EditText")
    private WebElement searchBox;

    @AndroidFindBy(id="com.raincan.android.hybrid:id/main_area_name")
    private WebElement areaName;

    @AndroidFindBy(id="com.raincan.android.hybrid:id/iv_drawer")
    private WebElement hamburgerMenu;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat/android.widget.CheckedTextView")
    private List<WebElement> menuItems;


    public void clickExploreButton() {
        exploreNowButton.click();
    }


    public void searchCity(String cityName) {
        searchBox.sendKeys(cityName);
        areaName.click();
    }

    public void openHamburgerMenu() {
        hamburgerMenu.click();
    }

    public void selectMenuItem(String itemName) {
        for (WebElement item : menuItems) {
            if (item.getText().equalsIgnoreCase(itemName)) {
                item.click();
                break;
            }
        }
    }

    public void getAllMenuItems() {
        for (WebElement item : menuItems) {
            System.out.println("Menu Item: " + item.getText());
        }
    }




}
