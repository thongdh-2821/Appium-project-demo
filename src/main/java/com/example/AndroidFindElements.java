package com.example;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class AndroidFindElements {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = StartDriverSession.initializeDriver();

    WebElement myElementByText = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Accessibility\")"));
    System.out.println("myElementByText " + myElementByText.getText());
    // By myElement1 = AppiumBy.androidUIAutomator("");

    WebElement myElementByClassName = driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\")")).get(2);
    System.out.println("myElementByClassName " + myElementByClassName.getText());

    WebElement myElementByDescription = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"Accessibility\")"));
    System.out.println("myElementByDescription " + myElementByDescription.getText());

    WebElement myElementResourceId = driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")")).get(1);
    System.out.println("myElementResourceId " + myElementResourceId.getText());
    
    //     WebElement myElementAccessibilityId = driver.findElement(AppiumBy.accessibilityId("Accessibility"));
    //     System.out.println("myElementAccessibilityId " + myElementAccessibilityId.getText());

    //     WebElement myElementId = driver.findElements(AppiumBy.id("android:id/text1")).get(1);
    //     System.out.println("myElementId "+ myElementId.getText());

    //     WebElement myElementClass = driver.findElements(AppiumBy.className("android.widget.TextView")).get(1);
    //     System.out.println("myElementClass "+ myElementClass.getText());

    //     WebElement myElementXpath = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]"));
    //     System.out.println("myElementXpath "+myElementXpath.getText());

    //     WebElement myElementXpathShort = driver.findElement(AppiumBy.xpath("//*[@text=\"Accessibility\"]"));
    //     System.out.println("myElementXpathShort "+myElementXpathShort.getText());
    System.out.println("print from");
    }
}
