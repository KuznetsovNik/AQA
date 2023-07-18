package gor_ui.login_page.forget_password;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static common.consts.DataTest.VALID_SMS_CODE;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Восстановление пароля")
public class EnterValidSmsCodeTest extends BaseForgetPage {

    @Test(groups = {"smoke"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6156898")
    @Description("Проверка валидных значений в поле Укажите код  при восстановлении пароля .")
    public void checkSmsCode() {
        openPageInputPassportAndClickSms();
        forgetPasswordPage.inputSmsCode(VALID_SMS_CODE);
        Assert.assertTrue(forgetPasswordPage.isButtonContinueClickable());
        forgetPasswordPage.clickContinue();
    }
}
