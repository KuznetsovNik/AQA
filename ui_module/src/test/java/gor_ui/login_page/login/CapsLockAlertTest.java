package gor_ui.login_page.login;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static common.consts.DataTest.PASSWORD_FIELD_CAPS_ALERT_CLASS;

@Epic("Epic-1 Регистрация/Авторизация/Безопасность (WEB)")
@Owner("Кузнецов Н.Г.")
@Story("US-1.2 Авторизация (вход в приложение)")
@TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/5993285")
public class CapsLockAlertTest extends BaseLoginPage {

    @Test(groups = {"regression"})
    @Description("Появление предупреждающего сообщения о включенном СapsLock при вводе пароля")
    public void capsLockAssert() {
        openPhoneAndClickOnField();
        loginPage.passwordFieldFastClick();
        loginPage.capsIsOn();
        Assert.assertTrue(loginPage.haveAlertCapsLockOn());
        loginPage.capsIsOn();
    }
}
