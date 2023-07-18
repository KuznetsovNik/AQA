package gor_api.user_service.settings.notification;

import dto.authorization_api.request.SettingsRequest;
import gor_api.BaseClassWithAuthToken;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import model.response.JsonResponse;
import org.testng.annotations.BeforeMethod;

import static constant.DataConstants.LOGIN_VALID_RU;
import static constant.DataConstants.TYPE_PHONE;
import static model.Location.RU;
import static property.BaseProperties.PASSWORD;

@Epic("EP-9 Изменение SMS-уведомлений")
@Owner("Чесноков Д.А.")
@Story("User-Service. Изменение статуса SMS")
public class BaseNotification extends BaseClassWithAuthToken {

    protected JsonResponse getAuthorizationResponseSMS(Object status) {
        return authApiWithTokenService.getSettingsSMSNotification(authHeaders,
                changeSMSNotificationStatus(status));
    }

    protected JsonResponse getAuthorizationResponsePUSH(Object status) {
        return authApiWithTokenService.getSettingsPUSHNotification(authHeaders,
                changePUSHNotificationStatus(status));
    }

    @Step("Формирование тела запроса для СМС-уведомлений")
    public SettingsRequest changeSMSNotificationStatus(Object status) {
        return SettingsRequest.builder().notificationStatusSms(status).build();
    }

    @Step("Формирование тела запроса для СМС-уведомлений")
    public SettingsRequest changePUSHNotificationStatus(Object status) {
        return SettingsRequest.builder().notificationStatusPush(status).build();
    }

    @BeforeMethod(alwaysRun = true)
    @Description("Авторизируемся по действующему паролю")
    public void authorization() {
        setAccessToken(RU.getCode(), LOGIN_VALID_RU, PASSWORD, TYPE_PHONE);
    }
}