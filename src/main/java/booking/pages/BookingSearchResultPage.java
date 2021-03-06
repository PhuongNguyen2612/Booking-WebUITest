package booking.pages;

import booking.BaseBookingPage;
import core.logger.MyLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This is a booking search result page class presentation
 */
public class BookingSearchResultPage extends BaseBookingPage {

    @FindBy(id="ss")
    private WebElement searchDestinationField;

    /**
     * Method get value attribute of search destination field
     *
     * @return String
     */
    public String getSearchDestinationFieldValue(){
        String value = searchDestinationField.getAttribute("value");
        MyLogger.LOGGER.info("Get destination value: "+value);
        return value;
    }
}
