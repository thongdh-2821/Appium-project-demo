// package com.example;

// import java.io.File;
// import java.net.URL;

// import org.openqa.selenium.remote.DesiredCapabilities;

// import io.appium.java_client.AppiumDriver;

// public class CreateDriverSession {
    
//     public static AppiumDriver initializeDriver(String platformName) throws Exception {
//         DesiredCapabilities caps = new DesiredCapabilities();
//         caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
//         caps.setCapability("newCommandTimeout", 300);

//         @SuppressWarnings("deprecation")
//         URL url = new URL("http://127.0.0.1:4723/wd/hub");

//         switch (platformName) {
//             case "Android" -> {
//                 // String appPath = "C:/Users/FileAPK/ApiDemos-debug.apk"; // nơi lưu trữ file app apk

//                 // UiAutomator2Options options = new UiAutomator2Options()
//                 //         .setDeviceName("pixel_3a")
//                 //         .setAutomationName("UiAutomator2")
//                 //         .setAvdLaunchTimeout(Duration.ofMillis(180000))
//                 //         .setNewCommandTimeout(Duration.ofMillis(300))
//                 //         .setApp(appPath);

//                 // AppiumDriver driver = new AndroidDriver(url, options);

//                 // System.out.println("session id:" + driver.getSessionId());

//                 // return driver;

//                 caps.setCapability(MobileCapabilityType.DEVICE_NAME, "pixel_3a");
//                 caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
//                 // caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
//                 String andAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
//                         + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
//                 // caps.setCapability(MobileCapabilityType.APP, "andAppUrl");
//                 caps.setCapability(MobileCapabilityType.appPackage, "com.google.android.apps.maps");
//                 caps.setCapability(MobileCapabilityType.appActivity, "com.google.android.maps.MapActivity");
//                 return new AppiumDriver (url, caps);

//             } 
//             case "IOS" -> {
//                 caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iphone 11");
//                 caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
//                 caps.setCapability(MobileCapabilityType.UDID, "77F6BBF0-8877-4EDF-8C8C-99DBE64A93FF");

//                 String iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
//                         + File.separator + "resources" + File.separator + "UIKitCatalog-iphonesimulator.app";
//                 caps.setCapability(MobileCapabilityType.APP, "iOSAppUrl");
                
//                 caps.setCapability("simulatorstartupTimeout", 180000);
//                 caps.setCapability("bundleId", "com.example.apple-samplecode.UICatalog");

//                 return new AppiumDriver (url, caps);
//             }
//             default -> throw new Exception("invalid platform");
//         } 
//     }

//     public static class MobileCapabilityType {

//         public static String appActivity;
//         public static String appPackage;
//         public static String PLATFORM_NAME;
//         public static String DEVICE_NAME;
//         public static String AUTOMATION_NAME;
//         public static String UDID;
//         public static String APP;

//     }
// }
// =====

package com.example;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.AppiumDriver;

public class CreateDriverSession {
    
    public static AppiumDriver initializeDriver(String platformName) throws Exception {
        @SuppressWarnings("deprecation")
        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        switch (platformName) {
            case "Android" -> {
                System.out.println("=========== Apply Android ==============" );
                // String appPath = "C:/Users/FileAPK/ApiDemos-debug.apk"; // nơi lưu trữ file app apk

                    UiAutomator2Options options = new UiAutomator2Options()
                        .setDeviceName("pixel_3a")
                        .setAvd("Pixel_3a_API_31")
                        .setAutomationName("UiAutomator2")
                        .setApp(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                                + File.separator + "resources" + File.separator + "ApiDemos-debug.apk")

                        // cài và mở app S learn        
                        // .setApp(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                        // + File.separator + "resources" + File.separator + "edx-stg-release-1.4.0.apk")
                        // .setApp(appPath)
                        .setAvdLaunchTimeout(Duration.ofMinutes(1))
                        .setNewCommandTimeout(Duration.ofMinutes(1))
                        .setAdbExecTimeout(Duration.ofMinutes(1));

                        // Cài mở app google map có sẵn trong máy
                        // .setAppPackage("com.google.android.apps.maps")
                        // .setAppActivity("com.google.android.maps.MapsActivity");
                    
                    AppiumDriver driver = new AndroidDriver(url, options);
                    
                    System.out.println("=========== Apply Android 1 ==============" );
                    System.out.println(driver);
                    System.out.println("session id:" + driver.getSessionId());
                
                    return driver;
            } 
            
            // Xử lý các trường hợp khác nếu có
        
        
            case "iOS" -> {
                System.out.println("=========== Apply IOS ==============" );
                XCUITestOptions options = new XCUITestOptions()
                    .setDeviceName("iPhone 11")
                    .setAutomationName("XCUITest")
                    .setUdid("77F6BBF0-8877-4EDF-8C8C-99DBE64A93FF")
                    .setApp(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                            + File.separator + "resources" + File.separator + "UIKitCatalog-iphonesimulator.app")
                    .setNewCommandTimeout(Duration.ofMinutes(1))
                    .setBundleId("com.example.apple-samplecode.UICatalog")
                    .setSimulatorStartupTimeout(Duration.ofMinutes(1));

                return new IOSDriver(url, options);
            }
            default -> throw new Exception("Invalid platform: " + platformName);
        }
    }
}

// public static AppiumDriver initializeDriver() throws Exception {

//     // DesiredCapabilities caps = new DesiredCapabilities();
//     String appPath = "C:/Users/FileAPK/ApiDemos-debug.apk"; // nơi lưu trữ file app apk

//     UiAutomator2Options options = new UiAutomator2Options().setDeviceName("pixel_3a")
//             .setAutomationName("UiAutomator2")
//             .setAvd("Pixel_3a_API_31")
//             .setAvdLaunchTimeout(Duration.ofMinutes(1))
//             .setNewCommandTimeout(Duration.ofMinutes(1))
//             // .setAppPackage("com.google.android.apps.maps")
//             .setAppPackage("com.google.android.apps.maps");
//             // .setAppActivity("com.google.android.maps.MapActivity");
//             // .setApp(appPath);

//     // Avd dùng để start máy ảo
//     // run: abd shell dumsys windown | grep -E mCurrentFocus để lấy giá trị cho val
//     // caps.setCapability(MobileBrowserType.ANDROID, appPath);
//     @SuppressWarnings("deprecation")
//     URL url = new URL("http://127.0.0.1:4723/wd/hub");
//     AppiumDriver driver = new AndroidDriver(url, options);

//     System.out.println("session id:" + driver.getSessionId());
//     return driver;
//     }
// }
