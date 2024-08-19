package com.example;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Demotest {

    private AndroidDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        try {
            driver = (AndroidDriver) StartDriverSession.initializeDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize Appium driver", e);
        }
    }

    @SuppressWarnings("deprecation")
    @Test
    public void sampleTest() throws Exception {
        By views = AppiumBy.accessibilityId("Views");
        By textFields = AppiumBy.accessibilityId("TextFields");
        By editText = AppiumBy.id("io.appium.android.apis:id/edit");
        By screenOfViews = AppiumBy.id("android:id/list");

        // Chờ và nhấp vào phần tử Views
        wait.until(ExpectedConditions.visibilityOfElementLocated(views)).click();

        // Swipe
        wait.until(ExpectedConditions.visibilityOfElementLocated(screenOfViews));

        // Lấy kích thước màn hình
        Dimension size = driver.manage().window().getSize();

        // Tính toán các tọa độ cho thao tác cuộn
        int startX = size.width / 2;          // điểm xuất phát theo chiều ngang
        int startY = (int) (size.height * 1); // điểm xuất phát theo chiều dọc
        int endX = size.width / 2;            // điểm kết thúc theo chiều ngang
        int endY = (int) (size.height * -1); // điểm kết thúc theo chiều dọc

        // Thực hiện thao tác cuộn
        TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
        touchAction.press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(endX, endY))
                    .release()
                    .perform();

        // Chờ và nhấp vào phần tử TextFields
        wait.until(ExpectedConditions.visibilityOfElementLocated(textFields)).click();

        // Chờ và gửi văn bản vào trường văn bản
        WebElement editTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(editText));
        editTextElement.sendKeys("my text");
        Thread.sleep(300);
        editTextElement.clear();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
