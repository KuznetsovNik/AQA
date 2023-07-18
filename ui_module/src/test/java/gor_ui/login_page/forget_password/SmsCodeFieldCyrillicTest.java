package gor_ui.login_page.forget_password;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static common.consts.DataTest.CYRILLIC;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Восстановление пароля")
public class SmsCodeFieldCyrillicTest extends BaseForgetPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6186442")
    @Description("Введенные в поле ввода Укажите код строчные и заглавные буквы кириллицы не отображаются.")
    public void checkSmsCodeCyrillic() {
        openPageInputPassportAndClickSms();
        forgetPasswordPage.inputSmsCode(CYRILLIC);
        Assert.assertTrue(forgetPasswordPage.isButtonContinueClickable());
    }
}