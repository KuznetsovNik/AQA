package gor_ui.login_page.registration.phone;

import gor_ui.login_page.registration.BaseRegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationField;
import static common.consts.DataTest.CYRILLIC;
import static common.consts.DataTest.NUMBER_PHONE_EMPTY;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("YarotskayaE")
@Story("Регистрация нового клиента.")
public class PhoneFieldCyrillicTest extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6181476")
    @Description("Ввод в поле ввода номера телефона букв кириллицы")
    public void checkCyrillicPhone() {
        openRegistrationAndClickOnField();
        registrationPage.inputPersonalData(RegistrationField.PHONE, CYRILLIC);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.PHONE), NUMBER_PHONE_EMPTY);
    }
}