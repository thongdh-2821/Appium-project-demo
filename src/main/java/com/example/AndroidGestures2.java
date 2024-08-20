package com.example;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

// Scroll

public class AndroidGestures2 {
    public static void main(String[] args) throws Exception {
         AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
         swipeGesture(driver);
    }

    public static void swipeGesture(AppiumDriver driver){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

        WebElement element = driver.findElement(AppiumBy.
        xpath("//*[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[1]"));

        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
            "left", 100, "top", 100, "width", 600, "height", 600,
            "elementId", ((RemoteWebElement) element).getId(),
            "direction", "left",
            "percent", 0.75
        ));
    }
}
