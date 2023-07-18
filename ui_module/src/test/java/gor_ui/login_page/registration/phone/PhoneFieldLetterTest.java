package gor_ui.login_page.registration.phone;

import gor_ui.login_page.registration.BaseRegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationField;
import static common.consts.DataTest.LETTERS;
import static common.consts.DataTest.NUMBER_PHONE_EMPTY;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("YarotskayaE")
@Story("Регистрация нового клиента.")
public class PhoneFieldLetterTest extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6181475")
    @Description("Введенные в поле ввода телефона строчные и заглавные латинские буквы не отображаются.")
    public void checkLetters() {
        openRegistrationAndClickOnField();
        registrationPage.inputPersonalData(RegistrationField.PHONE, LETTERS);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.PHONE), NUMBER_PHONE_EMPTY);
    }
}