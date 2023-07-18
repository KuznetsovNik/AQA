package gor_api.user_service.settings.notification.sms;

import gor_api.user_service.settings.notification.BaseNotification;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import model.response.JsonResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static constant.BaseHeaders.RequestHeaders.AUTHORIZATION;
import static org.testng.Assert.assertEquals;

@Epic("EP-9 Изменение SMS-уведомлений")
@Owner("Чесноков Д.А.")
@Story("User-Service. Изменение статуса SMS")
@TmsLink("https://vmmreg32.testrail.net/index.php?/suites/view/25147")
public class StatusTrueAuthWithoutTokenNegativeTest extends BaseNotification {

    @Test(suiteName = "user_service", groups = {"regression"})
    @Description("Изменение статуса SMS при авторизации без токена")
    void changeSMSNotificationAuthWithoutTokenTest() {
        JsonResponse auth = authApiWithTokenService.getSettingsSMSNotification(authHeaders.removeKey(AUTHORIZATION),
                changeSMSNotificationStatus(true));
        assertEquals(HttpStatus.SC_UNAUTHORIZED, auth.getStatusCode());
    }
}