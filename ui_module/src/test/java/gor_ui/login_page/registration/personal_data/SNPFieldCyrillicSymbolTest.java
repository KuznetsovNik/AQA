package gor_ui.login_page.registration.personal_data;

import gor_ui.login_page.login.BaseLoginPage;
import gor_ui.login_page.registration.BaseRegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationField;

import static common.consts.DataTest.CYRILLIC;
import static common.consts.DataTest.CYRILLIC_VALID_SYMBOL;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("YarotskayaE")
@Story("Регистрация нового клиента.")
public class SNPFieldCyrillicSymbolTest extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6197169")
    @Description("Введенные в поля ФИО строчные и заглавные буквы кириллицы с допустимыми спецсимволами отображаются.")
    public void checkCyrillicSymbolSNPF() {
        openRegistrationAddCodeAndClickContinue();
        registrationPage.inputPersonalData(RegistrationField.SURNAME, CYRILLIC_VALID_SYMBOL);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.SURNAME), CYRILLIC_VALID_SYMBOL);
        registrationPage.inputPersonalData(RegistrationField.NAME, CYRILLIC_VALID_SYMBOL);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.NAME), CYRILLIC_VALID_SYMBOL);
        registrationPage.inputPersonalData(RegistrationField.PATRONYMIC, CYRILLIC_VALID_SYMBOL);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.PATRONYMIC), CYRILLIC_VALID_SYMBOL);
    }
}