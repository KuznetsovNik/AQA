package gor_ui.login_page.registration.personal_data;

import gor_ui.login_page.registration.BaseRegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationField;

import static common.consts.DataTest.*;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("YarotskayaE")
@Story("Регистрация нового клиента.")
public class EmailFieldBoundaryValuesTest extends BaseRegistrationPage {

    @Test(enabled = false, groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6173157")
    @Description("Граничные значения в полей Email")
    public void emailBoundaryValues() {
        openRegistrationAddDateNotEmail();
        Assert.assertFalse(registrationPage.buttonContinueRegistrationClick());
        Assert.assertEquals(registrationPage.getClassOfErrorTextEmptyField(RegistrationField.EMAIL), ERROR_MASSAGE_EMPTY_FIELD);
        registrationPage.inputPersonalData(RegistrationField.EMAIL, EMAIL_10_SYMBOLS);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.EMAIL), EMAIL_10_SYMBOLS);
        Assert.assertEquals(registrationPage.getClassOfErrorText(RegistrationField.EMAIL), ERROR_MASSAGE_EMPTY_FIELD);
        Assert.assertFalse(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.inputWithCustomClear(RegistrationField.EMAIL, EMAIL_11_SYMBOLS);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.EMAIL), EMAIL_11_SYMBOLS);
        Assert.assertTrue(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.inputWithCustomClear(RegistrationField.EMAIL, EMAIL_35_SYMBOLS);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.EMAIL), EMAIL_35_SYMBOLS);
        Assert.assertTrue(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.inputWithCustomClear(RegistrationField.EMAIL, EMAIL_36_SYMBOLS);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.EMAIL), EMAIL_36_SYMBOLS);
        Assert.assertEquals(registrationPage.getClassOfErrorTextEmptyField(RegistrationField.EMAIL), ERROR_MASSAGE_EMPTY_FIELD);
        Assert.assertFalse(registrationPage.isButtonContinueRegistrationClickable());
    }
}

