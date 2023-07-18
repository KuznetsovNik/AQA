package gor_api.user_service.settings.controls_question_and_answer;

import dto.authorization_api.request.SettingsRequest;
import gor_api.authorization_one_time.BaseAuthorization;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import model.response.JsonResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static constant.DataConstants.SECURITY_QUESTION;
import static constant.DataConstants.SECURITY_ANSWER;
import static org.testng.Assert.assertEquals;

@Epic("EP-15 Изменение контрольного вопроса/ответа")
@Owner("Чесноков Д.А.")
@Story("User-Service. Изменение контрольного вопроса и ответа")
@TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6423574")
public class UnauthorizedUserNegativeTest extends BaseAuthorization {

    @Test(suiteName = "user_service", groups = {"regression"})
    @Description("Изменение контрольного вопроса и ответа неавторизованного пользователя")
    void changeQuestionAndAnswerUnauthorizedUserTest() {
        JsonResponse response = authApiService
                .getSettingsControlUnauthorizedUser(SettingsRequest.builder()
                        .securityQuestion(SECURITY_QUESTION)
                        .securityAnswer(SECURITY_ANSWER)
                        .build());
        assertEquals(HttpStatus.SC_UNAUTHORIZED, response.getStatusCode());
    }
}