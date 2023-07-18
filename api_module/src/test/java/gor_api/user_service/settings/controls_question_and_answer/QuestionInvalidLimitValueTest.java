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
@TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6423613")
public class QuestionInvalidLimitValueTest extends BaseControlQuestionAndAnswer {

    @DataProvider(name = "invalidLimitValue")
    public Object[][] getInvalidLimitValue() {
        return new Object[][] {
                {"\u0000", SECURITY_ANSWER},
                {"девичьядевичьядевичьядевичьядевичьядевичьядевичьяде", SECURITY_ANSWER}
        };
    }

    @Test(suiteName = "user_service", groups = {"regression"}, dataProvider = "invalidLimitValue")
    @Description("Невалидные приграничные значения")
    void questionInvalidLimitValueTest(String question, String answer) {
        assertEquals(HttpStatus.SC_BAD_REQUEST, getAuthorizationResponse(question, answer).getStatusCode());
    }
}