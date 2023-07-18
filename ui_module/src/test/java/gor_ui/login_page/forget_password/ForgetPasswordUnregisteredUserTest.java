package gor_ui.login_page.forget_password;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static common.consts.DataTest.FORGET_PASSWORD_ERROR_CLASS;
import static common.consts.DataTest.NOT_VALID_PASSPORT;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Восстановление пароля")
public class ForgetPasswordUnregisteredUserTest extends BaseForgetPage {

    @Test(groups = {"smoke"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6156897")
    @Description("Проверка восстановления пароля при незарегистрированном номере паспорта")
    public void checkUnregisteredUser() {
        openForgetPassword();
        forgetPasswordPage.inputFieldPassport(NOT_VALID_PASSPORT);
        forgetPasswordPage.clickContinue();
        Assert.assertEquals(forgetPasswordPage.getClassErrorMassageUser(), FORGET_PASSWORD_ERROR_CLASS);
    }
}
