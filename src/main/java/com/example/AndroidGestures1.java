package com.example;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;


// Zoom in or out
public class AndroidGestures1 {
    public static void main(String[] args) throws Exception {
        System.out.println("=========== debug ==============" );
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        System.out.println("=========== debug 1==============" );
        pinchOpenGesture(driver);
        System.out.println("=========== pinchOpenGesture ==============" );
    }

    public static void pinchOpenGesture(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"SKIP\"]")).click();
        Thread.sleep(5000);
        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
            "left", 200,
            "top",  400,
            "width", 600,
            "height", 600,
            "percent", 0.75
        ));
    }
}
