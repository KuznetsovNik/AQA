package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * Initialization options to start browser with selected parameters
 */
public final class InitOptions {
    private static ChromeOptions optChrome = new ChromeOptions();
    private static FirefoxOptions optFirefox = new FirefoxOptions();

    /**
     * Use headless mode on CI/CD
     * to avoid case when workaround the absence of real display on machines with no display hardware
     * and no physical input devices
     *
     * @param headlessMode
     * @return
     */
    protected static ChromeOptions defChromeOpt(boolean headlessMode) {

        // optChrome.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        if (headlessMode) {
            optChrome.addArguments("--headless");
            optChrome.addArguments("--window-size=1920,1080");
            optChrome.addArguments("--no-sandbox");
            optChrome.addArguments("--disable-gpu");
            optChrome.addArguments("--incognito");
            optChrome.addArguments("--disable-popup-blocking");
            optChrome.addArguments("--disable-extensions");
            optChrome.addArguments("--disable-infobars");
            optChrome.addArguments("--verbose");
            optChrome.addArguments("--verbose");
            optChrome.addArguments("--disable-dev-shm-usage");
        }
        optChrome.addArguments("--start-maximized");
        optChrome.addArguments("--no-sandbox");
        optChrome.addArguments("--disable-gpu");
        optChrome.addArguments("--incognito");
        optChrome.addArguments("--disable-popup-blocking");
        optChrome.addArguments("--disable-extensions");
        optChrome.addArguments("--disable-infobars");
        optChrome.addArguments("--remote-allow-origins=*");
        return optChrome;
    }

    protected static FirefoxOptions defFirefoxOptions() {

        optFirefox.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        optFirefox.addPreference("browser.private.browsing.autostart", true);

        return optFirefox;
    }
}