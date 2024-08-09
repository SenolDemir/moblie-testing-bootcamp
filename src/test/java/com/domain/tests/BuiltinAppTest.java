package com.domain.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

public class BuiltinAppTest {


    AppiumDriver driver = null;

    @BeforeTest
    public void setup() throws MalformedURLException {


        String path = "/Users/nuvanda/SDET/sdet library/Mobile Testing/test data/Calculator_8.6.1.apk";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:platformVersion", "15.0");
        caps.setCapability("appium:deviceName", "emulator-5554");
        caps.setCapability("appium:appPackage", "com.google.android.deskclock");
        caps.setCapability("appium:appActivity", "com.android.deskclock.DeskClock");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);



    }

    @AfterTest
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    public void setAlarmByDragAndDrop() throws InterruptedException {

        // open alarm tab
        driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Alarm\"]")).click();
        Thread.sleep(3000);

        //click to add alarm button
        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Add alarm\"]")).click();

        // Create drag and drop action
        WebElement source = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"10 o'clock\"]"));
        WebElement target = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"11 o'clock\"]"));
        Point sourceElementCenter = getCenterOfElement(source.getLocation(), source.getSize());
        Point targetElementCenter = getCenterOfElement(target.getLocation(), target.getSize());

        PointerInput finger1 = new PointerInput (PointerInput.Kind. TOUCH,"finger1");
        Sequence sequence = new Sequence (finger1, 1)
                .addAction (finger1.createPointerMove (Duration.ZERO, PointerInput.Origin.viewport(), sourceElementCenter))
                .addAction (finger1.createPointerDown(PointerInput.MouseButton. LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(588)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(588), PointerInput.Origin.viewport(), targetElementCenter))
                .addAction (finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));

        Thread.sleep(2000);

        String text = driver.findElement(By.id("com.google.android.deskclock:id/material_hour_tv")).getText();
        Assert.assertEquals(Integer.valueOf(text), 11);


    }

    private Point getCenterOfElement(Point location, Dimension size)
    {
        return new Point(location.getX() + size.getWidth()/2,
                location.getY()+ size.getHeight()/2);
    }



}
