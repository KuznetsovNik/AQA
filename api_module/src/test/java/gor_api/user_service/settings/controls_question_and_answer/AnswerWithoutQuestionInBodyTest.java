package gor_api.user_service.settings.controls_question_and_answer;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static constant.DataConstants.SECURITY_ANSWER;
import static org.testng.Assert.assertEquals;

@Epic("EP-15 Изменение контрольного вопроса/ответа")
@Owner("Чесноков Д.А.")
@Story("User-Service. Изменение контрольного ответа")
@TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6423577")
public class AnswerWithoutQuestionInBodyTest extends BaseControlQuestionAndAnswer {

    @Test(suiteName = "user_service", groups = {"regression"})
    @Description("Изменение ответа без указания контрольного вопроса в теле")
    void changeQuestionAndAnswerWithEmptyBodyTest() {
        assertEquals(HttpStatus.SC_BAD_REQUEST, getAuthorizationResponse(null, SECURITY_ANSWER).getStatusCode());
    }
}