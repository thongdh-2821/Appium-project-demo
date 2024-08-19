package com.example;

import java.net.URL;
import java.time.Duration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class StartDriverSession {
    // public static void main(String[] args) throws MalformedURLException {
    // // String appUrl = System.getProperty("user.dir") + File.separator + "src" +
    // File.separator + "main" + File.separator + "resources" + File.separator +
    // "ApiDemos-debug.apk";
    // String appPath = "C:/Users/do.hoang.thong/Downloads/ApiDemos-debug.apk"; //
    // nơi lưu trữ file app apk
    // UiAutomator2Options options = new
    // UiAutomator2Options().setDeviceName("pixel_3a").setAutomationName("UiAutomator2").setApp(appPath);

    // @SuppressWarnings("deprecation")
    // URL url = new URL("http://127.0.0.1:4723/wd/hub");
    // AppiumDriver driver = new AndroidDriver(url, options);

    // }

    // Sử dụng Avd để tự động mở máy ảo lên khi test
    // public static void main(String[] args) throws MalformedURLException {

    // // DesiredCapabilities caps = new DesiredCapabilities();

    // String appPath = "C:/Users/do.hoang.thong/Downloads/ApiDemos-debug.apk"; //
    // nơi lưu trữ file app apk

    // UiAutomator2Options options = new
    // UiAutomator2Options().setDeviceName("pixel_3a")
    // .setAutomationName("UiAutomator2").setAppActivity("val").setAvd("Pixel_3a_API_31")
    // .setAvdLaunchTimeout(Duration.ofMillis(880000))
    // .setApp(appPath);
    // // Avd dùng để start máy ảo
    // // run: abd shell dumsys windown | grep -E mCurrentFocus để lấy giá trị cho
    // val
    // // caps.setCapability(MobileBrowserType.ANDROID, appPath);
    // @SuppressWarnings("deprecation")
    // URL url = new URL("http://127.0.0.1:4723/wd/hub");
    // AppiumDriver driver = new AndroidDriver(url, options);
    // }

    public static AppiumDriver initializeDriver() throws Exception {

        // DesiredCapabilities caps = new DesiredCapabilities();
        String appPath = "C:/Users/FileAPK/ApiDemos-debug.apk"; // nơi lưu trữ file app apk

        UiAutomator2Options options = new UiAutomator2Options().setDeviceName("pixel_3a")
                .setAutomationName("UiAutomator2")
                .setAvd("Pixel_3a_API_31")
                .setAvdLaunchTimeout(Duration.ofMinutes(1))
                .setNewCommandTimeout(Duration.ofMinutes(1))
                .setApp(appPath);

        // Avd dùng để start máy ảo
        // run: abd shell dumsys windown | grep -E mCurrentFocus để lấy giá trị cho val
        // caps.setCapability(MobileBrowserType.ANDROID, appPath);
        @SuppressWarnings("deprecation")
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AppiumDriver driver = new AndroidDriver(url, options);

        System.out.println("session id:" + driver.getSessionId());
        return driver;
    }


}