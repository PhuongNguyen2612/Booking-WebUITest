package booking.pages;

import booking.BaseBookingPage;
import core.logger.MyLogger;
import core.webdriver.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomeBookingPage extends BaseBookingPage {

    @FindBy(xpath = "//button[@data-modal-id='language-selection']")
    private WebElement languageButton;

    @FindBy(id="ss")
    private WebElement searchDestinationField;

    @FindBy(className = "xp__dates-inner")
    private WebElement selectDatesButton;

    @FindBy(xpath = "//div[@data-bui-ref='calendar-next']")
    private WebElement nextMonthButton;

    @FindBy(xpath = "//div[@class='sb-date-field__display'][@data-placeholder='Check-in']")
    private WebElement checkInDateLabel;

    @FindBy(xpath = "//div[@class='sb-date-field__display'][@data-placeholder='Check-out']")
    private WebElement checkOutDateLabel;

    @FindBy(className = "bui-calendar__month")
    private List<WebElement> currentMonths;

    @FindBy(xpath = "//div[@class='xp__input-group xp__guests']")
    private WebElement selectNumOfPersonButton;

    @FindBy(xpath = "//button[@class='sb-searchbox__button ']")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id='xp__guests__inputs-container']/descendant::span[@class='bui-stepper__display'][1]")
    private WebElement adultNumber;

    @FindBy(xpath = "//*[@id='xp__guests__inputs-container']/descendant::button[2]")
    private WebElement decreaseAdultButton;

    @FindBy(xpath = "//*[@id='xp__guests__inputs-container']/descendant::button[2]")
    private WebElement increaseAdultButton;

    public SelectLanguageFrame clickLanguagesButton(){
        MyLogger.LOGGER.info("Click language button");
        languageButton.click();
        return new SelectLanguageFrame();
    }

    public HomeBookingPage setTextToDestinationSearchField(String text){
        MyLogger.LOGGER.info("add '"+text+"' to destination field");
        searchDestinationField.sendKeys(text);
        return this;
    }

    public HomeBookingPage clickSelectDatesButton(){
        MyLogger.LOGGER.info("click select dates button");
        selectDatesButton.click();
        return this;
    }

    public HomeBookingPage clickNextMonth(){
        MyLogger.LOGGER.info("Click next month");
        nextMonthButton.click();
        return this;
    }

    public String getCheckInDateText(){
        String checkInDateText = checkInDateLabel.getText();
        MyLogger.LOGGER.info("Get check in date: "+checkInDateText);
        return checkInDateText;
    }

    public String getCheckOutDateText(){
        String checkOutDateText = checkOutDateLabel.getText();
        MyLogger.LOGGER.info("Get check in date: "+checkOutDateText);
        return checkOutDateText;
    }

    public HomeBookingPage selectArrivalDate(int day, String month){
        selectMonth(month);
        String dateMonth = day+" "+month;
        MyLogger.LOGGER.info("Select "+day);
        DriverWrapper.getDriver().findElement(By.xpath("//span[contains(@aria-label,'"+dateMonth+"')]")).click();
        return this;
    }

    public void selectMonth(String month){
        while (!haveMonth(month)){
            clickNextMonth();
            try{
                Thread.sleep(500);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private boolean haveMonth(String month){
        for (WebElement element: currentMonths) {
            if (element.getText().contains(month)){
                return true;
            }
        }
        return false;
    }

    public HomeBookingPage clickSelectNumOfPersonButton(){
        MyLogger.LOGGER.info("Click select number of person button");
        selectNumOfPersonButton.click();
        return this;
    }

    public BookingSearchResultPage clickSearchButton(){
        MyLogger.LOGGER.info("Click search");
        searchButton.click();
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return new BookingSearchResultPage();
    }

    public int getCurrentAdultNumber(){
        int currentAdultNumber = Integer.parseInt(adultNumber.getText());
        MyLogger.LOGGER.info("Current adult number: "+currentAdultNumber);
        return currentAdultNumber;
    }

    public HomeBookingPage clickIncreaseAdultButton(){
        MyLogger.LOGGER.info("Increase number of adult");
        increaseAdultButton.click();
        return this;
    }

    public HomeBookingPage clickDecreaseAdultButton(){
        MyLogger.LOGGER.info("Decrease number of adult");
        decreaseAdultButton.click();
        return this;
    }

}
