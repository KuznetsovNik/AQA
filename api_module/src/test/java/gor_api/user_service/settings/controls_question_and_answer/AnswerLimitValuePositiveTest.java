package gor_api.user_service.settings.controls_question_and_answer;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.apache.http.HttpStatus;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static constant.DataConstants.LOGIN_VALID_RU;
import static constant.DataConstants.RETURN_ANSWER;
import static constant.DataConstants.RETURN_QUESTION;
import static constant.DataConstants.SECURITY_QUESTION;
import static constant.DataConstants.TYPE_PHONE;
import static model.Location.RU;
import static org.testng.Assert.assertEquals;
import static property.BaseProperties.PASSWORD;

@Epic("EP-15 Изменение контрольного вопроса/ответа")
@Owner("Чесноков Д.А.")
@Story("User-Service. Изменение контрольного ответа")
@TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6423619")
public class AnswerLimitValuePositiveTest extends BaseControlQuestionAndAnswer {

    @DataProvider(name = "validLimitValue")
    public Object[][] getValidLimitValue() {
        return new Object[][] {
                {SECURITY_QUESTION, "Q"},
                {SECURITY_QUESTION, "q"},
                {SECURITY_QUESTION, "1"},
                {SECURITY_QUESTION, "Дд"},
                {SECURITY_QUESTION, "девичьядевичьядевичьядевичьядевичьядевичьядевичья"},
                {SECURITY_QUESTION, "девичьядевичьядевичьядевичьядевичьядевичьядевичьяд"}
        };
    }

    @Test(suiteName = "user_service", groups = {"regression"}, dataProvider = "validLimitValue")
    @Description("Валидное граничное значение")
    public void answerValidLimitValueTest(String question, String answer) {
        assertEquals(HttpStatus.SC_OK, getAuthorizationResponse(question, answer).getStatusCode());
        assertEquals(answer, getUser().getSecurityAnswer());
        assertEquals(question, getUser().getSecurityQuestion());
    }

    @AfterMethod(alwaysRun = true)
    @Description("Возвращаем исходные данные")
    void returnQuestionAndAnswer() {
        setAccessToken(RU.getCode(), LOGIN_VALID_RU, PASSWORD, TYPE_PHONE);
        getAuthorizationResponse(RETURN_QUESTION, RETURN_ANSWER);
    }
}