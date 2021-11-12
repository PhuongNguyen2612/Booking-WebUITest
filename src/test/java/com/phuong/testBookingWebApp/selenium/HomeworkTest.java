package com.phuong.testBookingWebApp.selenium;

import booking.pages.BookingSearchResultPage;
import booking.pages.HomeBookingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeworkTest extends SeleniumBaseTest {

    @Test
    public void testSearchOnHomePage(){
        HomeBookingPage homeBookingPage = new HomeBookingPage().clickLanguagesButton()
                                                    .clickEnglishLanguageButton();
        homeBookingPage.setTextToDestinationSearchField("Paris");
        homeBookingPage.clickSelectDatesButton();
        homeBookingPage.selectArrivalDate(13,"February");
        homeBookingPage.selectArrivalDate(15, "February");
        homeBookingPage.clickSelectNumOfPersonButton();
        homeBookingPage.setAdultNumber(2);

        BookingSearchResultPage bookingSearchResultPage = homeBookingPage.clickSearchButton();
        String searchDestinationFieldValue = bookingSearchResultPage.getSearchDestinationFieldValue();
        Assert.assertEquals(searchDestinationFieldValue,"Paris");
    }
}
