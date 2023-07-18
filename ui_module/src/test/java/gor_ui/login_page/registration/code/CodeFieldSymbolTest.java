package gor_ui.login_page.registration.code;

import gor_ui.login_page.registration.BaseRegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationField;
import static common.consts.DataTest.SMS_CODE_EMPTY_STARS;
import static common.consts.DataTest.SPECIAL_SYMBOL;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("YarotskayaE")
@Story("Регистрация нового клиента.")
public class CodeFieldSymbolTest extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6173108")
    @Description("Возможность ввода в поле ввода пароля спец.символов.")
    public void checkSymbols() {
        openRegistrationAndClickCodeField();
        registrationPage.inputPersonalData(RegistrationField.CODE, SPECIAL_SYMBOL);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.CODE), SMS_CODE_EMPTY_STARS);
    }
}