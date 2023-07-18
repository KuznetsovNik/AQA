package gor_api.user_service.settings.password;

import dto.authorization_api.request.SettingsRequest;
import gor_api.BaseClassWithAuthToken;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import model.response.JsonResponse;

import static constant.DataConstants.LOGIN_VALID_RU;
import static constant.DataConstants.TYPE_PHONE;
import static model.Location.RU;

@Epic("EP-14 Изменение пароля в личном кабинете")
@Owner("Чесноков Д.А.")
@Story("User-Service. Изменение пароля")
public class BasePassword extends BaseClassWithAuthToken {

    protected JsonResponse getAuthorizationResponse(String password, String newPassword) {
        return authApiWithTokenService.getSettingsPassword(authHeaders,
                changePasswordRequest(password, newPassword));
    }

    @Step("Формирование тела запроса для пароля")
    public SettingsRequest changePasswordRequest(String password, String newPassword) {
        return SettingsRequest.builder()
                .password(password)
                .newPassword(newPassword)
                .build();
    }

    @Description("Авторизируемся по действующему паролю")
    public void authorization(String password) {
        setAccessToken(RU.getCode(), LOGIN_VALID_RU, password, TYPE_PHONE);
    }
}