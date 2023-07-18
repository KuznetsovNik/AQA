package gor_api.authorization_one_time.AuthWithoutValueInBody;

import gor_api.authorization_one_time.BaseAuthorization;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import model.response.JsonResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Epic("EP-6 Авторизация пользователя (разовая)")
@Owner("Чесноков Д.А.")
@Story("User-Service. Авторизация по телефону")
@TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6386275")
public class AuthWithEmptyBodyTest extends BaseAuthorization {

    @Test(suiteName = "user_service", groups = {"smoke", "regression"})
    @Description("Запрос с пустым телом")
    void authWithEmptyBody() {
        JsonResponse auth = authApiService.postPhone(headers, body());
        assertEquals(HttpStatus.SC_BAD_REQUEST, auth.getStatusCode());
    }
}