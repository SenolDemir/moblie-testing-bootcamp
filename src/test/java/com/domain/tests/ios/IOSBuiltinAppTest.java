package com.domain.tests.ios;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class IOSBuiltinAppTest {


    AppiumDriver driver = null;

    @BeforeTest
    public void setup() throws MalformedURLException {


        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:automationName", "xcuitest");
        caps.setCapability("platformName", "ios");
        caps.setCapability("appium:platformVersion", "17.0");
        caps.setCapability( "appium:deviceName", "iPhone 15 Pro Max");
        caps.setCapability("appium:udid", "A5EF4F86-717F-43AC-9407-C60BB1D4F08C");
        caps.setCapability("appium:noReset", true);
        caps.setCapability("appium:fullReset", false);
        caps.setCapability("appium:printPageSourceOnFindFailure", false);
        caps.setCapability("appium:useNewWDA", true);
        caps.setCapability("appium:bundleId", "com.apple.reminders");


        driver = new IOSDriver(new URL("http://127.0.0.1:4723"), caps);



    }

    @AfterTest
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    public void builtinAppTest() throws InterruptedException {

        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"New Reminder\"]")).click();
        Thread.sleep(3000);
        driver.findElement(AppiumBy.accessibilityId("Quick Entry Title Field")).sendKeys("test reminder");
        Thread.sleep(3000);
        driver.findElement(AppiumBy.accessibilityId("Add")).click();
        Thread.sleep(3000);
    }
}



