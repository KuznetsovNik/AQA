package gor_ui.login_page.registration.question;

import gor_ui.login_page.registration.BaseRegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationField;
import static common.consts.DataTest.CYRILLIC;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Регистрация нового клиента")
public class QuestionFieldCyrillicTest extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6204028")
    @Description("Введенные заглавные и строчные буквы кириллицы в поля Напишите свой вопрос и Ответ на контрольный вопрос отображаются.")
    public void checkQuestionCyrillic() {
        openRegistrationAddAllDateAndAddPasswordAndClickContinue();
        registrationPage.clickQuestions6();
        registrationPage.inputPersonalData(RegistrationField.WRITE_QUESTION, CYRILLIC);
        registrationPage.inputPersonalData(RegistrationField.WRITE_ANSWER, CYRILLIC);
        Assert.assertTrue(registrationPage.isButtonContinueRegistrationClickable());
    }
}
