package com.phuong.testBookingWebApp;

import core.webdriver.DriverWrapper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    @BeforeMethod
    public void preCondition() {
        DriverWrapper.getDriver().navigate().to("https://www.booking.com/");
    }

    @AfterTest
    public void postCondition() {
        DriverWrapper.getDriver().quit();
    }
}
