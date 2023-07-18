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

import static constant.DataConstants.LOGIN_INVALID_RU;
import static constant.DataConstants.TYPE_PHONE;
import static model.Location.RU;
import static org.testng.AssertJUnit.assertEquals;
import static property.BaseProperties.PASSWORD;

@Epic("EP-6 Авторизация пользователя")
@Owner("VerhovaA")
@Story("User-Service. Авторизация по телефону")
@TmsLink("Link not found")
public class InvalidLoginTest extends BaseAuthorization {

    @Test(suiteName = "user_service", groups = {"smoke", "regression"})
    @Description("Невалидный логин")
    void inValidLoginTest() {
        JsonResponse login = authApiService.postPhone(headers, body(RU.getCode(), LOGIN_INVALID_RU, PASSWORD, TYPE_PHONE));
        assertEquals(HttpStatus.SC_BAD_REQUEST, login.getStatusCode());
    }
}