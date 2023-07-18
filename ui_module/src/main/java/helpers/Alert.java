package helpers;

import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Alert extends Elements {

    @Step("Accept alert")
    public void waitAndAcceptAlert() {
        (waiter).until(ExpectedConditions.alertIsPresent()).accept();
    }
}