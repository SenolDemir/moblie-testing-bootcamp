package com.domain.tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class AndroidEmulatorTest {

    AppiumDriver driver = null;


    @BeforeTest
    public void setup() throws MalformedURLException {


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
    public void androidEmulatorExternalApp(){

        driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();


    }


    @AfterTest
    public void tearDown(){

        if(driver!=null){
            driver.quit();
        }
    }
}
