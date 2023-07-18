package gor_ui.login_page.login;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static common.consts.DataTest.*;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Авторизация (вход в приложение)")
public class PassportFieldLetterTest extends BaseLoginPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6153434")
    @Description("Введенные в поле ввода паспорта строчные и заглавные латинские буквы не отображаются.")
    public void checkLettersPassword() {
        openPassportAndClickOnField();
        loginPage.inputPassport(LETTERS);
        Assert.assertEquals(loginPage.getValueOfPassportField(), PASSPORT_EMPTY_NUMBER_UNDERSCORES);
    }
}