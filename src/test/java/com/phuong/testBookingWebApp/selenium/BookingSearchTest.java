package com.phuong.testBookingWebApp.selenium;

import booking.pages.BookingSearchResultPage;
import booking.pages.HomeBookingPage;
import com.phuong.testBookingWebApp.testListener.TestListener;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("Search Stays Tests")
public class BookingSearchTest extends SeleniumBaseTest {

    @Test(priority = 0, description="Search to stays in home page")
    @Severity(SeverityLevel.MINOR)
    @Description("Test Description: Test result page after search stays with all params in home page")
    public void testSearchStaysOnHomePage(){
        HomeBookingPage homeBookingPage = new HomeBookingPage();
        homeBookingPage.clickLanguagesButton().clickEnglishLanguageButton();
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
