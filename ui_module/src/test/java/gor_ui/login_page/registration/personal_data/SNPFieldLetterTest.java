package gor_ui.login_page.registration.personal_data;

import gor_ui.login_page.registration.BaseRegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationField;
import static common.consts.DataTest.LETTERS;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("YarotskayaE")
@Story("Регистрация нового клиента.")
public class SNPFieldLetterTest extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6194460")
    @Description("Введенные в поля ФИО строчные и заглавные латинские буквы отображаются.")
    public void checkLettersSNPF() {
        openRegistrationAddCodeAndClickContinue();
        registrationPage.inputPersonalData(RegistrationField.SURNAME, LETTERS);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.SURNAME), LETTERS);
        registrationPage.inputPersonalData(RegistrationField.NAME, LETTERS);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.NAME), LETTERS);
        registrationPage.inputPersonalData(RegistrationField.PATRONYMIC, LETTERS);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.PATRONYMIC), LETTERS);
    }
}