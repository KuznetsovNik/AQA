package gor_ui.login_page.registration.question;

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
public class QuestionFieldInValidBoundaryValuesTest extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6173178")
    @Description("Проверить невалидные граничные значения полей Напишите свой вопрос, Напишите ответ на контрольный вопрос.")
    public void checkInValid() {
        openRegistrationAddAllDateAndAddPasswordAndClickContinue();
        registrationPage.clickQuestions6();
        registrationPage.inputPersonalData(RegistrationField.WRITE_QUESTION, VALID_SYMBOL_51);
        registrationPage.inputPersonalData(RegistrationField.WRITE_ANSWER, VALID_SYMBOL_51);
        registrationPage.clickOnPage();
        Assert.assertFalse(registrationPage.isButtonContinueRegistrationClickable());
        Assert.assertEquals(registrationPage.getClassOfErrorText(RegistrationField.WRITE_QUESTION, TypeOfErrorMassage.EXCESS_LENGTH), QUESTION_ERROR_CLASS);
        registrationPage.inputWithCustomClear(RegistrationField.WRITE_QUESTION, SNP_EMPTY);
        registrationPage.inputWithCustomClear(RegistrationField.WRITE_ANSWER,SNP_EMPTY);
        Assert.assertFalse(registrationPage.isButtonContinueRegistrationClickable());
    }
}
