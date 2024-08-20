package com.example;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;


// Click và kéo thả
public class AndroidGestures {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = StartDriverSession.initializeDriver();
        longClickGesture(driver);
        // clickGesture(driver);
        dragGesture(driver);
    }

    public static void longClickGesture(AppiumDriver driver) {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        // action long click with element
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
            "elementId", ((RemoteWebElement) element).getId(),
            "duration", 1000
        ));

        // action long click with location
        // driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
        //     "x", 216,
        //     "y", 570,
        //     "duration", 1000
        // ));
    }

    // clickGesture đang không hộ trợ...
    // public static void clickGesture(AppiumDriver driver) {
    //     WebElement elementClick = driver.findElement(AppiumBy.accessibilityId("Views"));
    //     System.out.println("\n\n aaaa" + elementClick + "\n\n =============");

    //     driver.executeScript("mobile: clickGesture", ImmutableMap.of(
    //         "elementId", ((RemoteWebElement) elementClick).getId()
    //         ));
    //     }

    private static void dragGesture(AppiumDriver driver) {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
        
        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
        "elementId", ((RemoteWebElement) element).getId(),
        "endX", 650,
        "endY", 580
        ));
        }
}
