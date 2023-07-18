package gor_api.user_service.settings.password;

import dto.authorization_api.response.AuthResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import model.response.JsonResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static constant.BaseHeaders.RequestHeaders.AUTHORIZATION;
import static constant.ErrorMessages.UNAUTHORIZED_MESSAGE;
import static helper.ObjectMapperHelper.mapJsonToObject;
import static org.testng.Assert.assertEquals;
import static property.BaseProperties.PASSWORD;

@Epic("EP-14 Изменение пароля в личном кабинете")
@Owner("Чесноков Д.А.")
@Story("User-Service. Изменение пароля")
@TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6434508")
public class ChangePasswordWithoutTokenTest extends BasePassword {

    @Test(suiteName = "user_service", groups = {"regression"})
    @Description("Валидные данные без токена")
    void changePasswordWithoutTokenTest() {
        authorization(PASSWORD);
        JsonResponse auth = authApiWithTokenService.getSettingsPassword(authHeaders.removeKey(AUTHORIZATION),
                changePasswordRequest(PASSWORD, "Qwerty123"));
        assertEquals(HttpStatus.SC_UNAUTHORIZED, auth.getStatusCode());
        authResponse = mapJsonToObject(auth, AuthResponse.class);
        assertEquals(UNAUTHORIZED_MESSAGE, authResponse.getDetail());
    }
}