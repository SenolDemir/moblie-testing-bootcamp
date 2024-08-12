package com.domain.tests.ios;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import java.io.File;
import java.net.URL;
import java.util.HashMap;

public class SimulatorExternalApp {


    private AppiumDriver driver;
    private static AppiumDriverLocalService server;


    @BeforeTest
    public static void startAppiumServer() {

        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();

        // Tell serviceBuilder where node is installed. Or set this path in an environment variable named NODE_PATH
        serviceBuilder.usingDriverExecutable(new File("/Users/nuvanda/.nvm/versions/node/v22.4.1/bin/node"));
        // Tell serviceBuilder where Appium is installed. Or set this path in an environment variable named APPIUM_PATH
        serviceBuilder.withAppiumJS(new File("/Users/nuvanda/.nvm/versions/node/v22.4.1/bin/appium"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();

        // The XCUITest driver requires that a path to the Carthage binary is in the PATH variable. I have this set for my shell, but the Java process does not see it. It can be inserted here.
        HashMap<String, String> environment = new HashMap();
        environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));
        serviceBuilder.withEnvironment(environment);

        server = AppiumDriverLocalService.buildService(serviceBuilder);
        server.start();

    }

    @BeforeClass
    public void startSession(){


        String appPath = "/Users/nuvanda/SDET/sdet library/Mobile Testing/test data/iOS.Simulator.SauceLabs.Mobile.Sample.app.2.7.1.app";

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
        caps.setCapability("appium:app", appPath);

        driver = new IOSDriver(server.getUrl(), caps);

    }


    @Test
    public void sauceAppTest() throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("test-Username")).sendKeys("problem_user");
        driver.findElement(AppiumBy.accessibilityId("test-Password")).sendKeys("secret_sauce");
        driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();
        Thread.sleep(5000);
    }



    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }

    @AfterTest
    public static void stopAppiumServer() {
        server.stop();
    }






}
