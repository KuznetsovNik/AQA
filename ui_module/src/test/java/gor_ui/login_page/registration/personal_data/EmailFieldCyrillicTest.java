package gor_ui.login_page.registration.personal_data;

import gor_ui.login_page.registration.BaseRegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationField;

import static common.consts.DataTest.ERROR_MASSAGE_EMPTY_FIELD;
import static common.consts.DataTest.SPECIAL_SYMBOL;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("YarotskayaE")
@Story("Регистрация нового клиента.")
public class EmailFieldCyrillicTest extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6173155")
    @Description("Введенные в поля email строчные и заглавные кириллицы, буквы отображаются, но появляется error-massage")
    public void checkCyrillicEmail() {
        openRegistrationAddDateNotEmail();
        registrationPage.inputPersonalData(RegistrationField.EMAIL, SPECIAL_SYMBOL);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.EMAIL), SPECIAL_SYMBOL);
        Assert.assertEquals(registrationPage.getClassOfErrorText(RegistrationField.EMAIL), ERROR_MASSAGE_EMPTY_FIELD);
    }
}