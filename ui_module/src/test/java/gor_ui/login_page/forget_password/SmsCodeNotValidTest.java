package gor_ui.login_page.forget_password;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static common.consts.DataTest.*;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Восстановление пароля")
public class SmsCodeNotValidTest extends BaseForgetPage {

    @Test(groups = {"regression"}, enabled = false)
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6156911")
    @Description("Проверка появления алерта при неверно введенном коде из смс при восстановлении пароля.")
    public void checkSamePassword() throws InterruptedException {
        openPageInputPassportAndClickSms();
        forgetPasswordPage.inputSmsCode(SMS_CODE_2_TIMES1);
        forgetPasswordPage.clickContinue();
        Assert.assertEquals(forgetPasswordPage.getClassErrorMassageSmsCode(), SMS_ERROR_CLASS);
        forgetPasswordPage.clearSmsCode(SMS_CODE_2_TIMES2);
        forgetPasswordPage.clickContinue();
        Assert.assertEquals(forgetPasswordPage.getClassErrorMassageSmsCode(), SMS_ERROR_CLASS);
        forgetPasswordPage.clearSmsCode(SMS_CODE_2_TIMES3);
        forgetPasswordPage.clickContinue();
        Assert.assertEquals(forgetPasswordPage.getClassErrorMassageSmsCode1(), SMS_ERROR_CLASS);
        Thread.sleep(27000);
    }
}