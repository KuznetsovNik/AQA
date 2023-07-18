package gor_ui.login_page.login;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static common.consts.DataTest.LETTERS;
import static common.consts.DataTest.NUMBER_PHONE_EMPTY;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Авторизация (вход в приложение)")
public class PhoneFieldLetterTest extends BaseLoginPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6153397")
    @Description("Введенные в поле ввода телефона строчные и заглавные латинские буквы не отображаются.")
    public void checkLetters() {
        openPhoneAndClickOnField();
        loginPage.inputLogin(LETTERS);
        Assert.assertEquals(loginPage.getValueOfPhoneField(), NUMBER_PHONE_EMPTY);
    }
}