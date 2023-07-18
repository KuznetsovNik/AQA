package gor_ui.login_page.registration.question;

import gor_ui.login_page.registration.BaseRegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationField;
import static common.consts.DataTest.LETTERS;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Регистрация нового клиента")
public class QuestionFieldLetterTest extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6204030")
    @Description("Введенные заглавные и строчные буквы латиницы в поля Напишите свой вопрос и Ответ на контрольный вопрос отображаются.")
    public void checkQuestionLetters() {
        openRegistrationAddAllDateAndAddPasswordAndClickContinue();
        registrationPage.clickQuestions6();
        registrationPage.inputPersonalData(RegistrationField.WRITE_QUESTION, LETTERS);
        registrationPage.inputPersonalData(RegistrationField.WRITE_ANSWER, LETTERS);
        Assert.assertTrue(registrationPage.isButtonContinueRegistrationClickable());
    }
}
