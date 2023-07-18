package gor_ui.login_page.registration.personal_data;

import gor_ui.login_page.registration.BaseRegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationField;
import static common.consts.DataTest.CYRILLIC;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("YarotskayaE")
@Story("Регистрация нового клиента.")
public class SNPFieldCyrillicTest extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6197093")
    @Description("Введенные в поля ФИО строчные и заглавные кириллицы, буквы отображаются.")
    public void checkCyrillicSNPF() {
        openRegistrationAddCodeAndClickContinue();
        registrationPage.inputPersonalData(RegistrationField.SURNAME, CYRILLIC);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.SURNAME), CYRILLIC);
        registrationPage.inputPersonalData(RegistrationField.NAME, CYRILLIC);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.NAME), CYRILLIC);
        registrationPage.inputPersonalData(RegistrationField.PATRONYMIC, CYRILLIC);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.PATRONYMIC), CYRILLIC);
    }
}