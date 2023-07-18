package gor_api.authorization.phone;

import gor_api.authorization_one_time.BaseAuthorization;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import model.response.JsonResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static constant.DataConstants.INVALID_PASSWORD;
import static constant.DataConstants.LOGIN_VALID_RU;
import static constant.DataConstants.TYPE_PHONE;
import static model.Location.RU;
import static org.testng.AssertJUnit.assertEquals;

@Epic("EP-6 Авторизация пользователя")
@Owner("VerhovaA")
@Story("User-Service. Авторизация по телефону")
@TmsLink("Link not found")
public class InvalidPasswordTest extends BaseAuthorization {

    @Test(suiteName = "user_service", groups = {"smoke", "regression"})
    @Description("Невалидный пароль")
    void inValidPasswordTest() {
        JsonResponse password = authApiService.postPhone(headers, body(RU.getCode(), LOGIN_VALID_RU, INVALID_PASSWORD, TYPE_PHONE));
        assertEquals(HttpStatus.SC_BAD_REQUEST, password.getStatusCode());
    }
}