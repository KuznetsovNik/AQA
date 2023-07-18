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
public class QuestionFieldSymbolTest extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6173175")
    @Description("Проверка отображения алерта при вводе некорректных символов в поля Напишите свой вопрос и Ответ на контрольный вопрос.")
    public void checkQuestionNumberAndSymbol() {
        openRegistrationAddAllDateAndAddPasswordAndClickContinue();
        registrationPage.clickQuestions6();
        registrationPage.inputPersonalData(RegistrationField.WRITE_QUESTION, SPECIAL_SYMBOL);
        registrationPage.inputPersonalData(RegistrationField.WRITE_ANSWER, SPECIAL_SYMBOL);
        registrationPage.clickOnPage();
        Assert.assertEquals(registrationPage.getClassOfErrorText(RegistrationField.WRITE_QUESTION, TypeOfErrorMassage.INVALID_SYMBOL), QUESTION_ERROR_CLASS);
        registrationPage.inputWithCustomClear(RegistrationField.WRITE_QUESTION, VALID_SYMBOL1);
        registrationPage.inputWithCustomClear(RegistrationField.WRITE_ANSWER, VALID_SYMBOL1);
        Assert.assertEquals(registrationPage.getClassOfErrorText(RegistrationField.WRITE_QUESTION,TypeOfErrorMassage.INVALID_SYMBOL), QUESTION_ERROR_CLASS);
        registrationPage.inputWithCustomClear(RegistrationField.WRITE_QUESTION, VALID_SYMBOL2);
        registrationPage.inputWithCustomClear(RegistrationField.WRITE_ANSWER, VALID_SYMBOL2);
        Assert.assertEquals(registrationPage.getClassOfErrorText(RegistrationField.WRITE_QUESTION,TypeOfErrorMassage.INVALID_SYMBOL), QUESTION_ERROR_CLASS);
    }
}
