package gor_api.user_registration;

import dto.authorization_api.response.AuthResponse;
import gor_api.authorization_one_time.BaseAuthorization;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import model.response.JsonResponse;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static constant.ClientStatus.ACTIVE;
import static constant.ParamsList.ACTIVE_USER;
import static constant.ParamsList.MOBILE_PHONE;
import static helper.ObjectMapperHelper.mapJsonToObject;
import static org.testng.AssertJUnit.assertEquals;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("Яроцкая Е.И.")
@Story("ЕР-1 Проверка регистрации пользователя")
public class UserIsRegistrationTest extends BaseAuthorization {

    @Test(enabled = false, groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6204278")
    @Description("Проверка регистрации пользователя: пользователь зарегистрирован в системе.")
    void authWithPassport() {
        addParams(MOBILE_PHONE, ACTIVE_USER);
        JsonResponse auth = authApiService.getUserDate(params, headers);
        assertEquals(auth.getStatusCode(), (HttpStatus.SC_OK));
        response = mapJsonToObject(auth, AuthResponse.class);
        Assert.assertEquals(response.getClientStatus(), ACTIVE);
    }
}