package com.phuong.testBookingWebApp.selenium;

import booking.pages.HomeBookingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookingTest extends SeleniumBaseTest {

    @Test
    public void openBookingApp(){
        Assert.assertEquals(true, true);
    }

    @Test
    public void testSelectLanguage_English(){
        String title = new HomeBookingPage()
                .clickLanguagesButton()
                .clickEnglishLanguageButton()
                .getTitle();
        Assert.assertTrue(title.contains("Official site"));
    }

    @Test
    public void testSelectDestination_Paris(){
        new HomeBookingPage().setTextToDestinationSearchField("Paris");
    }

    @Test
    public void testChooseArrivalDates(){
        HomeBookingPage homeBookingPage = new HomeBookingPage();
        homeBookingPage.clickSelectDatesButton();
        homeBookingPage.selectArrivalDate(13,"February");
        homeBookingPage.selectArrivalDate(15,"March");
        Assert.assertTrue(homeBookingPage.getCheckInDateText().contains("Feb 13"));
        Assert.assertTrue(homeBookingPage.getCheckOutDateText().contains("Mar 15"));
    }

    @Test
    public void testSelectNumOfPerson() {
        HomeBookingPage homeBookingPage = new HomeBookingPage();
        homeBookingPage.clickSelectNumOfPersonButton();
        homeBookingPage.setAdultNumber(6);
        Assert.assertEquals(homeBookingPage.getCurrentAdultNumber(),6);
    }
}