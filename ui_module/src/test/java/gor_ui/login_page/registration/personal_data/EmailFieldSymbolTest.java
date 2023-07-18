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
public class EmailFieldSymbolTest extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6173156")
    @Description("WINDOWS ONLY.Введенные в поля email спецсимволы, они отображаются, но появляется error-massage")
    public void checkLettersEmail() {
        openRegistrationAddDateNotEmail();
        registrationPage.inputPersonalData(RegistrationField.EMAIL, LETTERS);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.EMAIL), LETTERS);
        Assert.assertEquals(registrationPage.getClassOfErrorText(RegistrationField.EMAIL), ERROR_MASSAGE_EMPTY_FIELD);
        registrationPage.inputWithCustomClear(RegistrationField.EMAIL, EMAIL_12_SYMBOLS_HYPHEN);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.EMAIL), EMAIL_12_SYMBOLS_HYPHEN);
        Assert.assertTrue(registrationPage.isButtonContinueRegistrationClickable());
    }
}