package gor_ui.login_page.forget_password;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static common.consts.DataTest.PASSPORT_EMPTY_NUMBER;
import static common.consts.DataTest.SPECIAL_SYMBOL;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Восстановление пароля")
public class PassportFieldSymbolTest extends BaseForgetPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6183075")
    @Description("Введенные в поле ввода паспорта специальные символы не отображаются,кнопка Продолжить не активна.")
    public void checkSymbolPassport() {
        openForgetPassword();
        forgetPasswordPage.inputData(SPECIAL_SYMBOL);
        Assert.assertEquals(forgetPasswordPage.getValuePassportField(), PASSPORT_EMPTY_NUMBER);
        Assert.assertFalse(forgetPasswordPage.isButtonContinueClickable());
    }
}