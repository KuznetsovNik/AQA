package gor_ui.login_page.forget_password;

import common.config.AppConfigProvider;
import gor_ui.login_page.login.BaseLoginPage;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import static common.consts.DataTest.VALID_SMS_CODE;

public class BaseForgetPage extends BaseLoginPage {
    @Step("Нажать забыли пароль и поставить курсор в поле ввода паспорта")
    public void openForgetPassword() {
        brManager.reloadPage();
        forgetPasswordPage.clickForgetPassword();
        forgetPasswordPage.clickPassport();
    }

    @Step("Добавление валидного паспорта, закрытие алерта и поставить курсор в поле Укажите код")
    public void addPassportAcceptAlertAndClickSms() {
        forgetPasswordPage.inputFieldPassport(AppConfigProvider.get().userPassport());
        forgetPasswordPage.clickContinue();
        forgetPasswordPage.acceptAlert();
        forgetPasswordPage.clickSmsCode();
    }

    @Step("Открыли страницу забыли пароль,ввели валидный паспорт, закрыли алерт, поставили курсор в поле Укажите код")
    public void openPageInputPassportAndClickSms() {
        openForgetPassword();
        addPassportAcceptAlertAndClickSms();
    }

    @Step("Добавление валидного sms кода и нажать кнопку продолжить")
    public void addValidSmsCodeAndClickContinue() {
        forgetPasswordPage.inputSmsCode(VALID_SMS_CODE);
        forgetPasswordPage.clickContinue();
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        brManager.reloadPage();
        forgetPasswordPage.clickClose();
    }
}
