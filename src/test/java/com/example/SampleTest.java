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
import io.appium.java_client.remote.options.BaseOptions;

public class SampleTest {

    private AndroidDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        var options = new BaseOptions()
                .amend("appium:newCommandTimeout", 3600)
                .amend("appium:connectHardwareKeyboard", true);

        try {

            @SuppressWarnings("deprecation")
            URL appiumServerUrl = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver(appiumServerUrl, options);
            wait = new WebDriverWait(driver, Duration.ofMillis(5000));
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