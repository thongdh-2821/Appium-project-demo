package com.example;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class SampleTest {

    private AndroidDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp () {
        String appPath = "C:/Users/FileAPK/ApiDemos-debug.apk"; // nơi lưu trữ file app apk
            UiAutomator2Options options = new UiAutomator2Options().setDeviceName("pixel_3a")
            .setAutomationName("UiAutomator2")
            .setAvd("Pixel_3a_API_31")
            .setAvdLaunchTimeout(Duration.ofMillis(180000))
            .setNewCommandTimeout(Duration.ofMillis(10000))
            .setApp(appPath);

        try {

            @SuppressWarnings("deprecation")
            URL appiumServerUrl = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver(appiumServerUrl, options);
            wait = new WebDriverWait(driver, Duration.ofMillis(000));

        } catch (MalformedURLException e) {
            e.printStackTrace();
            driver = null; // Trong trường hợp này, driver sẽ là null
        }
    }

    @Test
    public void sampleTest() {
        // if (driver != null) {  // Kiểm tra driver không null trước khi sử dụng
        // //     WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
        // //     WebElement el1 = driver.findElement(AppiumBy.accessibilityId("Access'ibility"));
        // //     el1.click();
        // //     WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMillis(500));
        // //     WebElement el2 = driver.findElement(AppiumBy.accessibilityId("Accessibility Node Querying"));
        // //     el2.click();
        // // } else {
        // //     System.out.println("Driver is not initialized. Test cannot proceed.");
        // // }

        clickElementByAccessibilityId("Access'ibility");
        clickElementByAccessibilityId("Accessibility Node Querying");
    }

        private void clickElementByAccessibilityId(String accessibilityId) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId(accessibilityId)));
        element.click();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}