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
public class SNPFieldSymbolTest extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6173151")
    @Description("Введенные в поля ФИО спецсимволы, не отображаются кроме '-'")
    public void checkCyrillicSNPF() {
        openRegistrationAddCodeAndClickContinue();
        registrationPage.inputPersonalData(RegistrationField.SURNAME, SPECIAL_SYMBOL);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.SURNAME), SNP_EMPTY);
        registrationPage.inputPersonalData(RegistrationField.NAME, SPECIAL_SYMBOL);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.NAME), SNP_EMPTY);
        registrationPage.inputPersonalData(RegistrationField.PATRONYMIC, SPECIAL_SYMBOL);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.PATRONYMIC), SNP_EMPTY);
        registrationPage.inputPersonalData(RegistrationField.SURNAME, LETTER_DASH_VALID);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.SURNAME), LETTER_DASH_VALID);
        registrationPage.inputPersonalData(RegistrationField.NAME, LETTER_DASH_VALID);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.NAME), LETTER_DASH_VALID);
        registrationPage.inputPersonalData(RegistrationField.PATRONYMIC, LETTER_DASH_VALID);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.PATRONYMIC), LETTER_DASH_VALID);
    }
}