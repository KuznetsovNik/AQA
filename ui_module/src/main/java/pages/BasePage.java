package pages;

import driver.BrowserManager;
import driver.DriverManager;
import helpers.*;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public abstract class BasePage {
    protected DriverManager drManager;
    protected BrowserManager brManager;
    protected Button button;
    protected DropDown dropDown;
    protected ElementsAttributes elementsAttributes;
    protected Input input;
    protected Move move;
    protected Alert alert;

    public BasePage(WebDriver driver) {
        log.info("{} created", this.getClass().getName());
        this.drManager = new DriverManager(driver);
        this.brManager = new BrowserManager(driver);
        this.input = drManager.getInput();
        this.button = drManager.getButton();
        this.dropDown = drManager.getDropDown();
        this.elementsAttributes = drManager.getElAttr();
        this.move = drManager.getMove();
        this.alert = new Alert();
    }

    public void waitForSpinnerStopped() {

        String isSpinnerExistJs = "return document.querySelector('body > ha-root > nz-spin')";

        WebDriverWait wait = elementsAttributes.waiter(100);

        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public @Nullable Boolean apply(@Nullable WebDriver webDriver) {
                return null != ((JavascriptExecutor) drManager.getDriver()).executeScript(isSpinnerExistJs);
            }
        });

        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public @Nullable Boolean apply(@Nullable WebDriver webDriver) {
                return null == ((JavascriptExecutor) drManager.getDriver()).executeScript(isSpinnerExistJs);
            }
        });
    }
}