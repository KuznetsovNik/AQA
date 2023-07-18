package gor_ui.login_page.registration.question;


import gor_ui.login_page.registration.BaseRegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationField;
import static common.consts.DataTest.*;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Регистрация нового клиента")
public class QuestionFieldValidBoundaryValuesTest extends BaseRegistrationPage {
    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6173174")
    @Description("WINDOWS ONLY.Проверить валидные граничные значения полей Напишите свой вопрос, Напишите ответ на контрольный вопрос.")
    public void checkValid() {
        openRegistrationAddAllDateAndAddPasswordAndClickContinue();
        registrationPage.clickQuestions6();
        registrationPage.inputPersonalData(RegistrationField.WRITE_QUESTION,ONE_NUMBER);
        registrationPage.inputPersonalData(RegistrationField.WRITE_ANSWER,ONE_NUMBER);
        Assert.assertTrue(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.inputWithCustomClear(RegistrationField.WRITE_QUESTION, IN_VALID_SYMBOL_2);
        registrationPage.inputWithCustomClear(RegistrationField.WRITE_ANSWER,IN_VALID_SYMBOL_2);
        Assert.assertTrue(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.inputWithCustomClear(RegistrationField.WRITE_QUESTION, VALID_SYMBOL_50);
        registrationPage.inputWithCustomClear(RegistrationField.WRITE_ANSWER,VALID_SYMBOL_50);
        Assert.assertTrue(registrationPage.isButtonContinueRegistrationClickable());
        registrationPage.inputWithCustomClear(RegistrationField.WRITE_QUESTION, VALID_SYMBOL_49);
        registrationPage.inputWithCustomClear(RegistrationField.WRITE_ANSWER,VALID_SYMBOL_49);
        Assert.assertTrue(registrationPage.isButtonContinueRegistrationClickable());
    }
}
