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
public class PassportFieldBoundaryValuesTest extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6173137")
    @Description("Проверка граничных значений для поля ввода паспорта")
    public void passportBoundaryValues() {
        openRegistrationAddDateNotPassport();
        registrationPage.clickField(RegistrationField.PASSPORT);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.PASSPORT), PASSPORT_EMPTY_NUMBER_UNDERSCORES);
        Assert.assertFalse(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.inputPersonalData(RegistrationField.PASSPORT, ONE_NUMBER);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.PASSPORT), PASSPORT_ONE_NUMBERS);
        Assert.assertFalse(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.inputPersonalData(RegistrationField.PASSPORT, FOUR_NUMBERS);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.PASSPORT), PASSPORT_FIVE_NUMBERS);
        Assert.assertFalse(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.inputPersonalData(RegistrationField.PASSPORT, FOUR_NUMBERS);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.PASSPORT), PASSPORT_NINE_NUMBERS);
        Assert.assertFalse(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.inputPersonalData(RegistrationField.PASSPORT, ONE_NUMBER_EIGHT);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.PASSPORT), VALID_PASSPORT);
        Assert.assertTrue(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.inputWithCustomClear(RegistrationField.PASSPORT, VALID_PASSPORT+ONE_NUMBER_EIGHT);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.PASSPORT), VALID_PASSPORT);
    }
}

