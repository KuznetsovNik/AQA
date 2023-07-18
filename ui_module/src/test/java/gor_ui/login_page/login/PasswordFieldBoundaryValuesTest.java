package gor_ui.login_page.login;

import common.config.AppConfigProvider;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static common.consts.DataTest.*;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Авторизация (вход в приложение)")
public class PasswordFieldBoundaryValuesTest extends BaseLoginPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6153839")
    @Description("WINDOWS ONLY.Проверка граничных значений поля ввода пароля.")
    public void passwordFieldParameterNotValid5() {
        openPhoneAndClickOnField();
        loginPage.inputLogin(AppConfigProvider.get().userNumberPhone());
        loginPage.inputPassword(NOT_VALID_PASS0);
        Assert.assertFalse(loginPage.checkButtonGoClickable());
        loginPage.addSymbolPassword(ADD_SYMBOL5);
        Assert.assertFalse(loginPage.checkButtonGoClickable());
        loginPage.addSymbolPassword(ADD_SYMBOL1);
        Assert.assertTrue(loginPage.checkButtonGoClickable());
//        Assert.assertTrue(loginPage.isButtonGoClickable());
        loginPage.addSymbolPassword(ADD_SYMBOL5);
        Assert.assertTrue(loginPage.checkButtonGoClickable());
        loginPage.addSymbolPassword(ADD_SYMBOL9);
        Assert.assertTrue(loginPage.checkButtonGoClickable());
        loginPage.inputPasswordWithCustomClear(VALID_PASS21);
        Assert.assertEquals(loginPage.getValueOfPasswordField(), VALID_PASS20);
    }
}