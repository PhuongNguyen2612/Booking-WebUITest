package com.phuong.testBookingWebApp.selenium;

import com.phuong.testBookingWebApp.BaseTest;
import core.webdriver.DriverWrapper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class SeleniumBaseTest extends BaseTest {

    @BeforeMethod
    public void preCondition() {
        DriverWrapper.getDriver().navigate().to("https://www.booking.com/");
    }

    @AfterTest
    public void postCondition() {
        DriverWrapper.getDriver().quit();
    }

}
