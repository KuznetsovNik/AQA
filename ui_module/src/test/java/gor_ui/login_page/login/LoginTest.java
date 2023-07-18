package gor_ui.login_page.login;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static common.utils.AssertMsg.assertTrue;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("KartavenkovaTV")
@Story("Авторизация (вход в приложение)")
public class LoginTest extends BaseLoginPage {

    @Test(groups = {"smoke"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/5992946")
    @Description("Авторизация по номеру телефона с валидными данными.")
    public void authorizationByNumberPhone() {
        openPhoneAndClickOnField();
        addPhoneDataAuthorization();
        loginPage.clickButtonGo();
        loginPage.mainPageInit();
        assertTrue(mainPage.logo());
        mainPage.closeAlert();
        mainPage.logout();
        Assert.assertFalse(loginPage.checkButtonGoClickable());
    }
}