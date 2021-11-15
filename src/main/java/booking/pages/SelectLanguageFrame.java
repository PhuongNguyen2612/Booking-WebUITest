package booking.pages;

import booking.BaseBookingPage;
import core.logger.MyLogger;
import io.qameta.allure.Step;
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
    @Step("Clicking on English language button")
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
    @Step("Clicking on VietNam language button")
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
    @Step("Clicking on France language button")
    public HomeBookingPage clickFranceLanguageButton(){
        MyLogger.LOGGER.info("Choose France");
        franceLanguageButton.click();
        return new HomeBookingPage();
    }
}
