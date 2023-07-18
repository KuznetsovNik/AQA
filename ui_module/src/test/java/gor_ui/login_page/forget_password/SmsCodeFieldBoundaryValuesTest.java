package gor_ui.login_page.forget_password;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static common.consts.DataTest.*;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Восстановление пароля")
public class SmsCodeFieldBoundaryValuesTest extends BaseForgetPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6156902")
    @Description("Проверка невалидных граничных значений в поле Укажите код при восстановлении пароля .")
    public void checkSmsCodeField() {
        openPageInputPassportAndClickSms();
        forgetPasswordPage.inputSmsCode(SMS_CODE_EMPTY);
        Assert.assertFalse(forgetPasswordPage.isButtonContinueClickable());
        forgetPasswordPage.inputSmsCode(ADD_SYMBOL1);
        Assert.assertFalse(forgetPasswordPage.isButtonContinueClickable());
        forgetPasswordPage.inputSmsCode(SMS_CODE_ADD_SYMBOL_4);
        Assert.assertFalse(forgetPasswordPage.isButtonContinueClickable());
        forgetPasswordPage.inputSmsCode(SMS_CODE_ADD_SYMBOL_7);
        Assert.assertTrue(forgetPasswordPage.isButtonContinueClickable());
        Assert.assertEquals(forgetPasswordPage.getValueSmsField(), VALID_SMS_CODE);
    }
}