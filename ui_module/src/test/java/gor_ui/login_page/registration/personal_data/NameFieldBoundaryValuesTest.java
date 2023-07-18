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
public class NameFieldBoundaryValuesTest extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6188961")
    @Description("WINDOWS ONLY.Граничные значения в полей Фамилия")
    public void nameBoundaryValues() {
        openRegistrationAddDateNotName();
        Assert.assertFalse(registrationPage.buttonContinueRegistrationClick());
        Assert.assertEquals(registrationPage.getClassOfErrorTextEmptyField(RegistrationField.NAME), ERROR_MASSAGE_EMPTY_FIELD);
        registrationPage.inputPersonalData(RegistrationField.NAME, LETTER);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.NAME), LETTER);
        Assert.assertTrue(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.inputWithCustomClear(RegistrationField.NAME, VALID_LETTER_15);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.NAME), VALID_LETTER_15);
        Assert.assertTrue(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.inputWithCustomClear(RegistrationField.NAME, VALID_LETTER_30);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.NAME), VALID_LETTER_30);
        Assert.assertTrue(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.inputWithCustomClear(RegistrationField.NAME, VALID_LETTER_30 + LETTER);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.NAME), VALID_LETTER_30);
    }
}

