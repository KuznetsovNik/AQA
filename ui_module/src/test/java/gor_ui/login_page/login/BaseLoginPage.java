package gor_ui.login_page.login;

import common.config.AppConfigProvider;
import gor_ui.BaseTest;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeTest;

public class BaseLoginPage extends BaseTest {

    @BeforeTest(alwaysRun = true)
    public void openLoginPage() {
        brManager.reloadPage();
        navigation.goToLoginPage();
    }

    @Step("Добавление валидных паспортных данных и пароля")
    public void addPassportDataAuthorization() {
        loginPage.inputPassword(AppConfigProvider.get().userPassportPass());
        loginPage.inputPassportWithCustomClear(AppConfigProvider.get().userPassport());
    }

    @Step("Добавление валидных номера телефона и пароля")
    public void addPhoneDataAuthorization() {
        loginPage.inputLogin(AppConfigProvider.get().userNumberPhone());
        loginPage.inputPassword(AppConfigProvider.get().userNumberPass());
    }

    @Step("Открываю авторизацию по паспорту ,ставлю курсор в поле паспорт")
    public void openPassportAndClickOnField() {
        brManager.reloadPage();
        loginPage.openPassport();
        loginPage.clickFieldPassport();
    }

    @Step("Открываю авторизация по номеру телефона, ставлю курсор в поле номер телефона")
    public void openPhoneAndClickOnField() {
        brManager.reloadPage();
        loginPage.openPhone();
        loginPage.clickFieldLogin();
    }
}
