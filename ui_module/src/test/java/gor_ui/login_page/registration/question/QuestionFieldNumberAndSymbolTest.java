package gor_ui.login_page.registration.question;

import gor_ui.login_page.registration.BaseRegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationField;
import static common.consts.DataTest.VALID_NUMBER_AND_SYMBOL;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Регистрация нового клиента")
public class QuestionFieldNumberAndSymbolTest extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6204190")
    @Description("Введенные цифры и допустимые символы в поля Напишите свой вопрос и Ответ на контрольный вопрос отображаются.")
    public void checkQuestionNumberAndSymbol() {
        openRegistrationAddAllDateAndAddPasswordAndClickContinue();
        registrationPage.clickQuestions6();
        registrationPage.inputPersonalData(RegistrationField.WRITE_QUESTION, VALID_NUMBER_AND_SYMBOL);
        registrationPage.inputPersonalData(RegistrationField.WRITE_ANSWER, VALID_NUMBER_AND_SYMBOL);
        Assert.assertTrue(registrationPage.isButtonContinueRegistrationClickable());
    }
}
