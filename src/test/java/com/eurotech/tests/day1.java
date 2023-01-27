package com.eurotech.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class day1 {

    AppiumDriver<MobileElement> driver;

    @Test
    public void test1() throws MalformedURLException {


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














    }
}
