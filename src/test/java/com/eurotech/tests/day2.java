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

public class day2 {


    AppiumDriver<MobileElement> driver;
    @Test
    public void amazon() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION,"11");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel_2");

        //Set Application's package name
        desiredCapabilities.setCapability("appPackage","com.amazon.mShop.android.shopping");

        //Set Application's Activity name (Launcher activity name)
        desiredCapabilities.setCapability("appActivity","com.amazon.windowshop.home.HomeLauncherActivity");

        driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);

        //open amazon app
        //click skip sign in
        //search Apple Watch
        // click Apple Watch series 7
        Thread.sleep(3000);

        MobileElement skipSignIn = driver.findElement(By.xpath("//*[@text='Skip sign in']"));


        Thread.sleep(2000);
        skipSignIn.click();
        Thread.sleep(2000);
        MobileElement searchBox = driver.findElement(By.xpath("//*[@text='Search Amazon']"));

        searchBox.click();
        searchBox.sendKeys("Apple Watch");


        //*[@text='Skip sign in']  ---> Mobile test (Appium)
        //*[text()='Skip sign in'] ---> Selenium

        MobileElement series7 = driver.findElement(By.xpath("//*[@text='apple watch series 7']"));
        series7.click();

        Thread.sleep(2000);
        MobileElement resultTitle = driver.findElement(By.xpath("//*[@text='RESULTS']"));
        Assert.assertTrue(resultTitle.isDisplayed());


        Thread.sleep(2000);

        driver.closeApp();


    }
}
