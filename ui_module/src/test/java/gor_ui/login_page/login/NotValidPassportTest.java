package gor_ui.login_page.login;

import common.config.AppConfigProvider;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static common.consts.DataTest.*;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Авторизация (вход в приложение)")
public class NotValidPassportTest extends BaseLoginPage {

    @Test(groups = {"smoke"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6160544")
    @Description("Проверка появления алерта при вводе неверного паспорта и верного пароля")
    public void incorrectPassportTest() {
        openPassportAndClickOnField();
        loginPage.inputPassport(NOT_VALID_PASSPORT);
        loginPage.inputPassword(AppConfigProvider.get().userPassportPass());
        loginPage.clickButtonGo();
        Assert.assertEquals(loginPage.getClassOfPasswordField(), INVALID_LOGIN_DATA_ERROR_CLASS);
    }
}

