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

import static model.Location.BY;
import static constant.DataConstants.LOGIN_VALID_BY;
import static constant.DataConstants.TYPE_PHONE;
import static org.testng.AssertJUnit.assertEquals;
import static property.BaseProperties.PASSWORD;

@Epic("EP-6 Авторизация пользователя (разовая)")
@Owner("Чесноков Д.А.")
@Story("User-Service. Авторизация по телефону")
@TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6386120")
public class AuthValidPhoneByTest extends BaseAuthorization {

    @Test(enabled = false, suiteName = "user_service", groups = {"smoke", "regression"})
    @Description("Авторизация по телефону РБ. Валидные данные")
    void authWithPhone() {
        JsonResponse auth = authApiService.postPhone(headers, body(BY.getCode(), LOGIN_VALID_BY, PASSWORD, TYPE_PHONE));
        assertEquals(HttpStatus.SC_OK, auth.getStatusCode());
    }
}