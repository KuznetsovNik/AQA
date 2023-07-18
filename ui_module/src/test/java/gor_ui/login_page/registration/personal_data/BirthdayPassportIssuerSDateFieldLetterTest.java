package gor_ui.login_page.registration.personal_data;

import gor_ui.login_page.registration.BaseRegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationField;

import static common.consts.DataTest.DATE_EMPTY;
import static common.consts.DataTest.LETTERS;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("YarotskayaE")
@Story("Регистрация нового клиента.")
public class BirthdayPassportIssuerSDateFieldLetterTest extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6188967")
    @Description("Введенные в поля дата рождения и выдачи паспорта строчные и заглавные латинские буквы не отображаются.")
    public void checkFieldLetter() {
        openRegistrationAddCodeAndClickContinue();
        registrationPage.inputPersonalData(RegistrationField.BIRTHDAY, LETTERS);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.BIRTHDAY), DATE_EMPTY);
        registrationPage.inputPersonalData(RegistrationField.DATE_PASSPORT_ISSUER, LETTERS);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.DATE_PASSPORT_ISSUER), DATE_EMPTY);
        Assert.assertFalse(registrationPage.isButtonContinueRegistrationClickable());
    }
}