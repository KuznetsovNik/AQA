package helpers;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static events.JSWaiters.drManager;

public class Input extends Elements {

    @Step("Insert [{text}] to input field [{locator}]]")
    public void input(By locator, String text) {
        waitUntilClickable(locator).clear();
        waitUntilClickable(locator).sendKeys(text);
    }

    @Step("Insert [{text}] to input field [{locator}]]")
    public void inputWithoutWaitClickable(By locator, String text) {
        waitUntilClickable(locator).sendKeys(text);
    }

    @Step("Insert [{text}] to input field [{locator}]")
    public void input(WebElement element, String text) {
        waitUntilClickable(element).clear();
        waitUntilClickable(element).sendKeys(text);
    }

    @Step("Insert [{text}] to input field [{locator}]")
    public void inputAction(By element, String text) {
        Actions action = new Actions(drManager.getDriver());
        WebElement elem = waitUntilClickable(element);
        waitUntilClickable(elem).clear();
        action.click(elem).sendKeys(text).build().perform();
    }

    public void inputActionWithOutClear(By element, String text, By locatorListOfDropbox) {
        Actions action = new Actions(drManager.getDriver());
        waitUntilClickable(element).click();
        waitUntilVisible(locatorListOfDropbox);
        action.sendKeys(text).build().perform();
    }

    @Step("Insert [{text}] to input field [{locator}]")
    public void inputActionForDropBox(By element, String text) {
        Actions action = new Actions(drManager.getDriver());
        WebElement elem = waitUntilClickable(element);
        action.click(elem).sendKeys(text).build().perform();
    }

    @Step("Insert [{text}] to input field [{locator}]] with 'sendKeys' clear method")
    public void inputWithClear(By locator, String text) {
        waitUntilVisible(locator).sendKeys(Keys.CONTROL, "a");
        waitUntilVisible(locator).sendKeys(Keys.DELETE);
        waitUntilVisible(locator).sendKeys(text);
    }
}