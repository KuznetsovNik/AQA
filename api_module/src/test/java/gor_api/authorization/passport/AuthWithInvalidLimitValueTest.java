package gor_api.authorization.passport;

import gor_api.authorization_one_time.BaseAuthorization;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import model.response.JsonResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static constant.DataConstants.TYPE_DOCUMENT;
import static constant.DataConstants.VALID_PASSWORD;
import static model.DocType.PASSPORT_RU;
import static org.testng.AssertJUnit.assertEquals;

@Epic("EP-6 Авторизация пользователя")
@Owner("Яроцкая Е.И.")
@Story("User-Service. Авторизация по паспорту")
@TmsLink("Link not found")
public class AuthWithInvalidLimitValueTest extends BaseAuthorization {

    @DataProvider(name = "invalidLimitValue")
    public Object[][] getInvalidLimitValue() {
        return new Object[][] {
                {" "},
                {"1"},
                {"965684021"},
                {"79656840211"}
        };
    }

    @Test(suiteName = "user_service", groups = {"smoke", "regression"}, dataProvider = "invalidLimitValue")
    @Description("Невалидные граничные значения")
    void authWithPassportTest(String password) {
        JsonResponse auth = authApiService.postPassport(headers, body(PASSPORT_RU.getCode(), password, VALID_PASSWORD, TYPE_DOCUMENT));
        assertEquals(HttpStatus.SC_BAD_REQUEST, auth.getStatusCode());
    }
}