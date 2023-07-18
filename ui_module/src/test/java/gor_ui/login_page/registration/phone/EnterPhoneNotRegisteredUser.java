package gor_ui.login_page.registration.phone;

import gor_ui.login_page.registration.BaseRegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationField;
import static common.consts.DataTest.*;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("YarotskayaE")
@Story("Регистрация нового клиента.")
public class EnterPhoneNotRegisteredUser extends BaseRegistrationPage {

    @Test(groups = {"smoke"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6173092")
    @Description("Регистрации клиента (ввод номера телефона не зарегистрированного в системе)")
    public void enterPhoneNotRegisteredUser() {
        openRegistrationAddPhoneClickContinue();
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.CODE), SMS_CODE_EMPTY);
    }
}