package pages;

import common.config.AppConfigProvider;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

@Slf4j
public class Navigation extends BasePage {

    public Navigation(WebDriver driver) {
        super(driver);
    }

    public Navigation goToLoginPage() {
        brManager.getPage(AppConfigProvider.get().baseUrl());
        log.info("Navigate to login page");

        return this;
    }
}