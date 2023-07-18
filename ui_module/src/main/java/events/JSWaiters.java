package events;

import driver.DriverManager;
import lombok.extern.slf4j.Slf4j;
import netscape.javascript.JSException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

@Slf4j
public class JSWaiters {

    public static DriverManager drManager;

    private void waitJQuery() {
        try {

            ExpectedCondition<Boolean> jqueryLoad = driver -> drManager.getJs().executeScript("return jQuery.active === 0").equals(true);

            boolean jqReady = (Boolean) drManager.getJs().executeScript("return jQuery.active == 0");

            if (!jqReady) {
                drManager.getDriverWait().until(jqueryLoad);
            }
        } catch (JSException | JavascriptException ex) {
            System.out.println("Jquery not work: " + ex.getMessage());
        }
    }

    private void waitAngular() {
        ExpectedCondition<Boolean> angularLoad = driver -> drManager.getJs()
                .executeScript("return window.angular.element('body').injector().get('$http').pendingRequests.length === 0").equals(true);

        boolean angReady = drManager.getJs()
                .executeScript("return window.angular.element('body').injector().get('$http').pendingRequests.length === 0").equals(true);

        if (!angReady) {
            drManager.getDriverWait().until(angularLoad);
        }
    }

    void waitUntilJSReady(WebDriver drivers) {
        drManager = new DriverManager(drivers);
        ExpectedCondition<Boolean> jsLoad = driver -> drManager.getJs().executeScript("return document.getElementsByClassName(\"spinner\").length === 0").equals(true);
        boolean jsReady = drManager.getJs().executeScript("return document.getElementsByClassName(\"spinner\").length === 0").equals(true);

        if (!jsReady) {
            log.info("JAVASCRIPT IS NOT READY");
            drManager.getDriverWait().until(jsLoad);
        }
    }

    private void sleep(Integer sec) {
        long seconds = sec;
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}