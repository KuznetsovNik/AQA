package driver;

import common.utils.AllureUtils;
import helpers.*;
import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Manages WebDriver
 */

public class DriverManager {

    private static final int DEFAULT_IMPL_WAIT_SEC = 15;
    private static final int DEF_DELAY = 600;

    @Getter
    private WebDriver driver;
    private InitDriver initDriver;

    @Getter
    private WebDriverWait driverWait;

    @Getter
    private Button button;

    @Getter
    private DropDown dropDown;

    @Getter
    private ElementsAttributes elAttr;

    @Getter
    private Input input;

    @Getter
    private Move move;

    @Getter
    private JavascriptExecutor js;

    public DriverManager(WebDriver driver) {
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_IMPL_WAIT_SEC));
        this.js = (JavascriptExecutor) driver;
        this.button = new Button(driver, driverWait);
        this.dropDown = new DropDown();
        this.elAttr = new ElementsAttributes();
        this.input = new Input();
        this.move = new Move();
        this.initDriver = new InitDriver();
    }

    public static void takeScreen(WebDriver driver) {
        if (driver == null) {
            return;
        }

        var bytes = ((EventFiringWebDriver) driver).getScreenshotAs(OutputType.BYTES);
        AllureUtils.attachPng("Screenshoot", bytes);
    }
}