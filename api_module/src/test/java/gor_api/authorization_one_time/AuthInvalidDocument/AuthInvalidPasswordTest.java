package gor_api.authorization_one_time.AuthInvalidDocument;

import gor_api.authorization_one_time.BaseAuthorization;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import model.response.JsonResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static model.DocType.PASSPORT_RU;
import static constant.DataConstants.LOGIN_VALID_PASSPORT_RU;
import static constant.DataConstants.TYPE_DOCUMENT;
import static org.testng.AssertJUnit.assertEquals;
import static constant.DataConstants.INVALID_PASSWORD;

@Epic("EP-6 Авторизация пользователя (разовая)")
@Owner("Чесноков Д.А.")
@Story("User-Service. Авторизация по документу")
@TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6386346")
public class AuthInvalidPasswordTest extends BaseAuthorization {

    @Test(suiteName = "user_service", groups = {"smoke", "regression"})
    @Description("Паспорт РФ. Невалидный пароль")
    public void authWithPhone() {
        JsonResponse auth = authApiService.postPhone(headers,
                body(PASSPORT_RU.getCode(), LOGIN_VALID_PASSPORT_RU, INVALID_PASSWORD, TYPE_DOCUMENT));
        assertEquals(HttpStatus.SC_BAD_REQUEST, auth.getStatusCode());
    }
}