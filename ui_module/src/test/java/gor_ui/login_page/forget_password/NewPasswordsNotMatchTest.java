package gor_ui.login_page.forget_password;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static common.consts.DataTest.*;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Восстановление пароля")
public class NewPasswordsNotMatchTest extends BaseForgetPage {
    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6160974")
    @Description("Проверка появления алерта при  несовпадении полей Придумайте пароль и Подтвердите пароль.")
    public void checkSamePassword() {
        openPageInputPassportAndClickSms();
        addValidSmsCodeAndClickContinue();
        forgetPasswordPage.inputNewPassword(VALID_PASSPORT_PASSWORD);
        forgetPasswordPage.confirmNewPassword(VALID_PASSWORD_ANOTHER);
        forgetPasswordPage.clickOnPage();
        Assert.assertEquals(forgetPasswordPage.getClassErrorMassageTextPasswordNotMatch(), PASSWORD_ERROR_CLASS);
    }
}