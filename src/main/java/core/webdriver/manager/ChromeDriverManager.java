package core.webdriver.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager {
    private static ChromeDriverManager chromeDriverManagerInstance = null;

    private ChromeDriverManager() {
    }

    public void setDriverProperty(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
    }

    public WebDriver createDriver(){
        setDriverProperty();
        //Create a instance of ChromeOptions class
        ChromeOptions options = new ChromeOptions();

//Add chrome switch to disable notification - "**--disable-notifications**"
        options.addArguments("--disable-notifications");

//Pass ChromeOptions instance to ChromeDriver Constructor
        return new ChromeDriver(options);
    }

    public static ChromeDriverManager getChromeManagerInstance(){
        if (chromeDriverManagerInstance ==null){
            chromeDriverManagerInstance = new ChromeDriverManager();
        }
        return chromeDriverManagerInstance;
    }
}
