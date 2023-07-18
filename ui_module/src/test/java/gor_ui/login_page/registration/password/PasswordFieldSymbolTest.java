package gor_ui.login_page.registration.password;

import gor_ui.login_page.registration.BaseRegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationField;
import pages.TypeOfErrorMassage;

import static common.consts.DataTest.PASSWORD_ERROR_CLASS;
import static common.consts.DataTest.SPECIAL_SYMBOL;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Регистрация нового клиента")
public class PasswordFieldSymbolTest extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6192829")
    @Description("Введенные специальные символы в поля Придумайте пароль и Подтвердите пароль не отображаются(пороли совпадают).")
    public void checkPasswordSymbol() {
        openRegistrationAddAllDateAndClickContinue();
        registrationPage.inputPersonalData(RegistrationField.PASSWORD, SPECIAL_SYMBOL);
        registrationPage.inputPersonalData(RegistrationField.CONFIRM_PASSWORD, SPECIAL_SYMBOL);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.PASSWORD), SPECIAL_SYMBOL);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.CONFIRM_PASSWORD), SPECIAL_SYMBOL);
        Assert.assertEquals(registrationPage.getClassOfErrorText(RegistrationField.PASSWORD, TypeOfErrorMassage.INCORRECT_CONTENT), PASSWORD_ERROR_CLASS);
    }
}