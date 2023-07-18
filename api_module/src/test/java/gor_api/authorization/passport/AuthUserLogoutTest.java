package gor_api.authorization.passport;

import gor_api.authorization_one_time.BaseAuthorization;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import model.response.JsonResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static constant.DataConstants.LOGIN_VALID_PASSPORT_RU;
import static constant.DataConstants.TYPE_DOCUMENT;
import static constant.DataConstants.VALID_PASSWORD;
import static model.DocType.PASSPORT_RU;
import static org.testng.AssertJUnit.assertEquals;

@Epic("EP-6 Авторизация пользователя")
@Owner("Чесноков Д.А.")
@Story("User-Service. Авторизация по паспорту")
@TmsLink("Link not found")
public class AuthUserLogoutTest extends BaseAuthorization {

    @Test(suiteName = "user_service", groups = {"smoke", "regression"})
    @Description("Выход из сессии")
    void logoutTest() {
        JsonResponse auth = authApiService.postPassport(headers,
                body(PASSPORT_RU.getCode(), LOGIN_VALID_PASSPORT_RU, VALID_PASSWORD, TYPE_DOCUMENT));
        assertEquals(HttpStatus.SC_OK, auth.getStatusCode());
        JsonResponse authL = authApiService.getLogout(headers);
        assertEquals(HttpStatus.SC_UNAUTHORIZED, authL.getStatusCode());
    }
}