package booking.pages;

import booking.BaseBookingPage;
import core.logger.MyLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectLanguageFrame extends BaseBookingPage {

    @FindBy(xpath = "//a[@hreflang='en-us']")
    private WebElement englishLanguageButton;

    @FindBy(xpath = "//a[@hreflang='vi']")
    private WebElement vietnamLanguageButton;

    @FindBy(xpath = "//a[@hreflang='fr']")
    private WebElement franceLanguageButton;

    public HomeBookingPage clickEnglishLanguageButton(){
        MyLogger.LOGGER.info("Choose English");
        englishLanguageButton.click();
        return new HomeBookingPage();
    }

    public HomeBookingPage clickVietNamLanguageButton(){
        MyLogger.LOGGER.info("Choose VietNam");
        vietnamLanguageButton.click();
        return new HomeBookingPage();
    }

    public HomeBookingPage clickFranceLanguageButton(){
        MyLogger.LOGGER.info("Choose France");
        franceLanguageButton.click();
        return new HomeBookingPage();
    }
}
