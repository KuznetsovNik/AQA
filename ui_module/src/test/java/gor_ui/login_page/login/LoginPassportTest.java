package gor_ui.login_page.login;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static common.utils.AssertMsg.assertTrue;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("BakuninAV")
@Story("Авторизация (вход в приложение)")
public class LoginPassportTest extends BaseLoginPage {

    @Test(groups = {"smoke"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/5994513&group_by=cases:section_id&group_id=1028302&group_order=asc&display_deleted_cases=0")
    @Description("WINDOWS ONLY.Авторизация по номеру паспорта с валидными данными")
    public void loginPassportTest() {
        openPassportAndClickOnField();
        addPassportDataAuthorization();
        loginPage.clickButtonGo();
        loginPage.mainPageInit();
        assertTrue(mainPage.logo());
        mainPage.closeAlert();
        mainPage.logout();
        Assert.assertFalse(loginPage.checkButtonGoClickable());
    }
}