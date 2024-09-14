package com.domain.tests.android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;


import java.net.MalformedURLException;
import java.net.URL;

public class EmulatorExternalApp {

    AppiumDriver driver = null;

    @BeforeClass
    public void startSession() throws MalformedURLException {


        String path = "/Users/nuvanda/SDET/sdet library/Mobile Testing/test data/Calculator_8.6.1.apk";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:platformVersion", "15.0");
        caps.setCapability("appium:deviceName", "emulator-5554");
        caps.setCapability("appium:app", path);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);

    }



    @Test
    public void test2() throws InterruptedException {


        WebElement multiply = driver
                .findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"multiply\"]"));
        WebElement equals = driver.findElement(AppiumBy.accessibilityId("equals"));

        getDigit(9).click();
        Thread.sleep(2000);

        multiply.click();
        getDigit(6).click();
        equals.click();

        String result = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
        Assert.assertEquals(Integer.valueOf(result), 54);


    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }

    public WebElement getDigit(int num) {
        return driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"" + num + "\"]"));
    }



}
