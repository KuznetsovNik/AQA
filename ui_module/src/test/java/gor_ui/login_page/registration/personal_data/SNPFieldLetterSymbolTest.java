package gor_ui.login_page.registration.personal_data;

import gor_ui.login_page.registration.BaseRegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationField;

import static common.consts.DataTest.LETTER_VALID_SYMBOL;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("YarotskayaE")
@Story("Регистрация нового клиента.")
public class SNPFieldLetterSymbolTest extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6197098")
    @Description("Введенные в поля ФИО строчные и заглавные латинские буквы с допустимыми спецсимволами отображаются.")
    public void checkLettersSymbolSNPF() {
        openRegistrationAddCodeAndClickContinue();
        registrationPage.inputPersonalData(RegistrationField.SURNAME, LETTER_VALID_SYMBOL);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.SURNAME), LETTER_VALID_SYMBOL);
        registrationPage.inputPersonalData(RegistrationField.NAME, LETTER_VALID_SYMBOL);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.NAME), LETTER_VALID_SYMBOL);
        registrationPage.inputPersonalData(RegistrationField.PATRONYMIC, LETTER_VALID_SYMBOL);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.PATRONYMIC), LETTER_VALID_SYMBOL);
    }
}