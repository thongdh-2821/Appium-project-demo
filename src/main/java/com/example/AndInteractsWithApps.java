package com.example;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
//Android: Interacting with Apps
public class AndInteractsWithApps {

    public static void main(String[] args) throws Exception {
        AndroidDriver driver = (AndroidDriver) CreateDriverSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By views = AppiumBy.accessibilityId("Views");
        driver.findElement(views).click();

        Thread.sleep(5000);

        driver.terminateApp("io.appium.android.apis");

        System.out.println(driver.queryAppState("io.appium.android.apis"));
        Thread.sleep(5000);
        driver.terminateApp("io.appium.android.apis");
        Thread.sleep(5000);
        System.out.println(driver.queryAppState("io.appium.android.apis"));
   //     driver.runAppInBackground(Duration.ofMillis(5000));
        driver.terminateApp("io.appium.android.apis");
        Thread.sleep(5000);
        driver.activateApp("com.android.settings");
        Thread.sleep(5000);
        driver.activateApp("io.appium.android.apis");
   //     System.out.println(driver.isAppInstalled("io.appium.android.apis"));
       // driver.terminateApp("io.appium.android.apis");
        String andAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
//        driver.installApp(andAppUrl, new AndroidInstallApplicationOptions().withReplaceEnabled());

    }
}
