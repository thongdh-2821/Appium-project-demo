package com.example;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class DifferentWaysOfDefiningElements {
    public static void main(String[] args) throws Exception{
        AppiumDriver driver = StartDriverSession.initializeDriver();
        
        WebElement myElementAccessibilityId = driver.findElement(AppiumBy.accessibilityId("Accessibility"));
        System.out.println("myElementAccessibilityId: " + myElementAccessibilityId.getText());
    }

}
