package com.phuong.testBookingWebApp.selenium;

import booking.pages.HomeBookingPage;
import com.phuong.testBookingWebApp.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeworkTest extends BaseTest {

    @Test
    public void testSearchOnHomePage(){
        String searchDestinationFieldValue = new HomeBookingPage().clickLanguagesButton()
                                                    .clickEnglishLanguageButton()
                                                    .setTextToDestinationSearchField("Paris")
                                                    .clickSelectDatesButton()
                                                    .selectArrivalDate(13,"February")
                                                    .selectArrivalDate(15, "February")
                                                    .clickSelectNumOfPersonButton()
                                                    .setAdultNumber(2)
                                                    .clickSearchButton()
                                                    .getSearchDestinationFieldValue();
        Assert.assertEquals(searchDestinationFieldValue,"Paris");
    }
}
