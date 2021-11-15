package booking.pages;

import booking.BaseBookingPage;
import core.logger.MyLogger;
import core.webdriver.DriverWrapper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * This is a booking home page class presentation
 */
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

    /**
     * Method to click on select language button
     *
     * @return SelectLanguageFrame
     */
    @Step("Clicking on languages button")
    public SelectLanguageFrame clickLanguagesButton(){
        MyLogger.LOGGER.info("Click language button");
        languageButton.click();
        return new SelectLanguageFrame();
    }

    /**
     * Method send %text% to the destination search field
     *
     * @param text - string variable present what we will input into search field
     * @return void
     */
    @Step("Set text {0} to destination search field")
    public void setTextToDestinationSearchField(String text){
        MyLogger.LOGGER.info("add '"+text+"' to destination field");
        searchDestinationField.sendKeys(text);
    }

    /**
     * Method to click on select date button to appear calendar frame to select check-in check-out dates
     *
     * @return void
     */
    @Step("Clicking on select arrival dates button")
    public void clickSelectDatesButton(){
        MyLogger.LOGGER.info("click select dates button");
        selectDatesButton.click();
    }

    /**
     * Method to go to the next month in calendar
     *
     * @return void
     */
    @Step("Clicking on next month button")
    public void clickNextMonth(){
        MyLogger.LOGGER.info("Click next month");
        nextMonthButton.click();
    }

    /**
     * Method to get current check in date text
     *
     * @return String
     */
    @Step("Get check in date text")
    public String getCheckInDateText(){
        String checkInDateText = checkInDateLabel.getText();
        MyLogger.LOGGER.info("Get check in date: "+checkInDateText);
        return checkInDateText;
    }

    /**
     * Method to get current check out date text
     *
     * @return String
     */
    @Step("Get check out date text")
    public String getCheckOutDateText(){
        String checkOutDateText = checkOutDateLabel.getText();
        MyLogger.LOGGER.info("Get check in date: "+checkOutDateText);
        return checkOutDateText;
    }

    /**
     * Method to select date in calendar
     *
     * @param day - day you want to choose
     * @param month - string of month you want to choose
     * @return void
     */
    @Step("Select arrival dates include: day {0}, month {1}")
    public void selectArrivalDate(int day, String month){
        selectMonth(month);
        String dateMonth = day+" "+month;
        MyLogger.LOGGER.info("Select "+day);
        DriverWrapper.getDriver().findElement(By.xpath("//span[contains(@aria-label,'"+dateMonth+"')]")).click();
    }

    /**
     * Method to select month in calendar
     *
     * @param month - string of month you want to choose
     * @return void
     */
    @Step("Select month {0}")
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

    /**
     * Method check months that are displayed in calendar have %month%
     *
     * @return boolean
     */
    private boolean haveMonth(String month){
        for (WebElement element: currentMonths) {
            if (element.getText().contains(month)){
                return true;
            }
        }
        return false;
    }

    /**
     * Method to click on select number of person button
     *
     * @return void
     */
    @Step("Clicking on select number of people button")
    public void clickSelectNumOfPersonButton(){
        MyLogger.LOGGER.info("Click select number of person button");
        selectNumOfPersonButton.click();
    }

    /**
     * Method to click search button
     *
     * @return BookingSearchResultPage
     */
    @Step("Clicking on search button")
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

    /**
     * Method to get current number of adult
     *
     * @return int
     */
    @Step("Get current adult number")
    public int getCurrentAdultNumber(){
        int currentAdultNumber = Integer.parseInt(adultNumber.getText());
        MyLogger.LOGGER.info("Current adult number: "+currentAdultNumber);
        return currentAdultNumber;
    }

    /**
     * Method to increase +1 number of adult
     *
     * @return void
     */
    @Step("Clicking on increase adult button")
    public void clickIncreaseAdultButton(){
        MyLogger.LOGGER.info("Increase number of adult");
        increaseAdultButton.click();
    }

    /**
     * Method to decrease -1 number of adult
     *
     * @return void
     */
    @Step("Clicking on decrease adult button")
    public void clickDecreaseAdultButton(){
        MyLogger.LOGGER.info("Decrease number of adult");
        decreaseAdultButton.click();
    }

    /**
     * Method to set number of adult base on the %number% you want
     *
     * @return HomeBookingPage .this
     */
    @Step("Set number {0} of adult")
    public void setAdultNumber(int number){
        int currentAdultNumber = getCurrentAdultNumber();
        if (number>currentAdultNumber){
            while (number!=currentAdultNumber){
                clickIncreaseAdultButton();
                currentAdultNumber = getCurrentAdultNumber();
            }
        } else if (number<currentAdultNumber){
            while (number!=currentAdultNumber){
                clickDecreaseAdultButton();
                currentAdultNumber = getCurrentAdultNumber();
                if (currentAdultNumber==0){
                    break;
                }
            }
        }
    }

}
