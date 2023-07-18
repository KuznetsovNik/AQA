package gor_api.authorization_one_time.AuthValidPhone;

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
import static constant.DataConstants.TYPE_PHONE;
import static model.Location.RU;
import static org.testng.AssertJUnit.assertEquals;
import static property.BaseProperties.PASSWORD;

@Epic("EP-6 Авторизация пользователя (разовая)")
@Owner("Чесноков Д.А.")
@Story("User-Service. Авторизация по телефону")
@TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6386110")
public class AuthValidPhoneRuTest extends BaseAuthorization {

    @Test(suiteName = "user_service", groups = {"smoke", "regression"})
    @Description("Авторизация по телефону РФ. Валидные данные")
    void authWithPhone() {
        JsonResponse auth = authApiService.postPhone(headers, body(RU.getCode(), LOGIN_VALID_RU, PASSWORD, TYPE_PHONE));
        assertEquals(HttpStatus.SC_OK, auth.getStatusCode());
    }
}