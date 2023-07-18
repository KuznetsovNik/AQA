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

import static constant.DataConstants.LOGIN_VALID_RU;
import static constant.DataConstants.TYPE_NOT_CORRECT;
import static model.Location.RU;
import static org.testng.AssertJUnit.assertEquals;
import static property.BaseProperties.PASSWORD;

@Epic("EP-6 Авторизация пользователя")
@Owner("VerhovaA")
@Story("User-Service. Авторизация по телефону")
@TmsLink("Link not found")
public class NotCorrectTypeTest extends BaseAuthorization {

    @Test(suiteName = "user_service", groups = {"smoke", "regression"})
    @Description("Невалидный тип авторизации")
    void typeInvalidTest() {
        JsonResponse auth = authApiService.postPhone(headers, body(RU.getCode(), LOGIN_VALID_RU, PASSWORD, TYPE_NOT_CORRECT));
        assertEquals(HttpStatus.SC_BAD_REQUEST, auth.getStatusCode());
    }
}