package gor_ui.login_page.registration.password;

import gor_ui.login_page.registration.BaseRegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationField;
import pages.TypeOfErrorMassage;

import static common.consts.DataTest.*;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Регистрация нового клиента")
public class PasswordFieldBoundaryValuesTest extends BaseRegistrationPage {

    @Test(groups = {"smoke"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6192205")
    @Description("WINDOWS ONLY.Проверка граничных значений в поля Придумайте пароль и Подтвердите пароль(пороли совпадают).")
    public void checkPasswordBoundaryValues() {
        openRegistrationAddAllDateAndClickContinue();
        registrationPage.inputPersonalData(RegistrationField.PASSWORD, NOT_VALID_PASS0);
        registrationPage.inputPersonalData(RegistrationField.CONFIRM_PASSWORD, NOT_VALID_PASS0);
        Assert.assertFalse(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.inputPersonalData(RegistrationField.PASSWORD, ADD_SYMBOL5);
        registrationPage.inputPersonalData(RegistrationField.CONFIRM_PASSWORD, ADD_SYMBOL5);
        Assert.assertEquals(registrationPage.getClassOfErrorText(RegistrationField.PASSWORD,TypeOfErrorMassage.INCORRECT_CONTENT), PASSWORD_ERROR_CLASS);
        registrationPage.inputPersonalData(RegistrationField.PASSWORD, ADD_SYMBOL1);
        registrationPage.inputPersonalData(RegistrationField.CONFIRM_PASSWORD, ADD_SYMBOL1);
        Assert.assertTrue(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.inputPersonalData(RegistrationField.PASSWORD, ADD_SYMBOL5);
        registrationPage.inputPersonalData(RegistrationField.CONFIRM_PASSWORD, ADD_SYMBOL5);
        Assert.assertTrue(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.inputPersonalData(RegistrationField.PASSWORD, ADD_SYMBOL9);
        registrationPage.inputPersonalData(RegistrationField.CONFIRM_PASSWORD, ADD_SYMBOL9);
        Assert.assertTrue(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.inputWithCustomClear(RegistrationField.PASSWORD, VALID_PASS21);
        registrationPage.inputWithCustomClear(RegistrationField.CONFIRM_PASSWORD, VALID_PASS21);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.PASSWORD), VALID_PASS20);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.CONFIRM_PASSWORD), VALID_PASS20);
    }
}