package utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.Arrays;

public class MobileGestures {
    /**
     * Scrolls to an element using UiSelector string and returns the found WebElement.
     * @param driver The WebDriver instance (should be AppiumDriver).
     * @param uiAutomatorString The UiSelector string, e.g., "new UiSelector().text(\"SomeText\")"
     * @return The found WebElement after scrolling.
     */
    public static WebElement scrollToElement(WebDriver driver, String uiAutomatorString) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        String scrollableUiAutomator = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(" + uiAutomatorString + ")";
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.androidUIAutomator(scrollableUiAutomator)
                )
        );
    }


    public static  void scrollToText(AppiumDriver driver, String text){
        String textPath ="new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().textContains(\""+text+"\"));";
//        driver.findElementByAndroidUIAutomator(textPath);
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(textPath)).click();

    }
    /**
     * Scrolls to the element with text "VASELINE" using UiSelector and clicks it.
     * @param driver The AppiumDriver instance.
     */
    public static void scrollToVaseline(AppiumDriver driver) {
        String uiAutomatorString = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"VASELINE\"))";
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(uiAutomatorString)).click();
    }
    /**
     * Swipes up repeatedly until the end of the scrollable screen is reached using W3C Actions API.
     * @param driver The AppiumDriver instance.
     */
    public static void swipeToEndOfScreen(AppiumDriver driver) {
        final int MAX_SWIPE = 20;
        int swipeCount = 0;
        String lastPageSource = "";
        String currentPageSource = driver.getPageSource();
        Dimension size = driver.manage().window().getSize();
        int width = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);
        while (lastPageSource != null && !currentPageSource.equals(lastPageSource) && swipeCount < MAX_SWIPE) {
            lastPageSource = currentPageSource;
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), width, startY));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), width, endY));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));
            swipeCount++;
            currentPageSource = driver.getPageSource();
        }
    }

    /**
     * Swipes up until the required element is present on the screen, then clicks it.
     * Returns true if the element is found and clicked, false otherwise.
     * @param driver The AppiumDriver instance.
     * @param locator The By locator of the element to find and click.
     * @return true if element is found and clicked, false if not found after swiping to end.
     */
    public static boolean swipeAndClickElement(AppiumDriver driver, WebElement locator) {
        final int MAX_SWIPE = 20;
        int swipeCount = 0;
        Dimension size = driver.manage().window().getSize();
        int width = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);
        while (swipeCount < MAX_SWIPE) {
            try {
                if (locator.isDisplayed()) {
                    locator.click();
                    return true;
                }
            } catch (Exception e) {
                // Element not found, swipe up
            }
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), width, startY));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), width, endY));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));
            swipeCount++;
        }
        return false;
    }

    private static io.appium.java_client.touch.offset.PointOption point(int x, int y) {
        return io.appium.java_client.touch.offset.PointOption.point(x, y);
    }
}
