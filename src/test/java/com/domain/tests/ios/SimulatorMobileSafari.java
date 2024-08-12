package com.domain.tests.ios;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SimulatorMobileSafari {



    AppiumDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {

        DesiredCapabilities iOSSafariCaps = new DesiredCapabilities();
        iOSSafariCaps.setCapability("appium:automationName", "XCUITest");
        iOSSafariCaps.setCapability("appium:platformName", "iOS");
        iOSSafariCaps.setCapability( "appium:deviceName", "iPhone 15 Pro Max");
        iOSSafariCaps.setCapability("appium:udid", "A5EF4F86-717F-43AC-9407-C60BB1D4F08C");
        iOSSafariCaps.setCapability("appium:browserName", "Safari");
        iOSSafariCaps.setCapability(CapabilityType.BROWSER_VERSION, "17.5");
        iOSSafariCaps.setCapability("safari:useSimulator", true);

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723"), iOSSafariCaps);
        System.out.println("***** iOS Mobile Web - Safari *****");
    }


    @AfterTest
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void mobilesafariTest() throws InterruptedException {

        driver.get("https://www.wikipedia.org/");
        Thread.sleep(3000);
    }
}
