package driver;

import common.config.AppConfigProvider;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class BrowserManager {

    private static final String URL = AppConfigProvider.get().baseUrl();
    private WebDriver driver;
    private DriverManager drManager;

    public BrowserManager(WebDriver driver) {
        this.driver = driver;
        this.drManager = new DriverManager(driver);
    }

    public void closeTab() {
        driver.close();
    }

    public void reloadPage() {
        driver.navigate().refresh();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void getPage(String url) {
        drManager.getDriver().get(url);
    }

    public String getCurrUrl() {
        return drManager.getDriver().getCurrentUrl();
    }

    public String getPageSrc() {
        return drManager.getDriver().getPageSource();
    }

    public void navigateTo(String url) {
        drManager.getDriver().navigate().to(url);
    }

    public void quit() {
        drManager.getDriver().quit();
    }

    public void openNewTab() {
        driver.getWindowHandle();
        drManager.getJs().executeScript(String.format("window.open(\"%s\");", URL));
    }

    public void openNewTab(String url) {
        driver.getWindowHandle();
        drManager.getJs().executeScript(String.format("window.open(\"%s\");", URL));
    }

    public void switchToAnotherTab(int tabNumber) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNumber));
    }

    public Cookie getCookie(String cookieName) {
        return drManager.getDriver().manage().getCookieNamed(cookieName);
    }
}