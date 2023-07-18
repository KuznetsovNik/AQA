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
public class PassportFieldCyrillicTest extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6173155")
    @Description("Введенные в поле ввода паспорта строчные и заглавные буквы кириллицы не отображаются.")
    public void checkCyrillicPassport() {
        openRegistrationAddCodeAndClickContinue();
        registrationPage.clickField(RegistrationField.PASSPORT);
        registrationPage.inputPersonalData(RegistrationField.PASSPORT, CYRILLIC);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.PASSPORT), PASSPORT_EMPTY_NUMBER_UNDERSCORES);
    }
}
