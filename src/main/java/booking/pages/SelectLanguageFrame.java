package booking.pages;

import booking.BaseBookingPage;
import core.logger.MyLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This is select language frame which appear after we click on select language button in home page
 */
public class SelectLanguageFrame extends BaseBookingPage {

    @FindBy(xpath = "//a[@hreflang='en-us']")
    private WebElement englishLanguageButton;

    @FindBy(xpath = "//a[@hreflang='vi']")
    private WebElement vietnamLanguageButton;

    @FindBy(xpath = "//a[@hreflang='fr']")
    private WebElement franceLanguageButton;

    /**
     * Method to choose English to be the language for booking page
     *
     * @return HomeBookingPage
     */
    public HomeBookingPage clickEnglishLanguageButton(){
        MyLogger.LOGGER.info("Choose English");
        englishLanguageButton.click();
        return new HomeBookingPage();
    }

    /**
     * Method to choose Vietnamese to be the language for booking page
     *
     * @return HomeBookingPage
     */
    public HomeBookingPage clickVietNamLanguageButton(){
        MyLogger.LOGGER.info("Choose VietNam");
        vietnamLanguageButton.click();
        return new HomeBookingPage();
    }

    /**
     * Method to choose France to be the language for booking page
     *
     * @return HomeBookingPage
     */
    public HomeBookingPage clickFranceLanguageButton(){
        MyLogger.LOGGER.info("Choose France");
        franceLanguageButton.click();
        return new HomeBookingPage();
    }
}
