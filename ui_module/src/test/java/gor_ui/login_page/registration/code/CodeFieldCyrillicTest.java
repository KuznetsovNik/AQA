package gor_ui.login_page.registration.code;

import gor_ui.login_page.registration.BaseRegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationField;
import static common.consts.DataTest.*;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("YarotskayaE")
@Story("Регистрация нового клиента.")
public class CodeFieldCyrillicTest extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6181598")
    @Description("Ввод в поле ввода номера телефона букв кириллицы")
    public void checkCyrillicPhone() {
        openRegistrationAndClickCodeField();
        registrationPage.inputPersonalData(RegistrationField.CODE,CYRILLIC);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.CODE), SMS_CODE_EMPTY_STARS);
    }
}