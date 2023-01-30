package com.eurotech.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class day1 {

    AppiumDriver<MobileElement> driver;

    @Test
    public void test1() throws MalformedURLException, InterruptedException {


        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        //1 way
      //  desiredCapabilities.setCapability("platformName","Android");

        //2 way
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION,"11");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel_2");

        //Set Application's package name
        desiredCapabilities.setCapability("appPackage","com.google.android.calculator");


        //Set Application's Activity name (Launcher activity name)
        desiredCapabilities.setCapability("appActivity","com.android.calculator2.Calculator");



        driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);


        // 2+3 = 5

        MobileElement digit2 = driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
        MobileElement digit3 = driver.findElementByAccessibilityId("3");

        MobileElement plus = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"plus\"]"));

        MobileElement equals = driver.findElement(By.id("com.google.android.calculator:id/eq"));

        digit2.click();
        plus.click();
        digit3.click();
        equals.click();

        MobileElement result = driver.findElement(By.id("com.google.android.calculator:id/result_final"));
        String actualResult = result.getText();
        Assert.assertEquals("5",actualResult);


        //Test case , verify that 5 * 8 = 40

        MobileElement digit5 = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
        MobileElement digit8 = driver.findElement(By.id("com.google.android.calculator:id/digit_8"));

        MobileElement multiply = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"multiply\"]"));


        digit5.click();
        multiply.click();
        digit8.click();
        equals.click();

        actualResult = result.getText();
        Assert.assertEquals("40",actualResult);

        //Homework for tomorrow
        // create a method to get all digits
        // 91- 74 = 17 verify the result


        // 18:55 UK time

        Thread.sleep(2000);
        driver.closeApp();

    }
}
