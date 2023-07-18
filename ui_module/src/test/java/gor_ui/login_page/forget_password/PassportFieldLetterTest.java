package gor_ui.login_page.forget_password;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static common.consts.DataTest.LETTERS;
import static common.consts.DataTest.PASSPORT_EMPTY_NUMBER;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Восстановление пароля")
public class PassportFieldLetterTest extends BaseForgetPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6183074")
    @Description("Введенные в поле ввода паспорта строчные и заглавные латинские буквы не отображаются,кнопка Продолжить не активна")
    public void checkLetterPassport() {
        openForgetPassword();
        forgetPasswordPage.inputData(LETTERS);
        Assert.assertEquals(forgetPasswordPage.getValuePassportField(), PASSPORT_EMPTY_NUMBER);
        Assert.assertFalse(forgetPasswordPage.isButtonContinueClickable());
    }
}