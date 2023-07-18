package gor_ui.login_page.forget_password;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static common.consts.DataTest.*;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Восстановление пароля")
public class ForgetPasswordTest extends BaseForgetPage {

    @Test(groups = {"smoke"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6156857")
    @Description("Проверка валидных значений в поле номер паспорта при восстановлении пароля, проверка активности кнопки продолжить.")
    public void checkValidFieldAndButton() {
        openForgetPassword();
        forgetPasswordPage.inputFieldPassport(VALID_PASSPORT);
        forgetPasswordPage.clickButtonGo();
        Assert.assertTrue(forgetPasswordPage.isButtonContinueClickable());
    }
}
