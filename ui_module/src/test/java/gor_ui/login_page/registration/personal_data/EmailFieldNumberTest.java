package gor_ui.login_page.registration.personal_data;

import gor_ui.login_page.login.BaseLoginPage;
import gor_ui.login_page.registration.BaseRegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationField;

import static common.consts.DataTest.ADD_SYMBOL9;
import static common.consts.DataTest.ERROR_MASSAGE_EMPTY_FIELD;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("YarotskayaE")
@Story("Регистрация нового клиента.")
public class EmailFieldNumberTest extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6190822")
    @Description("Введенные в поля email цифр, они отображаются, но появляется error-massage")
    public void checkLettersEmail() {
        openRegistrationAddDateNotEmail();
        registrationPage.inputPersonalData(RegistrationField.EMAIL, ADD_SYMBOL9+ADD_SYMBOL9);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.EMAIL), ADD_SYMBOL9+ADD_SYMBOL9);
        Assert.assertEquals(registrationPage.getClassOfErrorText(RegistrationField.EMAIL), ERROR_MASSAGE_EMPTY_FIELD);
    }
}