package gor_api.user_service.settings.notification.sms;

import gor_api.user_service.settings.notification.BaseNotification;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Epic("EP-9 Изменение SMS-уведомлений")
@Owner("Чесноков Д.А.")
@Story("User-Service. Изменение статуса SMS")
@TmsLink("https://vmmreg32.testrail.net/index.php?/suites/view/25147")
public class StatusWithEmptyBodyNegativeTest extends BaseNotification {

    @Test(suiteName = "user_service", groups = {"regression"})
    @Description("Отправка запроса с пустым телом")
    void changeSMSNotificationWithEmptyBodyTest() {
        assertEquals(HttpStatus.SC_BAD_REQUEST, getAuthorizationResponseSMS(null).getStatusCode());
    }
}