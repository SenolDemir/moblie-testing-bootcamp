package com.domain.tests.android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class EmulatorMobileChrome {


    AppiumDriver driver = null;

    @BeforeTest
    public void setup() throws MalformedURLException {

//        UiAutomator2Options options = new UiAutomator2Options()
//                .setPlatformName("Android")
//                .setDeviceName("emulator-5554")
//                .setPlatformVersion("12.0")
//                .noReset().withBrowserName("chrome");
//
//        driver = new AppiumDriver(new URL("http://127.0.0.1:4723"), options);


        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:platformVersion", "15.0");
        caps.setCapability("appium:deviceName", "emulator-5554");
        caps.setCapability("appium:noReset", true);
        caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        caps.setCapability(CapabilityType.BROWSER_VERSION, "127.0.6533.100");

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723"), caps);





    }


    @Test
    public void mobileChromeTest() throws InterruptedException {

        driver.get("https://www.wikipedia.org/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(5000);

    }

    @AfterTest
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}
