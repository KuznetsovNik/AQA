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
public class EnterCodeSuccessfulTest extends BaseRegistrationPage {

    @Test(groups = {"smoke"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6173115")
    @Description("Введите СМС-код регистрации клиента осуществляется успешно.")
    public void codeEnterSuccessful() {
        openRegistrationAddCodeAndClickContinue();
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.NAME), NAME_EMPTY);
    }
}
