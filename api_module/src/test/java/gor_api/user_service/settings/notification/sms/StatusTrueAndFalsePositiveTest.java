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
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@Epic("EP-9 Изменение SMS-уведомлений")
@Owner("Чесноков Д.А.")
@Story("User-Service. Изменение статуса SMS")
@TmsLink("https://vmmreg32.testrail.net/index.php?/suites/view/25147")
public class StatusTrueAndFalsePositiveTest extends BaseNotification {

    @Test(suiteName = "user_service", groups = {"regression"})
    @Description("Изменение статуса SMS на true")
    void changeSMSNotificationStatusTrueTest() {
        assertEquals(HttpStatus.SC_OK, getAuthorizationResponseSMS(true).getStatusCode());
        assertTrue(getUser().isSmsNotification());
    }

    @Test(suiteName = "user_service", groups = {"regression"})
    @Description("Изменение статуса SMS на false")
    void changeSMSNotificationStatusFalseTest() {
        assertEquals(HttpStatus.SC_OK, getAuthorizationResponseSMS(false).getStatusCode());
        assertFalse(getUser().isSmsNotification());
    }
}