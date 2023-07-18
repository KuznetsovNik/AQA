package gor_api.authorization.phone;

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

import static constant.DataConstants.TYPE_PHONE;
import static model.Location.RU;
import static org.testng.AssertJUnit.assertEquals;
import static property.BaseProperties.PASSWORD;

@Epic("EP-6 Авторизация пользователя")
@Owner("VerhovaA")
@Story("User-Service. Авторизация по телефону")
@TmsLink("Link not found")
public class PhoneWithInvalidLimitValueTest extends BaseAuthorization {

    @DataProvider(name = "invalidLimitValue")
    public Object[][] getInvalidLimitValue() {
        return new Object[][] {
                {" "},
                {"1"},
                {"7965684020"},
                {"796568402027"}
        };
    }

    @Test(suiteName = "user_service", groups = {"smoke", "regression"}, dataProvider = "invalidLimitValue")
    @Description("Граничные значения")
    void phoneInvalidLimitValueTest(String login) {
        JsonResponse auth = authApiService.postPhone(headers, body(RU.getCode(), login, PASSWORD, TYPE_PHONE));
        assertEquals(HttpStatus.SC_BAD_REQUEST, auth.getStatusCode());
    }
}