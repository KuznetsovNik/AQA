package gor_ui.login_page.forget_password;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static common.consts.DataTest.SPECIAL_SYMBOL;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Восстановление пароля")
public class SmsCodeFieldSymbolTest extends BaseForgetPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6186486")
    @Description("Введенные в поле ввода Укажите код  специальные символы не отображаются.")
    public void checkSmsCodeSymbol() {
        openPageInputPassportAndClickSms();
        forgetPasswordPage.inputSmsCode(SPECIAL_SYMBOL);
        Assert.assertFalse(forgetPasswordPage.isButtonContinueClickable());
    }
}