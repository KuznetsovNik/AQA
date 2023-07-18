package gor_ui.login_page.registration.phone;

import gor_ui.login_page.registration.BaseRegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationField;
import static common.consts.DataTest.*;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("YarotskayaE")
@Story("Регистрация нового клиента.")
public class PhoneFieldBoundaryValuesTest extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6173090")
    @Description("Проверка граничных значений для поля ввода номера телефона")
    public void phoneBoundaryValues() {
        openRegistrationAndClickOnField();
        Assert.assertFalse(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.inputPersonalData(RegistrationField.PHONE, ONE_NUMBER);
        Assert.assertFalse(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.inputPersonalData(RegistrationField.PHONE, FOUR_NUMBERS);
        Assert.assertFalse(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.inputPersonalData(RegistrationField.PHONE, FOUR_NUMBERS);
        Assert.assertFalse(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.inputPersonalData(RegistrationField.PHONE, ONE_NUMBER_EIGHT);
        Assert.assertTrue(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.inputPersonalData(RegistrationField.PHONE, ONE_NUMBER_EIGHT);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.PHONE), VALID_PHONE_NUMBER_VALUE_NEW);
    }
}
