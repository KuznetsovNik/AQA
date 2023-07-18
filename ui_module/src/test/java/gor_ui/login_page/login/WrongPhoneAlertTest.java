package gor_ui.login_page.login;

import common.config.AppConfigProvider;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static common.consts.DataTest.INVALID_LOGIN_DATA_ERROR_CLASS;
import static common.consts.DataTest.WRONG_PHONE_NUMBER;

@Epic("Epic-1 Регистрация/Авторизация/Безопасность (WEB)")
@Owner("Кузнецов Н.Г.")
@Story("US-1.2 Авторизация (вход в приложение)")
@TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6156844&group_by=cases:section_id&group_order=asc&display_deleted_cases=0&group_id=1028302")
public class WrongPhoneAlertTest extends BaseLoginPage {

    @Test(groups = {"smoke"})
    @Description("Авторизация по телефону с неверным номером телефона, но верным паролем")
    public void nullPhoneTest() {
        openPhoneAndClickOnField();
        loginPage.inputLogin(WRONG_PHONE_NUMBER);
        loginPage.inputPassword(AppConfigProvider.get().userNumberPass());
        loginPage.clickButtonGo();
        Assert.assertEquals(loginPage.getClassOfPasswordField(), INVALID_LOGIN_DATA_ERROR_CLASS);
    }
}

