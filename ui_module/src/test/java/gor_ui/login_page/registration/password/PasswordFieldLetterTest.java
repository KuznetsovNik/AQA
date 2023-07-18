package gor_ui.login_page.registration.password;

import gor_ui.login_page.registration.BaseRegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationField;
import pages.TypeOfErrorMassage;

import static common.consts.DataTest.LETTERS;
import static common.consts.DataTest.PASSWORD_ERROR_CLASS;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Регистрация нового клиента")
public class PasswordFieldLetterTest extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6192825")
    @Description("Введенные латинские заглавные и строчные буквы в поля Придумайте пароль и Подтвердите пароль не отображаются(пороли совпадают).")
    public void checkPasswordLetter() {
        openRegistrationAddAllDateAndClickContinue();
        registrationPage.inputPersonalData(RegistrationField.PASSWORD, LETTERS);
        registrationPage.inputPersonalData(RegistrationField.CONFIRM_PASSWORD, LETTERS);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.PASSWORD), LETTERS);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.CONFIRM_PASSWORD), LETTERS);
        Assert.assertEquals(registrationPage.getClassOfErrorText(RegistrationField.PASSWORD, TypeOfErrorMassage.INCORRECT_CONTENT), PASSWORD_ERROR_CLASS);
    }
}