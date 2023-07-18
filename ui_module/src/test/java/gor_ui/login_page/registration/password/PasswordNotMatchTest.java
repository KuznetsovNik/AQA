package gor_ui.login_page.registration.password;

import gor_ui.login_page.registration.BaseRegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationField;
import pages.TypeOfErrorMassage;

import static common.consts.DataTest.*;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Регистрация нового клиента")
public class PasswordNotMatchTest extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6173166")
    @Description("Проверка появления алерта при несовпадении полей Придумайте пароль и Подтвердите пароль.")
    public void checkPasswords() {
        openRegistrationAddAllDateAndClickContinue();
        registrationPage.inputPersonalData(RegistrationField.PASSWORD, VALID_PASSPORT_PASSWORD);
        registrationPage.inputPersonalData(RegistrationField.CONFIRM_PASSWORD, VALID_PASSWORD_ANOTHER);
        registrationPage.clickOnPage();
        Assert.assertEquals(registrationPage.getClassOfErrorText(RegistrationField.PASSWORD, TypeOfErrorMassage.LINES_NOT_MATCH), PASSWORD_ERROR_CLASS);
    }
}