package gor_ui.login_page.registration.question;

import gor_ui.login_page.registration.BaseRegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Регистрация нового клиента")
public class CheckDropdown extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6173177")
    @Description("Проверка работы dropdown Выберите контрольный вопрос")
    public void checkDropdown() {
        openRegistrationAddAllDateAndAddPasswordAndClickContinue();
        registrationPage.clickQuestions1();
        Assert.assertFalse(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.clickQuestions2();
        Assert.assertFalse(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.clickQuestions3();
        Assert.assertFalse(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.clickQuestions4();
        Assert.assertFalse(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.clickQuestions5();
        Assert.assertFalse(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.clickQuestions6();
        Assert.assertFalse(registrationPage.isButtonContinueRegistrationClickable());
        Assert.assertTrue(registrationPage.isVisibleField());
        Assert.assertTrue(registrationPage.isVisibleField2());
    }
}
