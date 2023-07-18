package gor_ui.login_page.registration.code;

import gor_ui.login_page.registration.BaseRegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationField;
import static common.consts.DataTest.LETTERS;
import static common.consts.DataTest.SMS_CODE_EMPTY_STARS;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("YarotskayaE")
@Story("Регистрация нового клиента.")
public class CodeFieldLetterTest extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6181597")
    @Description("Введенные в поле ввода телефона строчные и заглавные латинские буквы не отображаются.")
    public void checkLetters() {
        openRegistrationAndClickCodeField();
        registrationPage.inputPersonalData(RegistrationField.CODE, LETTERS);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.CODE), SMS_CODE_EMPTY_STARS);
    }
}