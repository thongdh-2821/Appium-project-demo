package com.example;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class CreateDriverSession {
    
    public static AppiumDriver initializeDriver(String platformName) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        caps.setCapability("newCommandTimeout", 300);

        @SuppressWarnings("deprecation")
        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        switch (platformName) {
            case "Android" -> {
                String appPath = "C:/Users/KingSpecOfficial/Downloads/ApiDemos-debug.apk"; // nơi lưu trữ file app apk

                UiAutomator2Options options = new UiAutomator2Options()
                        .setDeviceName("pixel_3a")
                        .setAutomationName("UiAutomator2")
                        .setAvdLaunchTimeout(Duration.ofMillis(180000))
                        .setNewCommandTimeout(Duration.ofMillis(300))
                        .setApp(appPath);

                AppiumDriver driver = new AndroidDriver(url, options);

                System.out.println("session id:" + driver.getSessionId());

                return driver;
            } 
            case "IOS" -> {
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iphone 11");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                caps.setCapability(MobileCapabilityType.UDID, "77F6BBF0-8877-4EDF-8C8C-99DBE64A93FF");

                String iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                        + File.separator + "resources" + File.separator + "UIKitCatalog-iphonesimulator.app";
                
                caps.setCapability("simulatorstartupTimeout", 180000);
                caps.setCapability("bundleId", "com.example.apple-samplecode.UICatalog");

                return new AppiumDriver (url, caps);
            }
            default -> throw new Exception("invalid platform");
        } 
    }

    private static class MobileCapabilityType {

        private static String PLATFORM_NAME;
        private static String DEVICE_NAME;
        private static String AUTOMATION_NAME;
        private static String UDID;

    }
}
