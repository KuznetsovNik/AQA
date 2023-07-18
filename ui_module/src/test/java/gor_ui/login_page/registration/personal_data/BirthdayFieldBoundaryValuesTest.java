package gor_ui.login_page.registration.personal_data;

import gor_ui.login_page.registration.BaseRegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationField;
import pages.TypeOfErrorMassage;

import static common.consts.DataTest.*;
import static pages.Day.*;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("YarotskayaE")
@Story("Регистрация нового клиента.")
public class BirthdayFieldBoundaryValuesTest extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6211649")
    @Description("WINDOWS ONLY.Введенные в поля дата рождения граничных значений.")
    public void checkBoundaryValues() {
        openRegistrationAddDateNotBirth();
        registrationPage.inputWithCustomClear(RegistrationField.BIRTHDAY, NOT_VALID_BIRTHDAY);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.BIRTHDAY),NOT_VALID_BIRTHDAY);
        Assert.assertFalse(registrationPage.isButtonContinueRegistrationClickable());
        Assert.assertEquals(registrationPage.getClassOfErrorText(RegistrationField.BIRTHDAY, TypeOfErrorMassage.INVALID_DATE), ERROR_MASSAGE_EMPTY_FIELD);
        registrationPage.inputWithCustomClear(RegistrationField.BIRTHDAY, MAX_VALID_BIRTHDAY);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.BIRTHDAY), MAX_VALID_BIRTHDAY);
        Assert.assertTrue(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.inputWithCustomClear(RegistrationField.BIRTHDAY, getEighteenYearsAgoDate());
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.BIRTHDAY), getEighteenYearsAgoDate());
        Assert.assertTrue(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.inputWithCustomClear(RegistrationField.BIRTHDAY, getSeventeenYearsAgoDate());
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.BIRTHDAY), getSeventeenYearsAgoDate());
        Assert.assertFalse(registrationPage.isButtonContinueRegistrationClickable());
    }
}