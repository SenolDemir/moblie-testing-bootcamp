package com.domain.tests.cloud;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.MutableCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceLabAndroidTest {

    AppiumDriver driver;


    @BeforeTest
    public void setup() throws MalformedURLException, InterruptedException {

        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:app", "storage:filename=Android.SauceLabs.Mobile.Sample.app.2.6.0.apk");  // The filename of the mobile app
        caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
        caps.setCapability("appium:platformVersion", "15.0");
        caps.setCapability("appium:automationName", "UiAutomator2");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("appiumVersion", "2.11.0");
        sauceOptions.setCapability("username", "oauth-senoldemir-80224");
        sauceOptions.setCapability("accessKey", "3cdb9d97-75e0-44a1-9eb5-6d4a110843cd");
        sauceOptions.setCapability("build", "<your build id>");
        sauceOptions.setCapability("name", "sauce android emulator test");
        sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
        caps.setCapability("sauce:options", sauceOptions);



        // Start the session
        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, caps);
        Thread.sleep(4000);


    }

    @AfterTest
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }


    }

    @Test
    public void androidEmulatorTest() throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("test-Username")).sendKeys("problem_user");
        Thread.sleep(2000);
        driver.findElement(AppiumBy.accessibilityId("test-Password")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();
        Thread.sleep(5000);
    }


}
