package gor_ui.login_page.login;

import common.config.AppConfigProvider;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static common.consts.DataTest.INVALID_LOGIN_DATA_ERROR_CLASS;
import static common.consts.DataTest.VALID_PASSPORT_PASSWORD;


@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("BakuninAV")
@Story("Авторизация (вход в приложение)")
public class WrongPasswordAlertTest extends BaseLoginPage {

    @Test(groups = {"smoke"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/5994515&group_by=cases:section_id&group_id=1028302&group_order=asc&display_deleted_cases=0")
    @Description("Появление валидации при введении некорректного пароля")
    public void wrongPasswordAlert() {
        openPhoneAndClickOnField();
        loginPage.inputLogin(AppConfigProvider.get().userNumberPhone());
        loginPage.inputPassword(VALID_PASSPORT_PASSWORD);
        loginPage.clickButtonGo();
        Assert.assertEquals(loginPage.getClassOfPasswordField(), INVALID_LOGIN_DATA_ERROR_CLASS);
    }
}
