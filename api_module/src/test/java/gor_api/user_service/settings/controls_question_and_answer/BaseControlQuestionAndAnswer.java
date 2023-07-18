package gor_api.user_service.settings.controls_question_and_answer;

import dto.authorization_api.request.SettingsRequest;
import gor_api.BaseClassWithAuthToken;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import model.response.JsonResponse;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static constant.DataConstants.LOGIN_VALID_RU;
import static constant.DataConstants.RETURN_ANSWER;
import static constant.DataConstants.RETURN_QUESTION;
import static constant.DataConstants.TYPE_PHONE;
import static model.Location.RU;
import static org.testng.Assert.assertEquals;
import static property.BaseProperties.PASSWORD;

@Epic("EP-15 Изменение контрольного вопроса/ответа")
@Owner("Чесноков Д.А.")
@Story("User-Service. Изменение контрольного вопроса и ответа")
public class BaseControlQuestionAndAnswer extends BaseClassWithAuthToken {

    protected JsonResponse getAuthorizationResponse(String question, String answer) {
        return authApiWithTokenService.getSettingsControl(authHeaders,
                changeControlQuestionAndAnswer(question, answer));
    }

    @Step("Формирование тела запроса для контрольного вопроса и ответа")
    public SettingsRequest changeControlQuestionAndAnswer(String securityQuestion, String securityAnswer) {
        return SettingsRequest.builder()
                .securityQuestion(securityQuestion)
                .securityAnswer(securityAnswer)
                .build();
    }

    @BeforeMethod(alwaysRun = true)
    @Description("Авторизируемся по действующему паролю")
    public void authorization() {
        setAccessToken(RU.getCode(), LOGIN_VALID_RU, PASSWORD, TYPE_PHONE);
    }

    @AfterMethod(alwaysRun = true)
    void tearDown() {
        assertEquals(RETURN_QUESTION, getUser().getSecurityQuestion());
        assertEquals(RETURN_ANSWER, getUser().getSecurityAnswer());
    }
}