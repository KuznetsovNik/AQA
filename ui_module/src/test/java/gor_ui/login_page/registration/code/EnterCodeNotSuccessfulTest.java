package gor_ui.login_page.registration.code;

import gor_ui.login_page.registration.BaseRegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationField;
import static common.consts.DataTest.NOT_VALID_SMS_CODE;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("YarotskayaE")
@Story("Регистрация нового клиента.")
public class EnterCodeNotSuccessfulTest extends BaseRegistrationPage {

    @Test(enabled = false, groups = {"smoke"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6173117" +
            "https://vmmreg32.testrail.net/index.php?/cases/view/6173118" +
            "https://vmmreg32.testrail.net/index.php?/cases/view/6173119")
    @Description("Введите СМС-код регистрации клиента осуществляется не успешно с 3 попыток.")
    public void codeEnterNotSuccessful() throws InterruptedException {
        openRegistrationAndClickCodeField();
        registrationPage.inputWithCustomClear(RegistrationField.CODE, NOT_VALID_SMS_CODE);
        registrationPage.buttonContinueRegistrationClick();
        Assert.assertTrue(registrationPage.isErrorMassageCodeVisible());
        registrationPage.inputWithCustomClear(RegistrationField.CODE, NOT_VALID_SMS_CODE);
        registrationPage.buttonContinueRegistrationClick();
        Assert.assertTrue(registrationPage.isErrorMassageCodeVisible());
        registrationPage.inputWithCustomClear(RegistrationField.CODE, NOT_VALID_SMS_CODE);
        registrationPage.buttonContinueRegistrationClick();
        Assert.assertTrue(registrationPage.isErrorMassageCodeVisible());
        Assert.assertFalse(registrationPage.isButtonContinueRegistrationClickable());
        Thread.sleep(27000);
    }
}
