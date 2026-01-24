package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CategoryPage {
    private AppiumDriver driver;


    public CategoryPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    // All category text elements
    @AndroidFindBy(xpath = "//android.widget.TextView")
    private List<WebElement> categoryList;


    // Get total number of categories
    public int getCategoryCount() {
        int count = 0;
        for (WebElement category : categoryList) {
            if (!category.getText().isEmpty()) {
                count++;
            }
        }
        return count;
    }


    // Print all category names
    public void printAllCategories() {
        System.out.println("------ Category List ------");
        for (WebElement category : categoryList) {
            String name = category.getText();
            if (!name.isEmpty()) {
                System.out.println(name);
            }
        }
    }
}

