package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ScrollExample {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = StartDriverSession.initializeDriver();

        By views = AppiumBy.accessibilityId("Views");
        By textFields = AppiumBy.accessibilityId("TextFields");
        By editText = AppiumBy.id("io.appium.android.apis:id/edit");

        driver.findElement(views).click();

        //Swipe
        // Lấy kích thước màn hình
        Dimension size = driver.manage().window().getSize();

        // Tính toán các tọa độ cho thao tác cuộn
        int startX = size.width / 2;            // điểm xuất phát theo chiều ngang (đang đặt là ở giữa màn hình)
        int startY = (int) (size.height * 1);   // điểm xuất phát theo chiều dọc kéo từ cuối màn hình
        int endX = size.width / 2;              // điểm kết thúc theo chiều ngang (đang đặt là ở giữa màn hình)
        int endY = (int) (size.height * -1);   // điểm kết thúc theo chiều dọc kéo từ cuối màn hình lên 90%

        // Thực hiện thao tác cuộn
        TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
        touchAction.press(PointOption.point(startX, startY))
                   .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                   .moveTo(PointOption.point(endX, endY))
                   .release()
                   .perform();

        driver.findElement(textFields).click();
        driver.findElement(editText).sendKeys("my text");
        Thread.sleep(300);
        driver.findElement(editText).clear();
    }
}