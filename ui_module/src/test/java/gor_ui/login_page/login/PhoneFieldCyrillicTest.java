package gor_ui.login_page.login;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static common.consts.DataTest.CYRILLIC;
import static common.consts.DataTest.NUMBER_PHONE_EMPTY;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Авторизация (вход в приложение)")
public class PhoneFieldCyrillicTest extends BaseLoginPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6153894")
    @Description("Введенные в поле ввода телефона строчные и заглавные буквы не отображаются.")
    public void checkCyrillicPhone() {
        openPhoneAndClickOnField();
        loginPage.inputLogin(CYRILLIC);
        Assert.assertEquals(loginPage.getValueOfPhoneField(), NUMBER_PHONE_EMPTY);
    }
}