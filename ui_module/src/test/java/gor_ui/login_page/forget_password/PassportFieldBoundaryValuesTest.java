package gor_ui.login_page.forget_password;

import common.config.AppConfigProvider;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static common.consts.DataTest.*;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Восстановление пароля")
public class PassportFieldBoundaryValuesTest extends BaseForgetPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6156861")
    @Description("WINDOWS ONLY.Проверка активности кнопки продолжить при невалидных граничных значений в поле номер паспорта при восстановлении пароля.")
    public void checkInvalidFieldPassport() {
        openForgetPassword();
        Assert.assertFalse(forgetPasswordPage.isButtonContinueClickable());
        forgetPasswordPage.inputFieldPassport(ADD_SYMBOL9);
        forgetPasswordPage.clickOnRecoverPassword();
        Assert.assertEquals(forgetPasswordPage.getClassErrorPassportShort(), FORGET_PASSWORD_ERROR_CLASS);
        forgetPasswordPage.clearPassport(ONE_NUMBER);
        forgetPasswordPage.clickOnRecoverPassword();
        Assert.assertEquals(forgetPasswordPage.getClassErrorPassportShort(), FORGET_PASSWORD_ERROR_CLASS);
        forgetPasswordPage.clearPassport(TOO_BIG_PASSPORT);
        Assert.assertEquals(forgetPasswordPage.getValuePassportField(), PASSPORT_VALID);
        forgetPasswordPage.clickOnRecoverPassword();
        Assert.assertTrue(forgetPasswordPage.isButtonContinueClickable());
    }
}