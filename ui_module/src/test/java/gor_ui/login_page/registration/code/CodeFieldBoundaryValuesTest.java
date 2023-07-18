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
public class CodeFieldBoundaryValuesTest extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6173109" +
            "https://vmmreg32.testrail.net/index.php?/cases/view/6173110")
    @Description("Проверка граничных значений для поля ввода кода")
    public void checkBoundaryValues() {
        openRegistrationAndClickCodeField();
        Assert.assertFalse(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.inputPersonalData(RegistrationField.CODE, ONE_NUMBER);
        Assert.assertFalse(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.inputPersonalData(RegistrationField.CODE, FOUR_NUMBERS);
        Assert.assertFalse(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.inputPersonalData(RegistrationField.CODE, ONE_NUMBER);
        Assert.assertTrue(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.inputPersonalData(RegistrationField.CODE,ONE_NUMBER_EIGHT);
        Assert.assertEquals(registrationPage.getValueOfField(RegistrationField.CODE), VALID_SMS_CODE);
    }
}
