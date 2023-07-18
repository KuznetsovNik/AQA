package gor_ui.login_page.forget_password;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static common.consts.DataTest.*;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Восстановление пароля")
public class NewPasswordFieldBoundaryTest extends BaseForgetPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6188767")
    @Description("WINDOWS ONLY.Проверка граничных значений в поля Придумайте пароль и Подтвердите пароль(поля совпадают) при восстановлении пароля .")
    public void checkSymbolPassport() {
        openPageInputPassportAndClickSms();
        addValidSmsCodeAndClickContinue();
        forgetPasswordPage.inputNewPassword(NOT_VALID_PASS0);
        forgetPasswordPage.confirmNewPassword(NOT_VALID_PASS0);
        Assert.assertFalse(forgetPasswordPage.isButtonContinueClickable());
        forgetPasswordPage.inputNewPassword(ADD_SYMBOL5);
        forgetPasswordPage.confirmNewPassword(ADD_SYMBOL5);
        Assert.assertEquals(forgetPasswordPage.getClassErrorMassageText(), PASSWORD_ERROR_CLASS);
        forgetPasswordPage.inputNewPassword(ADD_SYMBOL1);
        forgetPasswordPage.confirmNewPassword(ADD_SYMBOL1);
        Assert.assertTrue(forgetPasswordPage.isButtonContinueClickable());
        forgetPasswordPage.inputNewPassword(ADD_SYMBOL5);
        forgetPasswordPage.confirmNewPassword(ADD_SYMBOL5);
        Assert.assertTrue(forgetPasswordPage.isButtonContinueClickable());
        forgetPasswordPage.inputNewPassword(ADD_SYMBOL9);
        forgetPasswordPage.confirmNewPassword(ADD_SYMBOL9);
        Assert.assertTrue(forgetPasswordPage.isButtonContinueClickable());
        forgetPasswordPage.clearNewPassword(VALID_PASS21);
        forgetPasswordPage.clearConfirmPassword(VALID_PASS21);
        Assert.assertEquals(forgetPasswordPage.getValueOfNewPasswordField(), VALID_PASS20);
        Assert.assertEquals(forgetPasswordPage.getValueOfNewConfirmPasswordField(), VALID_PASS20);
    }
}