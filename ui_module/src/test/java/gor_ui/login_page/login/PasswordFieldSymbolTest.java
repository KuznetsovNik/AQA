package gor_ui.login_page.login;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static common.consts.DataTest.*;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Авторизация (вход в приложение)")
public class PasswordFieldSymbolTest extends BaseLoginPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/5994512")
    @Description("Возможность ввода в поле ввода пароля спец.символов.")
    public void checkSymbol() {
        openPhoneAndClickOnField();
        loginPage.inputSpecialSymbol(SPECIAL_SYMBOL_FIRST_PART);
        Assert.assertEquals(loginPage.getValueOfPasswordField(), SPECIAL_SYMBOL_FIRST_PART);
        loginPage.inputPasswordWithCustomClear(SPECIAL_SYMBOL_SECOND_PART);
        Assert.assertEquals(loginPage.getValueOfPasswordField(), SPECIAL_SYMBOL_SECOND_PART);
    }
}