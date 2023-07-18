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

import static model.DocType.PASSPORT_BY;
import static constant.DataConstants.LOGIN_INVALID_PASSPORT_BY;
import static constant.DataConstants.TYPE_DOCUMENT;
import static org.testng.AssertJUnit.assertEquals;
import static property.BaseProperties.PASSWORD;

@Epic("EP-6 Авторизация пользователя (разовая)")
@Owner("Чесноков Д.А.")
@Story("User-Service. Авторизация по документу")
@TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6386299")
public class AuthInvalidPassportByTest extends BaseAuthorization {

    @Test(enabled = false, suiteName = "user_service", groups = {"smoke", "regression"})
    @Description("Паспорт РБ. Невалидный логин")
    public void authWithPhone() {
        JsonResponse auth = authApiService.postPhone(headers,
                body(PASSPORT_BY.getCode(), LOGIN_INVALID_PASSPORT_BY, PASSWORD, TYPE_DOCUMENT));
        assertEquals(HttpStatus.SC_BAD_REQUEST, auth.getStatusCode());
    }
}