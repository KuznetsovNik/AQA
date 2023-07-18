package driver;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static common.consts.BrowserNameConsts.CHROME;
import static common.consts.BrowserNameConsts.FIREFOX;
import static driver.InitOptions.defChromeOpt;
import static driver.InitOptions.defFirefoxOptions;

/**
 * Driver initialization
 */
@Slf4j
public class InitDriver {

    private static WebDriver driver;

    InitDriver() {
    }

    public static WebDriver initDriver(String browserName) {
        if (driver == null) {
            createDriver(browserName);
            return driver;
        }
        return driver;
    }

    /**
     * Driver initialization for selected browser by
     *
     * @param browserName
     */
    private static void createDriver(String browserName) {
        if (browserName.equals(CHROME)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(defChromeOpt(false));
            log.info("Chrome browser instantiated");
        } else if (browserName.equals(FIREFOX)) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/geckondriver.exe");
            driver = new FirefoxDriver(defFirefoxOptions());
            log.info("Firefox browser instantiated");
        }
        if (driver == null) {
            throw new NullPointerException("WebDriver not instantiated");
        }
    }
}