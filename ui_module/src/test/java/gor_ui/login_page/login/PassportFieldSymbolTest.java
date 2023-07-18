package gor_ui.login_page.login;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static common.consts.DataTest.*;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Авторизация (вход в приложение)")
public class PassportFieldSymbolTest extends BaseLoginPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6153429")
    @Description("Введенные в поле ввода паспорта специальные символы не отображаются.")
    public void checkSymbolPassport() {
        openPassportAndClickOnField();
        loginPage.inputPassport(SPECIAL_SYMBOL);
        Assert.assertEquals(loginPage.getValueOfPassportField(), PASSPORT_EMPTY_NUMBER_UNDERSCORES);
    }
}
