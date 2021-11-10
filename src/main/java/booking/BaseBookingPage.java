package booking;

import core.logger.MyLogger;
import core.webdriver.DriverWrapper;
import org.openqa.selenium.support.PageFactory;

public class BaseBookingPage {

    public BaseBookingPage() {
        PageFactory.initElements(DriverWrapper.getDriver(),this);
    }

    /**
     * Method to get title of current page
     *
     * @return String
     */
    public String getTitle(){
        String title = DriverWrapper.getDriver().getTitle();
        MyLogger.LOGGER.info("Current page title: "+title);
        return title;
    }
}
