package gor_ui.login_page.forget_password;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static common.consts.DataTest.PASSWORD_ERROR_CLASS;
import static common.consts.DataTest.SPECIAL_SYMBOL;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Восстановление пароля")
public class NewPasswordFieldSymbolTest extends BaseForgetPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6189334")
    @Description("Введенные в поля Придумайте пароль и Подтвердите пароль спец. символы отображаются,но появляется алерт о содержании пароля.")
    public void checkNewPasswordFieldSymbol() {
        openPageInputPassportAndClickSms();
        addValidSmsCodeAndClickContinue();
        forgetPasswordPage.inputNewPassword(SPECIAL_SYMBOL);
        forgetPasswordPage.confirmNewPassword(SPECIAL_SYMBOL);
        Assert.assertEquals(forgetPasswordPage.getValueOfNewPasswordField(), SPECIAL_SYMBOL);
        Assert.assertEquals(forgetPasswordPage.getValueOfNewConfirmPasswordField(), SPECIAL_SYMBOL);
        Assert.assertEquals(forgetPasswordPage.getClassErrorMassageText(), PASSWORD_ERROR_CLASS);
    }
}