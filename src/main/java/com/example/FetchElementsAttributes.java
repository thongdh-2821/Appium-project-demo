package com.example;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class FetchElementsAttributes {
    
    public static void main(String[] args) throws Exception{
       AppiumDriver driver = StartDriverSession.initializeDriver();

       By accessibility = AppiumBy.accessibilityId("Accessibility");
       System.out.println("text:" + driver.findElement(accessibility).getText());
       System.out.println("text:" + driver.findElement(accessibility).getAttribute("text"));
       System.out.println("enabled:" + driver.findElement(accessibility).getAttribute("enabled"));
       System.out.println("checked:" + driver.findElement(accessibility).getAttribute("checked"));
       System.out.println("selected:" + driver.findElement(accessibility).getAttribute("selected"));
       System.out.println("displayed:" + driver.findElement(accessibility).getAttribute("displayed"));

       System.out.println("selected" + driver.findElement(accessibility).isSelected());
       System.out.println("enabled" + driver.findElement(accessibility).isEnabled());
    }
}
