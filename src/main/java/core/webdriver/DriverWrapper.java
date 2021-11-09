package core.webdriver;

import core.logger.MyLogger;
import core.webdriver.manager.ChromeDriverManager;
import org.openqa.selenium.WebDriver;

public class DriverWrapper {
    private static WebDriver driver = null;

    private DriverWrapper() {
        this.driver = ChromeDriverManager.getChromeManagerInstance().createDriver();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            MyLogger.LOGGER.info("------------new driver------------");
            new DriverWrapper();
        }
        return driver;
    }
}
