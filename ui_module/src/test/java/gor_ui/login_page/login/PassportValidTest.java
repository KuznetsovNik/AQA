package gor_ui.login_page.login;

import common.config.AppConfigProvider;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static common.consts.DataTest.ALERT_SHORT_PASSPORT;
import static common.consts.DataTest.SHORT_VALID_PASSPORT;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Авторизация (вход в приложение)")
public class PassportValidTest extends BaseLoginPage {

    @Test(groups = {"smoke"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/5996046")
    @Description("Проверка появления алерт сообщения при вводе короткого паспорта")
    public void checkPassport() {
        openPassportAndClickOnField();
        loginPage.inputPassport(SHORT_VALID_PASSPORT);
        loginPage.inputPassword(AppConfigProvider.get().userPassportPass());
        Assert.assertEquals(loginPage.getNotEnoughCharactersAlert(), ALERT_SHORT_PASSPORT);
    }
}
