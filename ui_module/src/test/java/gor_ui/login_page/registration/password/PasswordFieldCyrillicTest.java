package gor_ui.login_page.registration.password;

import gor_ui.login_page.registration.BaseRegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationField;
import static common.consts.DataTest.*;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Регистрация нового клиента")
public class PasswordFieldCyrillicTest extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6192808")
    @Description("Введенные заглавные и строчные буквы кириллицы в поля Придумайте пароль и Подтвердите пароль не отображаются(пороли совпадают).")
    public void checkPasswordCyrillic() {
        openRegistrationAddAllDateAndClickContinue();
        registrationPage.inputPersonalData(RegistrationField.PASSWORD, CYRILLIC);
        registrationPage.inputPersonalData(RegistrationField.CONFIRM_PASSWORD, CYRILLIC);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.PASSWORD), NEW_PASSWORD_EMPTY);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.CONFIRM_PASSWORD), NEW_PASSWORD_EMPTY);
        Assert.assertFalse(registrationPage.isButtonContinueRegistrationClickable());
    }
}