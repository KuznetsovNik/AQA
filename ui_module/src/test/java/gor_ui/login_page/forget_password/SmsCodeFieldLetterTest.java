package gor_ui.login_page.forget_password;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static common.consts.DataTest.LETTERS;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Восстановление пароля")
public class SmsCodeFieldLetterTest extends BaseForgetPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6186484")
    @Description("Введенные в поле ввода Укажите код  строчные и заглавные латинские буквы не отображаются.")
    public void checkSmsCodeLetter() {
        openPageInputPassportAndClickSms();
        forgetPasswordPage.inputSmsCode(LETTERS);
        Assert.assertTrue(forgetPasswordPage.isButtonContinueClickable());
    }
}