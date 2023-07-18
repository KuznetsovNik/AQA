package gor_ui.login_page.registration.phone;

import common.config.AppConfigProvider;
import gor_ui.login_page.registration.BaseRegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationField;
import static common.consts.DataTest.PHONE_REGISTERED_USER_ERROR_CLASS;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("YarotskayaE")
@Story("Регистрация нового клиента.")
public class EnterPhoneRegisteredUser extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6173093")
    @Description("Регистрации клиента (ввод уже зарегистрированного в системе номера телефона) не осуществляется")
    public void enterPhoneRegisteredUser() {
        openRegistrationAndClickOnField();
        registrationPage.inputPersonalData(RegistrationField.PHONE, AppConfigProvider.get().userNumberPhone());
        registrationPage.buttonContinueRegistrationClick();
        Assert.assertEquals(registrationPage.getClassOfErrorText(RegistrationField.PHONE), PHONE_REGISTERED_USER_ERROR_CLASS);
        Assert.assertTrue(registrationPage.isButtonComeInClickable());
        registrationPage.buttonContinueRegistrationClick();
        Assert.assertTrue(loginPage.isButtonEnterClickable());
    }
}