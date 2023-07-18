package gor_api.user_service.settings.controls_question_and_answer;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Epic("EP-15 Изменение контрольного вопроса/ответа")
@Owner("Чесноков Д.А.")
@Story("User-Service. Изменение контрольного вопроса и ответа")
@TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6423648")
public class RequestWithEmptyBodyNegativeTest extends BaseControlQuestionAndAnswer {

    @Test(suiteName = "user_service", groups = {"regression"})
    @Description("Отправка пустого тела")
    void changeQuestionAndAnswerWithEmptyBodyTest() {
        assertEquals(HttpStatus.SC_BAD_REQUEST, getAuthorizationResponse(null, null).getStatusCode());
    }
}