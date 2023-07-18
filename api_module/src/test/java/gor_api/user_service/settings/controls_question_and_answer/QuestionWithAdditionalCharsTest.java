package gor_api.user_service.settings.controls_question_and_answer;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.apache.http.HttpStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static constant.DataConstants.SECURITY_ANSWER;
import static org.testng.Assert.assertEquals;

@Epic("EP-15 Изменение контрольного вопроса/ответа")
@Owner("Чесноков Д.А.")
@Story("User-Service. Изменение контрольного вопроса")
@TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6423633")
public class QuestionWithAdditionalCharsTest extends BaseControlQuestionAndAnswer {

    @DataProvider(name = "additionalChars")
    public Object[][] getAdditionalChars() {
        return new Object[][] {
                {"-девичья", SECURITY_ANSWER},
                {" девичья", SECURITY_ANSWER},
                {"девичья-", SECURITY_ANSWER},
                {"девичья ", SECURITY_ANSWER}
        };
    }

    @Test(suiteName = "user_service", groups = {"regression"}, dataProvider = "additionalChars")
    @Description("Вспомогательные символы в начале / в конце")
    void questionAdditionalCharsTest(String question, String answer) {
        assertEquals(HttpStatus.SC_BAD_REQUEST, getAuthorizationResponse(question, answer).getStatusCode());
    }
}