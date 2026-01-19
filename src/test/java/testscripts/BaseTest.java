package testscripts;

import com.aventstack.chaintest.plugins.ChainTestListener;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


@Listeners(ChainTestListener.class)
public class BaseTest {

   protected WebDriver driver;


    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:platformVersion", "16");
        capabilities.setCapability("appium:deviceName", "testdevice");
        capabilities.setCapability("appium:udid", "emulator-5554");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:appPackage", "com.raincan.android.hybrid");
        capabilities.setCapability("appium:appActivity", "com.raincan.app.v2.splash.activity.SplashActivity");
        capabilities.setCapability("appium:newCommandTimeout", 50000);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));


//        capabilities.setCapability("platformName", "iOS");
//        capabilities.setCapability("appium:platformVersion", "26.0.1");
//        capabilities.setCapability("appium:udid", "00008130-000460A026BA001C");
//        capabilities.setCapability("appium:deviceName", "Adarsh's iPhone");
//        capabilities.setCapability("appium:automationName", "XCUITest");
//        capabilities.setCapability("appium:bundleId", BUNDLE_ID);
//        capabilities.setCapability("appium:newCommandTimeout", 50000);
////        capabilities.setCapability("appium:showXcodeLog", true);


    }
//    @BeforeSuite
//    public void AppiumSetup()
//    {
//        AppiumServiceBuilder builder = new AppiumServiceBuilder()
//                .withAppiumJS(new File("/usr/local/bin/appium"))  // Path to appium
//                .usingDriverExecutable(new File("/usr/local/bin/node"))  // Path to node
//                .usingPort(4723)
//                .withIPAddress("127.0.0.1")
//                .withTimeout(Duration.ofSeconds(300))
//                .withArgument(GeneralServerFlag.LOG_LEVEL, "info")
//                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
//                // .withArgument(() -> "--allow-cors")
//                .withArgument(() -> "--use-plugins", "images")
//                .withArgument(GeneralServerFlag.BASEPATH, "/");  // For Appium 2.x use "/"
//
//        service = AppiumDriverLocalService.buildService(builder);
//        service.start();
//        System.out.println("SERVER STARTED");
//    }
//

    }
