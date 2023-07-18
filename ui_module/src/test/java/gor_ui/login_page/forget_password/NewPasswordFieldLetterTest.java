package gor_ui.login_page.forget_password;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static common.consts.DataTest.LETTERS;
import static common.consts.DataTest.PASSWORD_ERROR_CLASS;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Восстановление пароля")
public class NewPasswordFieldLetterTest extends BaseForgetPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6189325")
    @Description("Введенные в поля Придумайте пароль и Подтвердите пароль латинские букв  отображаются,но появляется алерт о содержании пароля.")
    public void checkNewPasswordFieldLetter() {
        openPageInputPassportAndClickSms();
        addValidSmsCodeAndClickContinue();
        forgetPasswordPage.inputNewPassword(LETTERS);
        forgetPasswordPage.confirmNewPassword(LETTERS);
        Assert.assertEquals(forgetPasswordPage.getValueOfNewPasswordField(), LETTERS);
        Assert.assertEquals(forgetPasswordPage.getValueOfNewConfirmPasswordField(), LETTERS);
        Assert.assertEquals(forgetPasswordPage.getClassErrorMassageText(), PASSWORD_ERROR_CLASS);
    }
}