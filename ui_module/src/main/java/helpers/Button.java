package helpers;

import driver.InitDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Button extends Elements {

    public Button(WebDriver driver, WebDriverWait waiter) {
        this.driver = driver;
        this.waiter = waiter;
    }

    @Step("Click on an element: [{locator}]")
    public void btnClick(By locator) {
        waitUntilVisible(locator);
        waitUntilClickable(locator).click();
    }

    @Step("Click on an element: [{element}]")
    public void btnClick(WebElement element) {
        waitUntilClickable(element).click();
    }

    @Step("Mouse click on an element: [{element}]")
    public void mouseClick(WebElement element) {
        Actions action = new Actions(driver);
        waitUntilClickable(element);
        action.click(element).build().perform();
    }

    @Step("Double click on an element: [{element}]")
    public void btnDoubleClick(WebElement element) {
        Actions action = new Actions(driver);
        waitUntilClickable(element);
        action.doubleClick(element).build().perform();
    }

    @Step("Double click on an element: [{locator}]")
    public void btnDoubleClick(By locator) {
        Actions action = new Actions(driver);
        waitUntilClickable(locator);
        action.doubleClick(driver.findElement(locator)).build().perform();
    }

    @Step("Hover and click on element: [{element}]")
    public void hoverAndClick(WebElement element) {
        Actions action = new Actions(driver);
        action.clickAndHold(element).build().perform();
    }

    @Step("Hover and click on element: [{locator}]")
    public void hoverAndClick(By locator) {
        hoverAndClick(waitUntilClickable(locator));
    }

    @Step("Drag & drop element from: [{elementFrom}], to element: [{elementTo}]")
    public void mouseDragAndDrop(WebElement elementFrom, WebElement elementTo) {
        Button btn = new Button(driver, waiter);
        btn.mouseDragAndDrop(elementFrom, elementTo);
    }

    public void dragAndDrop(By locator, int x, int y) {
        Actions move = new Actions(InitDriver.initDriver("chrome"));
        WebElement elem = waitUntilExist(locator);
        Action actions = move.dragAndDropBy(elem, x, y).build();
        actions.perform();
    }

    @Step("Click escape")
    public void clickEscape() {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).build().perform();
    }

    @Step("Click element without waiting clickable")
    public void clickWithoutWaitingClickable(By locator) {
        waitUntilVisible(locator).click();
    }

    @Step("Check is button clickable")
    public boolean checkButtonClickable(By locator) {
        return  waitUntilVisible(locator).isEnabled();
    }
}