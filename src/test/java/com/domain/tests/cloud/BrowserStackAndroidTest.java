package com.domain.tests.cloud;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackAndroidTest {


    AppiumDriver driver;


    @BeforeTest
    public void setup() throws MalformedURLException, InterruptedException {

        String username = "senoldemir_saBk76";
        String accessKey = "CQvxdkvsyqMipz5zdbFY";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("os_version", "13.0");
        capabilities.setCapability("device", "Google Pixel 7");
        capabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
        capabilities.setCapability("project", "Sample Project");
        capabilities.setCapability("build", "build 1.0");

        URL url = new URL("https://"+username+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub");
        driver = new AndroidDriver(url, capabilities);

        Thread.sleep(4000);


    }

    @AfterTest
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }


    }

    @Test
    public void cloudAppTest() throws InterruptedException {

        driver.findElement(By.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("mobile testing");
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));


        Thread.sleep(3000);

    }




}
