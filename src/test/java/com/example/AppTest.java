package com.example;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    // AndroidDriver driver;
    WebDriverWait wait;
    /**
     * Rigorous Test :-)
     */
    @Test
      public void setUp () throws MalformedURLException  {
        String appPath = "C:/Users/FileAPK/ApiDemos-debug.apk"; // nơi lưu trữ file app apk
            UiAutomator2Options options = new UiAutomator2Options().setDeviceName("pixel_3a")
            .setAutomationName("UiAutomator2")
            .setAvd("Pixel_3a_API_31")
            .setAvdLaunchTimeout(Duration.ofMillis(1800000))
            .setNewCommandTimeout(Duration.ofMillis(100000))
            .setApp(appPath);

            @SuppressWarnings("deprecation")
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            AndroidDriver driver = new AndroidDriver(url, options);
            System.out.println("===========" + driver + "===========");
            System.out.println(driver.getSessionId());
            driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(3));
    }

        public void sampleTest() {
        
        
        clickElementByAccessibilityId("Access'ibility");
        clickElementByAccessibilityId("Accessibility Node Querying");
    }
    
    private void clickElementByAccessibilityId(String accessibilityId) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId(accessibilityId)));
        element.click();
    }

    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    // public void tearDown() {
    //     if (driver != null) {
    //         driver.quit();
    //     }
    // }
}
