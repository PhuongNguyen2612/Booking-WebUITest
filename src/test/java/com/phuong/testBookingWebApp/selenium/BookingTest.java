package com.phuong.testBookingWebApp.selenium;

import booking.pages.HomeBookingPage;
import com.phuong.testBookingWebApp.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookingTest extends BaseTest {

    @Test
    public void openBookingApp(){
        Assert.assertEquals(true, true);
    }

    @Test
    public void testSelectLanguage_English(){
        String title = new HomeBookingPage().clickLanguagesButton().clickEnglishLanguageButton().getTitle();
        Assert.assertTrue(title.contains("Official site"));
    }

    @Test
    public void testSelectDestination_Paris(){
        new HomeBookingPage().setTextToDestinationSearchField("Paris");
    }

    @Test
    public void testChooseArrivalDates(){
        HomeBookingPage homeBookingPage = new HomeBookingPage().clickSelectDatesButton().selectArrivalDate(13,"February").selectArrivalDate(15,"February");
        Assert.assertTrue(homeBookingPage.getCheckInDateText().contains("Feb 13"));
        Assert.assertTrue(homeBookingPage.getCheckOutDateText().contains("Feb 15"));
    }

    @Test
    public void testSelectNumOfPerson() {
        HomeBookingPage homeBookingPage = new HomeBookingPage().clickSelectNumOfPersonButton().clickIncreaseAdultButton();
        Assert.assertEquals(homeBookingPage.getCurrentAdultNumber(),3);
    }
}