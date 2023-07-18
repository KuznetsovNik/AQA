package gor_ui.login_page.registration.personal_data;

import common.consts.DataTest;
import gor_ui.login_page.registration.BaseRegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationField;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("YarotskayaE")
@Story("Регистрация нового клиента.")
public class EnterDataSuccessfulTest extends BaseRegistrationPage {

    @Test(groups = {"smoke"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6173147")
    @Description("Введите личных данных регистрации клиента осуществляется успешно.")
    public void codeEnterSuccessful() {
        openRegistrationAddAllDateAndClickContinue();
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.PASSWORD), DataTest.PASSWORD_EMPTY_NULL);
    }
}
