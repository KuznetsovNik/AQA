package gor_ui.login_page.forget_password;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static common.consts.DataTest.CYRILLIC;
import static common.consts.DataTest.NEW_PASSWORD_EMPTY;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Восстановление пароля")
public class NewPasswordsFieldCyrillic extends BaseForgetPage {
    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6189343")
    @Description("Введенные букв кириллицы в поля Придумайте пароль и Подтвердите пароль не отображаются.")
    public void checkNewPasswordFieldCyrillic() {
        openPageInputPassportAndClickSms();
        addValidSmsCodeAndClickContinue();
        forgetPasswordPage.inputNewPassword(CYRILLIC);
        forgetPasswordPage.confirmNewPassword(CYRILLIC);
        Assert.assertEquals(forgetPasswordPage.getValueOfNewPasswordField(), NEW_PASSWORD_EMPTY);
        Assert.assertEquals(forgetPasswordPage.getValueOfNewConfirmPasswordField(), NEW_PASSWORD_EMPTY);
        Assert.assertFalse(forgetPasswordPage.isButtonContinueClickable());
    }
}