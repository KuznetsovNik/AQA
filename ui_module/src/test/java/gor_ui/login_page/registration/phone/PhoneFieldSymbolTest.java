package gor_ui.login_page.registration.phone;

import gor_ui.login_page.registration.BaseRegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationField;
import static common.consts.DataTest.NUMBER_PHONE_EMPTY;
import static common.consts.DataTest.SPECIAL_SYMBOL;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("YarotskayaE")
@Story("Регистрация нового клиента.")
public class PhoneFieldSymbolTest extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6173091")
    @Description("Возможность ввода в поле ввода пароля спец.символов.")
    public void checkSymbols() {
        openRegistrationAndClickOnField();
        registrationPage.inputPersonalData(RegistrationField.PHONE, SPECIAL_SYMBOL);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.PHONE), NUMBER_PHONE_EMPTY);
    }
}